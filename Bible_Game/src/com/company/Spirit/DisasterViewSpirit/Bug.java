package com.company.Spirit.DisasterViewSpirit;

import com.company.Spirit.Spirit;

import javax.swing.*;

public class Bug extends Spirit {

    public Bug(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("bug.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
