import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoolSignsButton extends JButton implements ActionListener {

    String name;


    public CoolSignsButton(String name) {
        super(name);
        this.name = name;
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculator.value = Double.parseDouble(Calculator.tScore.getText());
        Calculator.isChecked = true;
        if(name=="+") Calculator.operation = "add";
        else if (name=="-") Calculator.operation = "subtract";
        else if (name=="*") Calculator.operation = "multiply";
        else Calculator.operation = "divide";
    }
}
