package UI;
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

import DataBase.DB;

public class Register implements ActionListener{
	

	Frame fr;
	Label lblTitle, lblName, lblEmail, lblRollNo, lblMobileNo;
	TextField txtName, txtEmail, txtRollNo,txtMobileNo;
	Button btnRegister, btnCancel;
	Panel pnlTitle, pnlName, pnlRollNo, pnlEmail, pnlMobileNo, pnlButtons, pnlAll;
	
	public Register(){
		
		fr = new Frame("Register Student");
				
		lblTitle = new Label("Enter Your Details !!");	
		
		lblName = new Label("Enter Your Name");
		lblRollNo = new Label("Enter Your Roll No");
		lblEmail = new Label("Enter Your Email");
		lblMobileNo = new Label("Enter Your Mobile No.");
		
		txtName = new TextField(16);
		txtRollNo = new TextField(16);
		txtEmail = new TextField(16);
		txtMobileNo = new TextField(16);
		
		btnRegister = new Button("Register");
		btnCancel = new Button("Cancel");
				
		btnRegister.addActionListener(this);
		btnCancel.addActionListener(this);
		
		pnlTitle = new Panel(); 
		pnlName = new Panel();  
		pnlRollNo = new Panel();
		pnlEmail = new Panel(); 
		pnlMobileNo= new Panel();
		pnlButtons = new Panel(); 
		pnlAll = new Panel(); 
		
	}
	
	// Add the Components into Containers
	public void showGUI(){
		
		pnlTitle.add(lblTitle);
		
		pnlName.add(lblName);
		pnlName.add(txtName);
		
		pnlRollNo.add(lblRollNo);
		pnlRollNo.add(txtRollNo);
		
		pnlEmail.add(lblEmail);
		pnlEmail.add(txtEmail);
		
		pnlMobileNo.add(lblMobileNo);
		pnlMobileNo.add(txtMobileNo);
		
		pnlButtons.add(btnRegister);
		pnlButtons.add(btnCancel);
		
		pnlAll.add(pnlTitle);
		pnlAll.add(pnlName);
		pnlAll.add(pnlRollNo);
		pnlAll.add(pnlEmail);
		pnlAll.add(pnlMobileNo);
		pnlAll.add(pnlButtons);
		
		GridLayout gridLayout = new GridLayout(6, 1);
		pnlAll.setLayout(gridLayout);
		
		fr.add(pnlAll);
		
		fr.pack();
		fr.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnRegister){
			System.out.println("Button Register Clicked...");
			Student s= new Student();
			s.Name = txtName.getText();
			s.RollNo = txtRollNo.getText();
			s.Email = txtEmail.getText();
			s.MobileNo = txtMobileNo.getText();
			
			DB helper = new DB();
			helper.createConnection();
			helper.saveStudent(s);
			helper.closeConnection();
		
			
			}
		else{
			System.out.println("Button Cancel Clicked...");
			fr.dispose();
		}
			
	}
	}