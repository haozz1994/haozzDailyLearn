package com.haozz.dailylearn.dailylearndetail.dailylearn202106.dailylearn_20210619;

/**
 * @author haozhezhe@yunquna.com
 * @date 3:51 PM 6/19/21
 */
public class User {

    private int id;
    private String name;

    byte[] a = new byte[1024*100];

    public User(){}

    public User(int id, String name) {
        super();
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
