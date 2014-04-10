package ro.cyberfire.smartbook.editor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jdom2.Document;
import org.jdom2.Element;

import ro.cyberfire.smartbook.reader.KeyString;
import ro.cyberfire.smartbook.reader.Lesson;
import ro.cyberfire.smartbook.reader.ScrollPane;
import ro.cyberfire.smartbook.xml.SmartBookXMLTags;
import ro.cyberfire.smartbook.xml.XMLFile;

public class LessonAdder extends JPanel {

  private static final long serialVersionUID = 1L;

  private SmartBookEditor smartBook;

  private JLabel titleLabel;
  private JLabel insertNameLabel;
  private JLabel insertDescriptionLabel;
  private JTextField name;
  private JTextArea description;
  private JButton lessonDone;

  public LessonAdder(ScrollPane displayPane, DefaultMutableTreeNode chapterNode, SmartBookEditor smartBook) {
    this.smartBook = smartBook;
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    displayPane.setViewportView(this);
    addComponents(displayPane, chapterNode);
  }

  private void addComponents(ScrollPane displayPane, final DefaultMutableTreeNode chapterNode) {
    titleLabel = new JLabel("Lectie noua");
    insertNameLabel = new JLabel("Titlul lectiei:");
    insertDescriptionLabel = new JLabel("Scurta descriere:");
    name = new JTextField();
    description = new JTextArea();
    lessonDone = new JButton("Gata");

    name.setMaximumSize(new Dimension(500, name.getPreferredSize().height));
    description.setLineWrap(true);
    description.setMaximumSize(new Dimension(500, 300));

    lessonDone.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!name.getText().isEmpty()) {
          addLessonToTree(chapterNode, name.getText(), description.getText());
          Lesson lesson = new Lesson(name.getText(), description.getText());
          chapterNode.add(new DefaultMutableTreeNode(lesson));
          smartBook.refreshTree();

          smartBook.getLessonsMap().put(new KeyString(name.getText()), lesson);
          name.setText("");
          description.setText("");
        }
      }
    });

    add(titleLabel);
    add(insertNameLabel);
    add(name);
    add(insertDescriptionLabel);
    add(description);
    add(lessonDone);
  }

  private void addLessonToTree(DefaultMutableTreeNode chapterNode, String name, String descriptionText) {
    DefaultMutableTreeNode bookNode = (DefaultMutableTreeNode) chapterNode.getParent();

    Document document = XMLFile.getDocument(smartBook.getFilePath());
    Element lesson = new Element(SmartBookXMLTags.LESSON);
    Element description = new Element(SmartBookXMLTags.DESCRIPTION);
    lesson.setAttribute("name", name);
    description.setText(descriptionText);
    lesson.addContent(description);
    String path = SmartBookXMLTags.CHAPTER + "/" + bookNode.getIndex(chapterNode);
    Element chapter = XMLFile.getElement(document, path);

    chapter.addContent(lesson);
    XMLFile.saveDocument(document, smartBook.getFilePath());
  }

}
