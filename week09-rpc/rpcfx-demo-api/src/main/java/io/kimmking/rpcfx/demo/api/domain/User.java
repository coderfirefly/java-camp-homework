package io.kimmking.rpcfx.demo.api.domain;

/**
 * 用户实体类
 *
 * @author kimmking
 * @date 2020/12/26
 */
public class User {
    /**
     * 用户id
     */
    private int id;

    /**
     * 用户名
     */
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
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
}
