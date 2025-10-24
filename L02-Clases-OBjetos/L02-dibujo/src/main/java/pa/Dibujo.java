package pa;

public class Dibujo {
	
	public static void main(String[] args) {
		
		System.out.println("\n\n Ejercicio pendiente de realizar \n\n");
		
		Square c1 = new Square();
		c1.changeColor("red");
		c1.slowMoveHorizontal(-155);
		c1.makeVisible();
		Square c2 = new Square();
		c2.changeColor("red");
		c2.moveHorizontal(-95);
		c2.makeVisible();
		Square c3 = new Square();
		c3.changeColor("red");
		c3.moveHorizontal(-35);
		c3.makeVisible();
		Square c4 = new Square();
		c4.changeColor("red");
		c4.moveHorizontal(25);
		c4.makeVisible();
		Square c5=new Square();
		c5.moveVertical(-60);
		c5.moveHorizontal(-95);
		c5.makeVisible();
		Square c6=new Square();
		c6.moveVertical(-60);
		c6.moveHorizontal(-35);
		c6.makeVisible();
		
		Circle ci1 = new Circle();
		ci1.moveHorizontal(-30);
		ci1.moveVertical(50);
		ci1.changeColor("black");
		ci1.makeVisible();
		Circle ci2 = new Circle();
		ci2.moveHorizontal(70);
		ci2.moveVertical(50);
		ci2.changeColor("black");
		ci2.makeVisible();
		Circle ci3 = new Circle();
		ci3.changeSize(30);
		ci3.moveHorizontal(-11);
		ci3.moveVertical(67);
		ci3.changeColor("yellow");
		ci3.makeVisible();
		Circle ci4 = new Circle();
		ci4.changeSize(30);
		ci4.moveHorizontal(88);
		ci4.moveVertical(67);
		ci4.changeColor("yellow");
		ci4.makeVisible();
		
		Triangle t1= new Triangle();
		t1.changeSize(60, 80);
		t1.moveHorizontal(5);
		t1.moveVertical(-80);
		t1.makeVisible();   
		Triangle t2= new Triangle();
		t2.changeSize(60, 80);
		t2.moveHorizontal(125);
		t2.moveVertical(-80);
		t2.changeColor("red");
		t2.makeVisible();
		
		Person persona=new Person();
		persona.changeSize(120, 70);
		persona.changeColor("blue");
		persona.moveHorizontal(-170);
		persona.moveVertical(-75);
		persona.makeVisible();
	}

}
