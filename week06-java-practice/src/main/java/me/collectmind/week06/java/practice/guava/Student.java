package me.collectmind.week06.java.practice.guava;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Student 实体
 * @author monica
 * @date 2020/12/19
 */
@Data
@NoArgsConstructor
@ToString
@Slf4j
@AllArgsConstructor
public class Student implements Serializable {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private String name;

}
