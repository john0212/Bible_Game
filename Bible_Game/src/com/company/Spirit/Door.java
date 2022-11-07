package com.company.Spirit;

import javax.swing.*;

public class Door extends Spirit {

    public Door(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("door.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
