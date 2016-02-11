package com.company.command;

import com.company.model.Drone;
import com.company.model.Order;
import com.company.model.Warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsh on 11.02.16.
 */
public class Command {

    public static List<String> commands = new ArrayList<>();

    public static void load(Drone drone, Warehouse warehouse, int product, int count) {
        commands.add(drone.num + " L " + warehouse.num + " " + product + " " + count);
    }

    public static void deliver(Drone drone, Order order, int product, int count) {
        commands.add(drone.num + " D " + order.num + " " + product + " " + count);
    }

    public static void unload(Drone drone, Warehouse warehouse, int product, int count) {
        commands.add(drone.num + " U " + warehouse.num + " " + product + " " + count);
    }

    public static void wait(Drone drone, int count) {
        commands.add(drone.num + " W " + count);
    }

}
