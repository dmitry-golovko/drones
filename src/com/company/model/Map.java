package com.company.model;

import com.company.Algo;
import com.company.command.Command;
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

    public void run(int maxWeight, List<Drone> drones, List<Warehouse> warehouses, List<Order> orders) {

        Algo.bookProducts(this, maxWeight, orders, warehouses);

        while (isOrdersEmpty()) {

            Drone drone = Algo.getFreeDrone(drones);
            Warehouse warehouse = Algo.findNearestWarehouse(drone, warehouses);

            Order order = findNearestOrder(orders, warehouse.num);

            List<Deliver> del = delivers.get(order);
            Deliver d = getDeliverForWar(warehouse, del);

            Command.load(drone, warehouse, d.product, d.count);
            Command.deliver(drone, order, d.product, d.count);
        }
    }

    Deliver getDeliverForWar(Warehouse warehouse, List<Deliver> delivers) {

        Deliver r = null;

        for (Deliver deliver : delivers) {

            if (deliver.from.num == warehouse.num) {
                r = deliver;
                break;
            }
        }

        delivers.remove(r);

        return r;
    }

    Order findNearestOrder(List<Order> orders, int warNum) {

        int min = Integer.MAX_VALUE;
        int ind = 0;

        for (int i = 0; i < Algo.pathsFromWarehouse[warNum].length; i++) {
            if (min > Algo.pathsFromWarehouse[warNum][i]) {
                min = Algo.pathsFromWarehouse[warNum][i];
                ind = i;
            }
        }

        return orders.get(ind);
    }

    boolean isOrdersEmpty() {
        return delivers.isEmpty();
    }

    public List<Deliver> getDelivers(Order order) {
        if (delivers.get(order) == null) {
            delivers.put(order, new ArrayList<Deliver>());
        }

        return delivers.get(order);
    }

}
