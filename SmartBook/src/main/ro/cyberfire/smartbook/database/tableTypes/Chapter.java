package ro.cyberfire.smartbook.database.tableTypes;

public class Chapter {
  private String name;
  private String description;

  public Chapter(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Chapter(String name) {
    this.name = name;
    this.description = "";
  }

  public Chapter() {
    this.name = "";
    this.description = "";
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
