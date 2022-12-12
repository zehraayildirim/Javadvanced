package javadevelopment;

public class J07BoundedTypeParam01 {

	public static void main(String[] args) {
		
		DataBounded01<Integer, String> data = new DataBounded01<Integer, String>(1, "value");
		//display() method can accept just
		//AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short
		//as data type for the second parameter because we restricted the second parameter by extending to Number
		data.display(false, 11);
		//If you want to get key you can use getKey() method
		System.out.println(data.getKey());
	}
	
	public void test() {
		System.out.println("Testing...");
	}

}
//first type that one and show you can use any data type for parameters
class DataBounded01<K, V>{
	private K key;
	private V value;
	
	public DataBounded01(K key, V value) {
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
	/*
		If you extend to Number Class as data type, it means you can use just
		AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, Short
	*/
	/*
		 AtomicInteger:
		 1) The AtomicInteger class is a wrapper class for an int value that allows it to be updated
		 atomically.
		 2)The most common use of the AtomicInteger is to handle a counter that is accessed
		 by different threads simultaneously.It will be very useful when you are working in multithreading environment
		 and required to perform thread safe operations on integer without taking any lock(synchronized method)
		 3)Operations are fast and more readable than primitive synchronized methods.
		 4)It provides many operations like increment and decrement on integer variable which is shared between many threads
		 and hence minimizing the need of complex multithreading.
	*/
	public <E extends Boolean, N extends Number> void display(E element, N number) {
		 System.out.println("Element: " + element + "\nNumber: " + number);
	}
	
	
}
