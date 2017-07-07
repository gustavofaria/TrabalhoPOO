package batalhanaval;

public class Ship {
    private int size;
    private int coord[];
    private int hv;
    
    public Ship(int s,int c,int d){
        size = s;
        coord = new int[s];
        coord[0] = c;
        hv = d;
    }
    
    public void addCoordinates(){
        if(hv == 1) for(int i=0;i<size-1;i++) coord[i+1] = coord[i] + 1;
        else for(int i=0;i<size-1;i++) coord[i+1] = coord[i] + 10;
    }
    
    public boolean attacked(int x){
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
}
