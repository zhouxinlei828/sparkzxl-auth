package com.github.sparkzxl.file.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.file.domain.repository.IFileMaterialRepository;
import com.github.sparkzxl.file.infrastructure.entity.FileMaterial;
import com.github.sparkzxl.file.infrastructure.mapper.FileMaterialMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * description： 文件 仓储实现类
 *
 * @author charles.zhou
 * @since 2020/6/16 0016
 */
@Repository
@RequiredArgsConstructor
public class FileMaterialRepository implements IFileMaterialRepository {

    private final FileMaterialMapper fileMaterialMapper;

    @Override
    public FileMaterial selectByOriginalFilename(String originalFilename) {
        return fileMaterialMapper.selectOne(new LambdaQueryWrapper<FileMaterial>()
                .eq(FileMaterial::getOriginalFilename, originalFilename)
                .last("limit 1"));
    }

    @Override
    public FileMaterial selectByDigest(String fileDigest) {
        return fileMaterialMapper.selectOne(new LambdaQueryWrapper<FileMaterial>()
                .eq(FileMaterial::getDigest, fileDigest)
                .last("limit 1"));
    }

    @Override
    public boolean saveFileMaterial(FileMaterial fileMaterialDO) {
        return fileMaterialMapper.insert(fileMaterialDO) == 1;
    }

    @Override
    public boolean deleteFile(String fileName) {
        LambdaQueryWrapper<FileMaterial> materialQueryWrapper = new LambdaQueryWrapper<>();
        materialQueryWrapper.eq(FileMaterial::getFileName, fileName);
        return fileMaterialMapper.delete(materialQueryWrapper) == 1;
    }

    @Override
    public FileMaterial selectByFilePath(String filePath) {
        LambdaQueryWrapper<FileMaterial> materialQueryWrapper = new LambdaQueryWrapper<>();
        materialQueryWrapper.eq(FileMaterial::getFullPath, filePath).last("limit 1");
        return fileMaterialMapper.selectOne(materialQueryWrapper);
    }


    @Override
    public Page<FileMaterial> fileMaterialPageList(int pageNum, int pageSize, String fileName, String contentType) {
        LambdaQueryWrapper<FileMaterial> materialQueryWrapper = new LambdaQueryWrapper<>();
        materialQueryWrapper.likeRight(StringUtils.isNotEmpty(fileName), FileMaterial::getFileName, fileName)
                .eq(StringUtils.isNotEmpty(contentType), FileMaterial::getContentType, contentType);
        return fileMaterialMapper.selectPage(new Page<>(pageNum, pageSize), materialQueryWrapper);
    }
}
