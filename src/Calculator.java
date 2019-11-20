import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Calculator {

    public static Double value;
    public static String operation=null;

    public Calculator(Double value) {
        this.value = value;
        gui();
    }

    void gui(){
        JFrame f = new JFrame("Calculator");

        JTextArea tWindow = new JTextArea("");
        tWindow.setBorder(new LineBorder(Color.BLACK,4));
        tWindow.setBackground(Color.BLACK);
        tWindow.setForeground(Color.WHITE);
        tWindow.setFont(new Font("Arial", Font.BOLD, 16));

        JButton bOne = bCoolButton("1");
        JButton bTwo = bCoolButton("2");
        JButton bThree = bCoolButton("3");
        JButton bFour = bCoolButton("4");
        JButton bFive = bCoolButton("5");
        JButton bSix = bCoolButton("6");
        JButton bSeven = bCoolButton("7");
        JButton bEight = bCoolButton("8");
        JButton bNine = bCoolButton("9");
        JButton bZero = bCoolButton("0");
        JButton bAdd = bCoolButton("+");
        JButton bSubtract = bCoolButton("-");
        JButton bMultiply = bCoolButton("*");
        JButton bDivide = bCoolButton("/");
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
        textPanel.add(tWindow);

        JPanel gridPane = new JPanel();
        gridPane.setLayout(new GridLayout(6,3,3,3));
        gridPane.setBorder(new LineBorder(Color.ORANGE,3));
        gridPane.setBackground(Color.ORANGE);
        myContainer.add(gridPane);
        gridPane.add(bOne);
        gridPane.add(bTwo);
        gridPane.add(bThree);
        gridPane.add(bFour);
        gridPane.add(bFive);
        gridPane.add(bSix);
        gridPane.add(bSeven);
        gridPane.add(bEight);
        gridPane.add(bNine);
        gridPane.add(bZero);
        gridPane.add(bCancel);
        gridPane.add(bAdd);
        gridPane.add(bSubtract);
        gridPane.add(bMultiply);
        gridPane.add(bDivide);
        gridPane.add(bEquals);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,400);
        f.setVisible(true);

        bOne.addActionListener(e ->{
            if(tWindow.getText()=="") tWindow.setText("1");
            tWindow.append("1")
        });
        bTwo.addActionListener(e -> tWindow.append("2"));
        bThree.addActionListener(e -> tWindow.append("3"));
        bFour.addActionListener(e -> tWindow.append("4"));
        bFive.addActionListener(e -> tWindow.append("5"));
        bSix.addActionListener(e -> tWindow.append("6"));
        bSeven.addActionListener(e -> tWindow.append("7"));
        bEight.addActionListener(e -> tWindow.append("8"));
        bNine.addActionListener(e -> tWindow.append("9"));
        bZero.addActionListener(e -> tWindow.append("0"));
        bAdd.addActionListener(e -> {
            value=Double.parseDouble(tWindow.getText());
            tWindow.setText("");
            operation = "add";
        });
        bSubtract.addActionListener(e -> {
            value=Double.parseDouble(tWindow.getText());
            tWindow.setText("");
            operation = "subtract";
        });
        bMultiply.addActionListener(e -> {
            value=Double.parseDouble(tWindow.getText());
            tWindow.setText("");
            operation = "multiply";
        });
        bDivide.addActionListener(e -> {
            value=Double.parseDouble(tWindow.getText());
            tWindow.setText("");
            operation = "divide";
        });
        bEquals.addActionListener(e -> {
            if(operation!=null){
                switch(operation){
                    case"add":
                        value+=Double.parseDouble(tWindow.getText());
                        break;
                    case "subtract":
                        value-=Double.parseDouble(tWindow.getText());
                        break;
                    case "multiply":
                        value*=Double.parseDouble(tWindow.getText());
                        break;
                    case "divide":
                        value/=Double.parseDouble(tWindow.getText());
                        break;
                }
            }
            tWindow.setText(value.toString());
        });
        bCancel.addActionListener(e -> {
            value=0d;
            tWindow.setText("0");
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
