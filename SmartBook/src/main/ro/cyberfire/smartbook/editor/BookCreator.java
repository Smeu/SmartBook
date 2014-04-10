package ro.cyberfire.smartbook.editor;

import java.io.File;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;

import ro.cyberfire.smartbook.reader.SmartBook;
import ro.cyberfire.smartbook.xml.XMLFile;

public class BookCreator {

  public BookCreator(SmartBook oldBook) {
    String bookName = JOptionPane.showInputDialog("Numele cartii:", JOptionPane.INFORMATION_MESSAGE);
    String path = "res/" + bookName + ".xml";

    File file = new File(path);
    if (file.exists()) {
      JOptionPane.showMessageDialog(null, "Numele exista, alegeti altul");
      return;
    }

    if (!bookName.isEmpty()) { // TODO: check non-existence of file
      Document document = new Document();
      Element root = new Element(bookName);
      root.setAttribute("name", bookName);
      document.setRootElement(root);
      XMLFile.saveDocument(document, path);

      new SmartBook(path).setVisible(true);
      oldBook.setVisible(false);
    }
  }

}
