package tesst.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	private String string;
//	private int age;
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		Person p=new Person();
		Class<?>cls=p.getClass();
		
		Constructor<?>con=cls.getConstructor(int.class,String.class);
		Object obj=con.newInstance(18,"mike");
		Field f=cls.getDeclaredField("age");
		f.setAccessible(true);
		f.setInt(obj, 20);
		Method method=cls.getDeclaredMethod("info");
		method.invoke(obj);
	}

	
}

class Person{
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(int age,String name) {
		this.age=age;
		this.name=name;
	}
	public void info() {
		System.out.println("age:"+age+",name:"+name);
	}
}