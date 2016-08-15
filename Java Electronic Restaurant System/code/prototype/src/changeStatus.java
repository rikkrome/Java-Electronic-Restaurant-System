
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class changeStatus  implements ActionListener{
	
	
	private JPanel changeStatus,panel_holdsButtons,panel_west,panel_center,panel_east,
	panel_north;
	private JButton btnOpen,btnEating,btnReading_menu,btnWaiting,btnback_changeStatus;
	private JLabel lblChangeStatus;
	private String tableNumber;
	private String lastPanel;
	private JButton btnHelp;
	private JButton btnPaid;
	
	
	public changeStatus(String TableNumber,String LastPanel){
		
		System.out.print("loaded changeStatus: "+TableNumber+"\n");
		tableNumber = TableNumber;
		lastPanel = LastPanel;

		loadchangeStatus();
	}
	
    public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

    	/*
         * changeStatus Actions
    	 */
    	if (button == btnback_changeStatus){
    		//if coming from waiter
    		if(lastPanel == "waiter"){
	    	    waitStaffView waitStaff = new waitStaffView(tableNumber);
	    		JPanel waitStaffView = waitStaff.returnWaitStaffView();
	    		
	        	contentPane.removeAll();
	        	contentPane.add(waitStaffView);
    		}
    		//if coming from manager
    		if(lastPanel == "manager"){
        	    managerView managerView = new managerView(tableNumber);
        		JPanel manView = managerView.returnManagerView();
        		
            	contentPane.removeAll();
            	contentPane.add(manView);
        	}
    	
    	}
    	else if (button == btnOpen){
        		
    	try {
			DataBase.updateTableStatus("Status","Open",tableNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	JOptionPane.showMessageDialog(null,
    		    "Table " + tableNumber +  " set to Open");
    	    

        	
        }else if (button == btnEating){
        try {
    		DataBase.updateTableStatus("Status","Eating",tableNumber);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        JOptionPane.showMessageDialog(null,
    		    "Table " + tableNumber +  " set to Eating");
        	
        }else if (button == btnReading_menu){

        try {
			DataBase.updateTableStatus("Status","Reading Menu",tableNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JOptionPane.showMessageDialog(null,
    		    "Table " + tableNumber +  " set to Reading Menu");
        
        }else if (button == btnHelp){
        	try {
    			DataBase.updateTableStatus("help","no",tableNumber);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	try {
    			DataBase.updateTableStatus("refill","no",tableNumber);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	JOptionPane.showMessageDialog(null,
        		    "Table " + tableNumber +  " help/refill fulfilled");
        	
        }else if (button == btnWaiting){
        	
        	try {
			DataBase.updateTableStatus("Status","Waiting for Food",tableNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	JOptionPane.showMessageDialog(null,
        		    "Table " + tableNumber +  " set to Waiting for Food");
        	
        }else if (button == btnPaid){
        	try {
    			DataBase.updateTableStatus("Status","Paid",tableNumber);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	JOptionPane.showMessageDialog(null,
        		    "Table " + tableNumber +  " set to Paid");
        }
    	
    	 // reload the window
    	contentPane.revalidate();
    	contentPane.repaint();

    	
    }
    
    public JPanel returnChangeStatus(){    	
    	
		return changeStatus;
    }
	public void loadchangeStatus(){

    	changeStatus = new JPanel();
//    	contentPane.add(changeStatus, BorderLayout.CENTER);
    	changeStatus.setLayout(new BorderLayout(0, 0));
    	
    	panel_holdsButtons = new JPanel();
    	changeStatus.add(panel_holdsButtons, BorderLayout.CENTER);
    	panel_holdsButtons.setLayout(new GridLayout(0, 3, 0, 0));
    	
    	panel_west = new JPanel();
    	panel_west.setBackground(new Color(112, 128, 144));
    	panel_holdsButtons.add(panel_west);
    	panel_west.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	btnOpen = new JButton("Open");
    	btnOpen.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_west.add(btnOpen);
    	btnOpen.addActionListener(this);

    	btnEating = new JButton("Eating");
    	btnEating.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_west.add(btnEating);
    	btnEating.addActionListener(this);
    	
    	panel_center = new JPanel();
    	panel_center.setBackground(new Color(112, 128, 144));
    	panel_holdsButtons.add(panel_center);
    	panel_center.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	btnReading_menu = new JButton("Reading Menu");
    	btnReading_menu.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_center.add(btnReading_menu);
    	btnReading_menu.addActionListener(this);
    	
    	btnPaid = new JButton("Paid");
    	btnPaid.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_center.add(btnPaid);
    	btnPaid.addActionListener(this);

    	panel_east = new JPanel();
    	panel_holdsButtons.add(panel_east);
    	panel_east.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	btnWaiting = new JButton("Place Order/Waiting");
    	btnWaiting.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_east.add(btnWaiting);
    	btnWaiting.addActionListener(this);
    	
    	btnHelp = new JButton("Help/Refill Fulfilled");
    	btnHelp.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_east.add(btnHelp);
    	btnHelp.addActionListener(this);

    	panel_north = new JPanel();
    	changeStatus.add(panel_north, BorderLayout.NORTH);
    	panel_north.setLayout(new BorderLayout(0, 0));
    	
    	btnback_changeStatus = new JButton("back");
    	btnback_changeStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_north.add(btnback_changeStatus, BorderLayout.WEST);
    	btnback_changeStatus.addActionListener(this);

    	lblChangeStatus = new JLabel("Change Status");
    	lblChangeStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	lblChangeStatus.setHorizontalAlignment(SwingConstants.CENTER);
    	panel_north.add(lblChangeStatus, BorderLayout.CENTER);
    	

    }



}
