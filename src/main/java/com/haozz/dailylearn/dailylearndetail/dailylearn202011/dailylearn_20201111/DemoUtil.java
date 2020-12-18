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

    public void demo() {

        List<UserBO> list = new ArrayList();
        Map<Long, UserVO> userVOMap = assembleUser(list, UserBO::getUserId);
    }


    /**
     * 这个返回值类型为什么是这样写:<T> Map<Long, UserVO>
     *     其实返回的是Map<Long, UserVO>，为什么前面要加<T>，这个不加确实会报错
     *
     *     解答：  这个<T>只是为了标识入参中的Collection中的泛型T的类型，当入参中有泛型的时候，就要在方法返回值的前面这样声明，应该是固定写法
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
