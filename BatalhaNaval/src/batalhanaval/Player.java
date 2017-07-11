package batalhanaval;

import java.util.ArrayList;

public class Player {
    private final int nofs;
    private ArrayList<Ship> ships;
    
    public Player(){
        nofs = 10;
        ships = new ArrayList<Ship>();
    }
    
    public int[] validPI(int s,int d,int pi){
        
        if(d == 1){
            if(10 - ((10 + pi) % 10) < s) return null;
            else{
                int vet[] = new int[s];
                for(int i=0;i<s;i++) vet[i] = pi+i;
                for(Ship ss : ships) if(ss.colision(vet)) return null;
                return vet;
            }
        }
        
        if(d == -1){
            if(pi+(10*(s-1)) > 99) return null;
            else{
                int vet[] = new int[s];
                for(int i=0;i<s;i++) vet[i] = pi+(10*i);
                for(Ship ss : ships) if(ss.colision(vet)) return null;
                return vet;
            }
        }
        return null;
    }
    
    public void addShip(Ship x){        
        ships.add(x);
    }
    
    public boolean endOfGame(){
        return nofs == 0;
    }
    
    public boolean getAttacked(int d){
        for(Ship s: ships) if(s.attacked(d)) return true;
        return false;
    }
    
    public boolean isThere(int d){
        for(Ship s: ships) if(s.coord(d)) return true;
        return false;
    }
}
