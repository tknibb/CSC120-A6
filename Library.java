import java.util.Hashtable;

public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
  }
  
  public Hashtable <String, Boolean> getCollection() {
    return this.collection;
  }

  public void addTitle(String title) {
    try {
      if (this.collection.containsKey(title)) {
        throw new RuntimeException("This book is already in the library.");
      }
      else {
        this.collection.put(title, true);
      }
    }
    catch(RuntimeException e){
      System.out.println(e);
    }
  }

  public String removeTitle(String title) {
    // return the title that we removed
    try {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException("This book is not in the library.");
      }
      else {
        this.collection.remove(title);
      }
    }
    catch(RuntimeException e){
      System.out.println(e);
    }
    return title;
  }

  public void checkOut(String title) {
    try {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException(title + " is not in the library.");
      }
      else if (this.collection.get(title).equals(false)) {
        throw new RuntimeException(title + " is currently checked out.");
      }
      else{
        this.collection.replace(title, false);
        System.out.println("Successfully checked out " + title);
      }
    }
    catch(RuntimeException e){
      System.out.println(e);
    }
  }

  public void returnBook(String title) {
    try {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException(title + " is not the library.");
      }
      else if (this.collection.get(title).equals(true)) {
        throw new RuntimeException(title + " has already been returned to library.");
      }
      else {
        this.collection.replace(title, true);
        System.out.println("Successfully returned " + title);
      }
    }
    catch(RuntimeException e){
      System.out.println(e);
    }
  }

  public boolean containsTitle(String title) {
    // returns true if the title appears as a key in the Libary's collection, false otherwise
    if (this.collection.containsKey(title)){
      return true;
    }
    return false;
  } 
  public boolean isAvailable(String title) {
    // returns true if the title is currently available, false otherwise
    if (this.collection.get(title).equals(true)) {
      return true;
    }
    return false;
  } 

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.collection.size() + " books in this collection.";
    return description;
  } 

  public void printCollection() {
    // prints out the entire collection in an easy-to-read way (including checkout status)
    System.out.println(this.collection.toString());
  }

  public static void main(String[] args) {
    Library neilson  = new Library("Neilson", "Smith College", 4);
    neilson.addTitle("The Bible");
    System.out.println(neilson);
    neilson.printCollection();
    neilson.checkOut("The Bible");
    neilson.returnBook("The Bible");
    neilson.returnBook("The Cat in the Hat");
    neilson.addTitle("The Cat in the Hat");
    neilson.checkOut("The Cat in the Hat");
  }

}