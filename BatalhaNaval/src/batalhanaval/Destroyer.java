package batalhanaval;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Destroyer extends Ship {

    public Destroyer(int c[], int d) {
        super(2, c, d);
    }
    public Icon getIcon(int i) {
        switch (i) {
            case 0:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/destroyer1v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/destroyer1h.jpg"));
                }

            case 1:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/destroyer2v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/destroyer2h.jpg"));
                }
          }

        return null;
    }
}
