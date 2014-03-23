package ro.cyberfire.smartbook.reader;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.ToolTipManager;

public class SmartBook {

  private Frame frame;
  private SplitPane splitPane;
  private ScrollPane rightScrollPane;
  private ScrollPane leftScrollPane;

  public SmartBook() {
    frame = new Frame();
    ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
    JLabel jabel = new JLabel("Text");
    jabel.setToolTipText("tooltip");
    // frame.add(jabel);
    // if(true) return;

    splitPane = new SplitPane();
    rightScrollPane = new ScrollPane();
    leftScrollPane = new ScrollPane();
    frame.add(splitPane);

    String text = "A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text A realy long text";
    text = text + text + text + text + text;

    rightScrollPane.setViewportView(new Lesson());
    leftScrollPane.setViewportView(new Tree());
    splitPane.setRightComponent(rightScrollPane);
    splitPane.setLeftComponent(leftScrollPane);

  }

  public void setVisible() {
    frame.pack();
    frame.setVisible(true);
    frame.setSize(1000, 601);
  }

}
