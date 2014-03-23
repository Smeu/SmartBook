package ro.cyberfire.smartbook;

/**
 * Base class for the components of the Book
 * 
 * @author Teodora
 */
public abstract class BookComponent {
  
  protected String name;
  protected String description;
  
  public BookComponent() {
    name = "";
    description = "";
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getName() {
    return name;
  }
  
  public String getDescription() {
    return description;
  }
  
}
