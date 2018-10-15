package cz.uhk.fim.webapp.gui;

import cz.uhk.fim.webapp.utils.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class MainFrame extends JFrame{

    private JTable table;

    public MainFrame() {
        init();
    }

    private void init() {
        setTitle("RSS Reader");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initContentUI();
    }

    private void initContentUI() {
       JPanel controlPanel = new JPanel(new BorderLayout());
       JButton btnLoad = new JButton("Load");
       JTextField txtInputField = new JTextField();
       JButton btnSave = new JButton("Save");

       controlPanel.add(btnLoad, BorderLayout.WEST);
       controlPanel.add(txtInputField, BorderLayout.CENTER);
       controlPanel.add(btnSave, BorderLayout.EAST);

       add(controlPanel, BorderLayout.NORTH);

       JTextArea txtContent = new JTextArea();
       add(new JScrollPane(txtContent),BorderLayout.CENTER);

        try {
            txtContent.setText(FileUtils.loadStringFromFile("rss.xml"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
