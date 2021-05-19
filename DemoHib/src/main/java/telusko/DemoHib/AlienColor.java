package telusko.DemoHib;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity //(name="alien_table")
//@Table (name="alien_table")
public class Alien2 {

	@Id
	private int id;
//	@Transient
//	private AlienName name;
//	@Column(name="alien_color")
//	private String color;
	private String Aname;
	
	
	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}
	@OneToMany(mappedBy="alien")
	private Collection<Laptop> laps= new ArrayList<Laptop>();
	
	public Collection<Laptop> getLaps(){
		return laps;
	}
	
	public void setLaps(Collection<Laptop> laps) {
		this.laps=laps;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

//	public AlienName getName() {
//		return name;
//	}
//	public void setName(AlienName name) {
//		this.name = name;
//	}
//	public String getColor() {
//		return color;
//	}
//	public void setColor(String color) {
//		this.color = color;
//	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + Aname + "]";
	}
	
	
	
}
