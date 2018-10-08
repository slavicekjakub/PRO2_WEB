package cz.uhk.fim.webapp.gui;

import javax.swing.*;


public class MainFrame extends JFrame{

    private JTable table;

    public MainFrame() {
        init();
    }

    private void init() {
        setTitle("Web App");
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
