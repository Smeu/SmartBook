package ro.cyberfire.smartbook;

import java.util.ArrayList;
import ro.cyberfire.smartbook.database.*;
import ro.cyberfire.smartbook.database.tableTypes.ParagraphType;

/**
 * Class which takes a book and puts it into the database
 * 
 * @author Teodora
 */
public class DataBaseBookAdder {
  
  /**
   * Adds a custom book to the database
   */
  public static void addSmth() {
    DatabaseManager db = new DatabaseManager("Caaarte.db"); 
    db.insertBookDetails("Numele cartii", "editura whatever", "Asta e o carte faina"); 
    db.insertChapter("Capitolul 1", "Ceva scurt sa ne obisnuim"); 
    db.insertLesson("Capitolul 1", "Introducere", "nu e greu");
    db.insertParagraph("Introducere", 0, ParagraphType.Definitie, "p1", "Introducerea este necesara"); 
    db.insertLesson("Capitolul 1", "Continuarea introducerii", "ceva p-aici");
    db.insertParagraph("Continuarea introducerii", 0, ParagraphType.Definitie, "p1", 
		       "Aici avem legatura la <ref Introducere > introducere <ref>."); 
    db.insertChapter("Capitolul 2", "Ceva despre numere"); 
    db.insertLesson("Capitolul 2", "Numere naturale", "Cele mai folosite numere"); 
    db.insertParagraph("Numere naturale", 0, ParagraphType.Definitie, "p1", 
		       "Numerele naturale sunt cele de tipul 1, 2, 3...");
    db.insertParagraph("Numere naturale", 0, ParagraphType.Definitie, "p2", 
	               "Ele sunt folosite pentru a numara cantitati intregi si pozitive.");
    db.insertLesson("Capitolul 2", "Numere intregi", "cele naturale si inca ceva");
    db.insertParagraph("Numere intregi", 0, ParagraphType.Definitie, "p1", 
	               "Numerele intregi sunt formate din numerele <ref Numere naturale > naturale <ref> si opusele lor.");
    db.insertParagraph("Numere intregi", 0, ParagraphType.Definitie, "p2", "Ele sunt folosite pentru (...)");
    db.insertChapter("Capitolul 3", "Numere rationale");
    db.insertLesson("Capitolul 3", "Fractii ireductibile", "De forma m/n");
    db.insertParagraph("Fractii ireductibile", 0, ParagraphType.Definitie, "p1", 
	               "Fractiile ireductibile sunt fractii de forma m/n unde cmmdc(m, n) = 1.");
    db.insertLesson("Capitolul 3", "Demonstratii", "Demonstratiile sunt foarte importante");
    db.insertParagraph("Demonstratii", 0, ParagraphType.Definitie, "p1", 
	               "<ref Fractii ireductibile > Fractiile ireductibile <ref> se folosesc pentru multe demonstratii.");
    db.insertParagraph("Demonstratii", 0, ParagraphType.Definitie, "p2", 
		       "De asemenea sunt foarte importante si <ref Numere naturale > numerele naturale <ref>.");
    db.insertParagraph("Demonstratii", 0, ParagraphType.Definitie, "p3", 
	               "<img numePoza.jpg >");
  }
  
  /**
   * Writes details for a certain book in the console.
   * Debugging purposes!
   * 
   * @param book book for which to write details
   */
  public static void writeBook(Book book) {
    System.out.println(book.getName() + " " + book.getAuthor() + book.getPublisher());
    ArrayList <Chapter> chapterList = book.getChapterList();
    int numberOfChapters = chapterList.size();
    for (int chapter = 0; chapter < numberOfChapters; chapter++) {
      System.out.println(chapterList.get(chapter).getName());
      ArrayList <Lesson> lessonList = chapterList.get(chapter).getLessonList();
      int numberOfLessons = lessonList.size();
      for (int lesson = 0; lesson < numberOfLessons; lesson++) {
	System.out.println(lessonList.get(lesson).getName());
	ArrayList <String> definitionList = lessonList.get(lesson).getDefinitionList();
	int numberOfDefinitions = definitionList.size();
	for (int definition = 0; definition < numberOfDefinitions; definition++) {
	  System.out.println(definitionList.get(definition));
	}
      }
    }
  }
  
  /**
   * Adds a book to the database
   * 
   * @param book the book to be added to the database
   */
  public static void addToDataBase(Book book) {
    DatabaseManager db = new DatabaseManager(book.getName() + ".db");
    
    db.insertBookDetails(book.getName(), book.getPublisher(), book.getDescription());
    db.insertAuthors(book.getAuthor());
    ArrayList <Chapter> chapterList = book.getChapterList();
    int numberOfChapters = chapterList.size();
    for (int chapter = 0; chapter < numberOfChapters; chapter++) {
      db.insertChapter(chapterList.get(chapter).getName(), chapterList.get(chapter).getDescription());
      ArrayList <Lesson> lessonList = chapterList.get(chapter).getLessonList();
      int numberOfLessons = lessonList.size();
      for (int lesson = 0; lesson < numberOfLessons; lesson++) {
	db.insertLesson(chapterList.get(chapter).getName(), 
			lessonList.get(lesson).getName(), lessonList.get(lesson).getDescription());
	ArrayList <String> definitionList = lessonList.get(lesson).getDefinitionList();
	int numberOfDefinitions = definitionList.size();
	for (int definition = 0; definition < numberOfDefinitions; definition++) {
	  db.insertParagraph(lessonList.get(lesson).getName(), definition + 1, ParagraphType.Definitie, null,
			     definitionList.get(definition));
	}
      }
    }
  }
  
}
