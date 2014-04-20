package com.vernon.netty.core.common.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM8:13
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtilTest {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtilTest.class);

    @Test
    public void testToJson() {
        User user1 = new User(1111, "陈袁11");
        User user2 = new User(2222, "陈袁22");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        String json = JsonUtil.toJson(list);
        logger.info("JSON: {}", json);
    }

    @Test
    public void testJson2Object() {
        String json = "{\"userId\":2222,\"userName\":\"陈袁22\"}";
        User user = (User) JsonUtil.json2Object(json, User.class);
        logger.info("User: {}", user.toString());
    }

    @Test
    public void testJson2Map() {
        String json = "{\"chenyuan\":{\"userId\":2222,\"userName\":\"陈袁22\"}," +
                "\"daijing\":{\"userId\":2222,\"userName\":\"戴静22 这个是媳妇？ \"}}";
        // 测试
        String name = "你觉得呢? :(";
        Map<String, Object> map = (Map<String, Object>) JsonUtil.json2Map(json);
        if (map != null) {
            for (String key : map.keySet()) {
                logger.info("key : {}", key);
            }
        }

    }

    @Test
    public void testJson2GenericObject() {
        String json = "[{\"userId\":1111,\"userName\":\"陈袁11\"},{\"userId\":2222,\"userName\":\"陈袁22\"}]";
        TypeReference<List<User>> tr = new TypeReference<List<User>>() {
        };
        List<User> list = JsonUtil.json2GenericObject(json, tr);
        logger.info("list size() is : {}", list == null ? 0 : list.size());
        if (list != null && list.size() > 0) {
            for (User user : list) {
                logger.info(" User toString() : {}", user.toString());
            }
        }
    }


}

class User {

    private Integer userId;
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public User() {
    }

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
