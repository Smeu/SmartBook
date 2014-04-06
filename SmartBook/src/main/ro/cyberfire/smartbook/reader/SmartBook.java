package ro.cyberfire.smartbook.reader;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

    splitPane.setRightComponent(rightScrollPane);

    DefaultMutableTreeNode root = new DefaultMutableTreeNode();
    ocupateDeBazaDeDate(root);
    Tree tree = new Tree(root, rightScrollPane);

    rightScrollPane.setViewportView(new Lesson("a", "b"));
    leftScrollPane.setViewportView(tree);
    splitPane.setLeftComponent(leftScrollPane);

    addMenuBar();
  }

  private void componentPreferences(JComponent component) {
    component.setBackground(Theme.backgroundColor);
    component.setBorder(null);
  }

  private void addMenuBar() {
    // Creates a new Menu bar
    JMenuBar menuBar = new JMenuBar();
    componentPreferences(menuBar);

    // creates a menu for theme
    JMenu themeMenu = new JMenu("Personalizare");
    componentPreferences(themeMenu);

    // creates background color menu item.
    JMenuItem backgroundColor = new JMenuItem("Culoarea de fundal");
    componentPreferences(backgroundColor);
    backgroundColor.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        Color color = JColorChooser.showDialog(null, "Culoarea de fundal", Theme.backgroundColor);
        if (color == null) {
          return;
        }
        Theme.backgroundColor = color;
        Theme.savePref();
        restart();
      }
    });

    // creates border color menu item
    JMenuItem borderColor = new JMenuItem("Culoarea chenarului");
    componentPreferences(borderColor);
    borderColor.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        Color color = JColorChooser.showDialog(null, "Culoarea chenarului", Theme.borderColor);
        if (color == null) {
          return;
        }
        Theme.borderColor = color;
        Theme.savePref();
        restart();
      }
    });

    JMenuItem fontSize = new JMenuItem("Marimea Scrisului");
    componentPreferences(fontSize);
    fontSize.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog("Insert size: ");
        if (!input.matches("[0-9]+")) {
          JOptionPane.showMessageDialog(new JFrame(), "Bad input");
          return;
        }
        if (input == null || input.length() == 0) {
          return;
        }
        int size = Integer.parseInt(input);
        Theme.font = new Font("name", Font.PLAIN, size);
        Theme.savePref();
        restart();
      }
    });

    // creates reset to default menu item.
    JMenuItem resetDefault = new JMenuItem("Reseteaza");
    componentPreferences(resetDefault);
    resetDefault.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        Theme.resetToDefault();
        restart();
      }
    });

    // add menu items to menu
    themeMenu.add(backgroundColor);
    themeMenu.add(borderColor);
    themeMenu.add(fontSize);
    themeMenu.add(resetDefault);

    // add menus to menu bar
    menuBar.add(themeMenu);

    frame.setJMenuBar(menuBar);
  }

  private void restart() {
    try {
      restartApplication();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void restartApplication() throws URISyntaxException, IOException {
    final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
    final File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

    /* is it a jar file? */
    if (!currentJar.getName().endsWith(".jar"))
      return;

    /* Build command: java -jar application.jar */
    final ArrayList<String> command = new ArrayList<String>();
    command.add(javaBin);
    command.add("-jar");
    command.add(currentJar.getPath());

    final ProcessBuilder builder = new ProcessBuilder(command);
    builder.start();
    System.exit(0);
  }

  /*
   * private void faObazaDeDate() { DatabaseManager db = new DatabaseManager("test4.db"); db.insertBookDetails("test",
   * "publisher", "description"); db.insertChapter("Chapter1", "description"); db.insertChapter("Chapter2",
   * "description"); db.insertLesson("Chapter1", "Lesson1.1", "description"); db.insertLesson("Chapter1", "Lesson1.2",
   * "description"); db.insertLesson("Chapter2", "Lesson2.1", "Descrierea pt Lesson2.1"); db.insertLesson("Chapter2",
   * "Lesson2.2", "description"); db.insertParagraph("Lesson1.1", 0, ParagraphType.Definitie, "paragraf1",
   * "definitia nr 1"); db.insertParagraph("Lesson1.1", 0, ParagraphType.Definitie, "paragraf1",
   * "si acum prezentam cum <ref Lesson2.1 > asta (asta multiplu) <ref> este un button catre Lesson2.1");
   * db.insertParagraph("Lesson2.1", 0, ParagraphType.Definitie, "paragraf1", "definitia nr 3");
   * db.insertParagraph("Lesson1.2", 0, ParagraphType.Definitie, "paragraf1", "definitia nr 4");
   * db.insertParagraph("Lesson1.1", 0, ParagraphType.Definitie, "paragraf1",
   * "definitia nr 5 cu o poza <img res/smartBook.jpg >"); db.insertParagraph("Lesson1.1", 0, ParagraphType.Definitie,
   * "paragraf1", "definitia nr 6"); }
   */

  private void ocupateDeBazaDeDate(DefaultMutableTreeNode root) {
    DefaultMutableTreeNode book;

    DatabaseManager db = new DatabaseManager("res/Carte.db");
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
      if (lesson.getIdChapter() == ChapterId) {
        Lesson l = this.lessons.get(new KeyString(lesson.getName()));
        if (l == null) {
          System.out.println("aici e problema");
        }
        // new Lesson(lesson.getName(), lesson.getDescription());
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(l);
        addParagraphs(l, db, db.queryDriver.getID_Lesson(lesson.getName()));
        chapterNode.add(node);
      }
    }
  }

  private void addParagraphs(Lesson lesson, DatabaseManager db, Integer id_Lesson) {
    List<ro.cyberfire.smartbook.database.tableTypes.Paragraph> paragraphs = db.queryDriver.getAllPharagraphs();
    for (int i = 0; i < paragraphs.size(); ++i) {
      if (paragraphs.get(i).getIdLesson() == id_Lesson) {
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
