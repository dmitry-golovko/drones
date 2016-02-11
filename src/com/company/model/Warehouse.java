package com.company.model;

/**
 * Created by bsh on 11.02.16.
 */
public class Warehouse extends Entity {

    public int[] products;

    public boolean isEmpty(){
        if(products == null){
            return true;
        }
        for(int i = 0; i < products.length; i++){
            if(products[i] > 0){
                return false;
            }
        }
        return true;
    }
}
