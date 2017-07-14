package batalhanaval;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BattleShip extends Ship {
    private boolean bobinho;
    public BattleShip(int c[], int d) {
        super(4, c, d);
        bobinho = true;
    }

    public Icon getIcon(int i) {
        switch (i) {
            case 0:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/battleship1v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/battleship1h.jpg"));
                }

            case 1:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/battleship2v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/battleship2h.jpg"));
                }
            case 2:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/battleship3v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/battleship3h.jpg"));
                }
            case 3:
                if (isVertical()) {
                    return new ImageIcon(getClass().getResource("images/battleship4v.jpg"));
                } else {
                    return new ImageIcon(getClass().getResource("images/battleship4h.jpg"));
                }

        }

        return null;
    }
}
