import javax.swing.*;

public class Main {

    private Main(){
        JFrame window = new JFrame("Calculator");
        window.setSize(325, 355);
        window.add(new Panel());
        window.setResizable(false);
        window.setLocationRelativeTo(null);                     //центр экрана
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //кнопка выхода
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

