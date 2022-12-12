package javadevelopment;

import java.util.LinkedList;
import java.util.List;

public class J03Generic03 {

	public static void main(String[] args) {
		//Without using generic class. It uses down casting for every type of data
		List<Object> elements = new LinkedList<>();
		elements.add(new NonGenericData02("Mark"));
		elements.add(new NonGenericData02("John"));
		elements.add(new NonGenericData02("Adem"));
		elements.add("Chris");
		elements.add(11);
		elements.add(3.2);
		elements.add('A');		
		System.out.println(elements);
		
		//With using generic class.
		List<GenericData02<Object>> elementsGen = new LinkedList<>();
		elementsGen.add(new GenericData02<Object>("Mark"));
		elementsGen.add(new GenericData02<Object>(11));
		elementsGen.add(new GenericData02<Object>(3.2));
		elementsGen.add(new GenericData02<Object>('A'));
		System.out.println(elementsGen);
		
		//If you want to store just Strings in the list just convertObject type to String in line 32
		//After converting, if you try to store a data different from String, you will get 
		//compile time error which is good because when you type code you will realise the problem.
		//But if you do not use generic it will give run time error which breaks your app.
		List<GenericData02<String>> elementsGenStr = new LinkedList<>();
		elementsGenStr.add(new GenericData02<String>("Mark"));
		elementsGenStr.add(new GenericData02<String>("Ted"));
		elementsGenStr.add(new GenericData02<String>("John"));
		elementsGenStr.add(new GenericData02<String>("Chris"));
		System.out.println(elementsGenStr);
	}
}

class NonGenericData02{
	private String name;

	public NonGenericData02(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

class GenericData02<T>{
	private T name;

	public GenericData02(T name) {
		this.name = name;
	}
	
	public T getName() {
		return name;
	}

	@Override
	public String toString() {
		return "GenericNames [name=" + name + "]";
	}

}










