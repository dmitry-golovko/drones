package com.company;

import com.company.command.Deliver;
import com.company.model.Map;
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

    public static Map bookProducts(List<Order> orders, List<Warehouse> warehouses) {

        Map map = new Map();

        for (Order order : orders) {

            for (int i = 0; i < order.products.length; i++) {

                if (order.products[i] == 0)
                    continue;

                for (Warehouse warehouse : warehouses) {

                    int prodW = warehouse.products[i];
                    int prodC = order.products[i];

                    if (prodW != 0) {

                        List<Deliver> delivers = map.getDelivers(order);
                        Deliver deliver;

                        if (prodW >= prodC) {
                            deliver = new Deliver(warehouse, order, i, prodW - prodC);
                            prodW -= prodC;
                            prodC = 0;
                        } else {
                            deliver = new Deliver(warehouse, order, i, prodC - prodW);
                            prodW = 0;
                            prodC -= prodW;
                        }

                        delivers.add(deliver);

                        warehouse.products[i] = prodW;
                        warehouse.books[i] += deliver.count;
                        order.products[i] = prodC;
                        order.books[i] += deliver.count;
                    }
                }
            }
        }

        return map;
    }

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

}
