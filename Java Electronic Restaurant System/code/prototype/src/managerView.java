
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class managerView extends JFrame implements ActionListener{
	
	private JPanel managerView , panel_northSection , panel_STS_labelHolder,
	panel_5_buttonLayout;
	
	private JButton btnBack_ManagerView, btnViewMenu_ManagerView, btnOrder_ManagerView,
	btnChangeStatus_ManagerView, btnComp_Items_ManagerView, btnReports_ManagerView;
	private String tableNumber;
	private JLabel  lblManagerView;
	
	public managerView(String TableNumber){
		System.out.print("loaded managerView: "+TableNumber+"\n");
		tableNumber = TableNumber;

		loadManagerView();
	}
	
	
	
	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
    	JPanel contentPane = prototype_standard.returnContentPaneView();

        /*
         * managerView actions
         * need to add another password panel
         * here
         */
        if (button == btnBack_ManagerView){
        	staffTypeSelectionView staffTypeSelection = new staffTypeSelectionView();
        	JPanel GoBackToView = staffTypeSelection.returnStaffTypeSelectionView();
     	    contentPane.removeAll();
     	    contentPane.add(GoBackToView);

     	    
        }else if (button == btnViewMenu_ManagerView){
        	//contentPane.removeAll();
        	//get the menu
        	
        }else if (button == btnOrder_ManagerView){
        	MenuView view = new MenuView(tableNumber,"managerView");
    		JPanel newView = view.returnMenuView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(newView);
        	
        }else if (button == btnChangeStatus_ManagerView){
        	changeStatus statusClass = new changeStatus(tableNumber,"manager");
    		JPanel changeStatusView = statusClass.returnChangeStatus();
    		
	    	contentPane.removeAll();
    	    contentPane.add(changeStatusView);
        	
        }else if (button == btnComp_Items_ManagerView){
        	
        	CompItemView view = new CompItemView(tableNumber,"managerView");
    		JPanel newView = view.returnView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(newView);
        	
        }else if (button == btnReports_ManagerView){
        	interfaceView view = new interfaceView(tableNumber);
    		JPanel newView = view.returnView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(newView);
        }
        
  	   // reload the window
     	contentPane.revalidate();
     	contentPane.repaint();
        
	}
    public JPanel returnManagerView(){    	
    	
		return managerView;
    }
	
    public void loadManagerView(){

    	managerView = new JPanel();
//    	contentPane.add(managerView, BorderLayout.CENTER);
    	managerView.setLayout(new BorderLayout(0, 0));
    	
    	panel_northSection = new JPanel();
    	managerView.add(panel_northSection, BorderLayout.NORTH);
    	panel_northSection.setLayout(new BorderLayout(0, 0));
    	
    	btnBack_ManagerView = new JButton("back");
    	panel_northSection.add(btnBack_ManagerView, BorderLayout.WEST);
    	
    	panel_STS_labelHolder = new JPanel();
    	panel_northSection.add(panel_STS_labelHolder, BorderLayout.SOUTH);
    	
    	    	
    	lblManagerView = new JLabel("Manager View");
    	panel_STS_labelHolder.add(lblManagerView);
    	btnBack_ManagerView.addActionListener(this);
    	
    	panel_5_buttonLayout = new JPanel();
    	managerView.add(panel_5_buttonLayout, BorderLayout.CENTER);
    	panel_5_buttonLayout.setLayout(new GridLayout(0, 3, 0, 0));
    	
    	btnViewMenu_ManagerView = new JButton("View Menu");
    	panel_5_buttonLayout.add(btnViewMenu_ManagerView);
    	btnViewMenu_ManagerView.addActionListener(this);
    	
    	btnOrder_ManagerView = new JButton("Order");
    	panel_5_buttonLayout.add(btnOrder_ManagerView);
    	btnOrder_ManagerView.addActionListener(this);
    	
    	btnChangeStatus_ManagerView = new JButton("Change Table Status");
    	panel_5_buttonLayout.add(btnChangeStatus_ManagerView);
    	btnChangeStatus_ManagerView.addActionListener(this);
    	
    	btnComp_Items_ManagerView = new JButton("Comp Items");
    	panel_5_buttonLayout.add(btnComp_Items_ManagerView);
    	btnComp_Items_ManagerView.addActionListener(this);
    	
    	btnReports_ManagerView = new JButton("Reports");
    	panel_5_buttonLayout.add(btnReports_ManagerView);
    	btnReports_ManagerView.addActionListener(this);    	
    	
    }
    

}
