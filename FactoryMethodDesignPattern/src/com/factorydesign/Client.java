package com.factorydesign;

public class Client {
	
	public static void main(String[] args) {
		
		
		Polygon p = PolygonFactory.getInstance(4);
		
		System.out.println(p.getType());
	}

}
