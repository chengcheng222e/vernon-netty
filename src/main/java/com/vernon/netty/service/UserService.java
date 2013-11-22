package com.vernon.netty.service;

import com.vernon.netty.core.common.db.DaoFactory;
import com.vernon.netty.dao.UserLoginDao;
import com.vernon.netty.domain.UserLogin;
import org.apache.ibatis.session.SqlSession;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM4:08
 * To change this template use File | Settings | File Templates.
 */
public class UserService {

    /**
     * 根据用户名与密码获取用户信息
     *
     * @param account
     * @param password
     * @return
     */
    public UserLogin getUserLogin(String account, String password) {
        SqlSession session = DaoFactory.getSqlSessionFactory().openSession();
        try {
            UserLoginDao dao = session.getMapper(UserLoginDao.class);
            return dao.getUserLogin(account, password);
        } finally {
            session.close();
        }
    }
}
