package ro.cyberfire.smartbook.editor;

import java.io.File;

import javax.swing.JOptionPane;

import ro.cyberfire.smartbook.reader.SmartBook;

public class BookOpener {

  public BookOpener(SmartBook oldBook) {
    String bookName = JOptionPane.showInputDialog("Numele cartii:", JOptionPane.INFORMATION_MESSAGE);

    File file = new File("res/" + bookName + ".xml");
    if (!file.exists()) {
      JOptionPane.showMessageDialog(null, "Cartea nu exista");
      return;
    }

    if (!bookName.isEmpty()) {
      new SmartBook("res/" + bookName + ".xml").setVisible(true);
      oldBook.setVisible(false);
    }
  }

}
