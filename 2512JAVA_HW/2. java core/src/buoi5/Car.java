package buoi5;

public class Car {

    String  make;
    String model;
    int year;
    String  color;
    double price;


    public Car(String make, String model, int year, String color,double price){
        this.make = make;
        this.model= model;
        this.year =  year;
        this.color = color;
        this.price  =  price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;

        Car other = (Car) obj;
        return year == other.year
                && Double.compare(price, other.price) == 0
                && make.equals(other.make)
                && model.equals(other.model)
                && color.equals(other.color);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
