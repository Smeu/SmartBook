package ro.cyberfire.smartbook.reader;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;

public class Tree extends JTree {

  private static final long serialVersionUID = -8873096309009059458L;

  public Tree() {
    preferences();
  }

  public Tree(TreeNode arg0) {
    super(arg0);
    preferences();
  }

  private void preferences(){
    setRootVisible(false);
  }
}
