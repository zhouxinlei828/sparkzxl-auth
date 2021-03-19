package com.github.sparkzxl.auth.application.service;

import com.github.sparkzxl.auth.infrastructure.entity.CommonArea;
import com.github.sparkzxl.auth.interfaces.dto.area.AreaQueryDTO;
import com.github.sparkzxl.database.base.service.SuperCacheService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * description: 地区表 服务类
 *
 * @author charles.zhou
 * @date   2020-07-28 19:41:37
 */
public interface IAreaService extends SuperCacheService<CommonArea> {

    /**
     * 查询地区信息
     *
     * @param areaQueryDTO 地区查询入参
     * @return List<CommonArea>
     */
    List<CommonArea> getAreaList(AreaQueryDTO areaQueryDTO);

    /**
     * 导入城市数据信息
     * @param multipartFile 文件信息
     * @return
     */
    boolean importAreaJsonData(MultipartFile multipartFile);
}
