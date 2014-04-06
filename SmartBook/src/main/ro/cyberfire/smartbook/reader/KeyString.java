package ro.cyberfire.smartbook.reader;

/**
 * String key for hash maps.
 * 
 * @author Rares
 * 
 */
public class KeyString {

  String key;

  public KeyString(String key) {
    this.key = key;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    KeyString other = (KeyString) obj;
    if (key == null) {
      if (other.key != null)
        return false;
    }
    else if (!key.contains(other.key))
      return false;
    return true;
  }

}
