package telusko.DemoHib;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Table (name="alien_table")
@Entity //(name="alien_table")
public class Alien {

	@Id
	private int id;
	private String Aname;
	
	@OneToMany(mappedBy="alien",fetch=FetchType.EAGER)
	private Collection<Laptop> laps= new ArrayList<Laptop>();
	
//	@Transient
//	private AlienName name;
//	@Column(name="alien_color")
//	private String color;
	
	
	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}

	
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

	@Override
	public String toString() {
		return "Alien [id=" + id + ", Aname=" + Aname + ", laps=" + laps + "]";
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

	
	
	
}
