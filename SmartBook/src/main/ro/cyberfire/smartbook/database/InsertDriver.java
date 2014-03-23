package ro.cyberfire.smartbook.database;

import java.sql.*;

import ro.cyberfire.smartbook.database.tableTypes.ParagraphType;

public class InsertDriver {

  private Connection connection;
  private QueryDriver queryDriver;

  public InsertDriver(Connection connection) {
    this.connection = connection;
    queryDriver = new QueryDriver(connection);
  }

  public void insertBookDetails(String name, String publisher, String description) {
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "INSERT INTO BookDetails (Name,Publisher,Description) ";
      sql += "VALUES ('" + name + "', '" + publisher + "', '" + description + "');";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.commit();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  public void insertAuthors(String name) {
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "INSERT INTO Authors (Name) ";
      sql += "VALUES ('" + name + "');";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.commit();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  public void insertChapter(String name, String description) {
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "INSERT INTO Chapters (Name,Description) ";
      sql += "VALUES ('" + name + "' , '" + description + "');";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.commit();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  public void insertLesson(String chapterName, String name, String description) {
    Statement stmt = null;
    int idChapter = queryDriver.getID_Chapter(chapterName);
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "INSERT INTO Lessons (ID_Chapter,Name,Description) ";
      sql += "VALUES (" + idChapter + " , '" + name + "', '" + description + "');";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.commit();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  public void insertParagraph(String lessonName, int indexOrder, ParagraphType type, String name, String text) {
    Statement stmt = null;
    int idLesson = queryDriver.getID_Lesson(lessonName);
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "INSERT INTO Paragraphs (ID_Lesson,IndexOrder,Type,Name,Text) ";
      sql += "VALUES (" + idLesson + " , " + indexOrder + ", '" + type + "', '" + name + "', '" + text + "');";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.commit();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  public void insertAnchorText(String lessonName, String paragraphName, String text, String linkText,
      String linkLessonName, String linkParagraphName) {
    Statement stmt = null;
    int idLesson = queryDriver.getID_Lesson(lessonName);
    int idParagraph = queryDriver.getID_Paragrapah(paragraphName);
    int linkIdLesson = queryDriver.getID_Lesson(linkLessonName);
    int linkIdParagraph = queryDriver.getID_Paragrapah(linkParagraphName);
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "INSERT INTO Paragraphs (ID_Lesson,ID_Paragraph,Text,Link_Text,Link_ID_Lesson,Link_ID_Paragraph) ";
      sql += "VALUES (" + idLesson + " , " + idParagraph + ", '" + text + "', '" + linkText + "', " + linkIdLesson
          + ", " + linkIdParagraph + ");";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.commit();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }

  public void insertAnchorText(String lessonName, int paragraphIndexOrder, String text, String linkText,
      String linkLessonName, int linkParagraphIndexOrder) {
    Statement stmt = null;
    int idLesson = queryDriver.getID_Lesson(lessonName);
    int idParagraph = queryDriver.getID_Paragrapah(paragraphIndexOrder);
    int linkIdLesson = queryDriver.getID_Lesson(linkLessonName);
    int linkIdParagraph = queryDriver.getID_Paragrapah(linkParagraphIndexOrder);
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      String sql = "INSERT INTO Paragraphs (ID_Lesson,ID_Paragraph,Text,Link_Text,Link_ID_Lesson,Link_ID_Paragraph) ";
      sql += "VALUES (" + idLesson + " , " + idParagraph + ", '" + text + "', '" + linkText + "', " + linkIdLesson
          + ", " + linkIdParagraph + ");";
      stmt.executeUpdate(sql);
      stmt.close();
      connection.commit();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }
}
