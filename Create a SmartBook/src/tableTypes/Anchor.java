package ro.cyberfire.smartbook.database.tableTypes;

public class Anchor {

  private int idParagraph;
  private int idLesson;
  private String text;
  private String linkText;
  private int linkIdParagraph;
  private int linkIdLesson;

  public Anchor(int idParagraph, int idLesson, String text, int linkIdParagraph, int linkIdLesson) {
    this.idParagraph = idParagraph;
    this.idLesson = idLesson;
    this.text = text;
    this.linkIdParagraph = linkIdParagraph;
    this.linkIdLesson = linkIdLesson;
  }

  public int getIdParagraph() {
    return this.idParagraph;
  }

  public int getIdLesson() {
    return this.idLesson;
  }

  public int getLinkIdParagraph() {
    return this.linkIdParagraph;
  }

  public int getLinkIdLesson() {
    return this.linkIdLesson;
  }

  public String getLinkText() {
    return this.linkText;
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

  public void setLinkIdParagraph(int linkIdParagraph) {
    this.linkIdParagraph = linkIdParagraph;
  }

  public void setLinkIdLesson(int linkIdLesson) {
    this.linkIdLesson = linkIdLesson;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setLinkText(String linkText) {
    this.linkText = linkText;
  }
}
