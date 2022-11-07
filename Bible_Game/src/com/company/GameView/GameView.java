package com.company.GameView;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import com.company.Main;
import com.company.Spirit.*;

public abstract class GameView {

    protected ArrayList<Spirit> elements;
    protected Door door;
    protected ImageIcon img;

    public void drawView(Graphics g) {
        img.paintIcon(null, g, 0, 0);
        // 這兩行是在物件下面多了一層黑色的正方形(但物件本身不會影響)，是美化的功能
        g.setColor(new Color(0f, 0f, 0f, .3f));
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        for (Spirit s : elements) {
            // 要讓 spirit 來畫他自己
            s.draw(g);
        }
    }
}
