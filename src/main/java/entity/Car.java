package entity;

public class Car {
    private Long id;
    private String carname;
    private double price;
    public String getCarname() {
        return carname;
    }
    public void setCarname(String carname) {
        this.carname = carname;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
}

