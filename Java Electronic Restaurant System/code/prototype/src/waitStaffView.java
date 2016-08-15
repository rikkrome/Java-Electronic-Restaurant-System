
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class waitStaffView extends JFrame implements ActionListener {
	
	private JPanel waitStaffView , panel_northSection ,panel_STS_labelHolder,panel_3_buttonLayout  ;
	private JButton btnBack_WaitStaffView,btnOrder_WaitStaffView , btnCompItem_WaitStaffView, btnTables_WaitStaffView ;
	private JLabel lblWaitStaffView;
	private String tableNumber,mainView;
	
	
	public waitStaffView(String TableNumber){
		System.out.print("loaded waitStaffView: "+TableNumber+"\n");
		tableNumber = TableNumber;
		loadWaitStaffView();
	}

	
    public void actionPerformed(ActionEvent ae){

        JButton button = (JButton) ae.getSource();
        JPanel contentPane = prototype_standard.returnContentPaneView();
        /*
         * Wait Staff buttons
         */
        if (button == btnBack_WaitStaffView){
        	
        	staffTypeSelectionView staffTypeSelection = new staffTypeSelectionView();
        	JPanel GoBackToView = staffTypeSelection.returnStaffTypeSelectionView();
        	
     	    contentPane.removeAll();
     	    contentPane.add(GoBackToView);

        	
        }else if (button == btnOrder_WaitStaffView){
        	MenuView view = new MenuView(tableNumber,"waitStaff");
    		JPanel newView = view.returnMenuView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(newView);
        	
        }else if (button == btnTables_WaitStaffView){
        	changeStatus statusClass = new changeStatus(tableNumber,"waiter");
    		JPanel changeStatusView = statusClass.returnChangeStatus();
    		
	    	contentPane.removeAll();
    	    contentPane.add(changeStatusView);
        	
        }else if (button == btnCompItem_WaitStaffView){
        	CompItemView view = new CompItemView(tableNumber,"waitStaffView");
    		JPanel newView = view.returnView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(newView);
        }
        
        // reload the window
     	contentPane.revalidate();
     	contentPane.repaint();
    	
        
    }
    
    public JPanel returnWaitStaffView(){    	
    	
		return waitStaffView;
    }
	
    public void loadWaitStaffView(){


    	waitStaffView = new JPanel();
//    	contentPane.add(waitStaffView, BorderLayout.CENTER);
    	waitStaffView.setLayout(new BorderLayout(0, 0));
    	
    	panel_northSection = new JPanel();
    	waitStaffView.add(panel_northSection, BorderLayout.NORTH);
    	panel_northSection.setLayout(new BorderLayout(0, 0));
    	
    	btnBack_WaitStaffView = new JButton("back");
    	panel_northSection.add(btnBack_WaitStaffView, BorderLayout.WEST);
    	
    	panel_STS_labelHolder = new JPanel();
    	panel_northSection.add(panel_STS_labelHolder, BorderLayout.SOUTH);
    	
    	    	
    	lblWaitStaffView = new JLabel("Wait Staff View");
    	panel_STS_labelHolder.add(lblWaitStaffView);
    	btnBack_WaitStaffView.addActionListener(this);
    	
    	panel_3_buttonLayout = new JPanel();
    	waitStaffView.add(panel_3_buttonLayout, BorderLayout.CENTER);
    	panel_3_buttonLayout.setLayout(new GridLayout(0, 3, 0, 0));
    	
    	btnOrder_WaitStaffView = new JButton("Order");
    	panel_3_buttonLayout.add(btnOrder_WaitStaffView);
    	btnOrder_WaitStaffView.addActionListener(this);

    	btnTables_WaitStaffView = new JButton("Change Table Status");
    	panel_3_buttonLayout.add(btnTables_WaitStaffView);
    	btnTables_WaitStaffView.addActionListener(this);

    	btnCompItem_WaitStaffView = new JButton("Comp Item");
    	panel_3_buttonLayout.add(btnCompItem_WaitStaffView);
    	btnCompItem_WaitStaffView.addActionListener(this);
    }
    
    
    
}
