package com.haozz.dailylearn.dailylearndetail.dailylearn202011.dailylearn_20201111;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author haozhezhe@yunquna.com
 * @date 17:23 2020-11-11
 */
@Component
public class DemoUtil {


    /**
     * 这个返回值类型为什么是这样写
     */
    public <T> Map<Long, UserVO> assembleUser(Collection<T> collection, Function<T, Long>... mappers) {

        Map<Long, UserVO> userVOs = new HashMap<>();

        if (CollectionUtils.isEmpty(collection) || null == mappers || mappers.length == 0) {
            return userVOs;
        }

        List<Integer> ids = new ArrayList<>();
        for (Function<T, Long> mapper : mappers) {
            ids.addAll(collection.stream().map(mapper).filter(id -> id != null).distinct().mapToInt(Long::intValue).boxed().collect(Collectors.toList()));
        }

        ids = ids.stream().distinct().collect(Collectors.toList());

        if (CollectionUtils.isEmpty(ids)) {
            return userVOs;
        }

        // todo

        return userVOs;
    }
}
