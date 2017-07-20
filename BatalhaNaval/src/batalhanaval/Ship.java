package batalhanaval;

import javax.swing.Icon;

abstract public class Ship {

    private int size;
    private int coord[];
    private boolean attacked[];
    private int d;


    public Ship(int s, int c[], int orientation) {
        size = s;
        d = orientation;
        coord = new int[s];
        coord = c;
        attacked = new boolean[s];
        for(boolean a: attacked) a = false;
    }

    public boolean coord(int x) {
        for (int i = 0; i < size; i++) {
            if (coord[i] == x) {
                return true;
            }
        }
        return false;
    }

    public boolean attackHit(int x) {
        for (int i = 0; i < size; i++) {

            if (coord[i] == x) {
                attacked[i]=true;
                return true;
            }
        }
        return false;
    }

    public boolean destroyed() {
       for(boolean a: attacked) {
           if(a == false) return false;
       }
       return true;
    }

    public boolean colision(int x[]) {
        for (int i : coord) {
            for (int j : x) {
                if (i == j) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getPos(int x) {
       for(int i=0; i<size;i++)
       {
           if(coord[i]==x) return i;
       }
       return -1;
    }

    public Boolean isVertical() {
        return d == -1;
    }
    
    public int burglar(int haha[],int t){
        System.out.println("burglar : " + t);
        for(int i=0;i<size;i++){
            t++;
            haha[t] = coord[i];
            System.out.print(haha[t] + " ");
        }
        return t;
    }
    
    abstract Icon getIcon(int i);
}
