package com.company.Spirit.DisasterViewSpirit;

import com.company.Spirit.Spirit;

import javax.swing.*;

public class Tombstone extends Spirit {

    public Tombstone(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("tombstone.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
