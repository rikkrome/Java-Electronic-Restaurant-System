
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

public class selectTableView implements ActionListener{
	
	private JPanel selectTableView;
	private JButton btnTable1,btnTable2,btnTable3,btnTable4,btnTable5,btnTable6;
	
	public selectTableView(){
		
		selectTableView();
	
		
	}
	
	public void actionPerformed(ActionEvent ae){
	    JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

	    if(button == btnTable1){
	    	customerView customerClass = new customerView("1");
    		JPanel customerView = customerClass.returnCustomerView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
    	    
	    }else if(button == btnTable2){
	    	customerView customerClass = new customerView("2");
    		JPanel customerView = customerClass.returnCustomerView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);

	    }else if(button == btnTable3){
	    	
	    	customerView customerClass = new customerView("3");
    		JPanel customerView = customerClass.returnCustomerView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
	    	
	    }else if(button == btnTable4){
	    	
	    	customerView customerClass = new customerView("4");
    		JPanel customerView = customerClass.returnCustomerView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
	    	
	    }else if(button == btnTable5){
	    	
	    	customerView customerClass = new customerView("5");
    		JPanel customerView = customerClass.returnCustomerView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
	    	
	    }else if(button == btnTable6){
	    	
	    	customerView customerClass = new customerView("6");
    		JPanel customerView = customerClass.returnCustomerView();
    		
	    	contentPane.removeAll();
    	    contentPane.add(customerView);
	    	
	    }
	    
	 // reload the window
    	contentPane.revalidate();
    	contentPane.repaint();
	}
    public JPanel returnSelectTableView(){    	
    	
		return selectTableView;
    }
	
	public void selectTableView(){
		selectTableView = new JPanel();
		selectTableView.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel Westpanel = new JPanel();
		Westpanel.setBackground(new Color(112, 128, 144));
		selectTableView.add(Westpanel);
		Westpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		 btnTable1 = new JButton("Table 1");
		 btnTable1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		Westpanel.add(btnTable1);
		btnTable1.addActionListener(this);

		 btnTable4 = new JButton("Table 4");
		 btnTable4.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		Westpanel.add(btnTable4);
		btnTable4.addActionListener(this);

		JPanel Centerpanel = new JPanel();
		Centerpanel.setBackground(new Color(112, 128, 144));
		selectTableView.add(Centerpanel);
		Centerpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		 btnTable2 = new JButton("Table 2");
		 btnTable2.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		Centerpanel.add(btnTable2);
		btnTable2.addActionListener(this);

		 btnTable5 = new JButton("Table 5");
		 btnTable5.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		Centerpanel.add(btnTable5);
		btnTable5.addActionListener(this);

		JPanel Eastpanel = new JPanel();
		Eastpanel.setBackground(new Color(112, 128, 144));
		selectTableView.add(Eastpanel);
		Eastpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		 btnTable3 = new JButton("Table 3");
		 btnTable3.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		Eastpanel.add(btnTable3);
		btnTable3.addActionListener(this);

		 btnTable6 = new JButton("Table 6");
		 btnTable6.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		Eastpanel.add(btnTable6);
		btnTable6.addActionListener(this);

	}
	
	
}


