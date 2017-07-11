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
                c = Integer.parseInt(click.getName());
                
                if((bts == 0) && (crs == 0) && (dtr == 0) && (sub == 0)) {
                    janela.setVisible(false);
                    CPU computer = new CPU();
                    Game gg = new Game(p1,computer);
                }
                
                if(pst.getSelectedItem().toString().equals("Vertical")) b = -1;
                if(pst.getSelectedItem().toString().equals("Horizontal")) b = 1;
                if(opt.getSelectedItem().toString().equals("BattleShip"))a = 4;
                if(opt.getSelectedItem().toString().equals("Cruiser"))a = 3;
                if(opt.getSelectedItem().toString().equals("Destroyer"))a = 2;
                if(opt.getSelectedItem().toString().equals("Submarine"))a = 1;
                
                int vet[];
                vet = p1.validPI(a, b, c);
                
                if(vet != null){
                   Ship ss = new Ship(a,vet);
                   click.setEnabled(false);
                   p1.addShip(ss);
                   if(a == 4){
                       if(bts == 1) opt.removeItemAt(opt.getSelectedIndex());
                       bts--;
                   }
                   if(a == 3){
                       if(crs == 1) opt.removeItemAt(opt.getSelectedIndex());
                       crs--;
                   }
                   if(a == 2){
                       if(dtr == 1) opt.removeItemAt(opt.getSelectedIndex());
                       dtr--;
                   }
                   if(a == 1){
                       if(sub == 1) opt.removeItemAt(opt.getSelectedIndex());
                       sub--;
                   }
                }
                else JOptionPane.showMessageDialog(null,"Posicao Invalida !!!");
    
            }
        };
        Icon icone = new ImageIcon(getClass().getResource("images/sea.png"));
        for(int i=0;i<100;i++)
        {
            JButton dumb = new JButton(icone);
            dumb.setName(Integer.toString(i));
            dumb.addActionListener(getnumb);
            center.add(dumb);
        }
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
    
}
