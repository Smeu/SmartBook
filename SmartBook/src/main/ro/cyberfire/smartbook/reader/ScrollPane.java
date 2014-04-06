package ro.cyberfire.smartbook.reader;

import javax.swing.JScrollPane;

public class ScrollPane extends JScrollPane {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ScrollPane() {
    customize();
  }

  private void customize() {
    setBorder(new BubbleBorder(Theme.borderColor, 2, 16, 16));
    // );
    setBackground(Theme.backgroundColor);

    setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
  }

}
