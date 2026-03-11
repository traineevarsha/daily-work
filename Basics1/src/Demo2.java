import java.util.Date;
import java.util.List;
public class Demo2 {
	private String model; // should be enum since only fixed models 
	private String color; //
	private float price; //mutable
	private Engine engine;//mutable
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public String getFuelType() {
		return FuelType;
	}
	public void setFuelType(String fuelType) {
		FuelType = fuelType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	private String FuelType;
	String number;
	boolean insured;//mutable
	String transmission; //im
	List <Seat> seats;//mutable
	float weight; //mutable
	String design; 
	float mileage;
	String brand;
	boolean ev;
	Date manufacturingDate;
	List<Wheel> wheels;
	public String getModel() {
		return model;
	}
}

