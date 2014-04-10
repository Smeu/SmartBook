package ro.cyberfire.smartbook.editor;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jdom2.Document;
import org.jdom2.Element;

import ro.cyberfire.smartbook.xml.SmartBookXMLTags;
import ro.cyberfire.smartbook.xml.XMLFile;

public class ChapterAdder {

  public ChapterAdder(DefaultMutableTreeNode bookNode, SmartBookEditor smartBook) {
    String chapterName = JOptionPane.showInputDialog("Nume pentru capitol:", JOptionPane.INFORMATION_MESSAGE);

    if (!chapterName.isEmpty()) {
      Document document = XMLFile.getDocument(smartBook.getFilePath());
      Element chapter = new Element(SmartBookXMLTags.CHAPTER);
      chapter.setAttribute("name", chapterName);
      document.getRootElement().addContent(chapter);
      XMLFile.saveDocument(document, smartBook.getFilePath());

      DefaultMutableTreeNode chapterNode = new DefaultMutableTreeNode(chapterName);
      bookNode.add(chapterNode);
      smartBook.refreshTree();
    }
  }

}
