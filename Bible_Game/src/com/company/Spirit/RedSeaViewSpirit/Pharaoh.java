package com.company.Spirit.RedSeaViewSpirit;

import com.company.Spirit.Spirit;

import javax.swing.*;

public class Pharaoh extends Spirit {

    public Pharaoh(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("pharaoh.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
