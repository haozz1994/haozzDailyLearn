package com.haozz.dailylearn;

import com.haozz.dailylearn.mp.entity.User;
import com.haozz.dailylearn.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author
 * @date 2020/1/4 15:28
 **/

@SpringBootTest

public class SimpleTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMyBatisPlus(){

        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        Assert.isTrue(list.size() == 1 , "查询失败");

    }
}
