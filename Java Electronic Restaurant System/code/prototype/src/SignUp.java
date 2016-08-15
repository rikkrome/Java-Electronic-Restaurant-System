import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class SignUp implements ActionListener {
	
	private JPanel mainView;
	private JButton btnSignup, btnBack;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel labelAlert;
	private JTextField textBday;
	private JLabel label;
	String tableNumber;
	public SignUp(String TableNumber) {
		tableNumber = TableNumber;
		loadView();
	}
	 public void actionPerformed(ActionEvent ae){
	        JButton button = (JButton) ae.getSource();
			JPanel contentPane = prototype_standard.returnContentPaneView();
			
			if(button == btnSignup){
				boolean found = false;
				//check if username taken
				
				try {
					found = DataBase.loginCheck(txtUsername.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (found){
					labelAlert.setText("username taken");
				}else if(!found){
					labelAlert.setText("sign up complete");
					
					try {
						DataBase.postToLogin(txtUsername.getText(), txtPassword.getText(),textBday.getText());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					btnSignup.setVisible(false);

				}
			}else if(button == btnBack){
				
				login view = new login(tableNumber);
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
		mainView.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		 labelAlert = new JLabel("");
		 labelAlert.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		panel_2.add(labelAlert);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		txtUsername.setText("username");
		panel_2.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtUsername.setText("");
            }
        });
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		txtPassword.setText("password");
		panel_2.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtPassword.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtPassword.setText("");
            }
        });
		 
		 JPanel panel_3 = new JPanel();
		 panel_2.add(panel_3);
		 panel_3.setLayout(new BorderLayout(0, 0));
		 
		 JLabel lblBirthday = new JLabel("birthday");
		 panel_3.add(lblBirthday, BorderLayout.NORTH);
		 
		 textBday = new JTextField();
		 textBday.setText("04-13-2016");
		 panel_3.add(textBday, BorderLayout.CENTER);
		 textBday.setColumns(10);
		 textBday.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	            	textBday.setText("");
	            }
	        });
		 btnSignup = new JButton("signup");
		btnSignup.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		panel_2.add(btnSignup);
		
		label = new JLabel("");
		panel.add(label);
		btnSignup.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		mainView.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		 btnBack = new JButton("back");
		panel_1.add(btnBack, BorderLayout.WEST);
		btnBack.addActionListener(this);

		
	}
	

}
