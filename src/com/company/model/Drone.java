package com.company.model;

/**
 * Created by bsh on 11.02.16.
 */
public class Drone extends Entity {

    public Drone(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    public int payload;
    public int time;

}
