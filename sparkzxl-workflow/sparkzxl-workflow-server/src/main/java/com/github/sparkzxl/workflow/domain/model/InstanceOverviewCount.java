package com.github.sparkzxl.workflow.domain.model;

import lombok.Data;

/**
 * description: 流程统计总览
 *
 * @author charles.zhou
 * @date   2020-12-18 09:05:39
*/
@Data
public class InstanceOverviewCount {

    private int todayCount;

    private int weekCount;

    private int finishCount;

    private int unFinishCount;

    private int monthCount;

    private int totalCount;

}
