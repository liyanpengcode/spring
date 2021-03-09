package com.spring.code.generator.mapper;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author admin
 */
@Repository
public interface SysGeneratorMapper {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
