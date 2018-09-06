package thread;

import java.io.*;

class SimpleStack{
	private int MaxStack;
	private int emptyStack;
	public static int top;
	private char[] items;


	public SimpleStack(int i){
	    MaxStack=i;
	    emptyStack=-1;
	    top=0;
	    items=new char[MaxStack];
	}
	
	public void Push( char c){
	 items[top]=c;
	 top++;
	 }
	
	public char Pop(char c){
	 return items[top--];
	 }
	
	public boolean full(){
	 if(top+1==MaxStack){
		 return false;
	 }
	 else {
		 return true;
	 }
	 }
	
	public boolean empty(){
	 if(top== emptyStack) {
		return false;
	}
	 else {
		 return true;
	 }
	}
}

class pushThread extends Thread{
	SimpleStack m;
	char ch;
	
	pushThread(SimpleStack n){
		m = n;
	}
	public void run() {
		synchronized(m){
			
			try {
				while((ch= (char)System.in.read())=='\n')
				{  
				    if(m.full()){
				        m.Push(ch);
				        }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.notify();
			}
	}	
}
class popThread extends Thread{
	SimpleStack m;
	char ch;
	
	
	popThread(SimpleStack n){
		m = n;
	}
	public void run() {
		synchronized(m){
			try {
				m.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			while(!m.empty())
				{
				System.out.println(m.Pop(ch));
				System.out.println();
				}
			
			}
	}	
}

public class Stack {
	

	public static void main(String[] args) {
		SimpleStack m= new SimpleStack(10);
		
		pushThread pu = new pushThread(m);
		popThread po = new popThread(m);
		pu.start();
		po.start();

	}

}
