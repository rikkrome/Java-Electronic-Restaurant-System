
import java.awt.BorderLayout;
import java.awt.Color;
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

public class customerView  implements ActionListener{
	
	
	private JPanel customerView,panel_holdsButtons,panel_west,panel_center,panel_east,
	panel_north;
	private JButton btnMenu_customerView,btnHelp_customerView,btnOrdering_customerView,
	btnGame_customerView,btnBilling_customerView,btnRewardProgram_customerView,btnback_customerView;
	private JLabel lblCustomer;
	private String tableNumber;
	public customerView(String TableNumber){
		
		System.out.print("loaded customerView: "+TableNumber+"\n");
		tableNumber = TableNumber;

		loadCustomerView();
	}
	
    public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

    	/*
         * customerView Actions
    	 */
    	if (button == btnback_customerView){

    	    staffPasscodeView staffPasscode = new staffPasscodeView("userTypeSelection",tableNumber);
    		JPanel staffPasscodeView = staffPasscode.returnStaffPasscodeView();
    		
        	contentPane.removeAll();
        	contentPane.add(staffPasscodeView);
    	
    	}
    	else if (button == btnMenu_customerView){
        	    	
    		MenuView Menu = new MenuView(tableNumber,"customerView");
    		JPanel MenuView = Menu.returnMenuView();
    		
    	    contentPane.removeAll();
    	    contentPane.add(MenuView);
    	    

        	
        }else if (button == btnHelp_customerView){

        	requestView Request = new requestView(tableNumber);
        	JPanel requestView = Request.returnRequestView();
        	
        	contentPane.removeAll();
    	    contentPane.add(requestView);
        	
        }else if (button == btnOrdering_customerView){

        	orderView View = new orderView(tableNumber);
    		JPanel NewView = View.returnView();
    		
    	    contentPane.removeAll();
    	    contentPane.add(NewView);
        }else if (button == btnGame_customerView){
        	
        	gameView View = new gameView(tableNumber);
    		JPanel NewView = View.returnView();
//    		
    	    contentPane.removeAll();
    	    contentPane.add(NewView);
        	
        }else if (button == btnBilling_customerView){
        	
        	CustomerBilling View = new CustomerBilling(tableNumber);
    		JPanel NewView = View.returnView();
    		contentPane.removeAll();
    	    contentPane.add(NewView);
        	
        }else if (button == btnRewardProgram_customerView){
    		System.out.println("loginRP");

        	login View = new login(tableNumber);
    		JPanel NewView = View.returnView();
    		contentPane.removeAll();
    	    contentPane.add(NewView);
       	}
    	
    	 // reload the window
    	contentPane.revalidate();
    	contentPane.repaint();

    	
    }
    
    public JPanel returnCustomerView(){    	
    	
		return customerView;
    }
	public void loadCustomerView(){

    	customerView = new JPanel();
//    	contentPane.add(customerView, BorderLayout.CENTER);
    	customerView.setLayout(new BorderLayout(0, 0));
    	
    	panel_holdsButtons = new JPanel();
    	customerView.add(panel_holdsButtons, BorderLayout.CENTER);
    	panel_holdsButtons.setLayout(new GridLayout(0, 3, 0, 0));
    	
    	panel_west = new JPanel();
    	panel_west.setBackground(new Color(112, 128, 144));
    	panel_holdsButtons.add(panel_west);
    	panel_west.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	btnMenu_customerView = new JButton("menu");
    	btnMenu_customerView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_west.add(btnMenu_customerView);
    	btnMenu_customerView.addActionListener(this);

    	btnHelp_customerView = new JButton("help");
    	btnHelp_customerView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_west.add(btnHelp_customerView);
    	btnHelp_customerView.addActionListener(this);
    	
    	panel_center = new JPanel();
    	panel_center.setBackground(new Color(112, 128, 144));
    	panel_holdsButtons.add(panel_center);
    	panel_center.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	btnOrdering_customerView = new JButton("ordering");
    	btnOrdering_customerView.setBackground(new Color(255, 255, 255));
    	btnOrdering_customerView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_center.add(btnOrdering_customerView);
    	btnOrdering_customerView.addActionListener(this);

    	btnGame_customerView = new JButton("game");
    	btnGame_customerView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_center.add(btnGame_customerView);
    	btnGame_customerView.addActionListener(this);

    	panel_east = new JPanel();
    	panel_east.setBackground(new Color(112, 128, 144));
    	panel_holdsButtons.add(panel_east);
    	panel_east.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	btnBilling_customerView = new JButton("billing");
    	btnBilling_customerView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_east.add(btnBilling_customerView);
    	btnBilling_customerView.addActionListener(this);

    	btnRewardProgram_customerView = new JButton("reward program");
    	btnRewardProgram_customerView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	panel_east.add(btnRewardProgram_customerView);
    	btnRewardProgram_customerView.addActionListener(this);

    	panel_north = new JPanel();
    	customerView.add(panel_north, BorderLayout.NORTH);
    	panel_north.setLayout(new BorderLayout(0, 0));
    	
    	btnback_customerView = new JButton("back");
    	panel_north.add(btnback_customerView, BorderLayout.WEST);
    	btnback_customerView.addActionListener(this);

    	lblCustomer = new JLabel("Customer");
    	lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
    	panel_north.add(lblCustomer, BorderLayout.CENTER);
    	

    }



}
