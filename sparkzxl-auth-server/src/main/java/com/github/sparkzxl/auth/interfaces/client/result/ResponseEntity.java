package com.github.sparkzxl.auth.interfaces.client.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * description: 响应实体类
 *
 * @author zhouxinlei
 * @date 2021-10-14 16:13:49
 */
@Data
public class ResponseEntity {

    private int status;

    private String info;

    @JsonProperty("infocode")
    private Integer infoCode;

    private Integer count;

    private List<Area> districts;
}
