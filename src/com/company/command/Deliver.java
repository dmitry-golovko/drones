package com.company.command;

import com.company.model.Order;
import com.company.model.Warehouse;

/**
 * Created by bsh on 11.02.16.
 */
public class Deliver {

    public Deliver(Warehouse from, Order to, int product, int count) {
        this.from = from;
        this.to = to;
        this.product = product;
        this.count = count;
    }

    public Warehouse from;
    public Order to;
    public int product, count;

}
