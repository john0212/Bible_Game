package com.company.Spirit.DisasterViewSpirit;

import com.company.Spirit.Spirit;

import javax.swing.*;

public class Ice extends Spirit {

    public Ice(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("ice.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
