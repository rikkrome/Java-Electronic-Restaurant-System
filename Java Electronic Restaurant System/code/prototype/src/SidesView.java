
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class SidesView extends JFrame implements ActionListener {

	private JPanel SidesView , northPanel, CenterPanel , westPanel, NorthWestPanel ,  bottomWestPanel , southWestPanel,
	eastPanel, northEastPanel, southEastpanel;
	private JButton btnBack_SidesView , btnNewButton_1;
	private JLabel  lblSides  , lblSidesName , label;
	
	private String tableNumber;
	private JLabel label_2;
	private JButton button_1;
	private JPanel panel_1;
	private JLabel label_3;
	private JLabel label_4;
	private JButton button_3;
	private JPanel panel_3;
	private JButton button_4;
	private JLabel label_5;
	private JLabel label_1;
	private JButton button_5;
	private JPanel panel;
	private JLabel label_6;
	private String mainView;
	public SidesView(String TableNumber,String View){
		System.out.print("SidesView: "+TableNumber+"\n");
		tableNumber = TableNumber;
		mainView = View;
		loadSidesView();
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
	     JButton button = (JButton) ae.getSource();
			JPanel contentPane = prototype_standard.returnContentPaneView();

	       if (button == btnBack_SidesView){
	    	   
	    		MenuView Menu = new MenuView(tableNumber,mainView );
	    		JPanel MenuView = Menu.returnMenuView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(MenuView);
    	    	
	       }
	       
	    	 // reload the window
	    	contentPane.revalidate();
	    	contentPane.repaint();

	        
	}
    public JPanel returnSidesView(){    	
    	
		return SidesView;
    }
    
    public void loadSidesView(){

			SidesView = new JPanel();
//			contentPane.add(SidesView, BorderLayout.CENTER);
			SidesView.setLayout(new BorderLayout(0, 0));
			
			northPanel = new JPanel();
			northPanel.setBackground(new Color(112, 128, 144));
			SidesView.add(northPanel, BorderLayout.NORTH);
			northPanel.setLayout(new BorderLayout(0, 0));
			
			btnBack_SidesView = new JButton("back");
			btnBack_SidesView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			northPanel.add(btnBack_SidesView, BorderLayout.WEST);
			btnBack_SidesView.addActionListener(this);

			lblSides = new JLabel("SIDES");
			lblSides.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblSides.setHorizontalAlignment(SwingConstants.CENTER);
			northPanel.add(lblSides, BorderLayout.CENTER);
			
			CenterPanel = new JPanel();
			SidesView.add(CenterPanel, BorderLayout.CENTER);
			CenterPanel.setLayout(new GridLayout(0, 2, 0, 0));
			
			westPanel = new JPanel();
			westPanel.setBackground(new Color(112, 128, 144));
			CenterPanel.add(westPanel);
			westPanel.setLayout(new GridLayout(0, 1, 0, 0));
			
			NorthWestPanel = new JPanel();
			NorthWestPanel.setBackground(new Color(112, 128, 144));
			westPanel.add(NorthWestPanel);
			NorthWestPanel.setLayout(new BorderLayout(0, 0));
			
			lblSidesName = new JLabel("SidesName");
			lblSidesName.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblSidesName.setHorizontalAlignment(SwingConstants.CENTER);
			NorthWestPanel.add(lblSidesName, BorderLayout.NORTH);
			
			btnNewButton_1 = new JButton("image");
			NorthWestPanel.add(btnNewButton_1);
			
			bottomWestPanel = new JPanel();
			bottomWestPanel.setBackground(new Color(112, 128, 144));
			NorthWestPanel.add(bottomWestPanel, BorderLayout.SOUTH);
			bottomWestPanel.setLayout(new BorderLayout(0, 0));
			
			label = new JLabel("$10.00");
			label.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			bottomWestPanel.add(label, BorderLayout.CENTER);
			
			southWestPanel = new JPanel();
			southWestPanel.setBackground(new Color(112, 128, 144));
			westPanel.add(southWestPanel);
			southWestPanel.setLayout(new BorderLayout(0, 0));
			
			label_1 = new JLabel("SidesName");
			label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			southWestPanel.add(label_1, BorderLayout.NORTH);
			
			button_5 = new JButton("image");
			southWestPanel.add(button_5, BorderLayout.CENTER);
			
			panel = new JPanel();
			panel.setBackground(new Color(112, 128, 144));
			southWestPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new BorderLayout(0, 0));
			
			label_6 = new JLabel("$10.00");
			label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			label_6.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label_6, BorderLayout.CENTER);
			
			eastPanel = new JPanel();
			CenterPanel.add(eastPanel);
			eastPanel.setLayout(new GridLayout(0, 1, 0, 0));
			
			northEastPanel = new JPanel();
			northEastPanel.setBackground(new Color(112, 128, 144));
			eastPanel.add(northEastPanel);
			northEastPanel.setLayout(new BorderLayout(0, 0));
			
			label_2 = new JLabel("SidesName");
			label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			northEastPanel.add(label_2, BorderLayout.NORTH);
			
			button_1 = new JButton("image");
			northEastPanel.add(button_1, BorderLayout.CENTER);
			
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(112, 128, 144));
			northEastPanel.add(panel_1, BorderLayout.SOUTH);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			label_3 = new JLabel("$10.00");
			label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			panel_1.add(label_3, BorderLayout.CENTER);
			
			southEastpanel = new JPanel();
			southEastpanel.setBackground(new Color(112, 128, 144));
			eastPanel.add(southEastpanel);
			southEastpanel.setLayout(new BorderLayout(0, 0));
			
			label_4 = new JLabel("SidesName");
			label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			southEastpanel.add(label_4, BorderLayout.NORTH);
			
			button_3 = new JButton("image");
			southEastpanel.add(button_3, BorderLayout.CENTER);
			
			panel_3 = new JPanel();
			panel_3.setBackground(new Color(112, 128, 144));
			southEastpanel.add(panel_3, BorderLayout.SOUTH);
			panel_3.setLayout(new BorderLayout(0, 0));
			
			
			
			label_5 = new JLabel("$10.00");
			label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			panel_3.add(label_5, BorderLayout.CENTER);
		}
}
