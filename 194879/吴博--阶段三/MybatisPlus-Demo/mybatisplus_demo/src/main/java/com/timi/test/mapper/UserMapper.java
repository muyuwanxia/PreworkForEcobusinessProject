package com.timi.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timi.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author timi
 * @since 2020-02-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectPageVo(Page page, @Param("state") Integer state);
}
