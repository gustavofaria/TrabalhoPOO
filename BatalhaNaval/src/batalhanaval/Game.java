package batalhanaval;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {

    public Game(Player p1, CPU cpu) {

    
        JFrame janela = new JFrame("Batalha Naval");
        janela.setSize(1000, 500);
        JLabel player = new JLabel("Jogador");
        JLabel computer = new JLabel("Computador");
        JPanel main = new JPanel(new GridLayout(1, 2));
        JPanel right = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new BorderLayout());
        JPanel plyshp = new JPanel(new GridLayout(10, 10));
        JPanel cpushp = new JPanel(new GridLayout(10, 10));
        JButton you[] = new JButton[100];
        for (int i = 0; i < 100; i++) {
                plyshp.add(you[i] =  new JButton(p1.helpImages(i)));
           
        }


        ActionListener getnumb = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton click = (JButton) e.getSource();

                int i = Integer.parseInt(click.getName());
               if (cpu.attack(i)) {
                    click.setEnabled(false);
                    
                    Icon myIcon = cpu.helpImages(i);
                    click.setIcon(myIcon);
                } else {
                    click.setEnabled(false);
                }

                if (cpu.endOfGame()) {
                    janela.setVisible(false);
                    JOptionPane.showMessageDialog(null, "VOCE VENCEU !!! ");
                    new main();
                    janela.dispose();
                }

                int a = cpu.attacking(p1);
                you[a].setEnabled(false);
                
                if (p1.endOfGame()) {
                    janela.setVisible(false);
                    JOptionPane.showMessageDialog(null, "VOCE PERDEU !!!");
                    new main();
                    janela.dispose();
                }
            }
        };

        Icon icone = new ImageIcon(getClass().getResource("images/sea.png"));

        for (int i = 0; i < 100; i++) {
            JButton dumb = new JButton(icone);
            dumb.setName(Integer.toString(i));
            dumb.addActionListener(getnumb);
            cpushp.add(dumb);
        }

        right.add(plyshp, BorderLayout.CENTER);
        right.add(player, BorderLayout.NORTH);
        left.add(cpushp, BorderLayout.CENTER);
        left.add(computer, BorderLayout.NORTH);
        left.add(new JPanel(),BorderLayout.WEST);
        main.add(right);
        main.add(left);
        janela.add(main);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
