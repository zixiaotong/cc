package com.stone.cc.service;

import java.util.List;

import com.stone.cc.beans.RunLog;

public interface IRunLogService {
    List<RunLog> selectRunlogById(String id) throws Exception;
}
