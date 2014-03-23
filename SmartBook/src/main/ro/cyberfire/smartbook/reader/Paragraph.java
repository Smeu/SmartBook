package ro.cyberfire.smartbook.reader;

import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Paragraph {

  public static void paragraph(String text, JTextArea textArea, Map<KeyString, Lesson> lessons) {
    StringTokenizer splitStringTokenizer = new StringTokenizer(text, " ");
    while (splitStringTokenizer.hasMoreTokens()) {
      textArea.add(label(splitStringTokenizer, lessons));
    }
    String spaces = "                                                                                                                                                                                                                                      ";
    textArea.add(new JLabel(spaces + spaces + spaces + spaces));

  }

  private static JLabel label(StringTokenizer splitStringTokenizer, Map<KeyString, Lesson> lessons) {
    String text = splitStringTokenizer.nextToken().toString();
    if (text.contains("<ref")){
      String toolTip = lessonName(splitStringTokenizer);
      //splitStringTokenizer.nextToken();
      text = splitStringTokenizer.nextToken().toString();
      String part = splitStringTokenizer.nextToken().toString();
      while (!part.contains("<ref>")){
        text = text + " " + part;
        part = splitStringTokenizer.nextToken().toString();
      }
      Lesson lesson = lessons.get(new KeyString(toolTip));
      ClickableWord word = new ClickableWord(text, lesson);
      if (lesson != null)
        word.setToolTipText(lesson.getDescription());
      
      return word;
    }
    
    return new JLabel(text); 
  }
  
  private static String lessonName(StringTokenizer splitStringTokenizer){
    String name = splitStringTokenizer.nextToken().toString();
    String part = splitStringTokenizer.nextToken().toString();
    while (!part.contains(">")){
      name = name + " " + part;
      part = splitStringTokenizer.nextToken().toString();
    }
    
    return name;
  }

}
