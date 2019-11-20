import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Calculator {

    public static Double value;
    public static String operation = null;
    public static Boolean isChecked = false;
    public static JTextArea tScore;

    public Calculator(Double value) {
        this.value = value;
        gui();
    }

    void gui(){
        JFrame f = new JFrame("Calculator");

        tScore = new JTextArea("");
        tScore.setBorder(new LineBorder(Color.BLACK,4));
        tScore.setBackground(Color.BLACK);
        tScore.setForeground(Color.WHITE);
        tScore.setFont(new Font("Arial", Font.BOLD, 16));

        JButton bOne = new CoolDigitsButton("1");
        JButton bTwo = new CoolDigitsButton("2");
        JButton bThree = new CoolDigitsButton("3");
        JButton bFour = new CoolDigitsButton("4");
        JButton bFive = new CoolDigitsButton("5");
        JButton bSix = new CoolDigitsButton("6");
        JButton bSeven = new CoolDigitsButton("7");
        JButton bEight = new CoolDigitsButton("8");
        JButton bNine = new CoolDigitsButton("9");
        JButton bZero = new CoolDigitsButton("0");

        JButton bAdd = new CoolSignsButton("+");
        JButton bSubtract = new CoolSignsButton("-");
        JButton bMultiply = new CoolSignsButton("*");
        JButton bDivide = new CoolSignsButton("/");

        JButton bEquals = bCoolButton("=");
        JButton bCancel = bCoolButton("C");


        Container myContainer = f.getContentPane();
        myContainer.setLayout(new BorderLayout(6,6));
        myContainer.setBackground(Color.ORANGE);
        f.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.WHITE));

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.BLACK);
        textPanel.setBorder(new LineBorder(Color.ORANGE,4));
        textPanel.setLayout(new FlowLayout(2));
        myContainer.add(textPanel, BorderLayout.NORTH);
        textPanel.add(tScore);

        JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(4,4,3,3));
        gridPane.setBorder(new LineBorder(Color.ORANGE,3));
        gridPane.setBackground(Color.ORANGE);
        myContainer.add(gridPane);

        gridPane.add(bOne);
        gridPane.add(bTwo);
        gridPane.add(bThree);
        gridPane.add(bAdd);

        gridPane.add(bFour);
        gridPane.add(bFive);
        gridPane.add(bSix);
        gridPane.add(bSubtract);

        gridPane.add(bSeven);
        gridPane.add(bEight);
        gridPane.add(bNine);
        gridPane.add(bMultiply);

        gridPane.add(bCancel);
        gridPane.add(bZero);
        gridPane.add(bEquals);
        gridPane.add(bDivide);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);
        f.setVisible(true);

        bEquals.addActionListener(e -> {
            if(operation!=null){
                switch(operation){
                    case"add":
                        value+=Double.parseDouble(tScore.getText());
                        break;
                    case "subtract":
                        value-=Double.parseDouble(tScore.getText());
                        break;
                    case "multiply":
                        value*=Double.parseDouble(tScore.getText());
                        break;
                    case "divide":
                        value/=Double.parseDouble(tScore.getText());
                        break;
                }
            }
            tScore.setText(value.toString());
        });
        bCancel.addActionListener(e -> {
            value = 0d;
            tScore.setText("0");
            isChecked = true;
            operation = null;
        });
    }

    JButton bCoolButton(String name){
        JButton button = new JButton(name);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        return button;
    }
}
