package RegisterUserGUI;
 import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

 class Details implements Serializable{
	 String Name;
	 String Email;
	 String Password;
	  
	 
 }



 public class RegisterUserGUI extends Thread implements ActionListener{
	

	Frame fr;
	Label lblTitle, lblName, lblEmail, lblPassword;
	TextField txtName, txtEmail, txtPassword;
	Button btnRegister, btnCancel;
	Panel pnlTitle, pnlName, pnlEmail, pnlPassword, pnlButtons, pnlAll;
	
	RegisterUserGUI(){
		
		fr = new Frame("Register User");
				
		lblTitle = new Label("Enter Your Details !!");		
		lblName = new Label("Enter Your Name");		
		lblEmail = new Label("Enter Your Email");
		lblPassword = new Label("Enter Your Password");
		
		txtName = new TextField(16);
		txtEmail = new TextField(16);
		txtPassword = new TextField(16);
		
		btnRegister = new Button("Register");
		btnCancel = new Button("Cancel");
				
		btnRegister.addActionListener(this);
		btnCancel.addActionListener(this);
		
		pnlTitle = new Panel(); 
		pnlName = new Panel();  
		pnlEmail = new Panel();
		pnlPassword = new Panel();  
		pnlButtons = new Panel(); 
		pnlAll = new Panel(); 
		
	}
	
	// Add the Components into Containers
	void showGUI(){
		
		pnlTitle.add(lblTitle);
		
		pnlName.add(lblName);
		pnlName.add(txtName);
		
		pnlEmail.add(lblEmail);
		pnlEmail.add(txtEmail);
		
		pnlPassword.add(lblPassword);
		pnlPassword.add(txtPassword);
		
		pnlButtons.add(btnRegister);
		pnlButtons.add(btnCancel);
		
		pnlAll.add(pnlTitle);
		pnlAll.add(pnlName);
		pnlAll.add(pnlEmail);
		pnlAll.add(pnlPassword);
		pnlAll.add(pnlButtons);
		
		GridLayout gridLayout = new GridLayout(5, 1);
		pnlAll.setLayout(gridLayout);
		
		fr.add(pnlAll);
		
		fr.pack();
		fr.setVisible(true);
	}
 	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnRegister){
			System.out.println("Button Register Clicked...");
			
			RegisterUserGUI y = new RegisterUserGUI ();
			y.start();
		
			
			}
		else{
			System.out.println("Button Cancel Clicked...");
			fr.dispose();
		}
		
		
	}
 	public void run() {
 		Details D1= new Details();
		D1.Name = txtName.getText();
		D1.Email = txtEmail.getText();
		D1.Password = txtPassword.getText();
		
 		
 		try {
 			File file = new File("/Users/DELL/Downloads/Details.dat");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(D1);
			oos.close();
			fos.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		
 	}
 }