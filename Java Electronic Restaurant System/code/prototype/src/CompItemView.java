
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class CompItemView implements ActionListener{
	
	private JPanel mainView;
	private JTable table;
	private String tableNumber;
	private JButton btnSubmitOrder,btnBack;
	private JTextField txtIdNumber;
	private JTextField txtName;
	private JTextField txtDescription;
	private String billAmount;
	private JLabel lblAlert;
	private JPanel newView;
	public CompItemView(String TableNumber,String ViewFrom){
		
		if(ViewFrom == "managerView"){
			managerView View = new managerView(tableNumber);
			newView = View.returnManagerView();
		}else if(ViewFrom == "waitStaffView"){
		
			waitStaffView View = new waitStaffView(tableNumber);
			newView = View.returnWaitStaffView();
		}
		tableNumber = TableNumber;
		table = new JTable();

		reloadTables();
		
		
		loadView();


	}
	 public void reloadTables(){   
			ResultSet resultForOrder = null;
			String resultSUMAmount = "";

			try {
				resultForOrder = DataBase.get("CompView","billing",tableNumber).executeQuery();
				resultSUMAmount = DataBase.getSUMofBill(tableNumber);
				System.out.print(resultSUMAmount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			table.setModel(DbUtils.resultSetToTableModel(resultForOrder));
			if(resultSUMAmount != null){
				billAmount = resultSUMAmount;
			}
	    }
	 
		public void actionPerformed(ActionEvent ae){
	        JButton button = (JButton) ae.getSource();
			JPanel contentPane = prototype_standard.returnContentPaneView();

			if(button == btnSubmitOrder){
				
				ArrayList<String> foodData = new ArrayList<String>();
				String foodName = "";
				String price = "";
				String id = txtIdNumber.getText();
				String name = txtName.getText();
				String des = txtDescription.getText();
				

					try {
						System.out.println("getText "+txtIdNumber.getText());
					
						foodData = DataBase.getItembyIDBilling(id);
						System.out.println("foodData loaded");

						foodName = foodData.get(0);
						price = foodData.get(1);
						
						System.out.println("data: "+foodName+" "+price);

						DataBase.postToComp(id, name, foodName, price, des);
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						DataBase.deleteOneItemFromTable("",id, "CompView");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					lblAlert.setText("Removed From Bill");
					txtIdNumber.setText("");
					txtDescription.setText("");
					txtName.setText("");

					reloadTables();
			
			}else if(button == btnBack){
				
				
	    	
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
			panel_1.add(panel_2);
			panel_2.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel lblItemNumber = new JLabel("Item Number:");
			lblItemNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			panel_2.add(lblItemNumber);
			
			txtIdNumber = new JTextField();
			txtIdNumber.setText("ID Number");
			panel_2.add(txtIdNumber);
			txtIdNumber.setColumns(10);
			txtIdNumber.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	            	txtIdNumber.setText("");
	            }
	        });
			
			JLabel lblWaitStaffName = new JLabel("Wait Staff Name:");
			lblWaitStaffName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			panel_2.add(lblWaitStaffName);
			
			txtName = new JTextField();
			txtName.setText("name");
			panel_2.add(txtName);
			txtName.setColumns(10);
			txtName.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	            	txtName.setText("");
	            }
	        });
			
			JPanel panel_3 = new JPanel();
			panel_1.add(panel_3);
			panel_3.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel lblCompDescription = new JLabel("Comp Description");
			lblCompDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			panel_3.add(lblCompDescription);
			
			txtDescription = new JTextField();
			txtDescription.setText("description");
			panel_3.add(txtDescription);
			txtDescription.setColumns(10);
			txtDescription.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	            	txtDescription.setText("");
	            }
	        });
			
			JLabel label = new JLabel("");
			panel_3.add(label);
			
			btnSubmitOrder = new JButton("submit comp");
			btnSubmitOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			panel_3.add(btnSubmitOrder);
			btnSubmitOrder.addActionListener(this);

			JPanel panel_4 = new JPanel();
			mainView.add(panel_4, BorderLayout.NORTH);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			 btnBack = new JButton("back");
			panel_4.add(btnBack, BorderLayout.WEST);
			
			JLabel label_1 = new JLabel("$"+billAmount);
			label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			panel_4.add(label_1, BorderLayout.SOUTH);
			
			lblAlert = new JLabel("");
			panel_4.add(lblAlert, BorderLayout.EAST);
			btnBack.addActionListener(this);
	    	
	    }

}
