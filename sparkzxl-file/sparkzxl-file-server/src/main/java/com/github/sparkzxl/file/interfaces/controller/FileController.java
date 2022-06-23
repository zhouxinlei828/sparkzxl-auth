package com.github.sparkzxl.file.interfaces.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.web.annotation.Response;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.github.sparkzxl.file.api.FileProvider;
import com.github.sparkzxl.file.application.service.IFileService;
import com.github.sparkzxl.file.dto.FileDTO;
import com.github.sparkzxl.file.infrastructure.entity.FileMaterial;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialDTO;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialPageDTO;
import com.github.sparkzxl.file.vo.FileUploadModel;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * description: 文件上传 前端控制器
 *
 * @author charles.zhou
 * @since 2020-05-24 12:40:10
 */
@RestController
@HttpRequestLog
@Api(tags = "文件管理")
public class FileController implements FileProvider {

    private final IFileService fileService;

    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    @ApiOperation("文件上传")
    @Response
    @PostMapping("/file/upload")
    public FileUploadModel upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("fileType") String fileType) {
        return fileService.upload(multipartFile, fileType);
    }

    @ApiOperation("分页查询文件列表")
    @PostMapping("file/page")
    public Page<FileMaterial> fileMaterialPageList(@RequestBody FileMaterialPageDTO fileMaterialPageDTO) {
        return fileService.fileMaterialPageList(fileMaterialPageDTO);
    }

    @ApiOperation("删除文件")
    @Response
    @DeleteMapping("/file/delete/{fileName}")
    public boolean delete(@PathVariable("fileName") String fileName) {
        return fileService.deleteFile(fileName);
    }

    @Override
    public FileDTO getPdf(FileDTO fileDTO) {
        ExceptionAssert.failure("调用失败");
        return fileDTO;
    }
}
