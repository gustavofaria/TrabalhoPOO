package batalhanaval;
import java.util.Random;

public class CPU extends Player{
    private int attks[];
    private int index;
    
    public CPU(){
        super();
        attks = new int[100];
        index = 0;
    }
    
    public int attacking(){
        Random rg = new Random();
        int x = rg.nextInt(100);
        while(!belongs(x)) x = rg.nextInt(100);
        index++;
        return x;
    }
    
    public boolean belongs(int x){
        for(int i : attks) if(i == x) return true;
        return false;
    }
}
