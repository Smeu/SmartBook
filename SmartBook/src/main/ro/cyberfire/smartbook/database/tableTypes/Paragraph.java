package ro.cyberfire.smartbook.database.tableTypes;

public class Paragraph {
  private int idParagraph;
  private int idLesson;
  private int indexOrder;
  private ParagraphType type;
  private String name;
  private String text;

  public Paragraph(int idParagraph, int idLesson, int indexOrder) {
    this.idParagraph = idParagraph;
    this.idLesson = idLesson;
    this.indexOrder = indexOrder;
  }

  public Paragraph() {

  }

  public int getIdParagraph() {
    return this.idParagraph;
  }

  public int getIdLesson() {
    return this.idLesson;
  }

  public int getIndexOrder() {
    return this.indexOrder;
  }

  public ParagraphType getParagraphType() {
    return this.type;
  }

  public String getName() {
    return this.name;
  }

  public String getText() {
    return this.text;
  }

  public void setIdParagraph(int idParagraph) {
    this.idParagraph = idParagraph;
  }

  public void setIdLesson(int idLesson) {
    this.idLesson = idLesson;
  }

  public void setIndexOrder(int indexOrder) {
    this.indexOrder = indexOrder;
  }

  public void setParagraphType(ParagraphType type) {
    this.type = type;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
