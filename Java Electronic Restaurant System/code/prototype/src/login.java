import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JTextField;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class login implements ActionListener{
	
	private JPanel mainView;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JButton btnLogin,btnSignup,btnBack;
	private JLabel labelLogin;
	String tableNumber;
	public login(String TableNumber){
		tableNumber = TableNumber;
		System.out.println("login");
		loadView();
		
	}
	

    public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();
		if(button == btnBack){
			customerView View = new customerView(tableNumber);
    		JPanel NewView = View.returnCustomerView();
    		contentPane.removeAll();
    	    contentPane.add(NewView);
		}
		if(button == btnLogin){
			char[] input = passwordField.getPassword();
			String passwordInput = new String(input);
			String usernameInput = txtUsername.getText();
			String query = "SELECT * FROM `rewardProgram` WHERE  `username` =  '"+usernameInput+"' AND  `password` =  '"+passwordInput+"'";
			try{
				Connection con = DataBase.getConnection();
				PreparedStatement get = con.prepareStatement(query);
				ResultSet result = get.executeQuery();
				ArrayList<String> array = new ArrayList<String>();
				boolean empty = true;
				
				while(result.next()){
					//do a if else save array data 
					array.add(result.getString("username"));
					System.out.print(result.getString("username"));
					System.out.println(" ");
					System.out.print(result.getString("password")+"\n");
					empty = false;
				}
				if(empty){
					System.out.println("empty");
					labelLogin.setText("Sorry, your password was incorrect.");
				}else if(!empty){
					labelLogin.setText("Loading...");
					RewardProgram view = new RewardProgram(tableNumber, usernameInput);
					JPanel newView = view.returnView();
					
					contentPane.removeAll();
				   	contentPane.add(newView);

				}
				

				
			}catch(Exception e){ 
				System.out.println(e);
			}
			
		}else if(button == btnSignup){

			SignUp view = new SignUp(tableNumber);
			JPanel newView = view.returnView();
			
			contentPane.removeAll();
		   	contentPane.add(newView);
		}
		
		
		 // reload the window
    	contentPane.revalidate();
    	contentPane.repaint();		
    }

	
    public JPanel returnView(){    	
    	
		return mainView;
    }
    
    
	
	public void loadView(){

		
		mainView = new JPanel();
		mainView.setBackground(Color.BLACK);
		mainView.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		mainView.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnBack = new JButton("back");
		panel_2.add(btnBack, BorderLayout.NORTH);
		btnBack.addActionListener(this);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		labelLogin = new JLabel("");
		labelLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		labelLogin.setForeground(Color.WHITE);
		panel_3.add(labelLogin);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		panel_3.add(txtUsername);
		txtUsername.setText("username");
		txtUsername.setColumns(10);
		txtUsername.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtUsername.setText("");
            }
        });
		
		
		
		
		JPanel NorthP = new JPanel();
		NorthP.setBackground(Color.BLACK);
		panel.add(NorthP);
		
		JPanel WestP = new JPanel();
		WestP.setBackground(Color.BLACK);
		panel.add(WestP);
		
		JPanel CenterP = new JPanel();
		CenterP.setBackground(Color.BLACK);
		panel.add(CenterP);
		CenterP.setLayout(new GridLayout(0, 1, 0, 0));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		passwordField.setText("1234");
		CenterP.add(passwordField);
		
		passwordField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	passwordField.setText("");
            }
        });
		
		
		
		
		
		
		btnLogin = new JButton("login");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		CenterP.add(btnLogin);
		btnLogin.addActionListener(this);

		
		JPanel EastP = new JPanel();
		EastP.setBackground(Color.BLACK);
		panel.add(EastP);
		
		JPanel SouthP = new JPanel();
		SouthP.setBackground(Color.BLACK);
		panel.add(SouthP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnSignup = new JButton("signup");
		btnSignup.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		panel_1.add(btnSignup);
		btnSignup.addActionListener(this);

		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
    	
    	
	}


}
