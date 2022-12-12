package javadevelopment;

	/*
		Type Parameters
		The type parameters naming conventions is important!
		The naming conventions are as follows:
		
		T - Type
		E - Element
		K - Key
		N - Number
		V - Value
	*/


public class J06TypeParameters {

	public static void main(String[] args) {
		DataTypeParams<Integer, String> data = new DataTypeParams<Integer, String>(1, "Mark");	
		//Print the data by using toString() method
		System.out.println(data);
		//Print the key and value separately
		System.out.println("Key: " + data.getKey() + "\nValue: " + data.getValue());
		
		//Call the generic method by using generic class name
		//Note: We can create generic methods in any type of class 
		//As you see I can easily use every data type
		data.display("Element", "Number");
		data.display(12, 13);
		data.display("Gold", 51);
		data.display('A', false);
	}

}

class DataTypeParams<K, V>{
	private K key;
	private V value;
	
	public DataTypeParams(K key, V value) {
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
		return "DataTypeParams [key=" + key + ", value=" + value + "]";
	}
	
	public <E, N> void display(E element, N number) {
		System.out.println("Element: " + element + "\nNumber: " + number);
	}
	
}
