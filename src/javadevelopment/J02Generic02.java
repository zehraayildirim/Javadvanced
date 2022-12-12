package javadevelopment;

public class J02Generic02 {

	public static void main(String[] args) {
		//If you will use String type <String> 
		GenericData01<String> genericDataStr =  new GenericData01<String>("With using generic");
		String dataStr = genericDataStr.getObj();
		System.out.println(dataStr);
		
		//If you will use Integer type <Integer> 
		GenericData01<Integer> genericDataInt =  new GenericData01<Integer>(1234);
		Integer dataInt = genericDataInt.getObj();
		System.out.println(dataInt);
		
		//If you will use Integer type <Integer> 
		GenericData01<Boolean> genericDataBoolean =  new GenericData01<Boolean>(false);
		Boolean dataBoolean = genericDataBoolean.getObj();
		System.out.println(dataBoolean);
	}
}

class GenericData01<T>{
	private T obj;

	public GenericData01(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	@Override
	public String toString() {
		return "Data [obj=" + obj + "]";
	}
}
