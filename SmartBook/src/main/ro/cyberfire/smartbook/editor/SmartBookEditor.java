package ro.cyberfire.smartbook.editor;

import javax.swing.tree.DefaultMutableTreeNode;

import ro.cyberfire.smartbook.reader.SmartBook;
import ro.cyberfire.smartbook.reader.Tree;

public class SmartBookEditor extends SmartBook {

  public SmartBookEditor(String filePath) {
    super(filePath);
    refreshTree();
  }

  public void refreshTree() {
    tree = new Tree((DefaultMutableTreeNode) tree.getModel().getRoot(), rightScrollPane);
    tree.addMouseListener(new RightClickMenu(this).getMouseListener());
    tree.setRootVisible(true);
    leftScrollPane.setViewportView(tree);
  }
}
