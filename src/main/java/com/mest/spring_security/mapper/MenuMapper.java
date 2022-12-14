package com.mest.spring_security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mest.spring_security.domain.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Long UserId);
}
