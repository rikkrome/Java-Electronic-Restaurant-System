
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class selectTableView_WaitStaff implements ActionListener{
	
	private JPanel selectTableView_WaitStaff;
	private JButton btnTable1,btnTable2,btnTable3,btnTable4,btnTable5,btnTable6;
	private String table1Status,table1Refill,table1Help,table2Status,table2Refill,table2Help;
	private String table3Status,table3Refill,table3Help,table4Status,table4Refill,table4Help;
	private String table5Status,table5Refill,table5Help,table6Status,table6Refill,table6Help;
	
	public selectTableView_WaitStaff(){
		downloadStatus();
		selectTableView_WaitStaff();
	
		
	}
	
	public void actionPerformed(ActionEvent ae){
	    JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

	    if(button == btnTable1){
	    	waitStaffView waitStaffClass = new waitStaffView("1");
    		JPanel customerView = waitStaffClass.returnWaitStaffView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
    	    
	    }else if(button == btnTable2){
	    	waitStaffView waitStaffClass = new waitStaffView("2");
    		JPanel customerView = waitStaffClass.returnWaitStaffView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);

	    }else if(button == btnTable3){
	    	
	    	waitStaffView waitStaffClass = new waitStaffView("3");
    		JPanel customerView = waitStaffClass.returnWaitStaffView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
	    	
	    }else if(button == btnTable4){
	    	
	    	waitStaffView waitStaffClass = new waitStaffView("4");
    		JPanel customerView = waitStaffClass.returnWaitStaffView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
	    	
	    }else if(button == btnTable5){
	    	
	    	waitStaffView waitStaffClass = new waitStaffView("5");
    		JPanel customerView = waitStaffClass.returnWaitStaffView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
	    	
	    }else if(button == btnTable6){
	    	
	    	waitStaffView waitStaffClass = new waitStaffView("6");
    		JPanel customerView = waitStaffClass.returnWaitStaffView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
	    	
	    }
	    
	 // reload the window
    	contentPane.revalidate();
    	contentPane.repaint();
	}
    public JPanel returnselectTableView_WaitStaff(){    	
    	
		return selectTableView_WaitStaff;
    }
	
	public void selectTableView_WaitStaff(){
		selectTableView_WaitStaff = new JPanel();
		selectTableView_WaitStaff.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel Westpanel = new JPanel();
		selectTableView_WaitStaff.add(Westpanel);
		Westpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		 btnTable1 = new JButton("[ Table 1  - " +table1Status+ " ] Refill: " +table1Refill+ " - Help: " +table1Help);
		Westpanel.add(btnTable1);
		btnTable1.addActionListener(this);

		 btnTable4 = new JButton("[ Table 4  - " +table4Status+ " ] Refill: " +table4Refill+ " - Help: " +table4Help);
		Westpanel.add(btnTable4);
		btnTable4.addActionListener(this);

		JPanel Centerpanel = new JPanel();
		selectTableView_WaitStaff.add(Centerpanel);
		Centerpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		 btnTable2 = new JButton("[ Table 2  - " +table2Status+ " ] Refill: " +table2Refill+ " - Help: " +table2Help);
		Centerpanel.add(btnTable2);
		btnTable2.addActionListener(this);

		 btnTable5 = new JButton("[ Table 5  - " +table5Status+ " ] Refill: " +table5Refill+ " - Help: " +table5Help);
		Centerpanel.add(btnTable5);
		btnTable5.addActionListener(this);

		JPanel Eastpanel = new JPanel();
		selectTableView_WaitStaff.add(Eastpanel);
		Eastpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		 btnTable3 = new JButton("[ Table 3  - " +table3Status+ " ] Refill: " +table3Refill+ " - Help: " +table3Help);
		Eastpanel.add(btnTable3);
		btnTable3.addActionListener(this);

		 btnTable6 = new JButton("[ Table 6  - " +table6Status+ " ] Refill: " +table6Refill+ " - Help: " +table6Help);
		Eastpanel.add(btnTable6);
		btnTable6.addActionListener(this);

	}
	public void downloadStatus(){
		//get table 1
		ArrayList<String> table1 = new ArrayList<String>();
		ArrayList<String> table2 = new ArrayList<String>();
		ArrayList<String> table3 = new ArrayList<String>();
		ArrayList<String> table4 = new ArrayList<String>();
		ArrayList<String> table5 = new ArrayList<String>();
		ArrayList<String> table6 = new ArrayList<String>();
		try {
			table1 = DataBase.getItemStatus("1");
			table2 = DataBase.getItemStatus("2");
			table3 = DataBase.getItemStatus("3");
			table4 = DataBase.getItemStatus("4");
			table5 = DataBase.getItemStatus("5");
			table6 = DataBase.getItemStatus("6");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get table 1
		table1Status = table1.get(0);
		table1Refill = table1.get(1);
		table1Help = table1.get(2);
		//get table 2
		table2Status = table2.get(0);
		table2Refill = table2.get(1);
		table2Help = table2.get(2);
		//get table 3
		table3Status = table3.get(0);
		table3Refill = table3.get(1);
		table3Help = table3.get(2);
		//get table 4
		table4Status = table4.get(0);
		table4Refill = table4.get(1);
		table4Help = table4.get(2);
		//get table 5
		table5Status = table5.get(0);
		table5Refill = table5.get(1);
		table5Help = table5.get(2);
		//get table 6
		table6Status = table6.get(0);
		table6Refill = table6.get(1);
		table6Help = table6.get(2);


		
	}
	
}


