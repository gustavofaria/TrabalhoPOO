package batalhanaval;
import java.util.Random;

public class CPU extends Player{
    private int attks[];
    private int index;
    private int hit;
    private int nb;
    private int nc;
    private int nd;
    private int ns;
    
    public CPU(){
        super();
        attks = new int[100];
        index = -1;
        hit = 0;
        nb = 1;
        nc = 2;
        nd = 3;
        ns = 4;
        while(nb != 0 ){
            Random r = new Random();
            int d = (r.nextInt(2)*2)-1;
            int c = r.nextInt(100);
            int vet[] = validPI(4,d,c);
            if(vet != null){
                BattleShip bs = new BattleShip(vet,d);
                addShip(bs);
                nb--;
            }
            
        }
        while(nc != 0 ){
            Random r = new Random();
            int d = (r.nextInt(2)*2)-1;
            int c = r.nextInt(100);
            int vet[] = validPI(3,d,c);
            if(vet != null){
                Cruiser cr = new Cruiser(vet,d);
                addShip(cr);
                nc--;
            }
            
        }
        while(nd != 0 ){
            Random r = new Random();
            int d = (r.nextInt(2)*2)-1;
            int c = r.nextInt(100);
            int vet[] = validPI(2,d,c);
            if(vet != null){
                Destroyer dr = new Destroyer(vet,d);
                addShip(dr);
                nd--;
            }
        
        }
        while(ns != 0 ){
            Random r = new Random();
            int d = (r.nextInt(2)*2)-1;
            int c = r.nextInt(100);
            int vet[] = validPI(1,d,c);
            if(vet != null){
                Submarine sb = new Submarine(vet,d);
                addShip(sb);
                ns--;
            }
        
        }
    }
    
    public int attacking(Player p1){
        Random rg = new Random();
        
            int x = rg.nextInt(100);
            while(belongs(x)) x = rg.nextInt(100);
            index++;
            attks[index] = x;
            if(p1.getAttacked(x)){
                hit = 1;
                return (x+1);
            }
            else return (-1)*(x+1);

    }
    
    public boolean belongs(int x){
        for(int i : attks) if(i == x) return true;
        return false;
    }
}

