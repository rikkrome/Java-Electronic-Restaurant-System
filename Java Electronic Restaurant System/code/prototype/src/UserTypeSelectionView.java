
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

class UserTypeSelectionView  extends JFrame implements ActionListener{
	
	private JPanel UserTypeSelectionView,panel_titleHolder_UserTypeSelection,panel_1
	,panel_buttonHolder_UserTypeSelection;
	private JLabel lbtitle;
	private JButton btnCustomer, btnStaff;
	private JButton btnClose;
	
//	prototype_standard main = new prototype_standard();
	
	public UserTypeSelectionView(){
		
		System.out.print("UserTypeSelectionView\n");


		loadUserTypeSelection();

	}


    public void actionPerformed(ActionEvent ae){

        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

        /*
         * UserTypeSelectionView Actions
         */
        if(button == btnCustomer){
        	
        	
        	selectTableView SelectTableClass= new selectTableView();
    		JPanel selectTableView = SelectTableClass.returnSelectTableView();

//        	customerView customer = new customerView();
//    		JPanel customerView = customer.returnCustomerView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(selectTableView);
        	

        	
        }else if (button == btnStaff){

        	staffPasscodeView staffPasscode = new staffPasscodeView("staffTypeSelection",null);
    		JPanel staffPasscodeView = staffPasscode.returnStaffPasscodeView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(staffPasscodeView);
        	

        }else if (button == btnClose){
        	
        	System.exit(0); //Close program
        	dispose(); //Close window
        	setVisible(false); //Hide window

        }
        
    	// reload the window
    	contentPane.revalidate();
    	contentPane.repaint();
    }
    
    public JPanel returnUserTypeSelectionView(){    	
    	
		return UserTypeSelectionView;
    }
    
    public void loadUserTypeSelection(){


		UserTypeSelectionView = new JPanel();
//		mainPanel.add(UserTypeSelectionView, BorderLayout.CENTER);
		UserTypeSelectionView.setLayout(new BorderLayout(0, 0));

		
		panel_titleHolder_UserTypeSelection = new JPanel();
		panel_titleHolder_UserTypeSelection.setBackground(new Color(112, 128, 144));
		UserTypeSelectionView.add(panel_titleHolder_UserTypeSelection, BorderLayout.NORTH);
		panel_titleHolder_UserTypeSelection.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		panel_titleHolder_UserTypeSelection.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lbtitle = new JLabel("USER TYPE SELECTION");
		lbtitle.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lbtitle.setBackground(new Color(255, 250, 250));
		lbtitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbtitle);
		
		btnClose = new JButton("close");
		btnClose.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		btnClose.setForeground(new Color(0, 0, 0));
		btnClose.setBackground(new Color(0, 153, 255));
		panel_1.add(btnClose, BorderLayout.EAST);
		btnClose.addActionListener(this);

    	panel_buttonHolder_UserTypeSelection = new JPanel();
    	panel_buttonHolder_UserTypeSelection.setBackground(new Color(112, 128, 144));
    	UserTypeSelectionView.add(panel_buttonHolder_UserTypeSelection, BorderLayout.CENTER);
    	panel_buttonHolder_UserTypeSelection.setLayout(new GridLayout(0, 2, 0, 0));
    	
    	btnCustomer = new JButton("customer");
    	btnCustomer.setBackground(new Color(173, 216, 230));
    	btnCustomer.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_buttonHolder_UserTypeSelection.add(btnCustomer);
    	btnCustomer.addActionListener(this);

    	btnStaff = new JButton("staff");
    	btnStaff.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_buttonHolder_UserTypeSelection.add(btnStaff);
    	btnStaff.addActionListener(this);

    }

}
