package com.company.finder;

import com.company.model.Drone;
import com.company.model.Entity;
import com.company.model.Order;
import com.company.model.Warehouse;

import java.util.List;

/**
 * Created by user on 11.02.16.
 */
public class Finder {
    public Drone findNearestDrone(Entity entity, List<Drone> droneList){
        return null;
    }
    public Order findNearestOrder(Warehouse warehouse){
        return null;
    }
    public boolean isWarehouseDrones(List<Drone> drones, List<Warehouse> warehouses){
        for(Drone drone: drones){
            for(Warehouse warehouse: warehouses){
                if(drone.x == warehouse.x && drone.y == warehouse.y){
                    return true;
                }
            }
        }
        return false;
    }
}
