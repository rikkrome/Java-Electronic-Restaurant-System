
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class CustomerBilling implements ActionListener {
	
	private JPanel mainView;
	private JTable table;
	private String tableNumber;
	private JButton btnCash,btnBack,btnCard;
	private JLabel lblTotal;
	private String total;
	public CustomerBilling(String TableNumber){
		
		tableNumber = TableNumber;

		
		table = new JTable();
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		reloadTables();
		
		loadView();
		
		
		
	}
	   public void reloadTables(){   
			ResultSet resultForOrder = null;

			try {
				resultForOrder = DataBase.get("billingView","billing",tableNumber).executeQuery();
				total = DataBase.getSUMofBill(tableNumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			table.setModel(DbUtils.resultSetToTableModel(resultForOrder));

	    	
	    }
	
	   public void actionPerformed(ActionEvent ae){
	        JButton button = (JButton) ae.getSource();
			JPanel contentPane = prototype_standard.returnContentPaneView();

			if(button == btnCash){
				
				try {
					DataBase.updateTableStatus("help","yes",tableNumber);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         JOptionPane.showMessageDialog(null,
		        		    "Somebody will be here to assist you shortly.");
		         
		         
				SurveyView survey = new SurveyView(tableNumber);
	    		JPanel surveyView = survey.returnSurveyView();
	    		
	        	contentPane.removeAll();
	        	contentPane.add(surveyView); 
				
			
			}else if(button == btnCard){
				
				payCardView View = new payCardView(tableNumber);
	    		JPanel newView = View.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
				
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
		
		btnCard = new JButton("card");
		btnCard.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_2.add(btnCard, BorderLayout.CENTER);
		btnCard.addActionListener(this);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(112, 128, 144));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnCash = new JButton("cash");
		btnCash.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_3.add(btnCash);
		btnCash.addActionListener(this);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(112, 128, 144));
		mainView.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		 btnBack = new JButton("back");
		 btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_4.add(btnBack, BorderLayout.WEST);
		
		lblTotal = new JLabel("total $"+total);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_4.add(lblTotal, BorderLayout.EAST);
		btnBack.addActionListener(this);
    	
    }

}
