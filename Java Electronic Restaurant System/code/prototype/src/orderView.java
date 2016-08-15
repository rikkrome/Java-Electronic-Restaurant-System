
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class orderView implements ActionListener {
	
	private JPanel mainView;
	private JTable table;
	private String tableNumber;
	private JButton btnSubmitOrder,btnBack;

	
	ArrayList<String> result = new ArrayList<String>();
	String name,price,description,health,food_ID;
	private JTable table_submited;

	
	public orderView(String TableNumber){
		
		tableNumber = TableNumber;
		
		table = new JTable();
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table_submited = new JTable();
		table_submited.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		reloadTables();
		
		

		loadView();
		
		
		
	}
	
    public void reloadTables(){   
		ResultSet resultForOrder = null;
		ResultSet resultForsubmited = null;

		try {
			resultForOrder = DataBase.get("orderView","orderFromTable",tableNumber).executeQuery();
			resultForsubmited = DataBase.get("FoodStatus","FoodStatus",tableNumber).executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table.setModel(DbUtils.resultSetToTableModel(resultForOrder));
		table_submited.setModel(DbUtils.resultSetToTableModel(resultForsubmited));

    	
    }
	
	
	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

		if(button == btnSubmitOrder){
			
			
			try {
				DataBase.moveOneItemToOtherTable("OrderQueue", "orderFromTable",tableNumber,"orderView","placed");
				DataBase.moveOneItemToOtherTable("FoodStatus", "orderFromTable",tableNumber,"FoodStatus","placed order");

				DataBase.updateFoodStatus("yes","FoodStatus", "placed order", tableNumber,"");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				DataBase.deleteOneItemFromTable("orderFromTable",tableNumber,"orderView");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DataBase.updateTableStatus("Status","Waiting for Food",tableNumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			reloadTables();
		}else if(button == btnBack){
			
			customerView View = new customerView(tableNumber);
    		JPanel newView = View.returnCustomerView();
    		
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
    
    
    public void  loadView(){
    	
		mainView = new JPanel();

		mainView.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		mainView.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(112, 128, 144));
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		
		scrollPane_1.setViewportView(table_submited);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(112, 128, 144));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnSubmitOrder = new JButton("submit order");
		btnSubmitOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_3.add(btnSubmitOrder);
		btnSubmitOrder.addActionListener(this);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(112, 128, 144));
		mainView.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		 btnBack = new JButton("back");
		 btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_4.add(btnBack, BorderLayout.WEST);
		btnBack.addActionListener(this);
    	
    }
    

}
