package ro.cyberfire.smartbook.database.tableTypes;

public class Lesson {
  private String name;
  private String description;
  private int idChapter;

  public Lesson(String name, String description, int idChapter) {
    this.name = name;
    this.description = description;
    this.idChapter = idChapter;
  }

  public Lesson(String name, String description) {
    this.name = name;
    this.description = description;
    this.idChapter = 0;
  }

  public Lesson(String name) {
    this.name = name;
    this.description = "";
    this.idChapter = 0;
  }

  public Lesson() {
    this.name = "";
    this.description = "";
    this.idChapter = 0;
  }

  public String getName() {
    return this.name;
  }

  public int getIdChapter() {
    return this.idChapter;
  }

  public String getDescription() {
    return this.description;
  }

  public void setIdChapter(int idChapter) {
    this.idChapter = idChapter;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
