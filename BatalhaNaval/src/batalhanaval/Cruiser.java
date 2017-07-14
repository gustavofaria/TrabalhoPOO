package batalhanaval;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Cruiser extends Ship {
    private boolean a;
    public Cruiser(int c[], int d) {
        super(3, c, d);
         a= true;
    }
        public Icon getIcon(int i) {
        switch (i) {
            case 0:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/cruiser1v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/cruiser1h.jpg"));
                }

            case 1:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/cruiser2v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/cruiser2h.jpg"));
                }
            case 2:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/cruiser3v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/cruiser3h.jpg"));
                }
        }

        return null;
    }

}
