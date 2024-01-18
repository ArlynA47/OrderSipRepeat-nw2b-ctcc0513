package ordersiprepeat.nw2b.ctcc0513;

/**
 *
 * @author arlyn musada
 */

public class MenuItem {
    private String abbreviation; // Order item abbrevation
    private String name; // drink name
    private double price;
    private String category; // category (Coffee or Milk Tea)

    public MenuItem(String abbrv, String name, double price, String category) {
        this.abbreviation = abbrv;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getAbbrv() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}