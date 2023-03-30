public class Cafe extends Building{

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    
    public int getCoffee() {
        return this.nCoffeeOunces;
    }

    public int getSugar() {
        return this.nSugarPackets;
    }

    public int getCreams() {
        return this.nCreams;
    }

    public int getCups() {
        return this.nCups;
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        try {
            if (this.nCoffeeOunces <= size -1 | this.nSugarPackets <= nSugarPackets -1 | this.nCreams <= nCreams -1 | this.nCups == 0) {
                throw new RuntimeException("Sorry we don't have enough inventory to sell this coffee. Please try again.");
            }
            this.nCoffeeOunces -= 12;
            this.nSugarPackets -= 2;
            this.nCreams -= 3;
            this.nCups -= 1;
            System.out.println("Thank you for your purchase!");
        } 
        catch(RuntimeException e){
            System.out.println(e);
            this.restock(size, nSugarPackets, nCreams, 1);
        }
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        if (this.nCoffeeOunces < nCoffeeOunces) {
            this.nCoffeeOunces = nCoffeeOunces;
        }
        if (this.nSugarPackets < nSugarPackets) {
            this.nSugarPackets = nSugarPackets;
        }
        if (this.nCreams < nCreams) {
            this.nCreams = nCreams;
        }
        if (this.nCups < nCups) {
            this.nCups = nCups;
        }
    }

    public static void main(String[] args) {
        Cafe my_cafe = new Cafe("Compass Cafe", "Neilson Library", 1, 12, 4, 4, 2);
        my_cafe.sellCoffee(12, 2, 2);
        my_cafe.sellCoffee(22, 12, 12);
        my_cafe.sellCoffee(22, 12, 12);
    }
    
}
