package tick_tack_toe;

import javax.swing.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 300;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String  FIELD_SIZE_PREFIX = "Field size: ";
    private static final String  WIN_LENGTH_PREFIX = "Win length: ";

    private JSlider sliderWinLength;
    private JSlider sliderFieldSize;
    private JRadioButton humanVsAI;
    private JRadioButton humanVsHuman;

    public SettingsWindow(){

    }

}
