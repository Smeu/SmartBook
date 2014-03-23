package ro.cyberfire.smartbook;

import java.util.ArrayList;

/**
 * Class for the Chapters in the Book, which in turn are made of Lessons
 * 
 * @author Teodora
 */
public class Chapter extends BookComponent {
  
  private ArrayList <Lesson> lessonList;
  
  public Chapter() {
    super();
    lessonList = new ArrayList <Lesson>();
  }
  
  public void addLesson(Lesson lesson) {
    lessonList.add(lesson);
  }
  
  public ArrayList <Lesson> getLessonList() {
    return lessonList;
  }
  
}
