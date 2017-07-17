package batalhanaval;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {

    private Player p1;
    private Player p2;
    private JFrame main;
    private int bts;
    private int crs;
    private int dtr;
    private int sub;
    private int tam;
    private String nome;

    public Game() {
        sub = 4;
        dtr = 3;
        crs = 2;
        bts = 1;
        tam = 10;
        nome = "";
        main = new JFrame("Batalha Naval");
        main.setSize(500, 500);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel(new GridLayout(1, 3));
        JButton plyvsCPU = new JButton("Player vs CPU");
        JButton plyvsply = new JButton("Player vs Player");
        JButton option = new JButton("Options");
        JLabel image = new JLabel();
        Icon war = new ImageIcon(getClass().getResource("images/mainimage3.jpg"));

        plyvsply.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                while (nome == null || nome.equals("")) {
                    nome = JOptionPane.showInputDialog("Digite o nome do jogador 1");
                }
                p1 = new Player(nome,bts,crs,dtr,sub);
                nome ="";
                while (nome == null || nome.equals("")) {
                    nome = JOptionPane.showInputDialog("Digite o seu nome");
                }
                p2 = new Player(nome,bts,crs,dtr,sub);
                setup(p1,1);
                setup(p2,0);
                match(p1, p2);
            }
        });
        plyvsCPU.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                while (nome == null || nome.equals("")) {
                    nome = JOptionPane.showInputDialog("Digite o seu nome");
                }
                p1 = new Player(nome,bts,crs,dtr,sub);
                nome = "";
                setup(p1,0);
            }
        });
        option.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        image.setIcon(war);
        buttons.add(plyvsCPU);
        buttons.add(option);
        buttons.add(plyvsply);
        panel.add(image, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.SOUTH);
        main.add(panel);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

  

    public void match(Player p1, CPU cpu) {
        System.out.println("player vs cpu");
        JFrame janela = new JFrame("Batalha Naval");
        janela.setSize(500, 500);
        JLabel player = new JLabel(p1.getName());
        JLabel computer = new JLabel(cpu.getName());
        JPanel matchmain = new JPanel(new GridLayout(1, 2));
        JPanel right = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new BorderLayout());
        JPanel plyshp = new JPanel(new GridLayout(10, 10));
        JPanel cpushp = new JPanel(new GridLayout(10, 10));
        JButton you[] = new JButton[100];
        for (int i = 0; i < 100; i++) {
            plyshp.add(you[i] = new JButton(p1.helpImages(i)));

        }

        ActionListener getnumb = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton click = (JButton) e.getSource();

                int i = Integer.parseInt(click.getName());
                if (cpu.attack(i)) {

                    Icon myIcon = cpu.helpImages(i);
                    click.setIcon(myIcon);
                }
                click.setEnabled(false);

                if (cpu.endOfGame()) {
                    janela.setVisible(false);
                    JOptionPane.showMessageDialog(null, p1.getName() + " VENCEU !!! ");
                    janela.dispose();
                    main.setVisible(true);

                }

                int a = cpu.attacking(p1);
                you[a].setEnabled(false);

                if (p1.endOfGame()) {
                    janela.setVisible(false);
                    JOptionPane.showMessageDialog(null, cpu.getName() + " VENCEU !!!");
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
        matchmain.add(right);

        left.add(new JPanel(), BorderLayout.WEST);
        matchmain.add(left);
        janela.add(matchmain);
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja sair") != JOptionPane.OK_OPTION) {
                    main.setVisible(true);
                }
            }
        });
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }

    
    public void match(Player p1, Player p2) {
        System.out.println("player vs player");
        JFrame janela = new JFrame("Batalha Naval");
        janela.setSize(500, 500);
        JLabel player = new JLabel(p1.getName());
        JLabel computer = new JLabel(p2.getName());
        JPanel matchmain = new JPanel(new GridLayout(1, 2));
        JPanel right = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new BorderLayout());
        JPanel ply1shp = new JPanel(new GridLayout(10, 10));
        JPanel ply2shp = new JPanel(new GridLayout(10, 10));
        

        ActionListener getnumb1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton click = (JButton) e.getSource();

                int i = Integer.parseInt(click.getName());
                if (p1.attack(i)) {

                    Icon myIcon = p2.helpImages(i);
                    click.setIcon(myIcon);
                }
                click.setEnabled(false);
              

                if (p1.endOfGame()) {
                    janela.setVisible(false);
                    JOptionPane.showMessageDialog(null, p2.getName()+" VENCEU !!!");
                    janela.dispose();
                    main.setVisible(true);
                }
            }
        };

        ActionListener getnumb2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton click = (JButton) e.getSource();

                int i = Integer.parseInt(click.getName());
                if (p2.attack(i)) {

                    Icon myIcon = p2.helpImages(i);
                    click.setIcon(myIcon);
                }
                click.setEnabled(false);
              

                if (p2.endOfGame()) {
                    janela.setVisible(false);
                    JOptionPane.showMessageDialog(null, p1.getName()+" VENCEU !!!");
                    janela.dispose();
                    main.setVisible(true);
                }
            }
        };
        Icon icone = new ImageIcon(getClass().getResource("images/sea.png"));

        for (int i = 0; i < 100; i++) {
            JButton dumb = new JButton(icone);
            dumb.setName(Integer.toString(i));
            dumb.addActionListener(getnumb2);
            ply2shp.add(dumb);
        }
        for (int i = 0; i < 100; i++) {
            JButton dumb = new JButton(icone);
            dumb.setName(Integer.toString(i));
            dumb.addActionListener(getnumb1);
            ply1shp.add(dumb);
        }


        right.add(ply1shp, BorderLayout.CENTER);
        right.add(player, BorderLayout.NORTH);
        left.add(ply2shp, BorderLayout.CENTER);
        left.add(computer, BorderLayout.NORTH);
        matchmain.add(right);

        left.add(new JPanel(), BorderLayout.WEST);
        matchmain.add(left);
        janela.add(matchmain);
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja sair") != JOptionPane.OK_OPTION) {
                    main.setVisible(true);
                }
            }
        });
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }
    

    public void setup(Player player,int a) {
        final JFrame janela = new JFrame("Setup");
        
        janela.setSize(500, 500);
        JPanel setupmain = new JPanel(new BorderLayout());
        String[] options = {"BattleShip", "Cruiser", "Destroyer", "Submarine"};
        String[] position = {"Vertical", "Horizontal"};
        JComboBox opt = new JComboBox(options);
        JComboBox pst = new JComboBox(position);
        JPanel south = new JPanel();
        JPanel center = new JPanel(new GridLayout(10, 10));
        south.add(opt);
        south.add(pst);
        String numbers[] = new String[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = Integer.toString(i);
        }
        setupmain.add(center, BorderLayout.CENTER);
        setupmain.add(south, BorderLayout.SOUTH);
        janela.add(setupmain);
        int cruiser,battleship,destroyer, submarine;
        cruiser = crs;
        battleship = bts;
        destroyer = dtr;
        submarine = sub;
        ActionListener getnumb;
        getnumb = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton click = (JButton) e.getSource();
                int a, b, c;
                a = 0;
                b = 0;
                c = Integer.parseInt(click.getName());

                if (pst.getSelectedItem().toString().equals("Vertical")) {
                    b = -1;
                }
                if (pst.getSelectedItem().toString().equals("Horizontal")) {
                    b = 1;
                }
                if (opt.getSelectedItem().toString().equals("BattleShip")) {
                    a = 4;
                }
                if (opt.getSelectedItem().toString().equals("Cruiser")) {
                    a = 3;
                }
                if (opt.getSelectedItem().toString().equals("Destroyer")) {
                    a = 2;
                }
                if (opt.getSelectedItem().toString().equals("Submarine")) {
                    a = 1;
                }

                int vet[];
                vet = player.validPI(a, b, c);

                if (vet != null) {
                    Ship ss = null;

                    if (a == 4) {
                        if (bts == 1) {
                            opt.removeItemAt(opt.getSelectedIndex());
                        }
                        ss = new BattleShip(vet, b);
                        bts--;
                    }
                    if (a == 3) {
                        if (crs == 1) {
                            opt.removeItemAt(opt.getSelectedIndex());
                        }
                        ss = new Cruiser(vet, b);
                        crs--;
                    }
                    if (a == 2) {
                        if (dtr == 1) {
                            opt.removeItemAt(opt.getSelectedIndex());
                        }
                        ss = new Destroyer(vet, b);
                        dtr--;
                    }
                    if (a == 1) {
                        if (sub == 1) {
                            opt.removeItemAt(opt.getSelectedIndex());
                        }
                        ss = new Submarine(vet, b);
                        sub--;
                    }
                    for (int i = 0; i < a; i++) {
                        JButton fulano = (JButton) center.getComponent(vet[i]);
                        fulano.setIcon(ss.getIcon(i));
                        fulano.setEnabled(false);
                    }
                    player.addShip(ss);
                } else {
                    JOptionPane.showMessageDialog(null, "Posicao Invalida !!!");
                }

                if ((bts == 0) && (crs == 0) && (dtr == 0) && (sub == 0)) {
                    bts = battleship;
                    crs = cruiser;
                    dtr = destroyer;
                    sub = submarine;
                    janela.setVisible(false);
                    janela.dispose();
                    if(a==1) match(player, p2) ;
                  
                }

            }
        };
        Icon icone = new ImageIcon(getClass().getResource("images/blueSea.jpg"));
        for (int i = 0; i < 100; i++) {
            JButton dumb = new JButton(icone);
            dumb.setName(Integer.toString(i));
            dumb.addActionListener(getnumb);
            center.add(dumb);
        }

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

}
