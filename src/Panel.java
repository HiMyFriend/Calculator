import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Panel extends JPanel {

    private Font font;
    private JTextField output;

    private JButton numbers[];
    private JButton backspace;
    private JButton equals;
    private JButton plus;
    private JButton minus;
    private  JButton multi;
    private JButton div;
    private JButton clear;
    private JButton dot;

    private double firstNum;
    private double secondNum;
    private double result;
    private String operations;

    Panel(){
        numbers = new JButton[10];
        font = new Font("SanSerif", Font.BOLD, 20);
        output = new JTextField("Введите число...", 2000);
        backspace = new JButton("\uF0E7");
        equals = new JButton("=");
        plus = new JButton("+");
        minus = new JButton("-");
        multi = new JButton("*");
        div = new JButton("/");
        clear = new JButton("C");
        dot = new JButton(".");

        setLayout(null);
        setFocusable(true);
        grabFocus();

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                numbers[y * 3 + x + 1] = new JButton((y * 3 + x + 1) + "");
                numbers[y * 3 + x + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);
                numbers[y * 3 + x + 1].setFont(font);
                add(numbers[y * 3 + x + 1]);
            }
        }
        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50);
        numbers[0].setFont(font);
        add(numbers[0]);

        backspace.setBounds(10, 250, 50, 50);
        backspace.addActionListener(e -> {
            if(output.getText().length() > 0){
                StringBuilder strB = new StringBuilder(output.getText());
                strB.deleteCharAt(output.getText().length() - 1);
                String btnBackspace = strB.toString();
                output.setText(btnBackspace);
            }
        });
        add(backspace);

        equals.setBounds(130, 250, 50, 50);
        equals.addActionListener(e -> {
            secondNum = Double.parseDouble(output.getText());
            if(operations.equals("+")){
                result = firstNum + secondNum;
                output.setText(String.valueOf(result));

            }
            if(operations.equals("-")){
                result = firstNum - secondNum;
                output.setText(String.valueOf(result));
            }
            if(operations.equals("*")){
                result = firstNum * secondNum;
                output.setText(String.valueOf(result));
            }
            if(operations.equals("/")){
                result = firstNum / secondNum;
                output.setText(String.valueOf(result));
            }
        });
        add(equals);

        plus.setBounds(190, 70, 50, 50);
        plus.addActionListener(e -> {
            firstNum = Double.parseDouble(output.getText());
            output.setText("");
            operations = "+";
        });
        add(plus);

        minus.setBounds(190, 130, 50, 50);
        minus.addActionListener(e -> {
            firstNum = Double.parseDouble(output.getText());
            output.setText("");
            operations = "-";
        });
        add(minus);

        multi.setBounds(190, 190, 50, 50);
        multi.addActionListener(e -> {
            firstNum = Double.parseDouble(output.getText());
            output.setText("");
            operations = "*";
        });
        add(multi);

        div.setBounds(190, 250, 50, 50);
        div.addActionListener(e -> {
            firstNum = Double.parseDouble(output.getText());
            output.setText("");
            operations = "/";
        });
        add(div);

        clear.addActionListener(e -> {
            output.setText(null);
            setFocusable(true);
            grabFocus();
        });
        clear.setFont(font);
        clear.setBounds(250, 70, 50, 50);
        add(clear);

        dot.setFont(font);
        dot.setBounds(250, 130, 50, 50);
        dot.addActionListener(e -> {
            if(output.getText().isEmpty() || output.getText().indexOf('.') != -1)
                return;
            String newDot = output.getText() + '.';
            output.setText(newDot);
        });
        add(dot);

        output.setBounds(10, 10, 290, 50);
        output.setEditable(false);
        output.setFont(font);
        add(output);

        ActionListener l = (ActionEvent e)->{
            if(output.getText().equals("Введите число..."))
                output.setText("");
            JButton b = (JButton)e.getSource();
            output.setText(output.getText() + b.getText());
            setFocusable(true);
            grabFocus();
        };
        for(JButton b: numbers){
            b.addActionListener(l);
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();
                switch (e.getKeyCode()){
                    case (107):
                        firstNum = Double.parseDouble(output.getText());
                        output.setText("");
                        operations = "+";
                        return;

                    case(109):
                        firstNum = Double.parseDouble(output.getText());
                        output.setText("");
                        operations = "-";
                        return;
                    case (106):
                        firstNum = Double.parseDouble(output.getText());
                        output.setText("");
                        operations = "*";
                        return;
                    case (111):
                        firstNum = Double.parseDouble(output.getText());
                        output.setText("");
                        operations = "/";
                        return;
                    case (127):
                        output.setText(null);
                        setFocusable(true);
                        grabFocus();
                        return;
                    case (10):
                        secondNum = Double.parseDouble(output.getText());
                        if(operations.equals("+")){
                            result = firstNum + secondNum;
                            output.setText(String.valueOf(result));

                        }
                        if(operations.equals("-")){
                            result = firstNum - secondNum;
                            output.setText(String.valueOf(result));
                        }
                        if(operations.equals("*")){
                            result = firstNum * secondNum;
                            output.setText(String.valueOf(result));
                        }
                        if(operations.equals("/")){
                            result = firstNum / secondNum;
                            output.setText(String.valueOf(result));
                        }
                        return;
                }

                if(!Character.isDigit(symbol))
                    return;
                if(output.getText().equals("Введите число..."))
                    output.setText("");
                output.setText(output.getText() + symbol);
            }
        });
    }
}