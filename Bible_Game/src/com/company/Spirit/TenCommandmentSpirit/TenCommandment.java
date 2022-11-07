package com.company.Spirit.TenCommandmentSpirit;

import com.company.Spirit.Spirit;

import javax.swing.*;

public class TenCommandment extends Spirit {

    public TenCommandment(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("stone.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
