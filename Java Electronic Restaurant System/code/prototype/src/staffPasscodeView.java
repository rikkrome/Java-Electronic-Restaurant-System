
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;

public class staffPasscodeView  implements ActionListener {
	private JPanel staff_Passcode_view ,panel_back_login;
	private JButton btnBack_Staff_PasswordView ,btnLogin_Staff_passwordView ;
	private JLabel lblPasscode_staff_Passcode  ;
	private JPasswordField pwdPasscode_staff_Passcode_txtField;

	public JPanel moveToThisView;
	public String ViewItsGoingTo;
	private JPanel panel;
	private String tableNumber;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

//	public staffTypeSelectionView staffTypeSelection;
	public staffPasscodeView(String loadView, String TableNumber){
		System.out.print("staffPasscodeView:  "+loadView+"\n");

		tableNumber = TableNumber;

		load_Staff_Passcode_view();
		
		ViewItsGoingTo = loadView;
		

		if(loadView == "staffTypeSelection"){
			
			staffTypeSelectionView staffTypeSelection = new staffTypeSelectionView();
			moveToThisView = staffTypeSelection.returnStaffTypeSelectionView();
			
		}else if (loadView == "managerView"){
			
			
			selectTableView_Manager SelectTableClass= new selectTableView_Manager();
    		moveToThisView = SelectTableClass.returnselectTableView_Manager();
		}else if (loadView == "userTypeSelection"){
			UserTypeSelectionView userTypeSelection = new UserTypeSelectionView();
			moveToThisView = userTypeSelection.returnUserTypeSelectionView();
		}
	}
	
	

	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
 		JPanel contentPane = prototype_standard.returnContentPaneView();
        
        /*
         * staff_Passcode_view Actions
         */
         if(button == btnBack_Staff_PasswordView){
        	 
        	 JPanel GoBackToView = null;
        	 
        	 //go back to staffTypeSelection
     		if(ViewItsGoingTo == "staffTypeSelection"){
     			UserTypeSelectionView userTypeSelection = new UserTypeSelectionView();
        		GoBackToView = userTypeSelection.returnUserTypeSelectionView();
        		
        		//go back to managerView
     		}else if(ViewItsGoingTo == "managerView"){
     			staffTypeSelectionView staffTypeSelection = new staffTypeSelectionView();
        		GoBackToView = staffTypeSelection.returnStaffTypeSelectionView();
        		
        		//go back to userTypeSelection
     		}else if(ViewItsGoingTo == "userTypeSelection"){
     			customerView customer = new customerView(tableNumber);
     			GoBackToView = customer.returnCustomerView();
     		}
     	    contentPane.removeAll();
     	    contentPane.add(GoBackToView);
        	

        	 
        }else if (button == btnLogin_Staff_passwordView){
      	  char[] input = pwdPasscode_staff_Passcode_txtField.getPassword();

        	if(isPasswordCorrect(input , ViewItsGoingTo)){
        		System.out.print("password is correct\n");
        		
//        		staffTypeSelectionView staffTypeSelection = new staffTypeSelectionView();
//         		JPanel staffTypeSelectionView = staffTypeSelection.returnStaffTypeSelectionView();
         		
         	    contentPane.removeAll();
         	    contentPane.add(moveToThisView);
         	    

        	}
        	
        	//Zero out the possible password, for security.
            Arrays.fill(input, '0');

            pwdPasscode_staff_Passcode_txtField.selectAll();
            pwdPasscode_staff_Passcode_txtField.setText("0123456789");
//            resetFocus();

        }
         
  	    // reload the window
      	contentPane.revalidate();
      	contentPane.repaint();

        
	}
	private static boolean isPasswordCorrect(char[] input, String View) {
	    boolean isCorrect = true;
	    char[] staffTypeSelectionPassword = { '1', '2', '3', '4' };
	    char[] managerViewPassword = { '1', '1', '1', '1' };
	    char[] userTypeSelectionPassword = { '1', '1', '1', '1' };

	    if(View == "staffTypeSelection"){
		    if (input.length != staffTypeSelectionPassword.length) {
		        isCorrect = false;
		    } else {
		        isCorrect = Arrays.equals (input, staffTypeSelectionPassword);
		    }
		  //Zero out the password.
	 	    Arrays.fill(staffTypeSelectionPassword,'0');
	    }else if(View == "managerView"){
	    	 if (input.length != managerViewPassword.length) {
			        isCorrect = false;
			    } else {
			        isCorrect = Arrays.equals (input, managerViewPassword);
			    }
	    	//Zero out the password.
		 	    Arrays.fill(managerViewPassword,'0');
	    }else if(View == "userTypeSelection"){
	    	 if (input.length != userTypeSelectionPassword.length) {
			        isCorrect = false;
			    } else {
			        isCorrect = Arrays.equals (input, userTypeSelectionPassword);
			    }
	    	//Zero out the password.
	 	    Arrays.fill(userTypeSelectionPassword,'0');
	    }
	    

	    return isCorrect;
	}
    public JPanel returnStaffPasscodeView(){    	
    	
		return staff_Passcode_view;
    }
    
    
	public void load_Staff_Passcode_view(){
    	

    	staff_Passcode_view = new JPanel();
//		contentPane.add(staff_Passcode_view, BorderLayout.CENTER);
		staff_Passcode_view.setLayout(new BorderLayout(0, 0));
		
		panel_back_login = new JPanel();
		staff_Passcode_view.add(panel_back_login, BorderLayout.NORTH);
		panel_back_login.setLayout(new BorderLayout(0, 0));
		
		btnBack_Staff_PasswordView = new JButton("back");
		btnBack_Staff_PasswordView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_back_login.add(btnBack_Staff_PasswordView, BorderLayout.WEST);
		btnBack_Staff_PasswordView.addActionListener(this);
		
				
		btnLogin_Staff_passwordView = new JButton("login");
		btnLogin_Staff_passwordView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_back_login.add(btnLogin_Staff_passwordView, BorderLayout.EAST);
		
		lblPasscode_staff_Passcode = new JLabel("ENTER PASSCODE");
		lblPasscode_staff_Passcode.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblPasscode_staff_Passcode.setHorizontalAlignment(SwingConstants.CENTER);
		panel_back_login.add(lblPasscode_staff_Passcode, BorderLayout.CENTER);
		btnLogin_Staff_passwordView.addActionListener(this);
    	
    	panel = new JPanel();
    	staff_Passcode_view.add(panel, BorderLayout.CENTER);
    	    	panel.setLayout(new GridLayout(0, 1, 0, 0));
    	    	    	
    	    	    	label = new JLabel("");
    	    	    	panel.add(label);
    	    	    	
    	    	    	pwdPasscode_staff_Passcode_txtField = new JPasswordField();
    	    	    	panel.add(pwdPasscode_staff_Passcode_txtField);
    	    	    	pwdPasscode_staff_Passcode_txtField.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	    	    	pwdPasscode_staff_Passcode_txtField.setText("0123456789");
    	    	    	//    	pwdPasscode_staff_Passcode_txtField.setPreferredSize(getPreferredSize());
    	    	    	    	pwdPasscode_staff_Passcode_txtField.setPreferredSize(new Dimension(400, 24));
    	    	    	    	//clear the password field
    	    	    	    	pwdPasscode_staff_Passcode_txtField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	pwdPasscode_staff_Passcode_txtField.setText("");
            }
        });
    	    	    	    	
    	    	    	    	pwdPasscode_staff_Passcode_txtField.addActionListener(new ActionListener() {
    	    	    	    		
    	    	    	    		    public void actionPerformed(ActionEvent e) {
    	    	    	    		
    	    	    	    		        System.out.println("Enter pressed");

    	    	    	    		
    	    	    	    		    }
    	    	    	    		
    	    	    	    		});
    	    	    	
    	    	    	label_1 = new JLabel("");
    	    	    	panel.add(label_1);
    	    	    	
    	    	    	label_2 = new JLabel("");
    	    	    	panel.add(label_2);

    	
    }

}
