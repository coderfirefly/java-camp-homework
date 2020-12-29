package me.collectmind.week06.java.practice.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Guava
 * 事件总线 EventBus示例
 * @author monica
 * @date 2020/12/19
 */
public class GuavaDemo2 {
    static EventBus bus = new EventBus();
    static {
        bus.register(new GuavaDemo2());
    }


    public static void main(String[] args) {
        Student student = new Student(2, "KK02");
        System.out.println("I want " + student + " run now.");
        bus.post(new Aevent(student));
    }

    @Data
    @AllArgsConstructor
    public static class Aevent {
        private Student student;
    }

    @Subscribe
    public void handle(Aevent ae) {
        System.out.println(ae.student + "is running.");
    }
}
