package ro.cyberfire.smartbook.reader;

import ro.cyberfire.smartbook.editor.SmartBookEditor;

public class Main {

  public static void main(String... args) {
    // SmartBook smartBook = new SmartBook("res/book.xml");
    // smartBook.setVisible(true);

    SmartBook smartBookEditor = new SmartBookEditor("res/book.xml");
    smartBookEditor.setVisible(true);
  }

}
