package cz.uhk.fim.webapp.gui;

import cz.uhk.fim.webapp.model.RSSItem;
import cz.uhk.fim.webapp.model.RSSList;
import cz.uhk.fim.webapp.utils.RSSParser;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;


public class MainFrame extends JFrame{

    private static final String VALIDATION_TYPE = "VALIDATION_TYPE";
    private static final String IO_LOAD_TYPE = "IO_LOAD_TYPE";
    private static final String IO_SAVE_TYPE = "IO_SAVE_TYPE";

    private JTable table;
    private JLabel lblErrorMessage;
    private JTextField txtInputField;

    private RSSList rssList;

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
       txtInputField = new JTextField();
       JButton btnSave = new JButton("Save");
       lblErrorMessage = new JLabel();
       lblErrorMessage.setForeground(Color.RED);
       lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
       lblErrorMessage.setVisible(false);

       controlPanel.add(btnLoad, BorderLayout.WEST);
       controlPanel.add(txtInputField, BorderLayout.CENTER);
       controlPanel.add(btnSave, BorderLayout.EAST);
       controlPanel.add(lblErrorMessage, BorderLayout.NORTH);

       add(controlPanel, BorderLayout.NORTH);

       JPanel contentPanel = new JPanel(new WrapLayout());
       add(new JScrollPane(contentPanel),BorderLayout.CENTER);

        try {
            rssList = new RSSParser().getparseRSS("sc-47.xml");
            for (RSSItem item: rssList.getAllItems()){
                contentPanel.add(new CardView(item));
            }
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

//       btnLoad.addActionListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
//               if (validateInput()){
//                  try{
//                      txtContent.setText(FileUtils.loadStringFromFile(txtInputField.getText()));
//                  }catch (IOException e1){
//                      showErrorMessage(IO_LOAD_TYPE);
//                      e1.printStackTrace();
//                  }
//               }
//           }
//       });
//
//       btnSave.addActionListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
//               if (validateInput()){
//                   try {
//                       FileUtils.saveStringToFile(txtInputField.getText(), txtContent.getText().getBytes("UTF-8"));
//                   } catch (IOException e1) {
//                       showErrorMessage(IO_SAVE_TYPE);
//                       e1.printStackTrace();
//                   }
//                   try {
//                       rssList = new RSSParser().getparseRSS(txtInputField.getText());
//                       txtContent.setText("");
//                       for (RSSItem item: rssList.getAllItems()){
//                           txtContent.append(String.format("%s - autor: %s%n", item.getTitle(),item.getAutor()));
//                       }
//                   } catch (IOException | SAXException |ParserConfigurationException e1) {
//                       e1.printStackTrace();
//                   }
//
//               }
//           }
//       });
//
//
//       try {
//            txtContent.setText(FileUtils.loadStringFromFile("rss.xml"));
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }

    private boolean validateInput(){
        if (txtInputField.getText().trim().isEmpty()){
            showErrorMessage(VALIDATION_TYPE);
            return false;
        }
        lblErrorMessage.setVisible(false);
        return true;
    }

    private void showErrorMessage(String type){
        String message;
        switch (type){
            case VALIDATION_TYPE:
                message = "Chyba! Pole nesmí být prázdné!";
                break;
            case IO_LOAD_TYPE:
                message = "Chyba při načítání!";
                break;
            case IO_SAVE_TYPE:
                message = "Chyba při ukládání!";
                break;
            default:
                message = "Něco se pokazilo";
                break;
        }
        lblErrorMessage.setText(message);
        lblErrorMessage.setVisible(true);
    }

}
