package ro.cyberfire.smartbook.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Class for xml file functions. Can write and read from xml files.
 * 
 * @author Rares
 * 
 */
public class XMLFile {

  private XMLFile() {
  }

  /**
   * Gets a element from a xml file.
   * 
   * @param filePath Path to xml file.
   * @param pathToElement Path to desired element. Path have the following format: ....... / nodeName / node number /
   *          .........
   * @return Returns the element.
   */
  public static Element getElement(String filePath, String pathToElement) {
    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File(filePath);

    try {
      Document document = (Document) builder.build(xmlFile);
      return getElement(document, pathToElement);
    }
    catch (JDOMException | IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets a element from xml document.
   * 
   * @param document The xml document.
   * @param pathToElement Path to desired element. Path have the following format: ....... / nodeName / node number /
   *          .........
   * @return Returns the element.
   */
  public static Element getElement(Document document, String pathToElement) {
    String paths[] = pathToElement.split("/");

    Element node = document.getRootElement();
    for (int i = 0; i < paths.length; i += 2) {
      List<Element> list = node.getChildren(paths[i]);
      node = list.get(Integer.parseInt(paths[i + 1]));
    }
    return node;
  }

  /**
   * Gets the xml document from file.
   * 
   * @param filePath Path to xml file.
   * @return Return the document.
   */
  public static Document getDocument(String filePath) {
    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File(filePath);
    try {
      Document document = (Document) builder.build(xmlFile);
      return document;
    }
    catch (JDOMException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Saves the document on disk.
   * 
   * @param document Document to be saved.
   * @param filePath Disk location to be saved. Name must be included. Example: res/file.xml
   */
  public static void saveDocument(Document document, String filePath) {
    XMLOutputter xmlOutput = new XMLOutputter();
    xmlOutput.setFormat(Format.getPrettyFormat());
    try {
      xmlOutput.output(document, new FileWriter(filePath));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}