package com.github.sparkzxl.job.admin.core.scheduler;

import com.github.sparkzxl.job.admin.core.util.I18nUtil;

/**
 * @author xuxueli 2020-10-29 21:11:23
 */
public enum ScheduleTypeEnum {

    NONE(I18nUtil.getString("schedule_type_none")),

    /**
     * schedule by cron
     */
    CRON(I18nUtil.getString("schedule_type_cron")),

    /**
     * schedule by fixed rate (in seconds)
     */
    FIX_RATE(I18nUtil.getString("schedule_type_fix_rate"));

    private String title;

    ScheduleTypeEnum(String title) {
        this.title = title;
    }

    public static ScheduleTypeEnum match(String name, ScheduleTypeEnum defaultItem) {
        for (ScheduleTypeEnum item : ScheduleTypeEnum.values()) {
            if (item.name().equals(name)) {
                return item;
            }
        }
        return defaultItem;
    }

    public String getTitle() {
        return title;
    }

}
