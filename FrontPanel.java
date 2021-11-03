import javax.swing.*;
import java.awt.*;

public class FrontPanel extends JPanel {
    private static int[] xposBall = new int[120];
    private static int[] yposBall = new int[120];

    private static int CurrentBall;
    private static int yposfirstBallofLowestLine;
    private static boolean FirstLaunch = true;

    private static int totalLines = 8;
    private static int SpaceBetweenYpos = 150;
    private static int NumberLastBallofLine = totalLines * 12 - 1;


    FrontPanel() {
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
        if (FirstLaunch) {
            GenerateStartLines();
            FirstLaunch = false;
        }
        
        drawPreviousBalls(g);
        wait(10);
        GUI.frame.repaint();
    }

    public void GenerateStartLines() {
        for (int y = 0; y < totalLines; y++) {
            //int for all xpos of balls
            int x = 0;
            for (int i = 12 * y; i <= 12 * (y + 1); i++) {
                xposBall[i] = 90 + SpaceBetweenYpos * x;
                yposBall[i] = -100 + SpaceBetweenYpos * y;
                x++;
            }
            CurrentBall = CurrentBall + 12;
            System.out.println(CurrentBall);
            //Set the lowest point of all lines
            if (y == totalLines - 1) {
                yposfirstBallofLowestLine = yposBall[12 * totalLines];
                System.out.println(yposfirstBallofLowestLine + "LOWEST");
            }
        }
    }

    public void NewLine(Graphics g) {
        //if number of ypos is unded 0, return to the maximum -> last number of ball
        if (NumberLastBallofLine <= 0) NumberLastBallofLine = totalLines * 12 - 1;

        int y = 0;
        //set new values of balls, which are not visible anymore -> under PanelSize/WindowSize
        for (int i = NumberLastBallofLine; i > NumberLastBallofLine - 12; i--) {
            xposBall[i] = 90 + SpaceBetweenYpos * y;
            yposBall[i] = -100;
            y++;
        }
        NumberLastBallofLine = NumberLastBallofLine - 12;
        
    }

    public void drawPreviousBalls(Graphics g) {
        //draw all balls, which exist
        for (int i = 0; i < CurrentBall; i++) {
            g.setColor(Color.blue);
            g.fillOval(xposBall[i], yposBall[i], 100, 100);
            yposBall[i] ++;
            //Check, if the lowest line of balls is under the WindowSize/not visible anymore
            if (yposfirstBallofLowestLine > GUI.PANEL_SIZE_Y) {
                yposfirstBallofLowestLine = yposfirstBallofLowestLine - SpaceBetweenYpos;
                System.out.println("WEEWOO");
                NewLine(g);
            }
        }
        yposfirstBallofLowestLine++;
    }
}