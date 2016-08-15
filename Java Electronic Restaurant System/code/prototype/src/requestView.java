
import java.awt.BorderLayout;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class requestView implements ActionListener{
	
	private JPanel requestView,Main,West,East,Banner;
	private JButton btnRequest_Help,btnRequest_Refill,btnBack_requestView;
	private JTextField txtEnterRequest;
	private String tableNumber;
	private JLabel lblNewLabel,label,label_1;
	
	
	public requestView(String TableNumber){
		tableNumber = TableNumber;
		loadrequestView();
		
	}
	
	 public void actionPerformed(ActionEvent ae){
	    JButton button = (JButton) ae.getSource();
	    JPanel contentPane = prototype_standard.returnContentPaneView();

	    	/*
	         * requestView Actions
	    	 */
	    if(button == btnBack_requestView){
	    	customerView customer = new customerView(tableNumber);
    		JPanel customerView = customer.returnCustomerView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(customerView);
	    }
	    else if(button == btnRequest_Help){
	        try {
				DataBase.updateTableStatus("help","yes",tableNumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         JOptionPane.showMessageDialog(null,
	        		    "Somebody will be here to assist you shortly.");
		}
		else if(button == btnRequest_Refill){
			String getRequest = txtEnterRequest.getText();
//			getRequest = getRequestText;
			 try {
					DataBase.updateTableStatus("refill",getRequest,tableNumber);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         JOptionPane.showMessageDialog(null,
		        		    "Your drink request has been submitted");
		}
	    
	    // reload the window
    	contentPane.revalidate();
    	contentPane.repaint();
	 }
		
	public JPanel returnRequestView(){
		
		return requestView;
	}
	
	public void loadrequestView(){
		
		requestView = new JPanel();

		requestView.setLayout(new BorderLayout(0, 0));
		
		Main = new JPanel();
		requestView.add(Main, BorderLayout.CENTER);
		Main.setLayout(new GridLayout(0, 2, 0, 0));
		
		West = new JPanel();
		Main.add(West);
		West.setLayout(new GridLayout(0, 1, 0, 0));
		
		label = new JLabel("");
		West.add(label);
		
		txtEnterRequest = new JTextField();
		txtEnterRequest.setText("Enter Drink Request Here");
		West.add(txtEnterRequest);
		txtEnterRequest.setColumns(10);
		
		btnRequest_Refill = new JButton("Request Refill");
		West.add(btnRequest_Refill);
		btnRequest_Refill.addActionListener(this);
		
		label_1 = new JLabel("");
		West.add(label_1);
		
		East = new JPanel();
		Main.add(East);
		East.setLayout(new BorderLayout(0, 0));
		
		btnRequest_Help = new JButton("Request Help");
		East.add(btnRequest_Help);
		btnRequest_Help.addActionListener(this);
		
		Banner = new JPanel();
		requestView.add(Banner, BorderLayout.NORTH);
		Banner.setLayout(new BorderLayout(0, 0));
		
		btnBack_requestView = new JButton("back");
		Banner.add(btnBack_requestView, BorderLayout.WEST);
		btnBack_requestView.addActionListener(this);
		
		lblNewLabel = new JLabel("Request View");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Banner.add(lblNewLabel, BorderLayout.CENTER);
		
	}

}
