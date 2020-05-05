package priv.xzhi.security.action01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

import priv.xzhi.security.action01.model.entity.Users;


/**
 * @author Xzhi
 * @desc: UsersMapper
 * @date 2020-05-05 21:58
 */

public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     */
    Users findByUserName(@Param("userName") String userName);
}