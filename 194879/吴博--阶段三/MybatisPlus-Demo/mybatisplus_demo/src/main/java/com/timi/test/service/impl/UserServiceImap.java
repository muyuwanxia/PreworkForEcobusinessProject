package com.timi.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.timi.test.entity.User;
import com.timi.test.mapper.UserMapper;
import com.timi.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author timi
 * @since 2020-02-14
 */
@Service
public class UserServiceImap extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return baseMapper.insert(user);
    }

    @Override
    public List<User> selectAll(Wrapper<User> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public User selectById(Integer UserId) {
        return baseMapper.selectById(UserId);
    }

    @Override
    public int updateUser(User user) {
        return baseMapper.updateById(user);
    }

    @Override
    public int deleteUserById(int id) {
        return baseMapper.deleteById(id);
    }

    public IPage<User> selectUserPage(Page<User> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return userMapper.selectPageVo(page, state);
    }
}
