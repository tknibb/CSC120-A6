import java.util.*;


public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    // check if this.residents contains name
    try {
      if (this.residents.contains(name)) {
        //   if so: throw and exception
        throw new RuntimeException(name + " is already a resident of " + this.name);
      }
      // if we're good to go, add to roster
      this.residents.add(name);
      System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
    } 
    catch (RuntimeException e) {
        System.out.println(e);
    }
  }

  public String moveOut(String name) {
    // return the name of the person who moved out
    try {
      if (!this.residents.contains(name)) {
        throw new RuntimeException(name + " doesnt live in " + this.name);
      }
      this.residents.remove(name);
      System.out.println(name + " has moved out of " + this.name);
    }
    catch (RuntimeException e) {
      System.out.println(e);
    }
    return name;
  }

  public boolean isResident(String person) {
    if (this.residents.contains(name)) {
      return true;
    }
    return false;
  }

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  public static void main(String[] args) {
    House wilson = new House("Wilson", "16 Kensington Ave", 4, false);
    System.out.println(wilson);
    wilson.moveIn("Taylor");
    wilson.moveIn("Kim");
    wilson.moveIn("Julie");
    wilson.moveOut("Kim");
    System.out.println(wilson);
    House scales = new House("Scales", "170 Elm Street", 4, true);
    System.out.println(scales);
    scales.moveIn("Liz");
    scales.moveOut("Ella");
    System.out.println(scales);
  }
}
