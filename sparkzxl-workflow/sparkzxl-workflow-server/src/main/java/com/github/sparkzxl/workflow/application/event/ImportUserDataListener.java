package com.github.sparkzxl.workflow.application.event;

import com.alibaba.excel.context.AnalysisContext;
import com.github.sparkzxl.database.base.listener.ImportDataListener;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessUserService;
import com.github.sparkzxl.workflow.domain.model.aggregates.excel.ProcessUserExcel;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description: 用户Excel导入监听
 *
 * @author charles.zhou
 * @since 2021-01-04 15:34:07
 */
@Component
@Slf4j
public class ImportUserDataListener extends ImportDataListener<ProcessUserExcel> {


    private IExtProcessUserService extProcessUserService;

    @Autowired
    public void setExtProcessUserService(IExtProcessUserService extProcessUserService) {
        this.extProcessUserService = extProcessUserService;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！size：{}", list.size());
        List<ExtProcessUser> processUserList = Lists.newArrayList();
        list.forEach(item -> {
            ExtProcessUser extProcessUser = new ExtProcessUser();
            extProcessUser.setAccount(item.getAccount());
            extProcessUser.setName(item.getName());
            extProcessUser.setStatus(true);
            processUserList.add(extProcessUser);
            count.getAndIncrement();
        });
        extProcessUserService.saveBatch(processUserList);
    }
}
