package com.company.Spirit.DisasterViewSpirit;

import com.company.Spirit.Spirit;

import javax.swing.*;

public class Frog extends Spirit {

    public Frog(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("frog.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
