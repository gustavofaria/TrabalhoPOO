package batalhanaval;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class main {
    private JFrame main;
    public main(){
        
        main = new JFrame("Batalha Naval");
        main.setSize(500, 500);
        JPanel panel = new JPanel(new BorderLayout());
        JButton pl = new JButton("Jogar");
        JLabel image = new JLabel();
        Icon war = new ImageIcon(getClass().getResource("images/mainimage3.jpg"));

        ActionListener numb = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                new Game();
            }
        };
        image.setIcon(war);
        panel.add(image, BorderLayout.CENTER);
        pl.addActionListener(numb);
        panel.add(pl, BorderLayout.SOUTH);
        main.add(panel);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        public void remain(){
            main.setVisible(true);
        }

    
    public static void main(String[] args) {
        
        new Game();
    }

}

