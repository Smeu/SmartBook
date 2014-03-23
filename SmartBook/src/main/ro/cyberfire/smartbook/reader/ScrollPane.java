package ro.cyberfire.smartbook.reader;

import javax.swing.JScrollPane;

public class ScrollPane extends JScrollPane{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ScrollPane() {
    customize();
  }

  private void customize() {
  //  AbstractBorder border = new BubbleBorder(Color.BLACK,2,16,16);
  //  setBorder(border);
    //setLayout(new WrapLayout(WrapLayout.LEFT));
    //);
    setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
  }
  
  

}
