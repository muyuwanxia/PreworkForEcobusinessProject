package com.seu.generator.service.impl;

import com.seu.generator.model.User;
import com.seu.generator.mapper.UserMapper;
import com.seu.generator.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author test
 * @since 2020-02-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
