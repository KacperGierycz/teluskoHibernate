package telusko.DemoHib;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LaptopStates {

	@Id
	private int lid;
	private String brand;
	private int price;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "LaptopStates [lid=" + lid + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}
