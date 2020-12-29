package me.collectmind.java.camp.spring.framework.study.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 学生实体类
 *
 * @author monica
 * @date 2020/11/28
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Student implements Serializable {
    private int id;

    private String name;

    public void init() {
        System.out.println("hello.........");
    }

    public Student create() {
        return new Student(101, "KK101");
    }
}
