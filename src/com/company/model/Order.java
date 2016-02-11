package com.company.model;

/**
 * Created by bsh on 11.02.16.
 */
public class Order extends Entity {

    public int[] products;

    public int[] books;

    public boolean isEmpty(){
        if(books == null){
            return true;
        }
        for (int book : books) {
            if (book > 0) {
                return false;
            }
        }
        return true;
    }

}
