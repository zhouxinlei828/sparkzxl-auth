package com.github.sparkzxl.file.domain.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.core.util.Mht2HtmlUtil;
import com.github.sparkzxl.file.application.service.IFileService;
import com.github.sparkzxl.file.domain.repository.IFileMaterialRepository;
import com.github.sparkzxl.file.dto.FileDTO;
import com.github.sparkzxl.file.infrastructure.convert.FileMaterialConvert;
import com.github.sparkzxl.file.infrastructure.entity.FileMaterial;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialDTO;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialPageDTO;
import com.github.sparkzxl.oss.service.OssTemplate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.util.Objects;

/**
 * description: 文件上传服务实现类
 *
 * @author charles.zhou
 * @date 2020-05-24 12:32:31
 */
@Service
@Slf4j
@AllArgsConstructor
public class FileServiceImpl implements IFileService {


    private final IFileMaterialRepository fileMaterialRepository;
    private final OssTemplate ossTemplate;

    @Override
    public FileMaterialDTO upload(MultipartFile multipartFile) {
        FileMaterial fileMaterial;
        String originalFilename = multipartFile.getOriginalFilename();
        String fileName = FileUtil.mainName(Objects.requireNonNull(originalFilename));
        String extension = FileUtil.extName(originalFilename);
        fileMaterial = fileMaterialRepository.selectByFileName(originalFilename);
        if (ObjectUtils.isEmpty(fileMaterial)) {
            fileMaterial = new FileMaterial();
            String objectName = "images".concat("/").concat(originalFilename);
            // 上传到阿里云
            ossTemplate.multipartUpload("sparkzxl",
                    objectName,
                    multipartFile);
            String url = ossTemplate.getObjectUrl("sparkzxl", objectName);
            fileMaterial.setFileName(fileName);
            fileMaterial.setSuffix(extension);
            fileMaterial.setFilePath(url);
            fileMaterial.setSize((double) multipartFile.getSize());
            fileMaterial.setContentType(multipartFile.getContentType());
            fileMaterial.setUid(IdUtil.randomUUID());
            boolean result = fileMaterialRepository.saveFileMaterial(fileMaterial);
            log.info("文件上传结果 result is {}", result);
        }
        return FileMaterialConvert.INSTANCE.convertFileMaterialDTO(fileMaterial);
    }

    @Override
    public PageInfo<FileMaterial> fileMaterialPageList(FileMaterialPageDTO fileMaterialPageDTO) {
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

    @Override
    public FileDTO getHtml(FileDTO fileDTO) throws Exception {
        String fileName = FileUtil.getName(fileDTO.getFilePath());
        String baseName = FileUtil.mainName(fileName);
        String tempFilePath = "/data/" + baseName + ".html";
        Mht2HtmlUtil.mht2html(fileDTO.getFilePath(), tempFilePath);
        BufferedInputStream bufferedInputStream = FileUtil.getInputStream(tempFilePath);
        String objectName = "images".concat("/").concat(fileName);
        ossTemplate.putObject("sparkzxl",
                objectName,
                bufferedInputStream);
        FileDTO outDto = new FileDTO();
        outDto.setFilePath(ossTemplate.getObjectURL("sparkzxl", objectName));
        return outDto;
    }
}
