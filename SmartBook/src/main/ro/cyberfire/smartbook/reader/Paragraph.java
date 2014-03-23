package ro.cyberfire.smartbook.reader;

import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Paragraph {

  public static void paragraph(String text, JTextArea textArea) {
    StringTokenizer splitStringTokenizer = new StringTokenizer(text, " ");
    while (splitStringTokenizer.hasMoreTokens()) {
      textArea.add(label(splitStringTokenizer));
    }
    String spaces = "                                                                                                                                                                                                                                      ";
    textArea.add(new JLabel(spaces + spaces + spaces + spaces));

  }

  private static JLabel label(StringTokenizer splitStringTokenizer) {
    String text = splitStringTokenizer.nextToken().toString();
    if (text.contains("<ref")){
      String toolTip = splitStringTokenizer.nextToken().toString();
      splitStringTokenizer.nextToken();
      text = splitStringTokenizer.nextToken().toString();
      String part = splitStringTokenizer.nextToken().toString();
      while (!part.contains("<ref>")){
        text = text + " " + part;
        part = splitStringTokenizer.nextToken().toString();
      }
      
      ClickableWord word = new ClickableWord(text);
      word.setToolTipText(toolTip);
      
      return word;
    }
    
    return new JLabel(text); 
  }

}
