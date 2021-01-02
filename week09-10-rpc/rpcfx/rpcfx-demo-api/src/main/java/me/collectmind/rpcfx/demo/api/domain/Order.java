package me.collectmind.rpcfx.demo.api.domain;

/**
 * 订单实体类
 *
 * @author monica
 * @date 2020/12/26
 */
public class Order {
    /**
     * 订单号
     */
    private int id;
    /**
     * 订单用户名
     */
    private String name;

    /**
     * 订单金额
     */
    private float amount;


    public Order(int id, String name, float amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
