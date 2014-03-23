package ro.cyberfire.smartbook.database.tableTypes;

public enum ParagraphType {
  Definitie("Definitie"), Observatie("Observatie"), DeRetinut("DeRetinut");

  private String type;

  ParagraphType(String type) {
    this.type = type;
  }

  public String toString() {
    return this.type;
  }
}
