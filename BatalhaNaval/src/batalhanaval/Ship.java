package batalhanaval;

public class Ship {
    private int size;
    private int coord[];
    
    public Ship(int s,int c[]){
        size = s;
        coord = new int[s];
        coord = c;
    }
    
    public boolean coord(int x){
        for(int i=0;i<size;i++) if(coord[i] == x) return true;
        return false;
    }
    
    public boolean attackHit(int x){
        for(int i=0;i<size;i++) if(coord[i] == x){
            size--;
            coord[i] = -1;
            return true;
        }
        return false;
    }
    
    public boolean destroyed(){
        if(size == 0) return true;
        return false;
    }
    
    public boolean colision(int x[]){
        for(int i: coord) for(int j: x) if(i == j) return true;
        return false;
    }
    
}
