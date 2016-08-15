import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class RewardProgram implements ActionListener {
	
	private JPanel mainView;
	private JButton btnCoupon, btnBack;
	private String gencode, name;
	
	String tableNumber;
	
	public RewardProgram(String TableNumber, String Name){
		tableNumber = TableNumber;
		name = Name;
		loadView();
	}
	public JPanel returnView(){    	
    	
		return mainView;
    }

	public void actionPerformed(ActionEvent ae){

    JButton button = (JButton) ae.getSource();
	JPanel contentPane = prototype_standard.returnContentPaneView();

    if(button == btnCoupon){
    	System.out.println("couponbutton");
    	gencode = "HPBD" + name;
    	JOptionPane.showMessageDialog(null, gencode);
    	try {
			DataBase.sendCode(gencode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }else if(button == btnBack){
    		customerView View = new customerView(tableNumber);
			JPanel newView = View.returnCustomerView();
		
	    	contentPane.removeAll();
	    	contentPane.add(newView);
    	}
    	contentPane.revalidate();
		contentPane.repaint();
	}

	public void loadView(){	
		mainView = new JPanel();
		mainView.setBackground(Color.BLACK);
		mainView.setLayout(new BorderLayout(0, 0));
	
		JPanel panel = new JPanel();
		mainView.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
	
		btnBack = new JButton("Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnBack, BorderLayout.WEST);
		btnBack.addActionListener(this);
	
		JPanel panel_1 = new JPanel();
		mainView.add(panel_1, BorderLayout.CENTER);
	
		JLabel lblBday = new JLabel("Is it your bithday? Get code");
		panel_1.add(lblBday);
	
		btnCoupon = new JButton("Coupon!");
		panel_1.add(btnCoupon);
		btnCoupon.addActionListener(this);
	}

}
