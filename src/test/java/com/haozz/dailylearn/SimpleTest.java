package com.haozz.dailylearn;

import com.haozz.dailylearn.mp.entity.User;
import com.haozz.dailylearn.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2020/1/4 15:28
 **/

@SpringBootTest

public class SimpleTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMyBatisPlus() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        Assert.isTrue(list.size() == 1, "查询失败");
    }

    @Test
    public void testByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ROBIN");
        map.put("age", "30");
        //where name= 'ROBIN' and age= 30;
        List<User> list = userMapper.selectByMap(map);
        System.out.println("==============" + list);

    }
}
