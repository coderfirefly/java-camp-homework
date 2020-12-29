package me.collectmind.java.camp.spring.framework.study.work.thursday.bean.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户实体类
 * 用于测试Bean的装配
 *
 * @author monica
 * @date 2020/11/29
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;
}
