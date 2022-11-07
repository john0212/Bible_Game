package com.company.Spirit;

import com.company.Main;

import javax.swing.*;
import java.awt.*;

public abstract class Spirit {

    protected ImageIcon img;
    // 相對位置(意思是他在最左上角座標是(1,1)，以此類推)
    protected Point relativePosition;
    // 絕對位置(這是來畫他真正的位置用的)
    protected Point absolutePosition;

    public void draw(Graphics g) {
        img.paintIcon(null, g, absolutePosition.x, absolutePosition.y);
    }

    public void setPosition(int x, int y) {
        relativePosition = new Point(x, y);
        // 不懂可以回去看 93 21:00
        absolutePosition = new Point((x - 1) * Main.CELL, (y - 1) * Main.CELL);
    }
}
