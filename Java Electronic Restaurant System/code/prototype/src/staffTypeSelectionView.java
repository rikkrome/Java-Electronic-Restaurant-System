
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
public class staffTypeSelectionView extends JFrame implements ActionListener  {
	
	private JPanel staffTypeSelectionView ,panel_northSection , panel_STS_labelHolder ,panel_3_buttonLayout ;
	private JLabel lblStaffTypeSelection  ;
	private JButton btnBack_Staff_type_selection ,btnWaitStaff_StaffTypeSelection ,btnManager_StaffTypeSelection,
	btnKitchenStaff_StaffTypeSelection;
	
	public staffTypeSelectionView(){
		System.out.print("staffTypeSelectionView\n");

		loadStaffTypeSelectionView();
	}
	
	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();


        /*
         * staffTypeSelectionView Actions
         */
        
	     if (button == btnBack_Staff_type_selection){
	    	 
	    	 UserTypeSelectionView userTypeSelection = new UserTypeSelectionView();
	     		JPanel userTypeSelectionView = userTypeSelection.returnUserTypeSelectionView();
	     		
	     	    contentPane.removeAll();
	     	    contentPane.add(userTypeSelectionView);
	     	    

	    	
	    }else if (button == btnWaitStaff_StaffTypeSelection){
	    	selectTableView_WaitStaff SelectTableClass= new selectTableView_WaitStaff();
    		JPanel selectTableView_WaitStaff = SelectTableClass.returnselectTableView_WaitStaff();

//        	customerView customer = new customerView();
//    		JPanel customerView = customer.returnCustomerView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(selectTableView_WaitStaff);
        	

	    	
	    }else if (button == btnManager_StaffTypeSelection){
	    	staffPasscodeView staffPasscode = new staffPasscodeView("managerView",null);
    		JPanel staffPasscodeView = staffPasscode.returnStaffPasscodeView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(staffPasscodeView);
        	

	    	
	    }else if (button == btnKitchenStaff_StaffTypeSelection){
	    	kitchenStaffView kitchenStaff = new kitchenStaffView();
    		JPanel kitchenStaffView = kitchenStaff.returnKitchenStaffView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(kitchenStaffView);

	    }
	     
  	    // reload the window
      	contentPane.revalidate();
      	contentPane.repaint();
		
	}
	
    public JPanel returnStaffTypeSelectionView(){    	
    	
		return staffTypeSelectionView;
    }
	
    public void loadStaffTypeSelectionView(){

    	staffTypeSelectionView = new JPanel();
//    	contentPane.add(staffTypeSelectionView, BorderLayout.CENTER);
    	staffTypeSelectionView.setLayout(new BorderLayout(0, 0));
    	
    	panel_northSection = new JPanel();
    	staffTypeSelectionView.add(panel_northSection, BorderLayout.NORTH);
    	panel_northSection.setLayout(new BorderLayout(0, 0));
    	
    	btnBack_Staff_type_selection = new JButton("back");
    	btnBack_Staff_type_selection.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_northSection.add(btnBack_Staff_type_selection, BorderLayout.WEST);
    	
    	panel_STS_labelHolder = new JPanel();
    	panel_northSection.add(panel_STS_labelHolder, BorderLayout.CENTER);
    	
    	    	
    	lblStaffTypeSelection = new JLabel("staff type selection");
    	lblStaffTypeSelection.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_STS_labelHolder.add(lblStaffTypeSelection);
    	btnBack_Staff_type_selection.addActionListener(this);
    	
    	panel_3_buttonLayout = new JPanel();
    	staffTypeSelectionView.add(panel_3_buttonLayout, BorderLayout.CENTER);
    	panel_3_buttonLayout.setLayout(new GridLayout(0, 3, 0, 0));
    	
    	btnWaitStaff_StaffTypeSelection = new JButton("wait staff");
    	btnWaitStaff_StaffTypeSelection.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_3_buttonLayout.add(btnWaitStaff_StaffTypeSelection);
    	btnWaitStaff_StaffTypeSelection.addActionListener(this);

    	btnManager_StaffTypeSelection = new JButton("manager");
    	btnManager_StaffTypeSelection.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_3_buttonLayout.add(btnManager_StaffTypeSelection);
    	btnManager_StaffTypeSelection.addActionListener(this);

    	btnKitchenStaff_StaffTypeSelection = new JButton("kitchen staff");
    	btnKitchenStaff_StaffTypeSelection.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_3_buttonLayout.add(btnKitchenStaff_StaffTypeSelection);
    	btnKitchenStaff_StaffTypeSelection.addActionListener(this);

    }
}
