package batalhanaval;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
    public Game (Player p1,CPU cpu){
        String numbers[] = new String[100];
        Icon icsub = new ImageIcon(getClass().getResource("images/submarine.png"));
        Icon ichdt1 = new ImageIcon(getClass().getResource("images/destroyer1h.jpg"));
        Icon ichdt2 = new ImageIcon(getClass().getResource("images/destroyer2h.jpg"));
        //Icon icvdt1 = new ImageIcon(getClass().getResource("images/destroyer1v.jpg"));
        //Icon icvdt2 = new ImageIcon(getClass().getResource("images/destroyer2v.jpg"));
        Icon ichcr1 = new ImageIcon(getClass().getResource("images/cruiser1h.jpg"));
        Icon ichcr2 = new ImageIcon(getClass().getResource("images/cruiser2h.jpg"));
        Icon ichcr3 = new ImageIcon(getClass().getResource("images/cruiser3h.jpg"));
        //Icon icvcr1 = new ImageIcon(getClass().getResource("images/cruiser1v.jpg"));
        //Icon icvcr2 = new ImageIcon(getClass().getResource("images/cruiser2v.jpg"));
        //Icon icvcr3 = new ImageIcon(getClass().getResource("images/cruiser3v.jpg"));
        //Icon ichbs1 = new ImageIcon(getClass().getResource("images/battleship1h.jpg"));
        //Icon ichbs2 = new ImageIcon(getClass().getResource("images/battleship2h.jpg"));
        //Icon ichbs3 = new ImageIcon(getClass().getResource("images/battleship3h.jpg"));
        //Icon ichbs4 = new ImageIcon(getClass().getResource("images/battleship4h.jpg"));
        //Icon icvbs1 = new ImageIcon(getClass().getResource("images/battleship1v.jpg"));
        //Icon icvbs2 = new ImageIcon(getClass().getResource("images/battleship2v.jpg"));
        //Icon icvbs3 = new ImageIcon(getClass().getResource("images/battleship3v.jpg"));
        //Icon icvbs4 = new ImageIcon(getClass().getResource("images/battleship4v.jpg"));
        
        
        final JFrame janela = new JFrame("Batalha Naval");
        janela.setSize(500,500);
        JLabel player = new JLabel("Jogador");
        JLabel computer = new JLabel("Computador");
        JPanel main = new JPanel(new GridLayout(1,2));
        JPanel right = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new BorderLayout());
        JPanel plyshp = new JPanel(new GridLayout(10,10));
        JPanel cpushp = new JPanel(new GridLayout(10,10));
        JLabel you[] = new JLabel[100];
        for(int i=0;i<100;i++) {
            if(p1.isThere(i)){
                plyshp.add(you[i] = new JLabel("X"));
            }
            else plyshp.add(you[i] = new JLabel("O"));
        }
        for(int i=0;i<100;i++) numbers[i] = Integer.toString(i);
        
        ActionListener getnumb = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JButton click = (JButton)e.getSource();
                
                int i = Integer.parseInt(click.getName());
                
                Icon icone;
                if(cpu.getAttacked(i)) {
                    click.setEnabled(false);
                    int vet[];
                    vet = p1.helpImages(i);
                    if(vet[0] == 1) click.setIcon(icsub);
                    if(vet[0] == 2){
                        if(vet[1] == 1) click.setIcon(ichdt1);
                        if(vet[1] == 2) click.setIcon(ichdt2);
                    }
                    if(vet[0] == 3){
                        
                    }
                    if(vet[0] == 4){
                        
                    }
                }
                else click.setEnabled(false);
                
                if(cpu.endOfGame()) {
                    
                    JOptionPane.showMessageDialog(null,"VOCE VENCEU !!! ");
                }
                
                int a = cpu.attacking(p1);
                if(a > 0) you[a-1].setText("Hit");
                else you[(-1)*(a-1)].setText("Miss");
                if(p1.endOfGame()) JOptionPane.showMessageDialog(null,"VOCE PERDEU !!!");
            }
        };

        Icon icone = new ImageIcon(getClass().getResource("images/sea.png"));
        
        for(int i=0;i<100;i++){
            JButton dumb = new JButton(icone);
            dumb.setName(Integer.toString(i));
            dumb.addActionListener(getnumb);
            cpushp.add(dumb);
        }        
        
        
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

