package com.github.sparkzxl.job.admin.core.util;

import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.TemplateHashModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ftl util
 *
 * @author xuxueli 2018-01-17 20:37:48
 */
public class FtlUtil {
    private static final Logger logger = LoggerFactory.getLogger(FtlUtil.class);

    private static final BeansWrapper WRAPPER = new BeansWrapperBuilder(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS).build();

    public static TemplateHashModel generateStaticModel(String packageName) {
        try {
            TemplateHashModel staticModels = WRAPPER.getStaticModels();
            return (TemplateHashModel) staticModels.get(packageName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

}
