package telusko.DemoHib;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity (name="alien_table")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
//@Table (name="alien_table")
public class AlienColor {

	@Id
	private int id;
//	@Transient
//	private AlienName name;
//	@Column(name="alien_color")
	private String color;
	private String Aname;
	
	
	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}
//	@OneToMany(mappedBy="alien")
//	private Collection<Laptop> laps= new ArrayList<Laptop>();
//	
//	public Collection<Laptop> getLaps(){
//		return laps;
//	}
	
//	public void setLaps(Collection<Laptop> laps) {
//		this.laps=laps;
//	}
	
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "AlienColor [id=" + id + ", color=" + color + ", Aname=" + Aname + "]";
	}

	
	
	
}
