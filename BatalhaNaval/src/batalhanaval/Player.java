package batalhanaval;

import java.util.ArrayList;

public class Player {
    private final int nofs;
    private ArrayList<Ship> ships;
    
    public Player(){
        nofs = 10;
        ships = new ArrayList<Ship>();
    }
    
    public int[] validPI(int length,int orientation,int pos){
        
        if(orientation == 1){//horizontal
            if(10 - ((10 + pos) % 10) < length) return null;
            else{
                int vet[] = new int[length];
                for(int i=0;i<length;i++) vet[i] = pos+i;
                for(Ship ss : ships) if(ss.colision(vet)) return null;
                return vet;
            }
        }
        
        if(orientation == -1){//vertical
            if(pos+(10*(length-1)) > 99) return null;
            else{
                int vet[] = new int[length];
                for(int i=0;i<length;i++) vet[i] = pos+(10*i);
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
        for(Ship s: ships) if(s.attackHit(d)) return true;
        return false;
    }
    
    public boolean isThere(int d){
        for(Ship s: ships) if(s.coord(d)) return true;
        return false;
    }
    
    public int[] helpImages(int x){
        int vet[];
        
        for(Ship s : ships) {
            vet = s.returnSizePos(x);
            if(vet[0] != -1) return vet;
        }
        return null;
    }
}
