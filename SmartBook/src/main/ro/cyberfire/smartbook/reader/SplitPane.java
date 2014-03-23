package ro.cyberfire.smartbook.reader;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class SplitPane extends JSplitPane {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public SplitPane() {
    super(JSplitPane.HORIZONTAL_SPLIT, true);
    customize();

  }

  private void customize() {
    setUI(customizedDelimitator());
    setBorder(null);
    setDividerLocation(200);
  }
  
  private BasicSplitPaneUI customizedDelimitator(){
    return new BasicSplitPaneUI() {
      public BasicSplitPaneDivider createDefaultDivider() {
        return new BasicSplitPaneDivider(this) {
          /**
           * 
           */
          private static final long serialVersionUID = 1L;

          public void setBorder(Border b) {

          }

          @Override
          public void paint(Graphics g) {
            setSize(7, getSize().height);
            g.setColor(Color.GRAY);
            g.fillRect(2, 0, 1, getSize().height);
            g.fillRect(4, 0, 1, getSize().height);
            int height = getSize().height;
            height /= 2;
            g.setColor(Color.blue);
            g.drawRoundRect(0, height - 20, 6, 40, 5, 5);
            g.fillRoundRect(2, height - 10, 3, 20, 3, 3);

            super.paint(g);
          }

        };
      }
    };
  }

}
