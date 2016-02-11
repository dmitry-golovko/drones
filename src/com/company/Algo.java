package com.company;

import com.company.model.Drone;
import com.company.model.Order;
import com.company.model.Warehouse;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bsh on 11.02.16.
 */
public class Algo {

    public static int[][] pathsFromWarehouse;
    public static int[][] pathsFromOrders;

    public static void calcPaths(List<Warehouse> warehouses, List<Order> orders) {
        pathsFromWarehouse = new int[warehouses.size()][orders.size()];

        for (Warehouse warehouse : warehouses) {
            for (Order order : orders) {
                pathsFromWarehouse[warehouse.num][order.num] = getDistance(warehouse.x, warehouse.y, order.x, order.y);
                pathsFromOrders[order.num][warehouse.num] = pathsFromWarehouse[warehouse.num][order.num];
            }
            Arrays.sort(pathsFromWarehouse[warehouse.num]);
        }

        for (Order order : orders) {
            Arrays.sort(pathsFromOrders[order.num]);
        }

    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.floor(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
    }

    public static void reverse(int[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            // swap the values at the left and right indices
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }
    public static Drone getFreeDrone(List<Drone> drones){
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < drones.size(); i++){
            if(drones.get(i).time == 0) {
                return drones.get(i);
            }else if(drones.get(i).time < minValue){
                minValue = drones.get(i).time;
                minIndex = i;
            }
        }
        for(Drone drone: drones){
            drone.time -= minValue;
        }
        return drones.get(minIndex);

    }

}
