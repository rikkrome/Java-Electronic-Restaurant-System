
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class payCardView implements ActionListener {
	
	private JPanel mainView;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtNumber;
	private JTextField txtStreetAddress;
	private JTextField txtAprt;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JTextField txtCardnumber;
	private JTextField txtExpdate;
	private JTextField txtCardname;
	private JButton btnBack,btnPay;
	
	private String tableNumber;
	public payCardView(String TableNumber){
		tableNumber = TableNumber;
		loadView();
		
		
	}
	
	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();
		
		if(button == btnBack){
			
			CustomerBilling View = new CustomerBilling(tableNumber);
    		JPanel newView = View.returnView();
    		
    	    contentPane.removeAll();
    	    contentPane.add(newView);
			
		}else if(button == btnPay){
			//first remove there bill
			ArrayList<String> foodData = new ArrayList<String>();

			try {
//				foodData = DataBase.getItembyID("","MenuDB");
				DataBase.paybill(tableNumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			CustomerBilling View = new CustomerBilling(tableNumber);
    		JPanel newView = View.returnView();
    		
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
			panel.setBackground(new Color(112, 128, 144));
			mainView.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			
			btnBack = new JButton("back");
			btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			panel.add(btnBack, BorderLayout.WEST);
			
			JPanel panel_1 = new JPanel();
			mainView.add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(112, 128, 144));
			panel_1.add(panel_2);
			panel_2.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel lblname = new JLabel("Full Name");
			panel_2.add(lblname);
			
			txtName = new JTextField();
			panel_2.add(txtName);
			txtName.setColumns(10);
			
			JLabel lblEmail = new JLabel("Email:");
			panel_2.add(lblEmail);
			
			txtEmail = new JTextField();
			panel_2.add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			panel_2.add(lblPhoneNumber);
			
			txtNumber = new JTextField();
			panel_2.add(txtNumber);
			txtNumber.setColumns(10);
			
			JLabel lblAddress = new JLabel("Address");
			panel_2.add(lblAddress);
			
			txtStreetAddress = new JTextField();
			txtStreetAddress.setText("Street Address");
			panel_2.add(txtStreetAddress);
			txtStreetAddress.setColumns(10);
			txtStreetAddress.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	            	txtStreetAddress.setText("");
	            }
	        });
			
			txtAprt = new JTextField();
			txtAprt.setText("Apartment,Suite , ect.");
			panel_2.add(txtAprt);
			txtAprt.setColumns(10);
			txtAprt.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	            	txtAprt.setText("");
	            }
	        });
			
			JLabel lblTownCity = new JLabel("Town / City");
			panel_2.add(lblTownCity);
			
			txtCity = new JTextField();
			panel_2.add(txtCity);
			txtCity.setColumns(10);
			
			JLabel lblState = new JLabel("State");
			panel_2.add(lblState);
			
			txtState = new JTextField();
			panel_2.add(txtState);
			txtState.setColumns(10);
			
			JLabel lblZip = new JLabel("ZIP");
			panel_2.add(lblZip);
			
			txtZip = new JTextField();
			panel_2.add(txtZip);
			txtZip.setColumns(10);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(112, 128, 144));
			panel_1.add(panel_3);
			panel_3.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel panel_4 = new JPanel();
			panel_4.setBackground(new Color(112, 128, 144));
			panel_3.add(panel_4);
			panel_4.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel lblCardNumber = new JLabel("Card Number");
			panel_4.add(lblCardNumber);
			
			txtCardnumber = new JTextField();
			panel_4.add(txtCardnumber);
			txtCardnumber.setColumns(10);
			
			JLabel lblExpirationDate = new JLabel("Expiration date");
			panel_4.add(lblExpirationDate);
			
			txtExpdate = new JTextField();
			panel_4.add(txtExpdate);
			txtExpdate.setColumns(10);
			
			JLabel lblNameOnCard = new JLabel("Name on card");
			panel_4.add(lblNameOnCard);
			
			txtCardname = new JTextField();
			panel_4.add(txtCardname);
			txtCardname.setColumns(10);
			
			btnPay = new JButton("pay");
			btnPay.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
			panel_3.add(btnPay);
			btnPay.addActionListener(this);

	 }

}
