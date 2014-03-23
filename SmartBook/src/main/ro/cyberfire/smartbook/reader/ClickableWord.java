package ro.cyberfire.smartbook.reader;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JToolTip;

public class ClickableWord extends JLabel {

  private static final long serialVersionUID = 7258486796110202404L;
  private ToolTip m_tooltip;
  
  public ClickableWord(String text) {
    super(text);
    setForeground(Color.blue);
    
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        System.out.println("Label Clicked!");
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
