package ro.cyberfire.smartbook.editor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jdom2.Document;
import org.jdom2.Element;

import ro.cyberfire.smartbook.reader.Lesson;
import ro.cyberfire.smartbook.reader.ScrollPane;
import ro.cyberfire.smartbook.reader.SmartBook;
import ro.cyberfire.smartbook.xml.SmartBookXMLTags;
import ro.cyberfire.smartbook.xml.XMLFile;

public class ParagraphAdder extends JPanel {

  private static final long serialVersionUID = 1L;
  private SmartBook smartBook;
  private JButton paragraphDone;
  private JTextArea paragraph;

  public ParagraphAdder(ScrollPane displayPane, DefaultMutableTreeNode lessonNode, SmartBook smartBook) {
    this.smartBook = smartBook;
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    displayPane.setViewportView(this);
    addComponents(displayPane, lessonNode);
  }

  private void addComponents(final ScrollPane displayPane, final DefaultMutableTreeNode lessonNode) {
    paragraph = new JTextArea();
    paragraphDone = new JButton("Gata");

    paragraph.setLineWrap(true);
    paragraph.setMaximumSize(new Dimension(500, 300));

    paragraphDone.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addParagraphText(lessonNode, paragraph.getText());

        Lesson lesson = (Lesson) lessonNode.getUserObject();
        lesson.addParagraph(paragraph.getText(), smartBook.getLessonsMap());
        displayPane.setViewportView(lesson);
      }
    });

    add(paragraph);
    add(paragraphDone);
  }

  private void addParagraphText(DefaultMutableTreeNode lessonNode, String paragraphText) {
    DefaultMutableTreeNode chapterNode = (DefaultMutableTreeNode) lessonNode.getParent();
    DefaultMutableTreeNode bookNode = (DefaultMutableTreeNode) chapterNode.getParent();

    Document document = XMLFile.getDocument(smartBook.getFilePath());
    Element paragraph = new Element(SmartBookXMLTags.PARAGRAPH);
    paragraph.setText(paragraphText);
    String path = SmartBookXMLTags.CHAPTER + "/" + bookNode.getIndex(chapterNode) + "/" + SmartBookXMLTags.LESSON + "/"
        + chapterNode.getIndex(lessonNode);
    Element lesson = XMLFile.getElement(document, path);

    lesson.addContent(paragraph);
    XMLFile.saveDocument(document, smartBook.getFilePath());
  }

}
