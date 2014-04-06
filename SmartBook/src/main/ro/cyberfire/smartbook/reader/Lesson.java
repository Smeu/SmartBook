package ro.cyberfire.smartbook.reader;

import java.awt.Dimension;
import java.awt.Insets;
import java.util.Map;

import javax.swing.JTextArea;

/**
 * Contains a lesson, which represent a division of a chapter. It's represented as a personalized JTextArea. Consists of
 * multiple paragraphs.
 * 
 * @author Rares
 * 
 */
public class Lesson extends JTextArea {

  private static final long serialVersionUID = 6327711909606805481L;
  private String name;
  private String description;
  private WrapLayout layout = new WrapLayout(WrapLayout.LEFT);

  public Lesson(String name, String description) {
    customize();
    this.name = name;
    this.description = description;

    setPreferredSize(new Dimension(300, 300));
    /*
     * String text = " A text with <ref description > this <ref> as clickable word. "; text = text + text + text + text;
     * 
     * JTextArea jTextArea = new JTextArea(text + text + text + text); jTextArea.setLineWrap(true);
     * jTextArea.setWrapStyleWord(true); Paragraph.paragraph(text, this); Paragraph.paragraph(text, this);
     */
  }

  public String getDescription() {
    return description;
  }

  /**
   * Add's a new paragraph for this this lesson.
   * 
   * @param text The text of the paragraph.
   * @param lessons Lessons map for connection with clickable words.
   */
  public void addParagraph(String text, Map<KeyString, Lesson> lessons) {
    Paragraph.paragraph(text, this, lessons);
  }

  @Override
  public Dimension getPreferredSize() {
    return layout.preferredLayoutSize(this);
  };

  private void customize() {
    setLineWrap(true);
    setWrapStyleWord(true);
    setEditable(false);
    setBackground(Theme.backgroundColor);
    setLayout(layout);
    setMargin(new Insets(20, 20, 20, 20));
    setForeground(getBackground());

  }

  @Override
  public String toString() {
    return name;
  }

}
