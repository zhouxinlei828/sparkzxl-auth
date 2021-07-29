package com.github.sparkzxl.file.domain.repository;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.file.infrastructure.entity.FileMaterial;

/**
 * description：文件 仓储类
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */
public interface IFileMaterialRepository {

    /**
     * 根据文件名查询文件
     *
     * @param fileName 文件名
     * @return FileMaterial
     */
    FileMaterial selectByFileName(String fileName);

    /**
     * 保存文件上传记录
     *
     * @param fileMaterial 文件素材
     * @return boolean
     */
    boolean saveFileMaterial(FileMaterial fileMaterial);

    /**
     * 删除文件记录
     *
     * @param fileName 文件名
     * @return boolean
     */
    boolean deleteFile(String fileName);

    /**
     * 根据文件路径查询文件素材
     *
     * @param filePath 文件路径
     * @return FileMaterial
     */
    FileMaterial selectByFilePath(String filePath);

    /**
     *  分页查询附件列表
     * @param pageNum 当前页
     * @param pageSize 页面大小
     * @param fileName 文件名
     * @param contentType 媒体类型
     * @return PageInfo<FileMaterial>
     */
    PageInfo<FileMaterial> fileMaterialPageList(int pageNum, int pageSize, String fileName, String contentType);
}
