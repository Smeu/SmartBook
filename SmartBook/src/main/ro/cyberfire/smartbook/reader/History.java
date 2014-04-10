package ro.cyberfire.smartbook.reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JScrollPane;

/**
 * Keeps history of viewed lessons and implements a button for them.
 * 
 * @author Rares
 * 
 */
public class History {

  public static final Stack<Lesson> lastLesson = new Stack<>();

  private static final JButton backButton = new JButton("Back");
  private static JScrollPane toShowInContainer;

  static {
    backButton.setEnabled(false);
    backButton.setBackground(Theme.backgroundColor);
    backButton.setBorder(null);
    backButton.setSize(backButton.getWidth() + 10, backButton.getHeight());
    backButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        lastLesson.pop();
        toShowInContainer.setViewportView(lastLesson.peek());
        updateButtonState();
      }
    });
  }

  /**
   * Update the button states. It will enabled it if have a prevision lesson to go to
   */
  public static void updateButtonState() {
    if (lastLesson.size() > 1) {
      backButton.setEnabled(true);
      return;
    }
    backButton.setEnabled(false);
  }

  /**
   * Sets the button with new data and returns it.
   * 
   * @param changePanel The panel in which the element from history will be shown up.
   * @return Returns the button.
   */
  public static JButton setButton(JScrollPane changePanel) {
    toShowInContainer = changePanel;
    return backButton;
  }

  private History() {
  }

}
