import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Convert");
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(500,400, 300, 300);
        jFrame.setResizable(false);
        //components
        JButton con = new conButton().convert;
        JButton clear = new conButton(1).convert;
        TextField input = new inputTxt().input;
        Label title = new inputTxt().title;
        Label out = new inputTxt().out;
        TextField result = new inputTxt().result;
        //add
        panel1.add(title);
        panel1.add(input);
        panel1.add(out);
        panel1.add(result);
        panel1.add(con);
        panel1.add(clear);
        jFrame.add(panel1);

        // action
        clear.addActionListener(c ->{
            input.setText("");
            result.setText("");
        });
        con.addActionListener(c ->{
            String temp = input.getText();
            conversion num2W = new conversion(temp);
            result.setText(num2W.words());
        });
        jFrame.setVisible(true);
    }
}
