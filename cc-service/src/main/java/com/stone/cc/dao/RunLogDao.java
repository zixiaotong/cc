package com.stone.cc.dao;

import java.util.List;

import com.stone.cc.beans.RunLog;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface RunLogDao {

    List<RunLog> selectRunlogById(String id) throws Exception;

}