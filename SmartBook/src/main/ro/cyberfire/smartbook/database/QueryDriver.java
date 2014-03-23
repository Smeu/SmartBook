package ro.cyberfire.smartbook.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ro.cyberfire.smartbook.database.tableTypes.*;

public class QueryDriver {

  private Connection connection;

  public QueryDriver(Connection connection) {
    this.connection = connection;
  }

  public Integer getID_Chapter(String chapterName) {
    Statement stmt = null;
    Integer id = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_Chapter FROM Chapters WHERE Name = '" + chapterName + "';");
      while (rs.next()) {
        id = rs.getInt("ID_Chapter");
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return id;
  }

  public Integer getID_Lesson(String lessonName) {
    Statement stmt = null;
    Integer id = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_Lesson FROM Lessons WHERE Name = '" + lessonName + "';");
      while (rs.next()) {
        id = rs.getInt("ID_Lesson");
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return id;
  }

  public Integer getID_Paragrapah(String pharagraphName) {
    Statement stmt = null;
    Integer id = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_Paragraph FROM Chapters WHERE Name = '" + pharagraphName + "';");
      while (rs.next()) {
        id = rs.getInt("ID_Paragraph");
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return id;
  }

  public Integer getID_Paragrapah(int indexOrder) {
    Statement stmt = null;
    Integer id = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_Paragraph FROM Chapters WHERE indexOrder = " + indexOrder + ";");
      while (rs.next()) {
        id = rs.getInt("ID_Paragraph");
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return id;
  }

  public BookDetails getBookDetails() {
    Statement stmt = null;
    BookDetails bookDetails = new BookDetails();
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM BookDetails;");
      while (rs.next()) {
        bookDetails.setName(rs.getString("Name"));
        bookDetails.setPubliser(rs.getString("Publisher"));
        bookDetails.setDescription(rs.getString("Description"));
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return bookDetails;
  }

  public List<String> getAuthors() {
    List<String> list = new ArrayList<String>();
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM Authors;");
      while (rs.next()) {
        list.add(rs.getString("Name"));
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return list;
  }

  public List<Chapter> getAllChapters() {
    List<Chapter> list = new ArrayList<Chapter>();
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM Chapters;");
      while (rs.next()) {
        list.add(new Chapter(rs.getString("Name"), rs.getString("Description")));
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return list;
  }

  public List<Lesson> getAllLessons() {
    List<Lesson> list = new ArrayList<Lesson>();
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM Lessons;");
      while (rs.next()) {
        list.add(new Lesson(rs.getString("Name"), rs.getString("Description"), rs.getInt("ID_Chapter")));
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return list;
  }

  public List<Paragraph> getAllPharagraphs() {
    List<Paragraph> list = new ArrayList<Paragraph>();
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM Paragraphs;");
      while (rs.next()) {
        Paragraph p = new Paragraph(rs.getInt("ID_Paragraph"), rs.getInt("ID_Lesson"), rs.getInt("IndexOrder"));

        switch (rs.getString("Type")) {
        case "Definitie":
          p.setParagraphType(ParagraphType.Definitie);
          break;
        case "DeRetinut":
          p.setParagraphType(ParagraphType.DeRetinut);
          break;
        case "Observatie":
          p.setParagraphType(ParagraphType.Observatie);
          break;

        }
        p.setName(rs.getString("Name"));
        p.setText(rs.getString("Text"));
        list.add(p);
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return list;
  }

  public List<Anchor> getAllAnchors() {
    List<Anchor> list = new ArrayList<Anchor>();
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM Paragraphs;");
      while (rs.next()) {
        Anchor a = new Anchor(rs.getInt("ID_Paragraph"), rs.getInt("ID_Lesson"), rs.getString("Text"),
            rs.getInt("Link_ID_Paragraph"), rs.getInt("Link_ID_Lesson"));
        a.setLinkText(rs.getString("Link_Text"));
        list.add(a);
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return list;
  }

  public Boolean isChapterNameUnique(String chapterName) {
    Boolean rez = true;
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT count(*) FROM Chapters WHERE Name = '" + chapterName + "';");
      while (rs.next()) {
        rez = false;
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return rez;
  }

  public Boolean isLessonNameUnique(String chapterName) {
    Boolean rez = true;
    Statement stmt = null;
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT count(*) FROM Lessons WHERE Name = '" + chapterName + "';");
      while (rs.next()) {
        rez = false;
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return rez;
  }

  public Chapter getChapterFromID(int idChapter) {
    Statement stmt = null;
    Chapter chapter = new Chapter();
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT Name, Description FROM Chapters WHERE ID_Chapter = " + idChapter + ";");
      while (rs.next()) {
        chapter.setName(rs.getString("Name"));
        chapter.setDescription(rs.getString("Description"));
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return chapter;
  }

  public Lesson getLessonFromID(int idLesson) {
    Statement stmt = null;
    Lesson lesson = new Lesson();
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_Chapter, Name, Description FROM Chapters WHERE ID_Lesson = "
          + idLesson + ";");
      while (rs.next()) {
        lesson.setIdChapter(rs.getInt("ID_Chapter"));
        lesson.setName(rs.getString("Name"));
        lesson.setDescription(rs.getString("Description"));
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return lesson;
  }

  public Paragraph getParagraphFromID(int idParagraph) {
    Statement stmt = null;
    Paragraph paragraph = new Paragraph();
    try {
      connection.setAutoCommit(false);
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT ID_Lesson, IndexOrder, Type, Name, Text FROM Chapters WHERE ID_Paragraph = "
          + idParagraph + ";");
      while (rs.next()) {
        paragraph.setIdLesson(rs.getInt("ID_Lesson"));
        paragraph.setIndexOrder(rs.getInt("IndexOrder"));
        paragraph.setName(rs.getString("Name"));
        paragraph.setText(rs.getString("Text"));
        paragraph.setIdParagraph(idParagraph);
        switch (rs.getString("Type")) {
        case "Definitie":
          paragraph.setParagraphType(ParagraphType.Definitie);
          break;
        case "DeRetinut":
          paragraph.setParagraphType(ParagraphType.DeRetinut);
          break;
        case "Observatie":
          paragraph.setParagraphType(ParagraphType.Observatie);
          break;
        }

      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return paragraph;
  }
}
