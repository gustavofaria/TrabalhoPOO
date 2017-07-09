package batalhanaval;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
    public Game (Player p1,CPU cpu){
        String numbers[] = new String[100];
        final JFrame janela = new JFrame("Batalha Naval");
        janela.setSize(800,800);
        JLabel player = new JLabel("Jogador");
        JLabel computer = new JLabel("Computador");
        JPanel main = new JPanel(new GridLayout(1,2));
        JPanel right = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new BorderLayout());
        JPanel plyshp = new JPanel(new GridLayout(10,10));
        JPanel cpushp = new JPanel(new GridLayout(10,10));
        JLabel you[] = new JLabel[100];
        for(int i=0;i<100;i++) plyshp.add(you[i] = new JLabel(Integer.toString(i)));
        for(int i=0;i<100;i++) numbers[i] = Integer.toString(i);
        
        ActionListener getnumb = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JButton click = (JButton)e.getSource();
                int i = Integer.parseInt(click.getText());
                if(cpu.getAttacked(i)) click.setName("Hit");
                else click.setName("Miss");
                click.setEnabled(false);
                if(cpu.endOfGame()) JOptionPane.showMessageDialog(null,"VOCE VENCEU !!! ");
                
                int a = cpu.attacking(p1);
                if(a > 0) you[a-1].setText("Hit");
                else you[(-1)*(a-1)].setText("Miss");
                if(p1.endOfGame()) JOptionPane.showMessageDialog(null,"VOCE PERDEU !!!");
            }
        };      
        for(int i=0;i<100;i++)((JButton)cpushp.add(new JButton(numbers[i]))).addActionListener(getnumb);
        right.add(plyshp,BorderLayout.CENTER);
        right.add(player,BorderLayout.NORTH);
        left.add(cpushp,BorderLayout.CENTER);
        left.add(computer,BorderLayout.NORTH);
        main.add(right);
        main.add(left);
        janela.add(main);
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}

