package com.haozz.dailylearn;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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


    @Test
    public void testByWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "B").lt("age", 35);// name like '%B%' and age <35;

//        wrapper.likeLeft("name","N").or().between("age",20,40).orderByAsc("age");//name like '%N' or age between 20 and 40 order age asc;


        List<User> users = userMapper.selectList(wrapper);

        System.out.println(users);

    }


}
