package ro.cyberfire.smartbook;

import java.awt.Image;
import java.util.ArrayList;

/**
 * Class for the Lessons to be part of Chapters
 * It is made of two lists, one for definitions and one for images
 * Definitions contain the sources for the images, so the imageList serves as 
 *  additional information
 * 
 * @author Teodora
 */
public class Lesson extends BookComponent {
  
  private ArrayList <String> definitionList;
  private ArrayList <Image> imageList;
  
  public Lesson() {
    super();
    definitionList = new ArrayList <String>();
    imageList = new ArrayList <Image>();
  }
  
  public void addDefinition(String definition) {
    definitionList.add(definition);
  }
  
  public ArrayList <String> getDefinitionList() {
    return definitionList;
  }
  
}
