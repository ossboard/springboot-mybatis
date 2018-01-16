package com.konantech.spring.service;

import com.konantech.spring.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class LogService {

    @Autowired
    private LogMapper logMapper;

    public List<Map<String, Object>> check(Map<String, Object> data) throws SQLException {
        return logMapper.check(data);
    }

    public int insert(Map<String, Object> data) throws SQLException {
        int ret = 0;
        try {
            ret = logMapper.insert(data);
        } catch (Exception e) {
            if (logMapper.check(data).size() == 0) {
                logMapper.create(data);
                logMapper.insert(data);
            }
        }
        return ret;
    }

    public int create(Map<String, Object> data) throws SQLException {
        return logMapper.create(data);
    }

    public int total(Map<String, Object> data) throws SQLException {
        return logMapper.total(data);
    }

    public List<Map<String, Object>> list(Map<String, Object> data) throws SQLException {
        return logMapper.list(data);
    }
}
