package me.collectmind.week06.java.practice.java8;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by monica on 2020/12/18.
 */
public class LambdaDemo<T extends Serializable&Comparable> {

    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();

        // 不使用 Lambda 的方式
        MathOperation op = new MathOperation() {
            @Override
            public Object operation(int a, int b) {
                return 1;
            }
        };
        // 使用 Lambda 方式
        MathOperation op1 = (a, b) -> 1;

        MathOperation addition = (int a, int b) -> a + b;


        MathOperation multi = (int a, int b) -> {
            int c = 1000;
            return a * b + c;
        };

        System.out.println("10 + 5  = " + demo.operate(10, 5, addition));
        System.out.println("10 * 5  = " + demo.operate(10, 5, multi));

        // 方法引用
        Arrays.asList(1, 2, 3).forEach(x -> System.out.println(x + 3));
        Arrays.asList(1, 2, 3).forEach(System.out::println);
    }

    private <T> T operate(int a, int b, MathOperation<T> mathOperation) {
        return mathOperation.operation(a, b);
    }


    interface MathOperation<T> {
        T operation(int a, int b);
    }
}

