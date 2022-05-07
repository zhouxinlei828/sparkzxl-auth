package com.github.sparkzxl.file.infrastructure.convert;

import com.github.sparkzxl.file.infrastructure.entity.FileMaterial;
import com.github.sparkzxl.file.vo.FileUploadModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * description：FileMaterial对象Convert
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */
@Mapper
public interface FileMaterialConvert {

    FileMaterialConvert INSTANCE = Mappers.getMapper(FileMaterialConvert.class);

    /**
     * FileMaterial转化为FileMaterialDTO
     *
     * @param fileMaterial 文件素材
     * @return FileMaterialDTO
     */
    @Mappings({
            @Mapping(source = "fullPath", target = "fileUrl"),
            @Mapping(source = "originalFilename", target = "fileName")
    })
    FileUploadModel convertFileUploadModel(FileMaterial fileMaterial);
}
