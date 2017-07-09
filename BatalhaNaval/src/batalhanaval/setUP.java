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
                    CPU computer = new CPU();
                    Game gg = new Game(p1,computer);
                }
                if(pst.getSelectedItem().toString().equals("Horizontal")){
                    b = 1;
                    if(opt.getSelectedItem().toString().equals("BattleShip")){
                        if(p1.validPI(4, b, c)){
                            int vet[] = new int[4];
                            for(int i=0;i<4;i++) vet[i] = c+i;
                            BattleShip ss = new BattleShip(vet);
                            if(p1.addShip(ss, vet)){
                            opt.removeItemAt(opt.getSelectedIndex());
                            bts--;
                            }
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Cruiser")){
                        if(p1.validPI(3, b, c)){
                            int vet[] = new int[3];
                            for(int i=0;i<3;i++) vet[i] = c+i;
                            Cruiser ss = new Cruiser(vet);
                            if(p1.addShip(ss, vet)){
                            if(crs == 1) opt.removeItemAt(opt.getSelectedIndex());
                            crs--;
                            }
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Destroyer")){
                        if(p1.validPI(2, b, c)){
                            int vet[] = new int[2];
                            for(int i=0;i<2;i++) vet[i] = c+i;
                            Destroyer ss = new Destroyer(vet);
                            if(p1.addShip(ss, vet)){
                            if(dtr == 1) opt.removeItemAt(opt.getSelectedIndex());
                            dtr--;
                            }
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Submarine")){
                        if(p1.validPI(1, b, c)){
                            int vet[] = new int[1];
                            for(int i=0;i<1;i++) vet[i] = c+i;
                            Submarine ss = new Submarine(vet);
                            if(p1.addShip(ss, vet)){
                            if(sub == 1) opt.removeItemAt(opt.getSelectedIndex());
                            sub--;
                            }
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                }
                if(pst.getSelectedItem().toString().equals("Vertical")){
                    b = -1;
                    if(opt.getSelectedItem().toString().equals("BattleShip")){
                        if(p1.validPI(4, b, c)){
                            int vet[] = new int[4];
                            for(int i=0;i<4;i++) vet[i] = c+(10*i);
                            BattleShip ss = new BattleShip(vet);
                            if(p1.addShip(ss, vet)){
                            opt.removeItemAt(opt.getSelectedIndex());
                            bts--;
                            }
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Cruiser")){
                        if(p1.validPI(3, b, c)){
                            int vet[] = new int[3];
                            for(int i=0;i<3;i++) vet[i] = c+(10*i);
                            Cruiser ss = new Cruiser(vet);
                            if(p1.addShip(ss, vet)){
                            if(crs == 1) opt.removeItemAt(opt.getSelectedIndex());
                            crs--;
                            }
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Destroyer")){
                        if(p1.validPI(2, b, c)){
                            int vet[] = new int[2];
                            for(int i=0;i<2;i++) vet[i] = c+(10*i);
                            Destroyer ss = new Destroyer(vet);
                            if(p1.addShip(ss, vet)){
                            if(dtr == 1) opt.removeItemAt(opt.getSelectedIndex());
                            dtr--;
                            }
                        }
                        else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
                    }
                    if(opt.getSelectedItem().toString().equals("Submarine")){
                        if(p1.validPI(1, b, c)){
                            int vet[] = new int[1];
                            for(int i=0;i<1;i++) vet[i] = c+(10*i);
                            Submarine ss = new Submarine(vet);
                            if(p1.addShip(ss, vet)){
                            if(sub == 1) opt.removeItemAt(opt.getSelectedIndex());
                            sub--;
                            }
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
