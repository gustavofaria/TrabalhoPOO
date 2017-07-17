
package batalhanaval;

import java.util.Random;

public class CPU extends Player {

    private int attks[];
    private int index;
    private int hit;
    private int nb;
    private int nc;
    private int nd;
    private int ns;

    public CPU(int battleship, int cruiser, int destroyer, int submarine) {
        super("Computer"/*,battleship, cruiser, destroyer, submarine*/);
        attks = new int[100];
        index = -1;
        hit = 0;
        nb = battleship;
        nc = cruiser;
        nd = destroyer;
        ns = submarine;
        while (nb != 0) {
            Random r = new Random();
            int d = (r.nextInt(2) * 2) - 1;
            int c = r.nextInt(100);
            int vet[] = validPI(4, d, c);
            if (vet != null) {
                System.out.println("Battleship " +nb+" :"+vet[0]+" "+ vet[1] +" "+ vet[2]+ " "+ vet[3]);
                BattleShip bs = new BattleShip(vet, d);
                addShip(bs);
                nb--;
            }

        }
        while (nc != 0) {
            Random r = new Random();
            int d = (r.nextInt(2) * 2) - 1;
            int c = r.nextInt(100);
            int vet[] = validPI(3, d, c);
            if (vet != null) {
                System.out.println("Cruiser " +nc+" :"+vet[0]+" "+ vet[1] +" "+ vet[2]);
                Cruiser cr = new Cruiser(vet, d);
                addShip(cr);
                nc--;
            }

        }
        while (nd != 0) {
            Random r = new Random();
            int d = (r.nextInt(2) * 2) - 1;
            int c = r.nextInt(100);
            int vet[] = validPI(2, d, c);
            if (vet != null) {
                System.out.println("Destroyer " +nd+" :"+vet[0]+" "+ vet[1]);
                Destroyer dr = new Destroyer(vet, d);
                addShip(dr);
                nd--;
            }

        }
        while (ns != 0) {
            Random r = new Random();
            int d = (r.nextInt(2) * 2) - 1;
            int c = r.nextInt(100);
            int vet[] = validPI(1, d, c);
            if (vet != null) {
                System.out.println("submarino " +ns+" :"+vet[0]);
                Submarine sb = new Submarine(vet, d);
                addShip(sb);
                ns--;
            }

        }
    }

    public int attacking(Player p1) {
        Random rg = new Random();

        int x = rg.nextInt(100);
        while (belongs(x)) {
            x = rg.nextInt(100);
        }
        index++;
        attks[index] = x;
        if (p1.attack(x)) {
            hit = 1;
        }
        return (x) ;

    }

    public boolean belongs(int x) {
        for (int i : attks) {
            if (i == x) {
                return true;
            }
        }
        return false;
    }
  
}


