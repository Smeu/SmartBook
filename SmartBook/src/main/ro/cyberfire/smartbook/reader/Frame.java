package ro.cyberfire.smartbook.reader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.ToolTipManager;

public class Frame extends JFrame {

  private static final String TITLE_NAME = "Smart Book";
  private static final long serialVersionUID = 1L;

  public Frame() throws HeadlessException {
    customizateFrame();
  }

  private void customizateFrame() {
    setDefaultLookAndFeelDecorated(true);
    setPreferredSize(new Dimension(1000, 600));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //setMinimumSize(new Dimension(1000, 600));
    //setLocationRelativeTo(null);
    setBackground(Color.yellow);
    setTitle(TITLE_NAME);
    ToolTipManager.sharedInstance().setInitialDelay(0);
  }

}
