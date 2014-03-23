package ro.cyberfire.smartbook.reader;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class Tree extends JTree {

  private static final long serialVersionUID = -8873096309009059458L;
  private ScrollPane rightScrollPane;
  
  public Tree() {
    preferences();
  }

  public Tree(TreeNode node, ScrollPane rightScrollPane) {
    super(node);
    preferences();
    this.rightScrollPane = rightScrollPane;
  }

  private void preferences() {
    setRootVisible(false);
    setBackground(Theme.backgroundColor);
    //setBorder(new BubbleBorder(preserveBackgroundColor, expandRow, expandRow, expandRow));
    
    addTreeSelectionListener(new TreeSelectionListener() {
      
      @Override
      public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) getLastSelectedPathComponent();
        
        if (node == null)
          return;
    
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
          rightScrollPane.setViewportView((Lesson) nodeInfo);
        }
      }
    });
  }

}
