package batalhanaval;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Submarine extends Ship {
    private boolean a;

    public Submarine(int c[], int d) {
        super(1, c, d);
        a=true;
    }
    @Override
    public Icon getIcon(int i) {
            if(i==0){
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/submarine1v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/submarine1h.jpg"));
                }
        }

        return null;
    }
}
