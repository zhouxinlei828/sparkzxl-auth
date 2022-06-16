package com.github.sparkzxl.file.domain.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.core.context.RequestLocalContextHolder;
import com.github.sparkzxl.core.util.FileDigestUtil;
import com.github.sparkzxl.core.util.StrPool;
import com.github.sparkzxl.file.application.service.IFileService;
import com.github.sparkzxl.file.domain.repository.IFileMaterialRepository;
import com.github.sparkzxl.file.infrastructure.convert.FileMaterialConvert;
import com.github.sparkzxl.file.infrastructure.entity.FileMaterial;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialDTO;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialPageDTO;
import com.github.sparkzxl.file.vo.FileUploadModel;
import com.github.sparkzxl.oss.OssTemplate;
import com.github.sparkzxl.oss.context.OssClientContextHolder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * description: 文件上传服务实现类
 *
 * @author charles.zhou
 * @since 2020-05-24 12:32:31
 */
@Service
@Slf4j
@AllArgsConstructor
public class FileServiceImpl implements IFileService {

    private final IFileMaterialRepository fileMaterialRepository;
    private final OssTemplate ossTemplate;

    @Override
    public FileUploadModel upload(MultipartFile multipartFile, String fileType) {
        OssClientContextHolder.push(RequestLocalContextHolder.getTenant());
        try {
            InputStream inputStream = multipartFile.getInputStream();
            String fileDigest = FileDigestUtil.extractChecksum(inputStream, DigestAlgorithm.MD5);
            FileMaterial fileMaterial = fileMaterialRepository.selectByDigest(fileDigest);
            String fileBucket = "sparkzxl";
            if (ObjectUtils.isEmpty(fileMaterial)) {
                String originalFilename = multipartFile.getOriginalFilename();
                String extension = FileUtil.extName(originalFilename);
                fileMaterial = new FileMaterial();
                String nowDateString = DateUtil
                        .format(LocalDateTime.now(), DatePattern.PURE_DATETIME_MS_PATTERN);
                String generatedFilename = nowDateString.concat(IdUtil.objectId());
                String objectName = "images".concat("/").concat(generatedFilename).concat(StrPool.DOT).concat(extension);
                // 上传到阿里云
                ossTemplate.putObject(fileBucket, objectName, multipartFile);
                String url = ossTemplate.getObjectUrl(fileBucket, objectName);
                fileMaterial.setFileName(generatedFilename);
                fileMaterial.setOriginalFilename(originalFilename);
                fileMaterial.setObjectName(objectName);
                fileMaterial.setDigest(fileDigest);
                fileMaterial.setFileType(fileType);
                fileMaterial.setFileBucket(fileBucket);
                fileMaterial.setSuffix(extension);
                fileMaterial.setFullPath(url);
                fileMaterial.setSize((double) multipartFile.getSize());
                fileMaterial.setContentType(multipartFile.getContentType());
                boolean result = fileMaterialRepository.saveFileMaterial(fileMaterial);
                log.info("文件上传结果 result is {}", result);
            }
            return FileMaterialConvert.INSTANCE.convertFileUploadModel(fileMaterial);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            OssClientContextHolder.poll();
        }
    }

    @Override
    public Page<FileMaterial> fileMaterialPageList(FileMaterialPageDTO fileMaterialPageDTO) {
        return fileMaterialRepository.fileMaterialPageList(fileMaterialPageDTO.getPageNum(),
                fileMaterialPageDTO.getPageSize(),
                fileMaterialPageDTO.getFileName(),
                fileMaterialPageDTO.getContentType());
    }

    @Override
    public boolean deleteFile(String fileName) {
        ossTemplate.removeObject("sparkzxl", fileName);
        return fileMaterialRepository.deleteFile(fileName);
    }
}
