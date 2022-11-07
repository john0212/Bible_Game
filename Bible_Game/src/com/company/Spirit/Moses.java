package com.company.Spirit;

import com.company.GameView.DisasterView;
import com.company.Main;
import com.company.Spirit.DisasterViewSpirit.Bug;
import com.company.Spirit.DisasterViewSpirit.Frog;
import com.company.Spirit.DisasterViewSpirit.Ice;
import com.company.Spirit.DisasterViewSpirit.Tombstone;

import javax.swing.*;
import java.util.ArrayList;

public class Moses extends Spirit {

    public Moses(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("Moses.png");
    }

    @Override
    public String overlap(int x, int y) {
        if (Main.gameView instanceof DisasterView) {
            // check for bugs and frogs
            ArrayList<Frog> frogs = ((DisasterView) Main.gameView).getFrogs();
            ArrayList<Bug> bugs = ((DisasterView) Main.gameView).getBugs();
            for (Frog f : frogs) {
                if (f.getRelativePosition() != null && x == f.getRelativePosition().x && y == f.getRelativePosition().y) {
                    return "Die";
                }
            }
            for (Bug b : bugs) {
                if (b.getRelativePosition() != null && x == b.getRelativePosition().x && y == b.getRelativePosition().y) {
                    return "Die";
                }
            }

            // check for ice and tombstones
            ArrayList<Ice> ices = ((DisasterView) Main.gameView).getIces();
            ArrayList<Tombstone> tombstones = ((DisasterView) Main.gameView).getTombstones();
            for (Ice i : ices) {
                if (i.getRelativePosition() != null && x == i.getRelativePosition().x && y == i.getRelativePosition().y) {
                    return "Cannot move";
                }
            }
            for (Tombstone t : tombstones) {
                if (t.getRelativePosition() != null && x == t.getRelativePosition().x && y == t.getRelativePosition().y) {
                    return "Cannot move";
                }
            }
        }

        return "none";
    }
}
