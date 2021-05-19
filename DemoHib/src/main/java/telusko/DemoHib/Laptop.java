package telusko.DemoHib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

	@Id
	private int lid;
	private String lname;
	private String brand;
	private int price;
	
	@ManyToOne
	private Alien alien;
	
//	@ManyToMany
//	private List<Student> student=new ArrayList();

//	@ManyToOne
//	private Student student;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public Alien getAlien() {
		return alien;
	}
	public void setAlien(Alien alien) {
		this.alien = alien;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + ", brand=" + brand + ", price=" + price + ", alien=" + alien
				+ "]";
	}
	

	
	
	
	
//	public List<Student> getStudent() {
//		return student;
//	}
//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}


	}
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent() {
//		this.student = student;
//	}
	
	
	
	
	
	

