
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.sql.PreparedStatement;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class KitchenOrderQueueView implements ActionListener{
	
	private JPanel kitchenOrderQueueView;
	private JTable OrderQueueTable;
	private JPanel MenuBarpanel;
	private JButton btnBack;
	private JScrollPane scrollPane_1;
	private JTable cookingTable;
	private JPanel panel;
	private JButton btnDelete;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnClaim;
	private JPanel panel_3;
	private JButton btnReady;
	private JPanel panel_4;
	private JPanel Southpanel;
	private JPanel panel_5;
	private JScrollPane scrollPane_2;
	private JTable ReadyTable;
	private JPanel South_panel;
	private JPanel North_panel;
	private JLabel lblReady;
	private JLabel lblCooking;
	private JPanel panel_6;
	private JButton btnBackToQueue;
	private JPanel panel_7;
	private JButton btnBackToCooking;
	private JLabel label;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JLabel label_1;
	private JLabel lblNewLabel;
	public KitchenOrderQueueView(){
		
		kitchenOrderQueueView = new JPanel();
		
		

	    
		PreparedStatement get = null;



		
		
		OrderQueueTable = new JTable();		
		cookingTable = new JTable();
		ReadyTable = new JTable();
		
		reloadTables();
		
		loadKitchenOrderQueueView();


	}
    public void reloadTables(){   
		ResultSet resultForOrderQueue = null;
		ResultSet resultForCookingQueue = null;
		ResultSet resultForReadyQueue = null;

    	
		try {
			resultForOrderQueue = DataBase.get("kitchen","OrderQueue","").executeQuery();
			resultForCookingQueue = DataBase.get("kitchen","cooking","").executeQuery();
			resultForReadyQueue = DataBase.get("kitchen","kitchenReady","").executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OrderQueueTable.setModel(DbUtils.resultSetToTableModel(resultForOrderQueue));
		cookingTable.setModel(DbUtils.resultSetToTableModel(resultForCookingQueue));
		ReadyTable.setModel(DbUtils.resultSetToTableModel(resultForReadyQueue));

    }
	
	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();
		
		if(button == btnBack){
			kitchenStaffView kitchenStaff = new kitchenStaffView();
	         JPanel GoBackToView = kitchenStaff.returnKitchenStaffView();
	      	contentPane.removeAll();
	        contentPane.add(GoBackToView);
	        
	        
	        
		}else if(button == btnClaim){
			ArrayList<String> result = new ArrayList<String>();
			String id;
			
			
			try {
				DataBase.moveOneItemToOtherTable("cooking", "OrderQueue","","kitchen","cooking");

				reloadTables();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			try {
			
				result = DataBase.getArrayOneItemFromKitReadyQueue("OrderQueue");
				id = result.get(0);
				DataBase.updateFoodStatus("no","FoodStatus", "cooking", "",id);


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				DataBase.deleteOneItemFromTable("OrderQueue","","kitchen");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			
			
		}else if(button == btnReady){
			
			String id = "",foodID,Tbnumber, foodName,comment,price,status;
			ArrayList<String> resultFC = new ArrayList<String>();
			ArrayList<String> resultPrice= new ArrayList<String>();
			
			try {
				DataBase.moveOneItemToOtherTable("kitchenReady", "cooking","","kitchen","ready");
								
				
				resultFC = DataBase.getArrayOneItemFromKitReadyQueue("cooking");
				
				id = resultFC.get(0);
				foodID = resultFC.get(1);
				Tbnumber = resultFC.get(2);
				foodName = resultFC.get(3);
				comment = resultFC.get(4);
				
				resultPrice = DataBase.getItembyID(foodID, "MenuDB");
				price = resultPrice.get(1);
				
				status = "unpaid";
				System.out.println(id+" "+Tbnumber+" "+foodName+" "+comment+" "+price+" "+status+"\n");
				
				DataBase.moveOneItemfromKitchenToBilling(foodID,Tbnumber,foodName,comment,price,status);
				DataBase.deleteOneItemFromTable("cooking","","kitchen");
				
				
				
				reloadTables();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				DataBase.updateFoodStatus("no","FoodStatus", "ready", "",id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			id = "";
			Tbnumber = "";
			foodName = "";
			comment = "";
			
			
		}else if(button == btnBackToQueue){
			try {
				DataBase.moveOneItemToOtherTable("OrderQueue", "cooking","","kitchen","Placed");
				DataBase.deleteOneItemFromTable("cooking","","kitchen");
				reloadTables();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(button == btnBackToCooking){
			try {
				DataBase.moveOneItemToOtherTable("cooking", "kitchenReady","","kitchen","cooking");
				DataBase.deleteOneItemFromTable("kitchenReady","","kitchen");
				DataBase.deleteOneItemFromTable("billing","","kitchen");

				reloadTables();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
    	// reload the window
    	contentPane.revalidate();
    	contentPane.repaint();
    	
	}

    public JPanel returnKitchenOrderQueueView(){    	
    	
		return kitchenOrderQueueView;
    }
    
    public void loadKitchenOrderQueueView(){

		kitchenOrderQueueView.setLayout(new BorderLayout(0, 0));
		
		MenuBarpanel = new JPanel();
		kitchenOrderQueueView.add(MenuBarpanel, BorderLayout.NORTH);
		MenuBarpanel.setLayout(new BorderLayout(0, 0));
		
		btnBack = new JButton("back");
		MenuBarpanel.add(btnBack, BorderLayout.WEST);
		btnBack.addActionListener(this);

		panel_1 = new JPanel();
		kitchenOrderQueueView.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.WEST);
		
		
		scrollPane.setViewportView(OrderQueueTable);
		
		panel = new JPanel();
		panel_1.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
								
								panel_12 = new JPanel();
								panel.add(panel_12, BorderLayout.CENTER);
								panel_12.setLayout(new GridLayout(0, 1, 0, 0));
								
								panel_13 = new JPanel();
								panel_12.add(panel_13);
								panel_13.setLayout(new GridLayout(0, 3, 0, 0));
								
								lblNewLabel = new JLabel("          ");
								panel_13.add(lblNewLabel);
								
								panel_2 = new JPanel();
								panel_13.add(panel_2);
								panel_2.setLayout(new GridLayout(0, 1, 0, 0));
								
								btnClaim = new JButton("claim");
								panel_2.add(btnClaim);
								
								label_1 = new JLabel("          ");
								panel_13.add(label_1);
								btnClaim.addActionListener(this);
								
								panel_9 = new JPanel();
								panel_12.add(panel_9);
								panel_9.setLayout(new BorderLayout(0, 0));
								
								panel_10 = new JPanel();
								panel_9.add(panel_10, BorderLayout.WEST);
								panel_10.setLayout(new GridLayout(1, 0, 0, 0));
								
										btnBackToQueue = new JButton("back to queue");
										panel_10.add(btnBackToQueue);
										
										panel_11 = new JPanel();
										panel_9.add(panel_11, BorderLayout.EAST);
										panel_11.setLayout(new GridLayout(0, 1, 0, 0));
										
										btnBackToCooking = new JButton("back to cooking");
										panel_11.add(btnBackToCooking);
								btnBackToCooking.addActionListener(this);
						btnBackToQueue.addActionListener(this);

		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnReady = new JButton("ready");
		panel_6.add(btnReady);
		btnReady.addActionListener(this);
		
		label = new JLabel("");
		panel_4.add(label);
		
		panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));

		panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.WEST);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		South_panel = new JPanel();
		panel_5.add(South_panel, BorderLayout.SOUTH);
		South_panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane_2 = new JScrollPane();
		South_panel.add(scrollPane_2, BorderLayout.CENTER);
		
		
		scrollPane_2.setViewportView(ReadyTable);
		
		lblReady = new JLabel("ready");
		South_panel.add(lblReady, BorderLayout.NORTH);
		lblReady.setHorizontalAlignment(SwingConstants.CENTER);
		
		North_panel = new JPanel();
		panel_5.add(North_panel, BorderLayout.NORTH);
		North_panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		North_panel.add(scrollPane_1, BorderLayout.CENTER);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		scrollPane_1.setViewportView(cookingTable);
		
		lblCooking = new JLabel("cooking");
		lblCooking.setHorizontalAlignment(SwingConstants.CENTER);
		North_panel.add(lblCooking, BorderLayout.NORTH);
		
		Southpanel = new JPanel();
		panel_1.add(Southpanel, BorderLayout.SOUTH);
		Southpanel.setLayout(new BorderLayout(0, 0));
		
		btnDelete = new JButton("delete");
		Southpanel.add(btnDelete, BorderLayout.WEST);
		
		panel_8 = new JPanel();
		panel_1.add(panel_8, BorderLayout.NORTH);
		btnDelete.addActionListener(this);

    }
	
}
