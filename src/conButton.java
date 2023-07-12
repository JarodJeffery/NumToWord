
import javax.swing.*;
import java.awt.*;
public class conButton extends JFrame{

    public JButton convert;
    public conButton(){
        convert = new JButton("Convert");
        convert.setBounds(20,200,100,40);
    }

    public conButton(int i){
        convert = new JButton("Clear");
        convert.setBounds(150,200,100,40);
    }
}
