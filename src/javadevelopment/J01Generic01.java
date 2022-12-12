package javadevelopment;

public class J01Generic01 {
	/*
	 Advantages of Generics
	 1)Re-Usability: If we create a generic method we can use it for any type of list elements
	 2)Stronger type checking, better type safety(Reduces run time error)
	 3)Eliminate type casting statements(Improve program's performance)
	*/
	
	public static void main(String[] args) {
		NonGenericData data1 = new NonGenericData("Without using generic");

		//When we do not use generic class we  need type casting
		String variable1 = (String) data1.getObj();
		System.out.println(variable1);

		NonGenericData data2 = new NonGenericData(12);
		int variable2 = (int) data2.getObj();
		System.out.println(variable2);
	}

}

//NonGenericData class is not generic class
class NonGenericData{
	private Object obj;

	public NonGenericData(Object obj) {
		this.obj = obj;
	}

	public Object getObj() {
		return obj;
	}

	@Override
	public String toString() {
		return "Data [obj=" + obj + "]";
	}
}
