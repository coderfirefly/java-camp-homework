package me.collectmind.java.camp.spring.framework.study.practice.domain;

import lombok.Data;

import java.util.List;

/**
 * 学生实体类仓库
 *
 * @author monica
 * @date 2020/11/28
 */
@Data
public class Klass {
    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }
}
