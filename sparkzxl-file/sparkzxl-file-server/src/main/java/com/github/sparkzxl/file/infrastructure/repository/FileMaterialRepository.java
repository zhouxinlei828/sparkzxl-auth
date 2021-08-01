package com.github.sparkzxl.file.infrastructure.repository;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.database.utils.PageInfoUtils;
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
 * @date 2020/6/16 0016
 */
@Repository
@RequiredArgsConstructor
public class FileMaterialRepository implements IFileMaterialRepository {

    private final FileMaterialMapper fileMaterialMapper;

    @Override
    public FileMaterial selectByFileName(String fileName) {
        //文件新路径
        String extension = FileUtil.extName(fileName);
        LambdaQueryWrapper<FileMaterial> materialQueryWrapper = new LambdaQueryWrapper<>();
        materialQueryWrapper.eq(FileMaterial::getFileName, fileName);
        materialQueryWrapper.eq(FileMaterial::getSuffix, extension);
        materialQueryWrapper.last("limit 1");
        return fileMaterialMapper.selectOne(materialQueryWrapper);
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
        materialQueryWrapper.eq(FileMaterial::getFilePath, filePath).last("limit 1");
        return fileMaterialMapper.selectOne(materialQueryWrapper);
    }


    @Override
    public PageInfo<FileMaterial> fileMaterialPageList(int pageNum, int pageSize, String fileName, String contentType) {
        LambdaQueryWrapper<FileMaterial> materialQueryWrapper = new LambdaQueryWrapper<>();
        materialQueryWrapper.likeRight(StringUtils.isNotEmpty(fileName), FileMaterial::getFileName, fileName)
                .eq(StringUtils.isNotEmpty(contentType), FileMaterial::getContentType, contentType);
        PageHelper.startPage(pageNum, pageSize);
        return PageInfoUtils.pageInfo(fileMaterialMapper.selectList(materialQueryWrapper));
    }
}