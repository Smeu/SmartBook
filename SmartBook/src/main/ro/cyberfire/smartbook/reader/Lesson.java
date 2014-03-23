package ro.cyberfire.smartbook.reader;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JTextArea;

public class Lesson extends JTextArea {

  private static final long serialVersionUID = 1L;

  public Lesson() {
    customize();
    
    // TO DO
    // Sa primeasca referinta sau un sir catre paragrafe
    // si sa le creeze;
    setPreferredSize(new Dimension(300, 300));
    String text = "A text with <ref description > this <ref> as clickable word. ";
    text = text + text + text + text;
    
    JTextArea jTextArea = new JTextArea(text + text + text + text);
    jTextArea.setLineWrap(true);
    jTextArea.setWrapStyleWord(true);
    Paragraph.paragraph(text, this);
    Paragraph.paragraph(text, this);
  }
  
  @Override
  public Dimension getPreferredSize() {
    return getMinimumSize();
  };
  
  @Override
  public Dimension getMinimumSize() {
    return new Dimension(300, 300);
  };
  
  @Override
  public Dimension getMaximumSize(){
    return new Dimension(300, 300);
  }
  
  private void customize() {
    setLineWrap(true);
    setWrapStyleWord(true);
    setEditable(false);
   // setBackground(Color.GRAY);
    setLayout(new WrapLayout(WrapLayout.LEFT));
    setMargin(new Insets(20, 20, 20, 20));
    setForeground(getBackground());
  }

}
