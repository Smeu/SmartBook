package ro.cyberfire.smartbook.reader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;

import ro.cyberfire.smartbook.database.DatabaseManager;
import ro.cyberfire.smartbook.database.tableTypes.BookDetails;
import ro.cyberfire.smartbook.database.tableTypes.Chapter;

public class SmartBook {

  private Frame frame;
  private SplitPane splitPane;
  private ScrollPane rightScrollPane;
  private ScrollPane leftScrollPane;
  private Map<KeyString, Lesson> lessons = new HashMap<>();

  public SmartBook() {
    UIManager.put("Tree.rendererFillBackground", false);
   // faObazaDeDate();
    frame = new Frame();
    ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
    JLabel jabel = new JLabel("Text");
    jabel.setToolTipText("tooltip");

    splitPane = new SplitPane();
    rightScrollPane = new ScrollPane();
    ClickableWord.setScrollPane(rightScrollPane);
    leftScrollPane = new ScrollPane();
    frame.add(splitPane);

    DefaultMutableTreeNode root = new DefaultMutableTreeNode();
    ocupateDeBazaDeDate(root);
    Tree tree = new Tree(root, rightScrollPane);
    
    rightScrollPane.setViewportView(new Lesson("a", "b"));
    leftScrollPane.setViewportView(tree);
    splitPane.setRightComponent(rightScrollPane);
    splitPane.setLeftComponent(leftScrollPane);
    
  }

/*  private void faObazaDeDate() {
    DatabaseManager db = new DatabaseManager("test4.db");
    db.insertBookDetails("test", "publisher", "description");
    db.insertChapter("Chapter1", "description");
    db.insertChapter("Chapter2", "description");
    db.insertLesson("Chapter1", "Lesson1.1", "description");
    db.insertLesson("Chapter1", "Lesson1.2", "description");
    db.insertLesson("Chapter2", "Lesson2.1", "Descrierea pt Lesson2.1");
    db.insertLesson("Chapter2", "Lesson2.2", "description");
    db.insertParagraph("Lesson1.1", 0, ParagraphType.Definitie, "paragraf1", "definitia nr 1");
    db.insertParagraph("Lesson1.1", 0, ParagraphType.Definitie, "paragraf1", "si acum prezentam cum <ref Lesson2.1 > asta (asta multiplu) <ref> este un button catre Lesson2.1");
    db.insertParagraph("Lesson2.1", 0, ParagraphType.Definitie, "paragraf1", "definitia nr 3");
    db.insertParagraph("Lesson1.2", 0, ParagraphType.Definitie, "paragraf1", "definitia nr 4");
    db.insertParagraph("Lesson1.1", 0, ParagraphType.Definitie, "paragraf1", "definitia nr 5");
    db.insertParagraph("Lesson1.1", 0, ParagraphType.Definitie, "paragraf1", "definitia nr 6");
  }
*/
  private void ocupateDeBazaDeDate(DefaultMutableTreeNode root) {
    DefaultMutableTreeNode book;

    DatabaseManager db = new DatabaseManager("CartePeBune.db");
    BookDetails bk = new BookDetails();
    bk = db.queryDriver.getBookDetails();

    book = new DefaultMutableTreeNode(bk);
    root.add(book);
    
    
    addLessonsInMap(db);
    addChapters(book, db);

  }

  private void addLessonsInMap(DatabaseManager db) {
    List<ro.cyberfire.smartbook.database.tableTypes.Lesson> lessons = db.queryDriver.getAllLessons();
    for (ro.cyberfire.smartbook.database.tableTypes.Lesson lesson : lessons) {
      this.lessons.put(new KeyString(lesson.getName()), new Lesson(lesson.getName(), lesson.getDescription()));
    }
  }

  private void addChapters(DefaultMutableTreeNode book, DatabaseManager db) {
    List<Chapter> chapters = db.queryDriver.getAllChapters();
    for (Chapter chapter : chapters) {
      DefaultMutableTreeNode chapterNode = new DefaultMutableTreeNode(chapter);
      book.add(chapterNode);
      addLesson(chapterNode, db, db.queryDriver.getID_Chapter(chapter.getName()));
    }
  }

  private void addLesson(DefaultMutableTreeNode chapterNode, DatabaseManager db, int ChapterId) {
    List<ro.cyberfire.smartbook.database.tableTypes.Lesson> lessons = db.queryDriver.getAllLessons();
    for (ro.cyberfire.smartbook.database.tableTypes.Lesson lesson : lessons) {
      if (lesson.getIdChapter() == ChapterId){
        Lesson l = this.lessons.get(new KeyString(lesson.getName()));
        if(l == null){
          System.out.println("aici e problema");
        }
        //new Lesson(lesson.getName(), lesson.getDescription());
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(l);
        addParagraphs(l, db, db.queryDriver.getID_Lesson(lesson.getName()));
        chapterNode.add(node);
      }
    }
  }

  private void addParagraphs(Lesson lesson, DatabaseManager db, Integer id_Lesson) {
    List<ro.cyberfire.smartbook.database.tableTypes.Paragraph> paragraphs = db.queryDriver.getAllPharagraphs();
    for (int i = 0; i < paragraphs.size(); ++i) {
        if (paragraphs.get(i).getIdLesson() == id_Lesson){
          lesson.addParagraph(paragraphs.get(i).getText(), lessons);
        }
    }
  }

  public void setVisible() {
    frame.pack();
    frame.setVisible(true);
    frame.setSize(1000, 601);
  }

}
