
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class DessertView extends JFrame implements ActionListener {

	private JPanel DessertView , northPanel, CenterPanel , westPanel, NorthWestPanel ,  bottomWestPanel , southWestPanel,
	eastPanel, northEastPanel, southEastpanel;
	private JButton btnBack_DessertView , btnNewButton_1, btnAdd;
	private JLabel  lblDessert  , lblDessertName , label;
	private JLabel lblDessertName1, lblDessertName2, lblDessertName3, lblDessertName4;
	private JLabel labelPrice1, labelPrice2, labelPrice3, labelPrice4;
	private JButton btnImage1, btnImage2, btnImage3, btnImage4;
	
	private String tableNumber;
	private JLabel label_2;
	private JButton button_1;
	private JPanel panel_1;
	private JButton button_2;
	private JLabel label_3;
	private JLabel label_4;
	private JButton button_3;
	private JPanel panel_3;
	private JButton button_4;
	private JLabel label_5;
	private JLabel label_1;
	private JButton button_5;
	private JPanel panel;
	private JButton button_6;
	private JLabel label_6;
	
	private BufferedImage master1;
    private BufferedImage master2;
    private BufferedImage master3;
    private BufferedImage master4;
	
    private  ArrayList<String> resultNames = new ArrayList<String>();
    private ArrayList<String> resultPrice = new ArrayList<String>();
	private ArrayList<String> resultId = new ArrayList<String>();
	private ArrayList<String> resultDes = new ArrayList<String>();
	private ArrayList<String> resultHealth = new ArrayList<String>();
	
	private String mainView;
	public DessertView(String TableNumber,String View){
		System.out.print("DessertView: "+TableNumber+"\n");
		tableNumber = TableNumber;
		mainView = View;
		loadDessertView();
		loadData();
		
	}
	public void loadData(){
		///SELECT * FROM `MenuDB` WHERE `menuItemType` = 'Desserts'
				try {
					 resultNames = DataBase.getArrayOneItem("Desserts","MenuDB","name");
					 resultPrice = DataBase.getArrayOneItem("Desserts","MenuDB","price");
					 resultId = DataBase.getArrayOneItem("Desserts","MenuDB","id");
					 resultDes = DataBase.getArrayOneItem("Desserts","MenuDB","description");
					 resultHealth = DataBase.getArrayOneItem("Desserts","MenuDB","health");




				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

		    	lblDessertName1.setText(resultNames.get(0));
		    	lblDessertName2.setText(resultNames.get(1));
		    	lblDessertName3.setText(resultNames.get(2));
		    	lblDessertName4.setText(resultNames.get(3));
		    	labelPrice1.setText("$"+resultPrice.get(0));
		    	labelPrice2.setText("$"+resultPrice.get(1));
		    	labelPrice3.setText("$"+resultPrice.get(2));
		    	labelPrice4.setText("$"+resultPrice.get(3));
	}
	
	
	public void actionPerformed(ActionEvent ae){
	     JButton button = (JButton) ae.getSource();
			JPanel contentPane = prototype_standard.returnContentPaneView();

	       if (button == btnBack_DessertView){
	    	   
	    		MenuView Menu = new MenuView(tableNumber,mainView);
	    		JPanel MenuView = Menu.returnMenuView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(MenuView);
    	    	
	       }else if(button == btnImage1){
	    	   String id = resultId.get(0);
	    	   ViewMenuItem view = new ViewMenuItem(id,tableNumber, "Dessert",mainView);
	    		JPanel newView = view.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
	    	    
	       }else if(button == btnImage2){
	    	   String id = resultId.get(1);
	    	   ViewMenuItem view = new ViewMenuItem(id,tableNumber, "Dessert",mainView);
	    		JPanel newView = view.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
	    	    
	       }else if(button == btnImage3){
	    	   String id = resultId.get(2);
	    	   ViewMenuItem view = new ViewMenuItem(id,tableNumber, "Dessert",mainView);
	    		JPanel newView = view.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
	    	    
	       }else if(button == btnImage4){
	    	   String id = resultId.get(3);
	    	   ViewMenuItem view = new ViewMenuItem(id,tableNumber, "Dessert",mainView);
	    		JPanel newView = view.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
	       }
	       
	    	 // reload the window
	    	contentPane.revalidate();
	    	contentPane.repaint();

	        
	}

	public void loadButtomimage(JButton button,String ImageName, final int imageNumber){
    	System.out.println(ImageName);
        try {
        	if(imageNumber == 1)
        		master1 = ImageIO.read(new File(ImageName));
        	else if(imageNumber == 2)
            	master2 = ImageIO.read(new File(ImageName));
        	else if(imageNumber == 3)
            	master3 = ImageIO.read(new File(ImageName));
        	else if(imageNumber == 4)
            	master4 = ImageIO.read(new File(ImageName));
        	
        	
        	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        button.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                JButton button = (JButton) e.getComponent();
                Dimension size = button.getSize();
                Insets insets = button.getInsets();
                size.width -= insets.left + insets.right;
                size.height -= insets.top + insets.bottom;
                Image scaled = null;
                if (size.width > size.height) {
                    size.width = -1;
                } else {
                    size.height = -1;
                }
            	if(imageNumber == 1){
                     scaled = master1.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
            	}
            	else if(imageNumber == 2){
                     scaled = master2.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
            	}
            	else if(imageNumber == 3){
                     scaled = master3.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
            	}
            	else if(imageNumber == 4){
                     scaled = master4.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
            	}
//                Image scaled = master.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
                
                button.setIcon(new ImageIcon(scaled));
            }
        });
    }
	public JPanel returnDessertView(){    	
    	
		return DessertView;
    }
    
    public void loadDessertView(){

    	DessertView = new JPanel();
//		contentPane.add(AppetizersView, BorderLayout.CENTER);
		DessertView.setLayout(new BorderLayout(0, 0));
		
		northPanel = new JPanel();
		northPanel.setBackground(new Color(112, 128, 144));
		DessertView.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		btnBack_DessertView = new JButton("back");
		btnBack_DessertView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		northPanel.add(btnBack_DessertView, BorderLayout.WEST);
		btnBack_DessertView.addActionListener(this);

		lblDessert = new JLabel("DESSERTS");
		lblDessert.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblDessert.setHorizontalAlignment(SwingConstants.CENTER);
		northPanel.add(lblDessert, BorderLayout.CENTER);
		
		CenterPanel = new JPanel();
		DessertView.add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		westPanel = new JPanel();
		CenterPanel.add(westPanel);
		westPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		NorthWestPanel = new JPanel();
		NorthWestPanel.setBackground(new Color(112, 128, 144));
		westPanel.add(NorthWestPanel);
		NorthWestPanel.setLayout(new BorderLayout(0, 0));
		
		lblDessertName1 = new JLabel("DrinkName");
		lblDessertName1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblDessertName1.setHorizontalAlignment(SwingConstants.CENTER);
		NorthWestPanel.add(lblDessertName1, BorderLayout.NORTH);
		
		/*
		 * 
		 */


		btnImage1 = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(90, 50);
            }

        };
        loadButtomimage(btnImage1,"cheesecake.jpg",1);
		
		NorthWestPanel.add(btnImage1);
		btnImage1.addActionListener(this);
		/*
		 * 
		 */
		bottomWestPanel = new JPanel();
		bottomWestPanel.setBackground(new Color(112, 128, 144));
		NorthWestPanel.add(bottomWestPanel, BorderLayout.SOUTH);
		bottomWestPanel.setLayout(new BorderLayout(0, 0));
		
		//btnAdd1 = new JButton("add");
		//bottomWestPanel.add(btnAdd1, BorderLayout.EAST);
		
		labelPrice1 = new JLabel("$10.00");
		labelPrice1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		labelPrice1.setHorizontalAlignment(SwingConstants.CENTER);
		bottomWestPanel.add(labelPrice1, BorderLayout.CENTER);
		
		southWestPanel = new JPanel();
		southWestPanel.setBackground(new Color(112, 128, 144));
		westPanel.add(southWestPanel);
		southWestPanel.setLayout(new BorderLayout(0, 0));
		
		lblDessertName3 = new JLabel("DessertName");
		lblDessertName3.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblDessertName3.setHorizontalAlignment(SwingConstants.CENTER);
		southWestPanel.add(lblDessertName3, BorderLayout.NORTH);
		/*
		 * 
		 */
//		btnImage_3 = new JButton("image3");
		btnImage3 = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(90, 50);
            }

        };
        loadButtomimage(btnImage3,"chocolate lava cake.jpg",3);
		southWestPanel.add(btnImage3, BorderLayout.CENTER);
		btnImage3.addActionListener(this);
		/*
		 * 
		 */

		panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		southWestPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		//btnAdd3 = new JButton("add");
		//panel.add(btnAdd3, BorderLayout.EAST);
		
		labelPrice3 = new JLabel("$10.00");
		labelPrice3.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		labelPrice3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelPrice3, BorderLayout.CENTER);
		
		eastPanel = new JPanel();
		CenterPanel.add(eastPanel);
		eastPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		northEastPanel = new JPanel();
		northEastPanel.setBackground(new Color(112, 128, 144));
		eastPanel.add(northEastPanel);
		northEastPanel.setLayout(new BorderLayout(0, 0));
		
		lblDessertName2 = new JLabel("DessertName");
		lblDessertName2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblDessertName2.setHorizontalAlignment(SwingConstants.CENTER);
		northEastPanel.add(lblDessertName2, BorderLayout.NORTH);
		/*
		 * 
		 */
//		buttonImage2 = new JButton("image2");
		btnImage2 = new JButton(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(90, 50);
            }

        };
        loadButtomimage(btnImage2,"ice cream sundae.jpg",2);
		northEastPanel.add(btnImage2, BorderLayout.CENTER);
		btnImage2.addActionListener(this);
		/*
		 * 
		 */

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		northEastPanel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		//btnAdd2 = new JButton("add");
		//panel_1.add(btnAdd2, BorderLayout.EAST);
		
		labelPrice2 = new JLabel("$10.00");
		labelPrice2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		labelPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(labelPrice2, BorderLayout.CENTER);
		
		southEastpanel = new JPanel();
		southEastpanel.setBackground(new Color(112, 128, 144));
		eastPanel.add(southEastpanel);
		southEastpanel.setLayout(new BorderLayout(0, 0));
		
		lblDessertName4 = new JLabel("DessertName");
		lblDessertName4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblDessertName4.setHorizontalAlignment(SwingConstants.CENTER);
		southEastpanel.add(lblDessertName4, BorderLayout.NORTH);
		/*
		 * 
		 */
//		btnImage_4 = new JButton("image4");
		btnImage4 = new JButton(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(90, 50);
            }

        };
        loadButtomimage(btnImage4,"flan.jpg",4);
		southEastpanel.add(btnImage4, BorderLayout.CENTER);
		btnImage4.addActionListener(this);
		/*
		 * 
		 */

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(112, 128, 144));
		southEastpanel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		//btnAdd4 = new JButton("add");
		//panel_3.add(btnAdd4, BorderLayout.EAST);
		
		labelPrice4 = new JLabel("$10.00");
		labelPrice4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		labelPrice4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(labelPrice4, BorderLayout.CENTER);
	}
}
