package com.anstasia.account.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
