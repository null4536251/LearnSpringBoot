package com.tang.mapper;

import com.tang.domain.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SystemUserMapper {
    SystemUser login(SystemUser user);
}
