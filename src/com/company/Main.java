package com.company;

import com.company.model.Order;
import com.company.model.Warehouse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String INPUT_FILE_NAME = "mother_of_all_warehouses.in";
    public static void main(String[] args) {
	// write your code here
        File file = new File(INPUT_FILE_NAME);
        try {
            Scanner scanner = new Scanner(file);
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int drones = scanner.nextInt();
            int T = scanner.nextInt();
            int maxWeight = scanner.nextInt();
            int productCount = scanner.nextInt();
            int[] productWeight = new int[productCount];
            for(int i = 0; i < productCount; i++){
                productWeight[i] = scanner.nextInt();
            }
            int warehouseCount = scanner.nextInt();
            List<Warehouse> warehouseList = new ArrayList<>();
            for(int i = 0; i < warehouseCount; i++){
                Warehouse warehouse = new Warehouse();
                warehouse.x = scanner.nextInt();
                warehouse.y = scanner.nextInt();
                warehouse.products = new int[productCount];
                for(int j = 0; j < productCount; j++){
                    warehouse.products[j] = scanner.nextInt();
                }
            }

            int orderCount = scanner.nextInt();
            List<Order> orders = new ArrayList<>();
            for(int i = 0; i < orderCount; i++){
                Order order = new Order();
                order.x = scanner.nextInt();
                order.y = scanner.nextInt();
                int orderItemsCount = scanner.nextInt();
                order.products = new int[orderItemsCount];
                for(int j = 0; j < orderItemsCount; j++){
                    order.products[j] = scanner.nextInt();
                }

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
