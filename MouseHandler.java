import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class MouseHandler implements MouseListener {

    public void mouseClicked(MouseEvent e) {
        if (GameField.GameActive) {
            
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

                //Calculate line and split of clicked hole
                int line = (GameField.yposholes[i] - GUI.PANEL_SIZE_Y / 8) / GameField.SpaceBetweenYpos;
                int split = (GameField.xposholes[i] - (GUI.PANEL_SIZE_X / 2 - (GUI.PANEL_SIZE_X / 4 + GUI.PANEL_SIZE_X / 12))) / GameField.SpaceBetweenXpos;
                line++;
                split++;

                //if mouse position is in the oval/hole, draw circle
                if (distanceCenters < (GUI.PANEL_SIZE_Y / 10) / 2 && GameField.LowestChecker[split] != 1) {
    
                    //if red player is active draw red checker
                    if (GameField.playerRedActive) {
                        GameField.playerRedActive = false;
                        GameField.playerBlueActive = true;
                        GameField.LowestChecker[split]--;
                        GameField.boardArray[GameField.LowestChecker[split]][split] = "RED";
                        System.out.println(GameField.boardArray[line][split]);
                    }
                    //if blue player is active draw blue checker
                    else {
                        GameField.playerBlueActive = false;
                        GameField.playerRedActive = true;
                        GameField.LowestChecker[split]--;
                        GameField.boardArray[GameField.LowestChecker[split]][split] = "BLUE";
                        System.out.println(GameField.boardArray[GameField.LowestChecker[split]][split]);
                    }
                    
                    Check4Connected.checkedSplit = split;
                    Check4Connected.checkedLine = GameField.LowestChecker[split];
                    new Check4Connected();
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