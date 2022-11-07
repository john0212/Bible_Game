package com.company.GameView;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import com.company.Spirit.*;

public abstract class GameView {

    protected ArrayList<Spirit> elements;
    protected Door door;
    protected ImageIcon img;

    public void drawView(Graphics g) {
        img.paintIcon(null, g, 0, 0);
        for (Spirit s : elements) {
            // 要讓 spirit 來畫他自己
            s.draw(g);
        }
    }
}
