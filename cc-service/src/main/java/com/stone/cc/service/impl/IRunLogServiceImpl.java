package com.stone.cc.service.impl;

import java.util.List;

import com.stone.cc.beans.RunLog;
import com.stone.cc.dao.RunLogDao;
import com.stone.cc.service.IRunLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRunLogServiceImpl implements IRunLogService {

    @Autowired
    private RunLogDao RunLogDao;

    @Override
    public List<RunLog> selectRunlogById(String id) throws Exception {
        return RunLogDao.selectRunlogById(id);
    }
}
