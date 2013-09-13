package birken;

public class Person {
	
	private Summary sum;
	
	public Person(int nr){
		this.sum = new Summary(nr);
	}
	
	public Summary getSum(){
		return sum;
	}
}
