import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextArea{
    JTextArea text;
    JTextField textField;
    JCheckBox checkBox;

    public static void main(String[] args){
        TextArea gui = new TextArea();
        gui.go();

    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton button = new JButton("Just click it");
        button.addActionListener(new BtnListener());

        textField = new JTextField();
        textField.setText("Type something");
        textField.addActionListener(new FieldListener());

        text = new JTextArea(10,20);
        text.setLineWrap(true);
        text.setText("There will display your operation and Mytext.txt \n");

        try {
            File myFile = new File("Mytext.txt");
            FileReader reader = new FileReader(myFile);
            BufferedReader myReader = new BufferedReader(reader);

            String line = null;

            while ((line = myReader.readLine()) != null){
                text.append(line+"\n");
            }
            myReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        checkBox = new JCheckBox("love mv");
        checkBox.addItemListener(new CheckBoxListener());


        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.NORTH,textField);
        frame.getContentPane().add(BorderLayout.EAST,checkBox);
        frame.setSize(400,300);
        frame.setVisible(true);
    }

    class BtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            text.append("button clicked \n");
        }
    }
    class FieldListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            text.append("you typed : "+textField.getText()+"\n");
        }
    }
    class CheckBoxListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (checkBox.isSelected()){
                System.out.println("love mv forever");
            }
        }
    }
}
