package com.wantwant.utils;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("------------------当前数据源 {}"+DynamicDataSourceSwitcher.getDataSource());
        return DynamicDataSourceSwitcher.getDataSource();
}
}
