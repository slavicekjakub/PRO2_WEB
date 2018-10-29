package cz.uhk.fim.webapp.gui;

import cz.uhk.fim.webapp.model.RSSItem;

import javax.swing.*;
import java.awt.*;

public class CardView extends JPanel {

    private static final int ITEM_WIDTH = 180;
    private static final int COMPONENT_WIDTH = 160;
    private static final int HEIGHT = 1;

    final String startHtml = "<html><p style='width: " + COMPONENT_WIDTH + "px'>";
    final String konecHtml = "</p></html>";


    public CardView(RSSItem item){
      setLayout(new WrapLayout());
      setSize(ITEM_WIDTH,HEIGHT);
      setTitle(item.getTitle());
      setBackground(Color.RED);
      setDescription(item.getDescription());
      setInfo(String.format("%s - %s", item.getPubDate(), item.getAutor()));
    }

    public void setTitle(String title){
        JLabel lblTitle = new JLabel();
        lblTitle.setSize(COMPONENT_WIDTH,HEIGHT);
        lblTitle.setFont(new Font("Courier",Font.BOLD,12));
        lblTitle.setText(String.format("%s%s%s",startHtml,title,konecHtml));
        add(lblTitle);
    }

    public void setDescription(String description){
        JLabel lblDescription = new JLabel();
        lblDescription.setSize(COMPONENT_WIDTH,HEIGHT);
        lblDescription.setFont(new Font("Courier",Font.PLAIN,11));
        lblDescription.setText(String.format("%s%s%s",startHtml,description,konecHtml));
        add(lblDescription);
    }

    public void setInfo(String info){
        JLabel lblInfo = new JLabel();
        lblInfo.setSize(COMPONENT_WIDTH,HEIGHT);
        lblInfo.setFont(new Font("Courier",Font.ITALIC,10));
        lblInfo.setText(String.format("%s%s%s",startHtml,info,konecHtml));
        lblInfo.setForeground(Color.LIGHT_GRAY);
        add(lblInfo);
    }

    //TODO: udelat kazdemu bloku jinou barvu, ale pokud se zavre a znovu otevre tak ta barva bude stejna jako puvodne (třídy Color + String)
    //TODO: omezit délku popisku na 50-100 znaků + zakončení 3 tečky(...) jakože to pokračuje
}
