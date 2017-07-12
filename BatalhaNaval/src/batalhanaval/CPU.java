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
        
        int vet[] = new int[1];
        Random rg = new Random();
        
        while(ns != 0){
            int x = rg.nextInt(100);
            vet = this.validPI(1, 1, x);
            if(vet != null){
                Ship ss = new Ship(1,vet);
                this.addShip(ss);
                ns--;
            }
        }
        
        while(nd != 0){
            int x = rg.nextInt(100);
            int y = ((rg.nextInt(2)) * 2) - 1;
            vet = this.validPI(2, y, x);
            if(vet != null){
                Ship ss = new Ship(2,vet);
                this.addShip(ss);
                nd--;
            }
        }
        
        while(nc != 0){
            int x = rg.nextInt(100);
            int y = ((rg.nextInt(2)) * 2) - 1;
            vet = this.validPI(3, y, x);
            if(vet != null){
                Ship ss = new Ship(3,vet);
                this.addShip(ss);
                nc--;
            }
        }
        
        while(nb != 0){
            int x = rg.nextInt(100);
            int y = ((rg.nextInt(2)) * 2) - 1;
            vet = this.validPI(4, y, x);
            if(vet != null){
                Ship ss = new Ship(4,vet);
                this.addShip(ss);
                nb--;
            }
        }
    }
    
    public int attacking(Player p1){
        Random rg = new Random();
        int x = rg.nextInt();
        
        if(hit == 0){
            while(belongs(x)) x = rg.nextInt();
            index++;
            attks[index] = x;
            if(p1.getAttacked(x)) {
                hit++;
                return x;
            }
            else return (-1)*x;
        }
        else{
            if(!belongs(attks[index] + 1)){
                if(p1.getAttacked(attks[index] + 1)){
                    attks[index + hit] = attks[index] + 1;
                    index += hit;
                    hit = 1;
                    return attks[index];
                }
                else{
                    attks[index + hit] = attks[index] + 1;
                    hit++;
                    return (-1)*(attks[index] + 1);
                }
                
            }
            if(!belongs(attks[index] - 1)){
                if(p1.getAttacked(attks[index] - 1)){
                    attks[index + hit] = attks[index] - 1;
                    index += hit;
                    hit = 1;
                    return attks[index];
                }
                else{
                    attks[index + hit] = attks[index] - 1;
                    hit++;
                    return (-1)*(attks[index] - 1);
                }
            }
            if(!belongs(attks[index] + 10)){
                if(p1.getAttacked(attks[index] + 10)){
                    attks[index + hit] = attks[index] + 10;
                    index += hit;
                    hit = 1;
                    return attks[index];
                }
                else{
                    attks[index + hit] = attks[index] + 10;
                    hit++;
                    return (-1)*(attks[index] + 10);
                }
                
            }
            if(!belongs(attks[index] - 10)){
                if(p1.getAttacked(attks[index] - 10)){
                    attks[index + hit] = attks[index] - 10;
                    index += hit;
                    hit = 1;
                    return attks[index];
                }
                else{
                    attks[index + hit] = attks[index] - 10;
                    hit++;
                    return (-1)*(attks[index] - 10);
                }
                
            }
            hit = 0;

        }
        
        return x;
    }
    
    public boolean belongs(int x){
        for(int i : attks) if(i == x) return true;
        return false;
    }
}

