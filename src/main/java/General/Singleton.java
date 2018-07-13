package General;

class SingleObject {

	// create an object of SingleObject
	private static SingleObject instance = new SingleObject();

	// make the constructor private so that this class cannot be
	// instantiated
	private SingleObject() {
	}

	// Get the only object available
	public static SingleObject getInstance() {
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}
}

public class Singleton {

	public static void main(String[] args) {

		// illegal construct
		// Compile Time Error: The constructor SingleObject() is not visible
		// SingleObject object = new SingleObject();

		// Get the only object available
		SingleObject object = SingleObject.getInstance();

		// show the message
		object.showMessage();
	}
}

/*
 * To create the singleton class, we need to have static member of class,
 * private constructor and static factory method.
 * 
 * Static member: It gets memory only once because of static, it contains the
 * instance of the Singleton class. 
 * Private constructor: It will prevent to
 * instantiate the Singleton class from outside the class. 
 * Static factory  method: This provides the global point of access to the Singleton object and
 * returns the instance to the caller.
 */