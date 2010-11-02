package betwixt;

import java.util.Date;
import java.util.List;

public class PersonBean {
    
    private String name;
    private int age;
    private Date dob;
    private List<String> address;
    
    /** Need to allow bean to be created via reflection */
    public PersonBean() {}
    
    public PersonBean(String name, int age) {
        this.name = name;
        this.age = age;
    }    
    public PersonBean(String name, int age, List<String> address, Date dob ) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.dob=dob;
	}

	public String toString() {
        return "PersonBean[name='" + name + "',age='" + age + "']";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }	
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }   

	/**
	 * @return the address
	 */
	public List<String> getAddress() {
		return this.address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<String> address) {
		this.address = address;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return this.dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
