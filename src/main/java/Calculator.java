import com.sun.org.apache.xalan.internal.xsltc.compiler.FlowList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static com.sun.deploy.util.DeployUIManager.setLookAndFeel;


public class Calculator extends JFrame implements FocusListener {
    JTextField value1, value2, sum;
    JLabel plus, equals;

    public Calculator() {
        super("Dodaj dwie liczby");
setSize(350, 90);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLookAndFeel();
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);

value1 = new JTextField("0", 5);
plus = new JLabel("+");
value2 = new JTextField("0", 5);
equals = new JLabel("=");
sum = new JTextField("0", 5);

value1.addFocusListener(this);
value2.addFocusListener(this);

sum.setEditable(false);

add(value1);
add(plus);
add(value2);
add(equals);
add(sum);
setVisible(true);


    }


    public void focusGained(FocusEvent event) {
        try {
            float total = Float.parseFloat(value1.getText()) + Float.parseFloat(value2.getText());
            sum.setText("" + total);
        }
        catch (NumberFormatException nfe){
            value1.setText("0");
            value2.setText("0");
            sum.setText("0");



        }


    }

    public void focusLost(FocusEvent event) {
        focusGained(event);
    }

    private void setLookAndFeel() {
      try {
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
          SwingUtilities.updateComponentTreeUI(this);}
          catch (Exception exc) {
          System.err.println("Nie potrafię wczytać " + "systemowego wyglądu: " + exc);
          }
      }


       public static void main (String[] arguments) {
        Calculator frame = new Calculator();





       }



    }








