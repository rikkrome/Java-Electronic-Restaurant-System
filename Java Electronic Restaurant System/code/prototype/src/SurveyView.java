
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class SurveyView extends JFrame implements ActionListener{

	private JPanel SurveyView;
	private JButton btnSubmit;
	private String tablenumber;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblHowWasThe;
	private JLabel lblHowWasThe_1;
	private JRadioButton rdbtnDelicious;
	private JRadioButton rdbtnPrettyGood;
	private JRadioButton rdbtnNotGreat;
	private JRadioButton rdbtnExcellent;
	private JRadioButton rdbtnAcceptable;
	private JRadioButton rdbtnPoor;
	private JTextField txtEnterAComment;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */

	
	public SurveyView(String TableNumber) {
    	SurveyView = new JPanel();
//    	contentPane.add(MenuView, BorderLayout.CENTER);
    	SurveyView.setLayout(new BorderLayout(0, 0));
    	tablenumber = TableNumber;
    	
		
		JPanel panel = new JPanel();
		SurveyView.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnSubmit = new JButton("Submit");
		panel.add(btnSubmit, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("Take A Survey");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{124, 92, 104, 0};
		gbl_panel_1.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblHowWasThe = new JLabel("  How was the food?");
		GridBagConstraints gbc_lblHowWasThe = new GridBagConstraints();
		gbc_lblHowWasThe.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblHowWasThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblHowWasThe.gridx = 0;
		gbc_lblHowWasThe.gridy = 0;
		panel_1.add(lblHowWasThe, gbc_lblHowWasThe);
		
		rdbtnDelicious = new JRadioButton("Delicious!");
		GridBagConstraints gbc_rdbtnDelicious = new GridBagConstraints();
		gbc_rdbtnDelicious.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDelicious.gridx = 0;
		gbc_rdbtnDelicious.gridy = 1;
		panel_1.add(rdbtnDelicious, gbc_rdbtnDelicious);
		
		rdbtnPrettyGood = new JRadioButton("Pretty Good");
		GridBagConstraints gbc_rdbtnPrettyGood = new GridBagConstraints();
		gbc_rdbtnPrettyGood.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPrettyGood.gridx = 0;
		gbc_rdbtnPrettyGood.gridy = 2;
		panel_1.add(rdbtnPrettyGood, gbc_rdbtnPrettyGood);
		
		rdbtnNotGreat = new JRadioButton("Not Great");
		GridBagConstraints gbc_rdbtnNotGreat = new GridBagConstraints();
		gbc_rdbtnNotGreat.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNotGreat.gridx = 0;
		gbc_rdbtnNotGreat.gridy = 3;
		panel_1.add(rdbtnNotGreat, gbc_rdbtnNotGreat);
		
		lblHowWasThe_1 = new JLabel("  How was the service?");
		GridBagConstraints gbc_lblHowWasThe_1 = new GridBagConstraints();
		gbc_lblHowWasThe_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHowWasThe_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblHowWasThe_1.gridx = 0;
		gbc_lblHowWasThe_1.gridy = 4;
		panel_1.add(lblHowWasThe_1, gbc_lblHowWasThe_1);
		
		txtEnterAComment = new JTextField();
		txtEnterAComment.setText("Enter a Comment");
		txtEnterAComment.setToolTipText("Enter a Comment");
		GridBagConstraints gbc_txtEnterAComment = new GridBagConstraints();
		gbc_txtEnterAComment.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterAComment.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterAComment.gridx = 2;
		gbc_txtEnterAComment.gridy = 4;
		panel_1.add(txtEnterAComment, gbc_txtEnterAComment);
		txtEnterAComment.setColumns(10);
		
		rdbtnExcellent = new JRadioButton("Excellent");
		GridBagConstraints gbc_rdbtnExcellent = new GridBagConstraints();
		gbc_rdbtnExcellent.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnExcellent.gridx = 0;
		gbc_rdbtnExcellent.gridy = 5;
		panel_1.add(rdbtnExcellent, gbc_rdbtnExcellent);
		
		rdbtnAcceptable = new JRadioButton("Acceptable");
		GridBagConstraints gbc_rdbtnAcceptable = new GridBagConstraints();
		gbc_rdbtnAcceptable.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAcceptable.gridx = 0;
		gbc_rdbtnAcceptable.gridy = 6;
		panel_1.add(rdbtnAcceptable, gbc_rdbtnAcceptable);
		
		rdbtnPoor = new JRadioButton("Poor");
		GridBagConstraints gbc_rdbtnPoor = new GridBagConstraints();
		gbc_rdbtnPoor.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPoor.gridx = 0;
		gbc_rdbtnPoor.gridy = 7;
		panel_1.add(rdbtnPoor, gbc_rdbtnPoor);
		btnSubmit.addActionListener(this);
	}
	
	public JPanel returnSurveyView(){    	
    	
		return SurveyView;
    }
	
	public void foodselection(){
		if(rdbtnDelicious.isSelected()){
			rdbtnPrettyGood.setSelected(false);
			rdbtnNotGreat.setSelected(false);
		}
		else if(rdbtnPrettyGood.isSelected()){
			rdbtnDelicious.setSelected(false);
			rdbtnNotGreat.setSelected(false);
		}
		else if(rdbtnNotGreat.isSelected()){
			rdbtnDelicious.setSelected(false);
			rdbtnPrettyGood.setSelected(false);
		}
	}
	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

    	/*
    	 * Menu view actions
    	 */
        if (button == btnSubmit){
    		customerView customer = new customerView(tablenumber);
    		JPanel customerView = customer.returnCustomerView();
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(customerView); 	
       	}
    	// reload the window
    	contentPane.revalidate();
    	contentPane.repaint();
        
    }
}
