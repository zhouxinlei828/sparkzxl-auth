package com.github.sparkzxl.file.infrastructure.convert;

import com.github.sparkzxl.file.infrastructure.entity.FileMaterial;
import com.github.sparkzxl.file.interfaces.dto.FileMaterialDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-29T18:04:14+0800",
    comments = "version: 1.4.0.CR1, compiler: javac, environment: Java 1.8.0_292 (Azul Systems, Inc.)"
)
public class FileMaterialConvertImpl implements FileMaterialConvert {

    @Override
    public FileMaterialDTO convertFileMaterialDTO(FileMaterial fileMaterial) {
        if ( fileMaterial == null ) {
            return null;
        }

        FileMaterialDTO fileMaterialDTO = new FileMaterialDTO();

        fileMaterialDTO.setUid( fileMaterial.getUid() );
        fileMaterialDTO.setFileName( fileMaterial.getFileName() );
        fileMaterialDTO.setSuffix( fileMaterial.getSuffix() );
        fileMaterialDTO.setFilePath( fileMaterial.getFilePath() );
        fileMaterialDTO.setSize( fileMaterial.getSize() );
        fileMaterialDTO.setContentType( fileMaterial.getContentType() );
        fileMaterialDTO.setCreateTime( fileMaterial.getCreateTime() );

        return fileMaterialDTO;
    }
}
