package ro.cyberfire.smartbook.editor;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import ro.cyberfire.smartbook.reader.Tree;

/**
 * Class for the menu that appears on right clicking the tree.
 * 
 * @author Teodora
 * 
 */
public class RightClickMenu {

  private SmartBookEditor smartBook;
  private Tree tree;
  private JPopupMenu menu;

  private JMenuItem menuNewBook;
  private JMenuItem menuOpenBook;
  private JMenuItem menuAddChapter;
  private JMenuItem menuAddLesson;
  private JMenuItem menuAddParagraph;

  /**
   * Constructor for the menu.
   * 
   * @param tree the tree to attach the menu to
   * @param displayPane the pane where option windows are displayed
   */
  public RightClickMenu(SmartBookEditor smartBook) {
    this.smartBook = smartBook;
    tree = smartBook.getTree();
  }

  /**
   * Creates a MouseAdapter to handle the right click event on the tree.
   * 
   * @return MouseAdapter to use with the tree
   */
  public MouseListener getMouseListener() {
    return new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
          TreePath treePath = tree.getPathForLocation(e.getX(), e.getY());
          if (treePath != null) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treePath.getLastPathComponent();
            createMenu(selectedNode);
            menu.show(tree, e.getX(), e.getY());
          }
        }
        super.mousePressed(e);
      }
    };
  }

  /**
   * Creates a corresponding menu for the tree item that was selected via right click
   * 
   * @param node the selected node
   */
  private void createMenu(DefaultMutableTreeNode node) {
    menu = new JPopupMenu();
    int level = node.getLevel();

    if (level == 0) {
      createOptionMenu();
    }
    else if (level == 1) {
      createBookMenu(node);
    }
    else if (level == 2) {
      createChapterMenu(node);
    }
    else {
      createLessonMenu(node);
    }

    menu.setVisible(true);
  }

  /**
   * Menu for changing current book;
   */
  private void createOptionMenu() {
    menuNewBook = new JMenuItem(new AbstractAction("Carte noua") {
      private static final long serialVersionUID = 1L;

      public void actionPerformed(ActionEvent e) {
        new BookCreator(smartBook);
      }
    });
    menuOpenBook = new JMenuItem(new AbstractAction("Deschidere carte...") {
      private static final long serialVersionUID = 1L;

      public void actionPerformed(ActionEvent e) {
        new BookOpener(smartBook);
      }
    });

    menu.add(menuNewBook);
    menu.add(menuOpenBook);
  }

  /**
   * Menu for adding a chapter to a book.
   * 
   * @param node the selected node (a book)
   */
  private void createBookMenu(final DefaultMutableTreeNode bookNode) {
    menuAddChapter = new JMenuItem(new AbstractAction("Adaugare capitol") {
      private static final long serialVersionUID = 1L;

      public void actionPerformed(ActionEvent e) {
        new ChapterAdder(bookNode, smartBook);
      }
    });

    menu.add(menuAddChapter);
  }

  /**
   * Menu for adding a lesson to a chapter.
   * 
   * @param node the selected node (a chapter)
   */
  private void createChapterMenu(final DefaultMutableTreeNode chapterNode) {
    menuAddLesson = new JMenuItem(new AbstractAction("Adaugare lectie") {
      private static final long serialVersionUID = 1L;

      public void actionPerformed(ActionEvent e) {
        new LessonAdder(tree.getDisplayPane(), chapterNode, smartBook);
      }
    });

    menu.add(menuAddLesson);
  }

  /**
   * Menu for adding a paragraph to a lesson.
   * 
   * @param node the selected node (a lesson)
   */
  private void createLessonMenu(final DefaultMutableTreeNode lessonNode) {
    menuAddParagraph = new JMenuItem(new AbstractAction("Adaugare paragraf") {
      private static final long serialVersionUID = 1L;

      public void actionPerformed(ActionEvent e) {
        new ParagraphAdder(tree.getDisplayPane(), lessonNode, smartBook);
      }
    });

    menu.add(menuAddParagraph);
  }

}
