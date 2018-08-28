package varargs;
class Student{
	int roll;
	String name;
	
	
	
	public Student(int roll, String name) {
		this.roll = roll;
		this.name = name;
	}



	@Override
	public String toString() {
		return "Student Roll no =" + roll + ", Name=" + name + "";
	}
		
}

public class VarArgs {
	void fun2(Student...Students){ 
		for(Student elm : Students){
			System.out.println(elm.toString());
		}
		
		System.out.println("arr is "+Students);
		System.out.println("==================");
	    sort(Students);
	    System.out.println("After Sorting:");
	    for(Student elm : Students){
			System.out.println(elm.toString());
		}
	    
	}
	Student[] sort(Student[] a) {
		Student temp;
		for (int i= 0; i<a.length;i++) {
			 for (int j = i + 1; j < a.length; j++) {
				 if (a[i].roll>a[j].roll) {
					 temp = a[i];
					 a[i] = a[j];
					 a[j] = temp;
				 }
			 }
		}
		return a;
	}
	

	public static void main(String[] args) {
			
		Student S1=new Student(34 ,"John");
		Student S2=new Student(32 ,"Jack");
		Student S3=new Student(33 ,"Max");
		Student S4=new Student(12 ,"Charlie");
		Student S5=new Student(45 ,"Nigel");
		
		VarArgs v = new VarArgs();
		v.fun2(S1,S2,S3,S5,S4);
		
		


	}

}
