package javadevelopment;

	/*
	Serialization is a mechanism of writing the state of an object into a byte stream.
	The reverse of serialization is deserialization
	*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//First create that class
//Do not put "implements Serializable" first
class Vehicle implements Serializable{

	private static final long serialVersionUID = 4662202706132691568L;
	private String type;
	private int number;
	
	public Vehicle(String type, int number) {
		this.type = type;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", number=" + number + "]";
	}
		
}

//Create a "vehicles.dat" under src
//Second create that class name it as WriteObject
//Then run that class you will get Exception the add "implements Serializable" to the "Vehicle" class
//Then run the class again you will see something in the file but it is not readable things so create "readObject" class
public class J33SerializationOfObjects {

	public static void main(String[] args) {
		Vehicle bike = new Vehicle("Bike", 1234);
		Vehicle car = new Vehicle("Car", 9876);

		try(FileOutputStream fos = new FileOutputStream("src/vehicles.dat")){
			try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
				obj.writeObject(bike);
				obj.writeObject(car);
				System.out.println("Object written into the file");
			}
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Input or output problem");
		}
	}

}

class readObject {
	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("src/vehicles.dat")){

			try(ObjectInputStream obj = new ObjectInputStream(fis)){
				Vehicle v1 = (Vehicle) obj.readObject();
				Vehicle v2 = (Vehicle) obj.readObject();
				System.out.println("Object 1: " + v1);
				System.out.println("Object 2: " + v2);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}














