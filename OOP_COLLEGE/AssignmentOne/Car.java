package AssignmentOne;

//30
public class Car {
    private String make;
    private String models;
    private String year;


    public Car(String make, String models, String year) {
        this.make = make;
        this.models = models;
        this.year = year;
    }

    public Car() {

    }

    //getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

class mainClass3 {
    public static void main(String[] args) {
        Car car = new Car("Mercedes", "Z", "2024");
        car.setMake("BMW");
        car.setModels("Y");
        car.setYear("2025");
        System.out.println(car.getMake());
        System.out.println(car.getModels());
        System.out.println(car.getYear());
        Car car1 = new Car();
        car1.setMake("Porsche");
        car1.setModels("R");
        car1.setYear("2023");
        System.out.println(car1.getMake());
        System.out.println(car1.getModels());
        System.out.println(car1.getYear());


    }
}
