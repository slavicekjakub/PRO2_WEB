package cz.uhk.fim.webapp.gui;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.red;

public class DetailFrame extends JFrame
{
    private static final int ITEM_WIDTH = 300;
    private static final int ITEM_HEIGHT =400;
    private static final int COMPONENT_WIDTH = 160;
    private static final int HEIGHT = 1;

    private final String startHtml = "<html><p style='width:"+COMPONENT_WIDTH+"px'>";
    private final String endHtml = "</p></html>";

    public DetailFrame(CardView cardView, color)
    {
        setLayout(new WrapLayout());
        setSize(ITEM_WIDTH, ITEM_HEIGHT);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(MouseInfo.getPointerInfo().getLocation());
    }


    public void setTitle(String title)
    {
        JLabel lblTitle = new JLabel();
        lblTitle.setSize(COMPONENT_WIDTH,HEIGHT);
        lblTitle.setFont(new Font("Courier", Font.BOLD, 12));
        lblTitle.setText(String.format("%s%s%s", startHtml,title, endHtml));
        setBackground(red);
        add(lblTitle);
    }


    private void setDescription(String description)
    {

        JLabel lblDescription = new JLabel();
        lblDescription.setSize(COMPONENT_WIDTH,HEIGHT);
        lblDescription.setFont(new Font("Courier", Font.PLAIN, 11));
        lblDescription.setText(description);
        lblDescription.setText(String.format("%s%s%s", startHtml,description, endHtml));
        add(lblDescription);
    }


    private void setLink(String link)
    {
        JLabel lblLink = new JLabel();
        lblLink.setSize(COMPONENT_WIDTH,HEIGHT);
        lblLink.setFont(new Font("Courier", Font.BOLD, 12));
        lblLink.setText(String.format("%s<a href='%s'>%s</a>%s", startHtml,link,link, endHtml));
        add(lblLink);
    }

    private void setInfo(String info)
    {
        JLabel lblInfo = new JLabel();
        lblInfo.setSize(COMPONENT_WIDTH,HEIGHT);
        lblInfo.setFont(new Font("Courier", Font.ITALIC, 10));
        lblInfo.setForeground(Color.black);
        lblInfo.setText(String.format("%s%s%s", startHtml,info, endHtml));
        add(lblInfo);
    }

}