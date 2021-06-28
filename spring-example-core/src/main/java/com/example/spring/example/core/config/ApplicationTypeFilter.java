package com.example.spring.example.core.config;

import com.example.spring.example.core.bean.ExcludeBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 类型过滤器
 *
 * @author iterators
 * @date 2021.05.06
 */
@Slf4j
public class ApplicationTypeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String className = classMetadata.getClassName();
        log.info("class name: {}", className);
        return ExcludeBean.class.getName().equals(className);
    }
}
