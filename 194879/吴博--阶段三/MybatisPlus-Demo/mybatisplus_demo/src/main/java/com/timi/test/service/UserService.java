package com.timi.test.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.timi.test.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author timi
 * @since 2020-02-14
 */

public interface UserService extends IService<User> {
    /**
     * 增加
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 查询全部
     * @param queryWrapper
     * @return
     */
    List<User> selectAll(Wrapper<User> queryWrapper);

    /**
     * 根据id查询
      * @param UserId
     * @return
     */
    User selectById(Integer UserId);

    /**
     * 更新
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteUserById(int id);
}
