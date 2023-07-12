import javax.swing.*;
import java.awt.*;

public class inputTxt extends JFrame {

    TextField input;
    Label title;

    Label out;

    TextField result;
    public inputTxt(){
        input = new TextField();
        input.setBounds(10,40 ,250,50);
        title = new Label("Enter Number Here");
        title.setBounds(10,10,250,20);
        out = new Label("Converted sentence");
        out.setBounds(10, 90,250, 20);
        result = new TextField();
        result.setBounds(10,120 ,250,50);
    }
}
