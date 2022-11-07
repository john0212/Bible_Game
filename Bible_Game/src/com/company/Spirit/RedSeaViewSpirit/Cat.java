package com.company.Spirit.RedSeaViewSpirit;

import com.company.Spirit.Spirit;

import javax.swing.*;

public class Cat extends Spirit {

    public Cat(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("cat.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
