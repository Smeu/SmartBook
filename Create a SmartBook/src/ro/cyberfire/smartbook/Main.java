package ro.cyberfire.smartbook;

import ro.cyberfire.smartbook.database.*;
import ro.cyberfire.smartbook.database.tableTypes.BookDetails;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    DatabaseManager db = new DatabaseManager("test.db");
    db.insertBookDetails("test", "publisher", "description");
    BookDetails bk = new BookDetails();
    bk = db.queryDriver.getBookDetails();
    System.out.println(bk.getDescription().toString());
  }
}
