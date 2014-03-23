package ro.cyberfire.smartbook;

import java.util.ArrayList;

/**
 * Class representing the Book which will gather several chapters.
 * 
 * @author Teodora
 */
public class Book extends BookComponent {
   
  private String publisher;
  private String author;
  private ArrayList <Chapter> chapterList;
  
  public Book() {
    super();
    publisher = "";
    author = "";
    chapterList = new ArrayList <Chapter>();
  }
    
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
    
  public void setAuthor(String author) {
    this.author = author;
  }
  
  public void addChapter(Chapter chapter) {
    chapterList.add(chapter);
  }
  
  public String getPublisher() {
    return publisher;
  }
  
  public String getAuthor() {
    return author;
  }
  
  public ArrayList <Chapter> getChapterList() {
    return chapterList;
  }
  
}
