package tick_tack_toe;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 640;
    private GameMap gameMap;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Tick Tack Toe");
        setResizable(false);
        JButton btnStart = new JButton("<html><body><b>SART</b></body></html>");
        JButton btnStop = new JButton("<html><body><b>EXIT</b></body></html>");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);

        gameMap = new GameMap();
        final SettingsWindow settingsWindow = new SettingsWindow();

        add(gameMap, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);

        btnStart.addActionListener(e -> settingsWindow.setVisible(true));
        btnStop.addActionListener(e -> System.exit(0));
    }


}
