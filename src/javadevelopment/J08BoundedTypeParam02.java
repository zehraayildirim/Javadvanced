package javadevelopment;

public class J08BoundedTypeParam02 {

	public static void main(String[] args) {
		
		DataBounded<Integer, J08BoundedTypeParam02> data = new DataBounded<>(1, new J08BoundedTypeParam02());
		/*
		  display() method can accept just
		  AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short
		  as data type for the second parameter because we restricted the second parameter by extending to Number
		*/
		data.display(true, 11);
		//when we type getValue() it returns "new BoundedTypeParam()" and by using the object 
		//we can access to the methods inside the class
		data.getValue().test();
		//If you want to get key you can use getKey() method
		System.out.println(data.getKey());
	}
	
	public void test() {
		System.out.println("Testing...");
	}

}

//You get yellow warning because Final types cannot be further extended, but if you are sure about data type
//you can extend
class DataBounded<K extends Integer, V extends J08BoundedTypeParam02>{
	private K key;
	private V value;
	
	public DataBounded(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "DataBounded [key=" + key + ", value=" + value + "]";
	}
	//If you extend to Number Class as data type, it means you can use just 
	//AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short
	
	//You get yellow warning because Final types cannot be further extended, but if you are sure about data type
	//you can extend
	public <E extends Boolean, N extends Number> void display(E element, N number) {
		 System.out.println("Element: " + element + "\nNumber: " + number);
	}
	
}
