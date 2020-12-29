package me.collectmind.java.camp.spring.framework.study.work.thursday.aop.service.impl;

import me.collectmind.java.camp.spring.framework.study.work.thursday.aop.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * 接口实现类 用于测试AOP
 *
 * @author monica
 * @date 2020/11/29
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Override
    public void submitHomework() {
        System.out.println("student do submit homework");
    }
}
