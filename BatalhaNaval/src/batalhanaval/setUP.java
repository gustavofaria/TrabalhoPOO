package batalhanaval;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class setUP {
    int bts;
    int crs;
    int dtr;
    int sub;
    
    public setUP(){
        Player p1 = new Player();
        CPU computer = new CPU();
        bts = 1;
        crs = 2;
        dtr = 3;
        sub = 4;
      
        String selected[] = new String[10];
        final JFrame janela = new JFrame("Batalha Naval");
        janela.setSize(500,500);
        JPanel main = new JPanel(new BorderLayout());
        String[] options = {"BattleShip","Cruiser","Destroyer","Submarine"};
        String[] position = {"Vertical","Horizontal"};
        JComboBox opt = new JComboBox(options);
        JComboBox pst = new JComboBox(position);
        JPanel south = new JPanel();
        JPanel center = new JPanel(new GridLayout(10,10));
        south.add(opt);
        south.add(pst);
        String numbers[] = new String[100];
        for(int i=0;i<100;i++) numbers[i] = Integer.toString(i);
        main.add(center , BorderLayout.CENTER);
        main.add(south , BorderLayout.SOUTH);
        janela.add(main);

        ActionListener getnumb = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JButton click = (JButton)e.getSource();
                int b,c;
                c = Integer.parseInt(click.getText());
                
                if(bts == 0 && crs == 0 && dtr ==0 && sub == 0) {
                    janela.setVisible(false);
                    Game gg = new Game(p1,computer);
                }

                if(pst.getSelectedItem().toString().equals("Vertical")){
                    b = -1;

                    if(opt.getSelectedItem().toString().equals("BattleShip")){
                        int aux[] = p1.validPI(4,b,c);
                        if(aux != null){
                            System.out.println("vb sucess");
                            BattleShip bs = new BattleShip(aux);
                            p1.addShip(bs);
                            opt.removeItemAt(opt.getSelectedIndex());
                            bts--;
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }

                    if(opt.getSelectedItem().toString().equals("Cruiser")){
                        int aux[] = p1.validPI(3,b,c);
                        if(aux != null){
                            System.out.println("vc sucess");
                            Cruiser bs = new Cruiser(aux);
                            p1.addShip(bs);
                            if(crs == 1) opt.removeItemAt(opt.getSelectedIndex());
                            crs--;
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }

                    if(opt.getSelectedItem().toString().equals("Destroyer")){
                        int aux[] = p1.validPI(2,b,c);
                        if(aux != null){
                            System.out.println("vd sucess");
                            Destroyer bs = new Destroyer(aux);
                            p1.addShip(bs);
                            if(dtr == 1) opt.removeItemAt(opt.getSelectedIndex());
                            dtr--;
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!"); 
                    }

                    if(opt.getSelectedItem().toString().equals("Submarine")){
                        int aux[] = p1.validPI(1,b,c);
                        if(aux != null){
                            System.out.println("vs sucess");
                            Submarine bs = new Submarine(aux);
                            p1.addShip(bs);
                            if(sub == 1) opt.removeItemAt(opt.getSelectedIndex());
                            sub--;
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    
                }

                if(pst.getSelectedItem().toString().equals("Horizontal")){
                    b = 1;
                    if(opt.getSelectedItem().toString().equals("BattleShip")){
                        int aux[] = p1.validPI(4,b,c);
                        if(aux != null){
                            System.out.println("hb sucess");
                            BattleShip bs = new BattleShip(aux);
                            p1.addShip(bs);
                            opt.removeItemAt(opt.getSelectedIndex());
                            bts--;
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Cruiser")){
                        int aux[] = p1.validPI(3,b,c);
                        if(aux != null){
                            System.out.println("hc sucess");
                            Cruiser bs = new Cruiser(aux);
                            p1.addShip(bs);
                            if(crs == 1) opt.removeItemAt(opt.getSelectedIndex());
                            crs--;
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Destroyer")){
                        int aux[] = p1.validPI(2,b,c);
                        if(aux != null){
                            System.out.println("hd sucess");
                            Destroyer bs = new Destroyer(aux);
                            p1.addShip(bs);
                            if(dtr == 1) opt.removeItemAt(opt.getSelectedIndex());
                            dtr--;
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Submarine")){
                        int aux[] = p1.validPI(1,b,c);
                        if(aux != null){
                            System.out.println("hs sucess");
                            Submarine bs = new Submarine(aux);
                            p1.addShip(bs);
                            if(sub == 1) opt.removeItemAt(opt.getSelectedIndex());
                            sub--;
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");                        
                    }
                }
            }
        };
        for(int i=0;i<100;i++)((JButton)center.add(new JButton(numbers[i]))).addActionListener(getnumb);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
    
}
