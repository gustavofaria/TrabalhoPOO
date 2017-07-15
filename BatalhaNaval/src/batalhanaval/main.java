package batalhanaval;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class main {
    
    public main(){
        
        JFrame janela = new JFrame("Batalha Naval");
        janela.setSize(500,500);
        JPanel panel = new JPanel(new BorderLayout());
        JButton pl = new JButton("Jogar");
        JLabel image = new JLabel();
        Icon war = new ImageIcon(getClass().getResource("images/mainimage3.jpg"));
        
        ActionListener numb = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                janela.setVisible(false);
                new setUP();
            }
        };
        image.setIcon(war);
        panel.add(image,BorderLayout.CENTER);
        pl.addActionListener(numb);
        panel.add(pl,BorderLayout.SOUTH);
        janela.add(panel);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args) {
        
        new main();
    }

}

