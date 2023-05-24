package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainClass {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		SingletonClass singletonClass =SingletonClass.getInstance();
		
		SingletonClass singletonClass1 =SingletonClass.getInstance();
		
		System.out.println(" HashCode for singletonClass is :"+singletonClass.hashCode());
		
		//creates only single object( i.e both object have same hashcode) 
		System.out.println(" HashCode for singletonClass1 is :"+singletonClass1.hashCode());

		

		
		// Break SingleTon Class by Reflection
		
		Class<?> singleton=Class.forName("com.singleton.SingletonClass");
		
		Constructor<SingletonClass> constructor=(Constructor<SingletonClass>) singleton.getDeclaredConstructor();
		
		constructor.setAccessible(true);
		
		SingletonClass single=constructor.newInstance();
		
		System.out.println(" HashCode for singletonClass is :"+singletonClass.hashCode());
		
		System.out.println(" HashCode for singletonClass is :"+single.hashCode());
		
		
				
	}

}
