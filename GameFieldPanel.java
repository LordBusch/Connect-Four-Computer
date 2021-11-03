import javax.swing.*;
import java.awt.*;

public class GameFieldPanel extends JPanel {
    private static int[] xposholes = new int[43];
    private static int[] yposholes = new int[43];
    private static int totalLines = 6;
    private static int SpaceBetweenYpos = GUI.PANEL_SIZE_Y / 8;
    private static int SpaceBetweenXpos = GUI.PANEL_SIZE_X / 10;

    GameFieldPanel() {
        this.setSize(GUI.PANEL_SIZE_X, GUI.PANEL_SIZE_Y);
        this.setLayout(null);
    }

    public void paintComponent(Graphics g) {
        DrawBoard(g);
    }

    public void DrawBoard(Graphics g) {
        //Draw the background board
        g.setColor(Color.black);
        g.fillRect(GUI.PANEL_SIZE_X / 2 - ((GUI.PANEL_SIZE_X / 2 + GUI.PANEL_SIZE_X / 4) / 2), GUI.PANEL_SIZE_Y / 10, GUI.PANEL_SIZE_X / 2 + GUI.PANEL_SIZE_X / 4, GUI.PANEL_SIZE_Y / 2 + GUI.PANEL_SIZE_Y / 4);

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
}