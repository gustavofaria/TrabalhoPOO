package batalhanaval;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Player {

    private int nofs;
    protected ArrayList<Ship> ships;

    public Player() {
        nofs = 10;
        ships = new ArrayList<Ship>();
    }

    public int[] validPI(int length, int orientation, int pos) {

        if (orientation == 1) {//horizontal
            if (10 - (pos % 10) < length) {
                return null;
            } else {
                int vet[] = new int[length];
                for (int i = 0; i < length; i++) {
                    vet[i] = pos + i;
                }
                for (Ship ss : ships) {
                    if (ss.colision(vet)) {
                        return null;
                    }
                }
                return vet;
            }
        }

        if (orientation == -1) {//vertical
            if (pos + (10 * (length - 1)) > 99) {
                return null;
            } else {
                int vet[] = new int[length];
                for (int i = 0; i < length; i++) {
                    vet[i] = pos + (10 * i);
                }
                for (Ship ss : ships) {
                    if (ss.colision(vet)) {
                        return null;
                    }
                }
                return vet;
            }
        }
        return null;
    }

    public void addShip(Ship x) {
        ships.add(x);
    }

    public boolean endOfGame() {
        return nofs == 0;
    }

    public boolean attack(int d) {
        for (Ship s : ships) {
            if (s.attackHit(d)) {
                if(s.destroyed()) nofs--;
                return true;
            }
        }
        return false;
    }

    public boolean isThere(int d) {
        for (Ship s : ships) {
            if (s.coord(d)) {
                return true;
            }
        }
        return false;
    }

    public Icon helpImages(int x) {

        for (Ship ss : ships) {
            if (ss.coord(x)) {
                return ss.getIcon(ss.getPos(x));
            }
        }

        return new ImageIcon(getClass().getResource("images/sea.png"));
    }
    
    public int[] fuckingThief(){
        int x[] = new int[20];
        int i = -1;
        for (Ship ss : ships) {
            i = ss.burglar(x,i);
        }
        for(int j=0;j<20;j++) System.out.println(x[j] + " ");
        System.out.println();
        return x;
    }
}
