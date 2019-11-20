import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoolDigitsButton extends JButton implements ActionListener {

    String name;

    public CoolDigitsButton(String name) {
        super(name);
        this.name = name;
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Calculator.isChecked) {
            Calculator.tScore.setText(name);
            Calculator.isChecked = false;
        }
        else Calculator.tScore.append(name);
    }
}
