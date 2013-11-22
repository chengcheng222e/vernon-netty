package com.vernon.netty.dao;

import com.vernon.netty.domain.UserLogin;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM4:08
 * To change this template use File | Settings | File Templates.
 */
public interface UserLoginDao {

    /**
     * 根据用户名与密码获取用户信息
     *
     * @param account
     * @param password
     * @return
     */
    public UserLogin getUserLogin(@Param("account") String account, @Param("password") String password) ;
}
