package me.collectmind.java.camp.homework.basic;

/**
 * 四则运算的字节码例子
 *
 * Created by monica on 2020/10/18.
 */
public class MovingAverage {
    private int count = 0;
    private double sum = 0.0D;

    public void submit(double value) {
        this.count++;
        this.sum += value;
    }

    public double getAvg() {
        if (0 == this.count) {
            return sum;
        }
        return this.sum / this.count;
    }
}
