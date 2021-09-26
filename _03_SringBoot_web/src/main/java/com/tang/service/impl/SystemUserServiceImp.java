package com.tang.service.impl;

import com.tang.domain.SystemUser;
import com.tang.mapper.SystemUserMapper;
import com.tang.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImp implements SystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Override
    public SystemUser login(SystemUser user){
        SystemUser loginUser = systemUserMapper.login(user);
        return loginUser;
    }
}
