package com.github.sparkzxl.file.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.file.dto.FileDTO;
import com.github.sparkzxl.file.infrastructure.entity.FileMaterial;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialDTO;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialPageDTO;
import com.github.sparkzxl.file.vo.FileUploadModel;
import org.springframework.web.multipart.MultipartFile;


/**
 * description: 文件上传服务
 *
 * @author charles.zhou
 * @date 2020-05-24 12:30:30
 */
public interface IFileService {

    /**
     * 上传文件
     *
     * @param multipartFile 文件
     * @param fileType      文件类型
     * @return FileUploadModel
     */
    FileUploadModel upload(MultipartFile multipartFile, String fileType);

    /**
     * 删除文件
     *
     * @param objectName 文件名
     * @return boolean
     */
    boolean deleteFile(String objectName);

    /**
     * 分页查询文件列表
     *
     * @param fileMaterialPageDTO 文件分页查询入参
     * @return Page<FileMaterial>
     */
    Page<FileMaterial> fileMaterialPageList(FileMaterialPageDTO fileMaterialPageDTO);
}
