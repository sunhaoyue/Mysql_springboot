package com.wantwant.utils;


import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;

/**
 * 操作数据源
 * @author hy sunhaoyue
 */
public class DynamicDataSourceSwitcher {

    static Logger logger = LoggerFactory.getLogger(DynamicDataSourceSwitcher.class);
    public static final String defaultData = "defaultData";
    public static final String Mater = "master";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String name) {
        logger.info("-------- 设置数据源数据源为 ：{} "+ name);
        contextHolder.set(name);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void cleanDataSource() {
        contextHolder.remove();
    }
}
