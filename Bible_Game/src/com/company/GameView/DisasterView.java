package com.company.GameView;

import com.company.Spirit.DisasterViewSpirit.Bug;
import com.company.Spirit.DisasterViewSpirit.Frog;
import com.company.Spirit.DisasterViewSpirit.Ice;
import com.company.Spirit.DisasterViewSpirit.Tombstone;
import com.company.Spirit.Door;

import javax.swing.*;
import java.util.ArrayList;

public class DisasterView extends GameView {

    public ArrayList<Bug> getBugs() {
        return bugs;
    }

    public ArrayList<Frog> getFrogs() {
        return frogs;
    }

    public ArrayList<Ice> getIces() {
        return ices;
    }

    public ArrayList<Tombstone> getTombstones() {
        return tombstones;
    }

    private ArrayList<Bug> bugs = new ArrayList<>();
    private ArrayList<Frog> frogs = new ArrayList<>();
    private ArrayList<Ice> ices = new ArrayList<>();
    private ArrayList<Tombstone> tombstones = new ArrayList<>();

    public DisasterView() {
        img = new ImageIcon("egypt.jpg");
        elements = new ArrayList<>();
        door = new Door(10,10);

        bugs.add(new Bug(10, 5));
        bugs.add(new Bug(9, 5));
        bugs.add(new Bug(9, 4));
        bugs.add(new Bug(6, 2));
        bugs.add(new Bug(6, 3));
        bugs.add(new Bug(6, 4));
        bugs.add(new Bug(6, 5));
        frogs.add(new Frog(1, 2));
        frogs.add(new Frog(1, 3));
        frogs.add(new Frog(1, 4));
        frogs.add(new Frog(2, 2));
        frogs.add(new Frog(2, 3));
        ices.add(new Ice(7, 5));
        ices.add(new Ice(3, 5));
        ices.add(new Ice(5, 5));
        ices.add(new Ice(4, 5));
        ices.add(new Ice(8, 5));
        tombstones.add(new Tombstone(6, 6));
        tombstones.add(new Tombstone(7, 8));
        tombstones.add(new Tombstone(8, 8));
        tombstones.add(new Tombstone(9, 8));
        tombstones.add(new Tombstone(3, 8));

        elements.add(door);
        // addAll()可以把另一個 arrayList 放進去
        elements.addAll(bugs);
        elements.addAll(frogs);
        elements.addAll(ices);
        elements.addAll(tombstones);
    }
}
