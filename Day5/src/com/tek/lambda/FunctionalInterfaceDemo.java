package com.tek.lambda;
@FunctionalInterface

interface Animal {
	void eat();
}

class Cat implements Animal {

	public void eat() {
		System.out.println("animal eat inside class");
	}
}

	public class FunctionalInterfaceDemo {
	public static void main(String[] args) {
		oopWay();
		//functional();
	}
	private static void oopWay()
	{
		Animal animal=new Cat();
		animal.eat();
	}
	  private static void functional()
	  {
		  
		Animal animal=()->
		{//in line definition=written where its exactly required
			System.out.println("animal eat in lambda");
		};
		animal.eat();

	}

}
