package com.konantech.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LogMapper {
    List<Map<String, Object>> check(Map<String, Object> data);

    int insert(Map<String, Object> data);

    int create(Map<String, Object> data);

    int total(Map<String, Object> data);

    List<Map<String, Object>> list(Map<String, Object> data);

}
