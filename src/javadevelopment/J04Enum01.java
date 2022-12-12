package javadevelopment;

public enum J04Enum01 {
	/*
	 1)What is enum?
	   An "enum" is a special "class" that represents a group of constants 
	   (unchangeable variables, static + final variables).
	 2)What is the difference between enum and class?
	   a)An enum can, just like a class, have attributes and methods. 
	   The only difference is that enum constants are public, static and final(unchangeable-cannot be overridden).
	   b)An enum cannot be used to create objects, and it cannot extend other classes 
	   (but it can implement interfaces).
	 3)Why And When To Use Enums?
	   Use enums when you have values that you know aren't going to change, 
	   like month days, days, colors, deck of cards, etc. 
	 4)Constants should be in uppercase letters,separate them with comma, do not use semicolon at the end 
	 */
	
	JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER
	
}
















