package com.haozz.dailylearn.dailylearndetail.dailylearn202003.dailylearn_20200326;

import lombok.Builder;
import lombok.Data;

/**
 * @author: haozz
 * @date: 2020/3/26 22:30
 */
@Data
@Builder
public class RepeatEntity {

    private Integer index;

    private String firstName;

    private String secondName;

    private String thirdName;

    /**
     * 是否重复
     */
    private Integer isRepeat;
}
