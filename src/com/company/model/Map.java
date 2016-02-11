package com.company.model;

import com.company.command.Deliver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bsh on 11.02.16.
 */
public class Map {

    public int width, height;
    public byte[][] map;

    public HashMap<Order, List<Deliver>> delivers = new HashMap<>();

    public List<Deliver> getDelivers(Order order) {
        if (delivers.get(order) == null) {
            delivers.put(order, new ArrayList<Deliver>());
        }

        return delivers.get(order);
    }

}
