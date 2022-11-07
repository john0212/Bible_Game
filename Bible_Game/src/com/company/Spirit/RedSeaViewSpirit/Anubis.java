package com.company.Spirit.RedSeaViewSpirit;

import com.company.Spirit.Spirit;

import javax.swing.*;

public class Anubis extends Spirit {

    public Anubis(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("anubis.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
