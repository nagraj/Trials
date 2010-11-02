package JSON;

public class SimpleObject {

	String name;
	int age;
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public SimpleObject(String name, int age) {		
		this.name = name;
		this.age = age;
	}
	
	
}
