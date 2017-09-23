package com.stone.cc.service.impl;

import com.stone.cc.service.TestRegistryService;
import org.springframework.stereotype.Service;

/**
 * @author shanglei
 * @date 2017/7/28.
 */
@Service("testRegistryServices")
public class TestRegistryServiceImpl implements TestRegistryService {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
