package ro.cyberfire.smartbook;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Teodora
 */
public class MainWindow extends javax.swing.JFrame {

  private Book book;
  private Chapter chapter;
  private Lesson lesson;
  
  public MainWindow() {
    initComponents();
    setName("SmartBook");
    addFirstPanel();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    tabs = new javax.swing.JTabbedPane();
    actionChooser = new javax.swing.JPanel();
    creatorButton = new javax.swing.JButton();
    bookCreator = new javax.swing.JPanel();
    bookWelcomeLabel = new javax.swing.JLabel();
    bookNameLabel = new javax.swing.JLabel();
    bookNameText = new javax.swing.JTextField();
    publisherLabel = new javax.swing.JLabel();
    publisherText = new javax.swing.JTextField();
    authorLabel = new javax.swing.JLabel();
    authorText = new javax.swing.JTextField();
    bookDescriptionLabel = new javax.swing.JLabel();
    bookDescriptionText = new javax.swing.JTextField();
    bookDoneButton = new javax.swing.JButton();
    bookCancelButton = new javax.swing.JButton();
    chapterCreator = new javax.swing.JPanel();
    chapterWelcomeLabel = new javax.swing.JLabel();
    chapterNameLabel = new javax.swing.JLabel();
    chapterNameText = new javax.swing.JTextField();
    chapterDescriptionLabel = new javax.swing.JLabel();
    chapterDescriptionText = new javax.swing.JTextField();
    chapterDoneButton = new javax.swing.JButton();
    chapterCancelButton = new javax.swing.JButton();
    lessonCreator = new javax.swing.JPanel();
    lessonWelcomeLabel = new javax.swing.JLabel();
    lessonNameLabel = new javax.swing.JLabel();
    lessonNameText = new javax.swing.JTextField();
    lessonDescriptionLabel = new javax.swing.JLabel();
    lessonDescriptionText = new javax.swing.JTextField();
    lessonDoneButton = new javax.swing.JButton();
    lessonCancelButton = new javax.swing.JButton();
    lessonPartAdder = new javax.swing.JPanel();
    lessonPartWelcomeLabel = new javax.swing.JLabel();
    definitionLabel = new javax.swing.JLabel();
    definitionAddButton = new javax.swing.JButton();
    definitionScroll = new javax.swing.JScrollPane();
    definitionText = new javax.swing.JTextArea();
    imageLabel = new javax.swing.JLabel();
    imageAddButton = new javax.swing.JButton();
    browseImageButton = new javax.swing.JButton();
    imagePath = new javax.swing.JTextField();
    lessonPartDoneButton = new javax.swing.JButton();
    bookCreationEndButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("SmartBook");
    setBackground(new java.awt.Color(102, 102, 102));
    setResizable(false);

    tabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);

    actionChooser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    creatorButton.setText("Create a new book");
    creatorButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        creatorButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout actionChooserLayout = new javax.swing.GroupLayout(actionChooser);
    actionChooser.setLayout(actionChooserLayout);
    actionChooserLayout.setHorizontalGroup(
      actionChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(actionChooserLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(creatorButton)
        .addContainerGap(150, Short.MAX_VALUE))
    );
    actionChooserLayout.setVerticalGroup(
      actionChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(actionChooserLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(creatorButton)
        .addContainerGap(275, Short.MAX_VALUE))
    );

    tabs.addTab("Choose action", actionChooser);

    bookCreator.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    bookWelcomeLabel.setText("Create a new book");

    bookNameLabel.setText("Insert name (mandatory):");

    publisherLabel.setText("Insert publisher:");

    authorLabel.setText("Insert authors (mandatory):");

    bookDescriptionLabel.setText("Insert a short description:");

    bookDoneButton.setText("Create book");
    bookDoneButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bookDoneButtonActionPerformed(evt);
      }
    });

    bookCancelButton.setText("Cancel");
    bookCancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bookCancelButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout bookCreatorLayout = new javax.swing.GroupLayout(bookCreator);
    bookCreator.setLayout(bookCreatorLayout);
    bookCreatorLayout.setHorizontalGroup(
      bookCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(bookCreatorLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(bookCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(bookNameText)
          .addComponent(publisherText)
          .addComponent(authorText)
          .addComponent(bookDescriptionText)
          .addGroup(bookCreatorLayout.createSequentialGroup()
            .addComponent(bookCancelButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
            .addComponent(bookDoneButton))
          .addGroup(bookCreatorLayout.createSequentialGroup()
            .addGroup(bookCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(bookWelcomeLabel)
              .addComponent(bookNameLabel)
              .addComponent(publisherLabel)
              .addComponent(authorLabel)
              .addComponent(bookDescriptionLabel))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );

    bookCreatorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {authorLabel, bookDescriptionLabel, bookNameLabel, publisherLabel});

    bookCreatorLayout.setVerticalGroup(
      bookCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(bookCreatorLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(bookWelcomeLabel)
        .addGap(18, 18, 18)
        .addComponent(bookNameLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bookNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(publisherLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(publisherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(authorLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(authorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(bookDescriptionLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bookDescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(bookCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bookDoneButton)
          .addComponent(bookCancelButton))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    tabs.addTab("Create book", bookCreator);

    chapterCreator.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    chapterWelcomeLabel.setText("Create a new chapter");

    chapterNameLabel.setText("Insert name (mandatory):");

    chapterDescriptionLabel.setText("Insert a short description:");

    chapterDoneButton.setText("Create chapter");
    chapterDoneButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        chapterDoneButtonActionPerformed(evt);
      }
    });

    chapterCancelButton.setText("Cancel");
    chapterCancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        chapterCancelButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout chapterCreatorLayout = new javax.swing.GroupLayout(chapterCreator);
    chapterCreator.setLayout(chapterCreatorLayout);
    chapterCreatorLayout.setHorizontalGroup(
      chapterCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(chapterCreatorLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(chapterCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(chapterCreatorLayout.createSequentialGroup()
            .addComponent(chapterCancelButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(chapterDoneButton))
          .addComponent(chapterDescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(chapterWelcomeLabel)
          .addComponent(chapterNameLabel)
          .addComponent(chapterNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(chapterDescriptionLabel))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    chapterCreatorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {chapterDescriptionLabel, chapterDescriptionText, chapterNameLabel, chapterNameText});

    chapterCreatorLayout.setVerticalGroup(
      chapterCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(chapterCreatorLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(chapterWelcomeLabel)
        .addGap(18, 18, 18)
        .addComponent(chapterNameLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(chapterNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(chapterDescriptionLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(chapterDescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(chapterCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(chapterDoneButton)
          .addComponent(chapterCancelButton))
        .addContainerGap(127, Short.MAX_VALUE))
    );

    tabs.addTab("Create chapter", chapterCreator);

    lessonCreator.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    lessonWelcomeLabel.setText("Create a new lesson");

    lessonNameLabel.setText("Insert name (mandatory):");

    lessonDescriptionLabel.setText("Insert a short description:");

    lessonDoneButton.setText("Create lesson");
    lessonDoneButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        lessonDoneButtonActionPerformed(evt);
      }
    });

    lessonCancelButton.setText("Cancel");
    lessonCancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        lessonCancelButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout lessonCreatorLayout = new javax.swing.GroupLayout(lessonCreator);
    lessonCreator.setLayout(lessonCreatorLayout);
    lessonCreatorLayout.setHorizontalGroup(
      lessonCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(lessonCreatorLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(lessonCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(lessonCreatorLayout.createSequentialGroup()
            .addComponent(lessonCancelButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lessonDoneButton))
          .addGroup(lessonCreatorLayout.createSequentialGroup()
            .addGroup(lessonCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lessonDescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lessonWelcomeLabel)
              .addComponent(lessonNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(lessonDescriptionLabel)
              .addComponent(lessonNameLabel))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    lessonCreatorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lessonDescriptionLabel, lessonDescriptionText, lessonNameLabel, lessonNameText});

    lessonCreatorLayout.setVerticalGroup(
      lessonCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(lessonCreatorLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lessonWelcomeLabel)
        .addGap(18, 18, 18)
        .addComponent(lessonNameLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lessonNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(lessonDescriptionLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(lessonDescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(lessonCreatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lessonDoneButton)
          .addComponent(lessonCancelButton))
        .addContainerGap(127, Short.MAX_VALUE))
    );

    tabs.addTab("Create lesson", lessonCreator);

    lessonPartAdder.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    lessonPartWelcomeLabel.setText("Add lesson parts");

    definitionLabel.setText("Definition:");

    definitionAddButton.setText("Add");
    definitionAddButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        definitionAddButtonActionPerformed(evt);
      }
    });

    definitionText.setColumns(20);
    definitionText.setRows(5);
    definitionScroll.setViewportView(definitionText);

    imageLabel.setText("Graphic example:");

    imageAddButton.setText("Add");
    imageAddButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        imageAddButtonActionPerformed(evt);
      }
    });

    browseImageButton.setText("Browse...");

    imagePath.setEditable(false);

    lessonPartDoneButton.setText("Done");
    lessonPartDoneButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        lessonPartDoneButtonActionPerformed(evt);
      }
    });

    bookCreationEndButton.setText("Book done");
    bookCreationEndButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bookCreationEndButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout lessonPartAdderLayout = new javax.swing.GroupLayout(lessonPartAdder);
    lessonPartAdder.setLayout(lessonPartAdderLayout);
    lessonPartAdderLayout.setHorizontalGroup(
      lessonPartAdderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(lessonPartAdderLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(lessonPartAdderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(imagePath)
          .addComponent(definitionScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
          .addGroup(lessonPartAdderLayout.createSequentialGroup()
            .addComponent(lessonPartWelcomeLabel)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(lessonPartAdderLayout.createSequentialGroup()
            .addComponent(definitionLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(definitionAddButton))
          .addGroup(lessonPartAdderLayout.createSequentialGroup()
            .addComponent(imageLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageAddButton))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lessonPartAdderLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(browseImageButton))
          .addGroup(lessonPartAdderLayout.createSequentialGroup()
            .addComponent(lessonPartDoneButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bookCreationEndButton)))
        .addContainerGap())
    );
    lessonPartAdderLayout.setVerticalGroup(
      lessonPartAdderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(lessonPartAdderLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lessonPartWelcomeLabel)
        .addGap(18, 18, 18)
        .addGroup(lessonPartAdderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(definitionLabel)
          .addComponent(definitionAddButton))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(definitionScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(lessonPartAdderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(imageLabel)
          .addComponent(imageAddButton))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(browseImageButton)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
        .addGroup(lessonPartAdderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lessonPartDoneButton)
          .addComponent(bookCreationEndButton))
        .addContainerGap())
    );

    tabs.addTab("Add parts", lessonPartAdder);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void addFirstPanel() {
    tabs.removeAll();
    tabs.add(actionChooser);
    DataBaseBookAdder.addSmth();
  }
  
  private void creatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatorButtonActionPerformed
    tabs.remove(actionChooser);
    tabs.add(bookCreator);
  }//GEN-LAST:event_creatorButtonActionPerformed

  private void bookCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCancelButtonActionPerformed
    tabs.remove(bookCreator);
    tabs.add(actionChooser);
  }//GEN-LAST:event_bookCancelButtonActionPerformed

  private void chapterCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapterCancelButtonActionPerformed
    tabs.remove(chapterCreator);
    tabs.add(bookCreator);
  }//GEN-LAST:event_chapterCancelButtonActionPerformed

  private void lessonCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessonCancelButtonActionPerformed
    tabs.remove(lessonCreator);
    tabs.add(chapterCreator);
  }//GEN-LAST:event_lessonCancelButtonActionPerformed

  private void lessonPartDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessonPartDoneButtonActionPerformed
    tabs.remove(lessonPartAdder);
    tabs.add(lessonCreator);
    definitionText.setText("");
  }//GEN-LAST:event_lessonPartDoneButtonActionPerformed

  private void bookDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookDoneButtonActionPerformed
    String name = bookNameText.getText();
    String publisher = publisherText.getText();
    String author = authorText.getText();
    String description = bookDescriptionText.getText();
    
    if (name.isEmpty() || author.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please fill in all the mandatory fields!", 
				    "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }  
    book = new Book();
    book.setName(name);
    book.setPublisher(publisher);
    book.setAuthor(author);
    book.setDescription(description);
    
    tabs.remove(bookCreator);
    bookNameText.setText("");
    publisherText.setText("");
    authorText.setText("");
    bookDescriptionText.setText("");
    tabs.add(chapterCreator);
  }//GEN-LAST:event_bookDoneButtonActionPerformed

  private boolean chapterExists(ArrayList <Chapter> chapterList, String name) {
    int numberOfChapters = chapterList.size();
    
    for (int chapter = 0; chapter < numberOfChapters; chapter++) {
      if (name.equals(chapterList.get(chapter).getName())) {
	return true;
      }
    }
    return false;
  }
  
  private void chapterDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chapterDoneButtonActionPerformed
    String name = chapterNameText.getText();
    String description = chapterDescriptionText.getText();
    
    if (name.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please provide a chapter name", 
				    "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    if (chapterExists(book.getChapterList(), name)) {
      JOptionPane.showMessageDialog(this, "There already is a chapter with this name", 
				    "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    
    chapter = new Chapter();
    chapter.setName(name);
    chapter.setDescription(description);
    
    tabs.remove(chapterCreator);
    chapterNameText.setText("");
    chapterDescriptionText.setText("");
    tabs.add(lessonCreator);
    book.addChapter(chapter);
  }//GEN-LAST:event_chapterDoneButtonActionPerformed

  private boolean lessonExists(ArrayList <Lesson> lessonList, String name) {
    int numberOfLessons = lessonList.size();
    
    for (int lesson = 0; lesson < numberOfLessons; lesson++) {
      if (name.equals(lessonList.get(lesson).getName())) {
	return true;
      }
    }
    return chapterExists(book.getChapterList(), name);
  }
  
  private void lessonDoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessonDoneButtonActionPerformed
    String name = lessonNameText.getText();
    String description = lessonDescriptionText.getText();
    
    if (name.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please provide a lesson name",
				    "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    if (lessonExists(chapter.getLessonList(), name)) {
      JOptionPane.showMessageDialog(this, "There already is a lesson with this name", 
				    "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    
    lesson = new Lesson();
    lesson.setName(name);
    lesson.setDescription(description);
    
    tabs.remove(lessonCreator);
    lessonNameText.setText("");
    lessonDescriptionText.setText("");
    tabs.add(lessonPartAdder);
    chapter.addLesson(lesson);
  }//GEN-LAST:event_lessonDoneButtonActionPerformed

  private void definitionAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_definitionAddButtonActionPerformed
    String definition = definitionText.getText();
    
    if (definition.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please provide a lesson name",
				    "Warning", JOptionPane.WARNING_MESSAGE);
      return;
    }
    lesson.addDefinition(definition);
    definitionText.setText("");
  }//GEN-LAST:event_definitionAddButtonActionPerformed

  private void imageAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageAddButtonActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    File file = fileChooser.getSelectedFile();
    imagePath.setText(file.getName());
  }//GEN-LAST:event_imageAddButtonActionPerformed

  private void bookCreationEndButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCreationEndButtonActionPerformed
    //DataBaseBookAdder.writeBook(book);
    DataBaseBookAdder.addToDataBase(book);
    tabs.remove(lessonPartAdder);
    tabs.add(actionChooser);
  }//GEN-LAST:event_bookCreationEndButtonActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	if ("Nimbus".equals(info.getName())) {
	  javax.swing.UIManager.setLookAndFeel(info.getClassName());
	  break;
	}
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
	new MainWindow().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel actionChooser;
  private javax.swing.JLabel authorLabel;
  private javax.swing.JTextField authorText;
  private javax.swing.JButton bookCancelButton;
  private javax.swing.JButton bookCreationEndButton;
  private javax.swing.JPanel bookCreator;
  private javax.swing.JLabel bookDescriptionLabel;
  private javax.swing.JTextField bookDescriptionText;
  private javax.swing.JButton bookDoneButton;
  private javax.swing.JLabel bookNameLabel;
  private javax.swing.JTextField bookNameText;
  private javax.swing.JLabel bookWelcomeLabel;
  private javax.swing.JButton browseImageButton;
  private javax.swing.JButton chapterCancelButton;
  private javax.swing.JPanel chapterCreator;
  private javax.swing.JLabel chapterDescriptionLabel;
  private javax.swing.JTextField chapterDescriptionText;
  private javax.swing.JButton chapterDoneButton;
  private javax.swing.JLabel chapterNameLabel;
  private javax.swing.JTextField chapterNameText;
  private javax.swing.JLabel chapterWelcomeLabel;
  private javax.swing.JButton creatorButton;
  private javax.swing.JButton definitionAddButton;
  private javax.swing.JLabel definitionLabel;
  private javax.swing.JScrollPane definitionScroll;
  private javax.swing.JTextArea definitionText;
  private javax.swing.JButton imageAddButton;
  private javax.swing.JLabel imageLabel;
  private javax.swing.JTextField imagePath;
  private javax.swing.JButton lessonCancelButton;
  private javax.swing.JPanel lessonCreator;
  private javax.swing.JLabel lessonDescriptionLabel;
  private javax.swing.JTextField lessonDescriptionText;
  private javax.swing.JButton lessonDoneButton;
  private javax.swing.JLabel lessonNameLabel;
  private javax.swing.JTextField lessonNameText;
  private javax.swing.JPanel lessonPartAdder;
  private javax.swing.JButton lessonPartDoneButton;
  private javax.swing.JLabel lessonPartWelcomeLabel;
  private javax.swing.JLabel lessonWelcomeLabel;
  private javax.swing.JLabel publisherLabel;
  private javax.swing.JTextField publisherText;
  private javax.swing.JTabbedPane tabs;
  // End of variables declaration//GEN-END:variables
  
}
