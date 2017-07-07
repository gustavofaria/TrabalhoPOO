package batalhanaval;

public class Player {
    private final int nofs;
    private Ship ships[];
    
    public Player(){
        nofs = 10;
    }
    
    public boolean endOfGame(){
        return nofs == 0;
    }
}
