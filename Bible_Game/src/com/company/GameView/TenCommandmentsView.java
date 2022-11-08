package com.company.GameView;

import com.company.Spirit.TenCommandmentSpirit.TenCommandment;

import javax.swing.*;
import java.util.ArrayList;

public class TenCommandmentsView extends GameView {

    public ArrayList<TenCommandment> getStones() {
        return stones;
    }

    private ArrayList<TenCommandment> stones = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }

    private int count;

    public TenCommandmentsView() {
        img = new ImageIcon("mountain.jpg");
        elements = new ArrayList<>();

        count = 0;

        stones.add(new TenCommandment(5,5));
        stones.add(new TenCommandment(1,4));
        stones.add(new TenCommandment(2,8));
        stones.add(new TenCommandment(3,3));
        stones.add(new TenCommandment(3,9));
        stones.add(new TenCommandment(4,8));
        stones.add(new TenCommandment(6,3));
        stones.add(new TenCommandment(7,4));
        stones.add(new TenCommandment(8,1));
        stones.add(new TenCommandment(9,2));

        elements.addAll(stones);

    }


}
