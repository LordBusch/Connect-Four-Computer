import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class MouseHandler implements MouseListener {

    public void mouseClicked(MouseEvent e) {
        System.out.println("CLICKED");

        //Get position of mouse
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;

        for (int i = 0; i < 42 ; i++) {
            //get position of middle of each hole
            GameField.midOfHoleX[i] = GameField.xposholes[i] + (GUI.PANEL_SIZE_Y / 10) / 2;
            GameField.midOfHoleY[i] = GameField.yposholes[i] + (GUI.PANEL_SIZE_Y / 10) / 2;

            //Generate distance between mouse and middle of hole
            int distanceX = (GameField.midOfHoleX[i] - x);
            int distanceY = (GameField.midOfHoleY[i] - y);
            int distanceCenters = (int)(Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)));

            //if mouse position is in the oval/hole, draw circle
            if (distanceCenters < (GUI.PANEL_SIZE_Y / 10) / 2) {
                GameField.ActiveHole = i;

                if (GameField.playerRedActive) {
                    GameField.playerRedActive = false;
                    GameField.playerBlueActive = true;
                    System.out.println("BLUE");
                    GameField.drawChecker[i] = 1;
                }
                else {
                    GameField.playerBlueActive = false;
                    GameField.playerRedActive = true;
                    System.out.println("RED");
                    GameField.drawChecker[i] = 2;
                }
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
        
    }

    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }

    
}