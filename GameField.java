import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    private static int heightBoard = GUI.PANEL_SIZE_Y / 2 + GUI.PANEL_SIZE_Y / 4;
    private static int widthBoard = GUI.PANEL_SIZE_X / 2 + GUI.PANEL_SIZE_X / 4;
    public static int[] xposholes = new int[43];
    public static int[] yposholes = new int[43];
    private static int totalLines = 6;
    public static int SpaceBetweenYpos = GUI.PANEL_SIZE_Y / 8;
    public static int SpaceBetweenXpos = GUI.PANEL_SIZE_X / 10;

    public static int xposPickedHole;
    public static int yposPickedHole;
    public static int[] midOfHoleX = new int[43];
    public static int[] midOfHoleY = new int[43];
    public static int ActiveHole;
    public static int[] drawChecker = new int[43];

    public static boolean playerRedActive = true;
    public static boolean playerBlueActive;

    public static String[][] boardArray = new String[7][8];
    private static boolean loadArrayOnce = true;

    GameField() {
        this.setSize(GUI.PANEL_SIZE_X, GUI.PANEL_SIZE_Y);
        this.setLayout(null);
    }

    //Create method for delay
	public static void wait(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

    public void paintComponent(Graphics g) {
        if (loadArrayOnce) {
            CreateArray();
            loadArrayOnce = false;
        }
        DrawBoard(g);
        DrawCheckers(g);
        DrawMarker(g);

        GUI.frame.repaint();
        wait(50);
    }

    public void CreateArray() {
        for(int i = 0; i <= 6; i++) {
            System.out.println(i + "Array");
            for (int j = 0; j <= 7; j++) {
                if (j == 8) {
                    j = 0;
                }
                boardArray[i][j] = "emtpy";
            }
        }
    }

    public void DrawBoard(Graphics g) {
        //Draw the background board
        g.setColor(Color.black);
        g.fillRect(GUI.PANEL_SIZE_X / 2 - ((GUI.PANEL_SIZE_X / 2 + GUI.PANEL_SIZE_X / 4) / 2), GUI.PANEL_SIZE_Y / 10, widthBoard, heightBoard);

        //Calculate the holes
        for (int y = 0; y < totalLines; y++) {
            //int for all xpos of balls
            int x = 0;
            for (int i = 7 * y; i <= 7 * (y + 1); i++) {
                xposholes[i] = (GUI.PANEL_SIZE_X / 2 - (GUI.PANEL_SIZE_X / 4 + GUI.PANEL_SIZE_X / 12)) + SpaceBetweenXpos * x;
                yposholes[i] = GUI.PANEL_SIZE_Y / 8 + SpaceBetweenYpos * y;
                x++;
            }

        }

        //Draw the white holes
        for (int i = 0; i < 42; i++) {
            g.setColor(Color.white);
            g.fillOval(xposholes[i], yposholes[i], GUI.PANEL_SIZE_Y / 10, GUI.PANEL_SIZE_Y / 10);
        }
    }



    public void DrawMarker(Graphics g) {
        //Get position of mouse
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;

        for (int i = 0; i < 42 ; i++) {
            //get position of middle of each hole
            midOfHoleX[i] = GameField.xposholes[i] + (GUI.PANEL_SIZE_Y / 10) / 2;
            midOfHoleY[i] = GameField.yposholes[i] + (GUI.PANEL_SIZE_Y / 10) / 2;

            //Generate distance between mouse and middle of hole
            int distanceX = (midOfHoleX[i] - x);
            int distanceY = (midOfHoleY[i] - y);
            int distanceCenters = (int)(Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)));
            
            //if mouse position is in the oval/hole, draw circle
            if (distanceCenters < (GUI.PANEL_SIZE_Y / 10) / 2) {
                ActiveHole = i;
            }
        }

        if (playerRedActive) g.setColor(Color.decode("#ff4254"));
        else g.setColor(Color.decode("#63C5DA"));

        //g.fillOval(GameField.xposholes[ActiveHole], GameField.yposholes[ActiveHole], GUI.PANEL_SIZE_Y / 10, GUI.PANEL_SIZE_Y / 10);
        g.fillRect(GameField.xposholes[ActiveHole], GUI.PANEL_SIZE_Y / 10 + GUI.PANEL_SIZE_Y / 2 + GUI.PANEL_SIZE_Y / 4, GUI.PANEL_SIZE_Y / 10, GUI.PANEL_SIZE_Y / 20);
    }

    public void DrawCheckers(Graphics g) {
        int Active = 0;

        for(int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 7; j++) {
                if (j == 8) {
                    j = 0;
                }
                //check if hole is hole is loaded
                if (GameField.boardArray[i][j] != "emtpy") {
                    Active = (i - 1) * 7 + (j - 1);
                    //set Color of checker -> 1 = red ; 2 = blue
                    if (GameField.boardArray[i][j] == "RED") g.setColor(Color.red);
                    else g.setColor(Color.blue);
                    
                        
                    g.fillOval(GameField.xposholes[Active], GameField.yposholes[Active], GUI.PANEL_SIZE_Y / 10, GUI.PANEL_SIZE_Y / 10);
                }
                if (Active == 42) Active = 0;
            }
        }
    }
}