package com.seu.generator.mapper;

import com.seu.generator.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author test
 * @since 2020-02-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
