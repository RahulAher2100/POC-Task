package com.factorydesign;

public class PolygonFactory {
	
	public static Polygon getInstance(int sides) {
		
		Polygon polygon=null;
		
		switch (sides) {
		
		case 3:
			polygon= new Triangle();
			break;
			
		case 4:
			polygon= new Square();
			break;
			
		case 5:
			polygon =new Pentagon();
			break;
			
		 default: 
			break;
				
		}
		
		return polygon;
	}

}
