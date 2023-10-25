
class Car
{
	public void car1()
	{
		System.out.print("1");	}
}

public class PolyUpcasting extends Car {
	public void poly()
	{
		System.out.print("2");
	}

	public static void main(String[] args) {
		
		Car c1=new PolyUpcasting();//upcasting
		c1.car1();
		PolyUpcasting p=(PolyUpcasting)c1;
		p.car1();
		p.poly();
		
	}

}
