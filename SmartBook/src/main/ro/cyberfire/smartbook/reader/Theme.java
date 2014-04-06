package ro.cyberfire.smartbook.reader;

import java.awt.Color;
import java.awt.Font;
import java.util.prefs.Preferences;

public class Theme {

  private static final String DEFAULT_BACKGROUND_COLOR = "#FFF2CD";
  private static final String DEFAULT_BORDER_COLOR = getColor(Color.ORANGE);
  private static final int DEFAULT_FONT_SIZE = 14;

  public static Color backgroundColor;
  public static Color borderColor;
  public static Font font;

  static {
    Preferences pref = Preferences.userRoot().node(SmartBook.class.getName());
    String BG_COLOR = "BackgroundColor";
    String BORDER_COLOR = "BorderColor";
    String FONT_SIZE = "FontSize";

    backgroundColor = Color.decode(pref.get(BG_COLOR, DEFAULT_BACKGROUND_COLOR));
    borderColor = Color.decode(pref.get(BORDER_COLOR, DEFAULT_BORDER_COLOR));
    int fontSize = pref.getInt(FONT_SIZE, DEFAULT_FONT_SIZE);
    font = new Font("Name", Font.PLAIN, fontSize);
  }

  public static void savePref() {
    Preferences pref = Preferences.userRoot().node(SmartBook.class.getName());
    String BG_COLOR = "BackgroundColor";
    String BORDER_COLOR = "BorderColor";
    String FONT_SIZE = "FontSize";

    pref.put(BG_COLOR, getColor(backgroundColor));
    pref.put(BORDER_COLOR, getColor(borderColor));
    pref.putInt(FONT_SIZE, font.getSize());
  }

  private static String getColor(Color c) {
    String hex = String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
    return hex;
  }

  public static void resetToDefault() {
    Preferences pref = Preferences.userRoot().node(SmartBook.class.getName());
    String BG_COLOR = "BackgroundColor";
    String BORDER_COLOR = "BorderColor";
    String FONT_SIZE = "FontSize";

    pref.put(BG_COLOR, DEFAULT_BACKGROUND_COLOR);
    pref.put(BORDER_COLOR, DEFAULT_BORDER_COLOR);
    pref.putInt(FONT_SIZE, DEFAULT_FONT_SIZE);
  }

}
