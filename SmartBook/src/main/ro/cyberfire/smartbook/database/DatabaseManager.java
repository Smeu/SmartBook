package ro.cyberfire.smartbook.database;

import java.io.File;
import java.sql.*;

import ro.cyberfire.smartbook.database.tableTypes.ParagraphType;

public class DatabaseManager {

  private Connection connection = null;
  private InsertDriver insertDriver = null;
  public QueryDriver queryDriver = null;

  public DatabaseManager(String path) { // path-ul contine si nume bazei de date cu extensia db. ex: test.db
    try {

      File f = new File(path);
      if (!f.exists()) {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        createBookDetailsTable();
        createAuthorsTable();
        createChaptersTable();
        createLessonsTable();
        createParagraphsTable();
        createDictionaryTable();
      }
      else {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
      }

    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }

    insertDriver = new InsertDriver(connection);
    queryDriver = new QueryDriver(connection);
  }

  private void createBookDetailsTable() {
    Statement stmt = null;
    try {
      stmt = connection.createStatement();
      String sql = "CREATE TABLE BookDetails ";
      sql += "(Name VARCHAR NOT NULL, Publisher VARCHAR, Description TEXT)";
      stmt.executeUpdate(sql);
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }

  private void createAuthorsTable() {
    Statement stmt = null;
    try {
      stmt = connection.createStatement();
      String sql = "CREATE TABLE Authors ";
      sql += "(Name VARCHAR NOT NULL)";
      stmt.executeUpdate(sql);
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }

  private void createChaptersTable() {
    Statement stmt = null;
    try {
      stmt = connection.createStatement();
      String sql = "CREATE TABLE Chapters ";
      sql += "(ID_Chapter INT PRIMARY KEY NOT NULL, Name VARCHAR, Description TEXT)";
      stmt.executeUpdate(sql);
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }

  private void createLessonsTable() {
    Statement stmt = null;
    try {
      stmt = connection.createStatement();
      String sql = "CREATE TABLE Lessons ";
      sql += "(ID_Lesson INT PRIMARY KEY NOT NULL, ID_Chapter INT NOT NULL, Name VARCHAR, Description TEXT)";
      stmt.executeUpdate(sql);
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }

  private void createParagraphsTable() {
    Statement stmt = null;
    try {
      stmt = connection.createStatement();
      String sql = "CREATE TABLE Paragraphs ";
      sql += "(ID_Paragraph INT PRIMARY KEY NOT NULL, ID_Lesson INT NOT NULL, IndexOrder INT NOT NULL, Type VARCHAR, Name VARCHAR, Text TEXT)";
      stmt.executeUpdate(sql);
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }

  private void createDictionaryTable() {
    Statement stmt = null;
    try {
      stmt = connection.createStatement();
      String sql = "CREATE TABLE Dictionary ";
      sql += "(ID_Lesson INT NOT NULL, ID_Paragraph INT NOT NULL, Text TEXT, Link_Text TEXT, Link_ID_Lesson INT NOT NULL, Link_ID_Paragraph INT NOT NULL)";
      stmt.executeUpdate(sql);
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }

  public void insertBookDetails(String name, String publisher, String description) {
    insertDriver.insertBookDetails(name, publisher, description);
  }

  public void insertAuthors(String name) {
    insertDriver.insertAuthors(name);
  }

  public void insertChapter(String name, String description) {
    insertDriver.insertChapter(name, description);
  }

  public void insertLesson(String chapterName, String name, String description) {
    insertDriver.insertLesson(chapterName, name, description);
  }

  public void insertParagraph(String lessonName, int indexOrder, ParagraphType type, String name, String text) {
    insertDriver.insertParagraph(lessonName, indexOrder, type, name, text);
  }

  public void insertAnchorText(String lessonName, String paragraphName, String text, String linkText,
      String linkLessonName, String linkParagraphName) {
    insertDriver.insertAnchorText(lessonName, paragraphName, text, linkText, linkLessonName, linkParagraphName);
  }

  public void insertAnchorText(String lessonName, int paragraphIndexOrder, String text, String linkText,
      String linkLessonName, int linkParagraphIndexOrder) {
    insertDriver.insertAnchorText(lessonName, paragraphIndexOrder, text, linkText, linkLessonName,
        linkParagraphIndexOrder);
  }
}
