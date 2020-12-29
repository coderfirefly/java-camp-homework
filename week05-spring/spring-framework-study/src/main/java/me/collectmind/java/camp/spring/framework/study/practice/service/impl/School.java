package me.collectmind.java.camp.spring.framework.study.practice.service.impl;

import lombok.Data;
import me.collectmind.java.camp.spring.framework.study.practice.domain.Klass;
import me.collectmind.java.camp.spring.framework.study.practice.domain.Student;

import me.collectmind.java.camp.spring.framework.study.practice.service.ISchool;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * School接口实现
 * @author monica
 * @date 2020/11/28
 */
@Data
public class School implements ISchool {

    @Autowired(required = true)
    Klass class1;


    @Resource(name = "student100")
    Student student100;


    @Override
    public void ding() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }
}
