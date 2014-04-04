package ro.cyberfire.smartbook.reader;

import java.awt.Dimension;
import java.awt.Insets;
import java.util.Map;

import javax.swing.JTextArea;

public class Lesson extends JTextArea {

  private static final long serialVersionUID = 1L;
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

  public void addParagraph(String text, Map<KeyString, Lesson> lessons) {
    Paragraph.paragraph(text, this, lessons);
  }

  @Override
  public Dimension getPreferredSize() {
    return layout.preferredLayoutSize(this);
  };

  /*
   * @Override public Dimension getMinimumSize() { return new Dimension(300, 300); };
   * 
   * @Override public Dimension getMaximumSize(){ return new Dimension(300, 300); }
   */

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
