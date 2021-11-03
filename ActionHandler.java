import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionHandler implements ActionListener {
    GameSettingsPanel gamesettingspanel = new GameSettingsPanel();
    FrontPanel frontPanel = new FrontPanel();
    GameFieldPanel gamefieldpanel = new GameFieldPanel();

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GUI.ExitButton) {
            System.exit(0);
        }
        if (e.getSource() == GUI.MainMenuButton) {
            GUI.frame.getContentPane().removeAll();
            frontPanel.add(GUI.ExitButton);
            frontPanel.add(GUI.StartGameMenuButton);
            GUI.frame.add(frontPanel).repaint();
        }

        if (e.getSource() == GUI.StartGameMenuButton) {
            GUI.frame.getContentPane().removeAll();
            gamesettingspanel.add(GUI.startGameButton);
            gamesettingspanel.add(GUI.MainMenuButton);
            GUI.frame.add(gamesettingspanel).repaint();
        }
        if (e.getSource() == GUI.startGameButton) {
            GUI.frame.getContentPane().removeAll();
            gamefieldpanel.add(GUI.MainMenuButton);
            GUI.frame.add(gamefieldpanel).repaint();
        }
    }
    
}