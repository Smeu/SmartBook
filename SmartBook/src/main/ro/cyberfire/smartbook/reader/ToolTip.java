package ro.cyberfire.smartbook.reader;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.JToolTip;

public class ToolTip extends JToolTip {

  private static final long serialVersionUID = 5999650136315992225L;
  private JTextArea panel;

  public ToolTip() {
    super();

    setLayout(new BorderLayout());
    preferences();

    /*
     * m_label = new JLabel(); m_button = new JButton("See, I am a button!"); m_panel = new JPanel(new BorderLayout());
     * m_panel.add(BorderLayout.CENTER, m_label); m_panel.add(BorderLayout.SOUTH, m_button); setLayout(new
     * BorderLayout());
     */
    add(panel);

  }

  private void preferences() {
    panel = new JTextArea();
    panel.setBackground(Theme.backgroundColor);
    panel.setBorder(new BubbleBorder(Theme.borderColor, 2, 16, 16, Theme.backgroundColor));
    panel.setMaximumSize(new Dimension(200, 100000));
    panel.setPreferredSize(new Dimension(200, 100));
    panel.setMargin(new Insets(5, 5, 5, 10));
    panel.setLineWrap(true);
    panel.setWrapStyleWord(true);
    panel.setEditable(false);
  }

  @Override
  public void paint(java.awt.Graphics g) {
    panel.paint(g);
  };

  @Override
  public void setVisible(boolean aFlag) {
    super.setVisible(true);
  };

  @Override
  public Dimension getPreferredSize() {
    return panel.getPreferredSize();
  }

  @Override
  public void setTipText(String tipText) {
    if (tipText != null && !tipText.isEmpty()) {
      panel.setText(tipText);
      panel.setFont(Theme.font);
    }
    else {
      super.setTipText(tipText);
    }
  }
}
