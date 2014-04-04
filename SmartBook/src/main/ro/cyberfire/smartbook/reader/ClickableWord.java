package ro.cyberfire.smartbook.reader;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JToolTip;

/**
 * Class for a word. Puts the word in a J panel and adds a mouse listener on it. Static scroll panel must be set before
 * is used. Tool tips added on this label are @ToolTip objects
 * 
 * @author Rares
 * 
 */
public class ClickableWord extends JLabel {

  private static final long serialVersionUID = 7258486796110202404L;
  private ToolTip m_tooltip;
  private static ScrollPane scrollPane;
  private Lesson lesson;

  public static void setScrollPane(ScrollPane scrollPanel) {
    scrollPane = scrollPanel;
  }

  /**
   * 
   * @param text The label text.
   * @param aLesson The view that will be changed to when clicked.
   */
  public ClickableWord(String text, Lesson aLesson) {
    super(text);
    this.lesson = aLesson;
    setForeground(Color.blue);

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        scrollPane.setViewportView(lesson);
      }
    });
  }

  @Override
  public JToolTip createToolTip() {
    if (m_tooltip == null) {
      m_tooltip = new ToolTip();
      m_tooltip.setComponent(this);
    }
    return m_tooltip;
  }
}
