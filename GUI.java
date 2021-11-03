import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

public class GUI {
    public static int PANEL_SIZE_X = 1920;
    public static int PANEL_SIZE_Y = 1080;

    public static JFrame frame;
    public static JButton StartGameMenuButton;
    public static JButton ExitButton;
    public static JButton startGameButton;
    public static JButton MainMenuButton;

    Font fontHeading = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 12);
	Font fontSubheadings = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 30);
    Font fontsizelittle = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 50);

    public GUI() {
        FrontPanel frontPanel = new FrontPanel();

        ActionHandler handler = new ActionHandler();

        frame = new JFrame();
        frame.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
        frame.setLayout(null);
        frame.setFocusable(true);
        frame.setUndecorated(true);
        frame.setVisible(true);

        MainMenuButton = new JButton("Main Menu");
        MainMenuButton.setBounds(PANEL_SIZE_X / 2 - PANEL_SIZE_X / 15, 0, PANEL_SIZE_X / 7, PANEL_SIZE_Y / 10);
        MainMenuButton.setBackground(Color.white);
        MainMenuButton.setForeground(Color.black);
        MainMenuButton.setFont(fontSubheadings);
        MainMenuButton.addActionListener(handler);

        //Start/Front panel

        ExitButton = new JButton("Exit");
        ExitButton.setBounds(PANEL_SIZE_X / 2 - PANEL_SIZE_X / 15, PANEL_SIZE_Y / 2 + PANEL_SIZE_Y / 3, PANEL_SIZE_X / 7, PANEL_SIZE_Y / 10);
        ExitButton.setBackground(Color.white);
        ExitButton.setForeground(Color.black);
        ExitButton.setFont(fontHeading);
        ExitButton.addActionListener(handler);

        StartGameMenuButton = new JButton("Start");
        StartGameMenuButton.setBounds(PANEL_SIZE_X / 2 - PANEL_SIZE_X / 15, PANEL_SIZE_Y / 2 - PANEL_SIZE_Y / 3, PANEL_SIZE_X / 7, PANEL_SIZE_Y / 10);
        StartGameMenuButton.setBackground(Color.white);
        StartGameMenuButton.setForeground(Color.black);
        StartGameMenuButton.setFont(fontHeading);
        StartGameMenuButton.addActionListener(handler);

        //GameSettingsPanel

        startGameButton = new JButton("Start");
        startGameButton.setBounds(PANEL_SIZE_X / 2 - PANEL_SIZE_X / 15, PANEL_SIZE_Y - PANEL_SIZE_Y / 10, PANEL_SIZE_X / 7, PANEL_SIZE_Y / 10);
        startGameButton.setBackground(Color.white);
        startGameButton.setForeground(Color.black);
        startGameButton.setFont(fontHeading);
        startGameButton.addActionListener(handler);

        frontPanel.add(ExitButton);
        frontPanel.add(StartGameMenuButton);
        frame.add(frontPanel);
    }
}