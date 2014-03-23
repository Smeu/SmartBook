package ro.cyberfire.smartbook.database.tableTypes;

public class BookDetails {
  private String name;
  private String publisher;
  private String description;

  public BookDetails() {
    this.name = "";
    this.description = "";
    this.publisher = "";
  }

  public BookDetails(String name) {
    this.name = name;
    this.description = "";
    this.publisher = "";
  }

  public String getName() {
    return this.name;
  }

  public String getPublisher() {
    return this.publisher;
  }

  public String getDescription() {
    return this.description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPubliser(String publisher) {
    this.publisher = publisher;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
