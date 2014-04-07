package ro.cyberfire.smartbook.reader;

import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * A paragraph that consists of labels.
 * 
 * @author Rares
 * 
 */
public class Paragraph {

  /**
   * Add the text as a series of Labels to the textarea.
   * 
   * @param text
   * @param textArea
   * @param lessons
   */
  public static void paragraph(String text, JTextArea textArea, Map<KeyString, Lesson> lessons) {
    // TODO try to add this to a container and that container to text area.
    StringTokenizer splitStringTokenizer = new StringTokenizer(text, " ");
    textArea.add(simpleJLabel("    "));
    while (splitStringTokenizer.hasMoreTokens()) {
      textArea.add(label(splitStringTokenizer, lessons));
    }
    String spaces = "                                                                                                                                                                                                                                      ";
    textArea.add(simpleJLabel(spaces + spaces + spaces + spaces));
  }

  private static JComponent label(StringTokenizer splitStringTokenizer, Map<KeyString, Lesson> lessons) {
    String text = splitStringTokenizer.nextToken().toString();
    if (text.contains("{ref")) {
      String toolTip = lessonName(splitStringTokenizer);
      text = splitStringTokenizer.nextToken().toString();
      String part = splitStringTokenizer.nextToken().toString();
      while (!part.contains("{ref}")) {
        text = text + " " + part;
        part = splitStringTokenizer.nextToken().toString();
      }
      Lesson lesson = lessons.get(new KeyString(toolTip));
      ClickableWord word = new ClickableWord(text, lesson);
      if (lesson != null)
        word.setToolTipText(lesson.getDescription());

      return word;
    }
    if (text.contains("{img")) {
      String path = splitStringTokenizer.nextToken().toString();
      if (path.endsWith("}")) {
        path = path.substring(0, path.length() - 1);
      }
      else {
        splitStringTokenizer.nextToken();
      }
      JLabel image = new JLabel();
      image.setIcon(new ImageIcon("res/" + path));
      return image;
    }
    return simpleJLabel(text);
  }

  private static JLabel simpleJLabel(String text) {
    JLabel label = new JLabel(text);
    label.setFont(Theme.font);
    return label;
  }

  private static String lessonName(StringTokenizer splitStringTokenizer) {
    String name = splitStringTokenizer.nextToken().toString();
    String part = splitStringTokenizer.nextToken().toString();
    while (!part.contains("}")) {
      name = name + " " + part;
      part = splitStringTokenizer.nextToken().toString();
    }

    return name;
  }

}
