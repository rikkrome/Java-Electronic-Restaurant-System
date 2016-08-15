
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

public class EntreeView extends JFrame implements ActionListener {

	private JPanel EntreeView , northPanel, CenterPanel , westPanel, NorthWestPanel ,  bottomWestPanel , southWestPanel,
	eastPanel, northEastPanel, southEastpanel;
	private JButton btnBack_EntreeView , btnNewButton_1, btnAdd;
	
	private JLabel lblEntree;
	
	private JLabel lblEntreeName1, lblEntreeName2, lblEntreeName3, lblEntreeName4;
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
	private ArrayList<String> resultNames = new ArrayList<String>();
	private ArrayList<String> resultPrice = new ArrayList<String>();
	private ArrayList<String> resultId = new ArrayList<String>();
	private ArrayList<String> resultDes = new ArrayList<String>();
	private ArrayList<String> resultHealth = new ArrayList<String>();
	
	
	private BufferedImage master1;
    private BufferedImage master2;
    private BufferedImage master3;
    private BufferedImage master4;
    private String mainView;
	public EntreeView(String TableNumber, String View){
		System.out.print("EntreeView: "+TableNumber+"\n");
		tableNumber = TableNumber;
		mainView = View;
		loadEntreeView();
		loadData();
		
	}
public void loadData(){    	
    	
    	///SELECT * FROM `MenuDB` WHERE `menuItemType` = 'Entrees'
		try {
			 resultNames = DataBase.getArrayOneItem("Entrees","MenuDB","name");
			 resultPrice = DataBase.getArrayOneItem("Entrees","MenuDB","price");
			 resultId = DataBase.getArrayOneItem("Entrees","MenuDB","id");
			 resultDes = DataBase.getArrayOneItem("Entrees","MenuDB","description");
			 resultHealth = DataBase.getArrayOneItem("Entrees","MenuDB","health");




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

    	lblEntreeName1.setText(resultNames.get(0));
    	lblEntreeName2.setText(resultNames.get(1));
    	lblEntreeName3.setText(resultNames.get(2));
    	lblEntreeName4.setText(resultNames.get(3));
    	labelPrice1.setText("$"+resultPrice.get(0));
    	labelPrice2.setText("$"+resultPrice.get(1));
    	labelPrice3.setText("$"+resultPrice.get(2));
    	labelPrice4.setText("$"+resultPrice.get(3));


    }
	
	
	public void actionPerformed(ActionEvent ae){
	     JButton button = (JButton) ae.getSource();
			JPanel contentPane = prototype_standard.returnContentPaneView();

	       if (button == btnBack_EntreeView){
	    	   
	    		MenuView Menu = new MenuView(tableNumber, mainView);
	    		JPanel MenuView = Menu.returnMenuView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(MenuView);
    	    	
	       }else if(button == btnImage1){
	    	   String id = resultId.get(0);
	    	   ViewMenuItem view = new ViewMenuItem(id,tableNumber, "Entree",mainView);
	    		JPanel newView = view.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
	    	    
	       }else if(button == btnImage2){
	    	   String id = resultId.get(1);
	    	   ViewMenuItem view = new ViewMenuItem(id,tableNumber, "Entree",mainView);
	    		JPanel newView = view.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
	    	    
	       }else if(button == btnImage3){
	    	   String id = resultId.get(2);
	    	   ViewMenuItem view = new ViewMenuItem(id,tableNumber, "Entree",mainView);
	    		JPanel newView = view.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
	    	    
	       }else if(button == btnImage4){
	    	   String id = resultId.get(3);
	    	   ViewMenuItem view = new ViewMenuItem(id,tableNumber, "Entree",mainView);
	    		JPanel newView = view.returnView();
	    		
	    	    contentPane.removeAll();
	    	    contentPane.add(newView);
	       }
	       
	       
	    	 // reload the window
	    	contentPane.revalidate();
	    	contentPane.repaint();

	        
	}
    public JPanel returnEntreeView(){    	
    	
		return EntreeView;
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
    
    public void loadEntreeView(){

    	EntreeView = new JPanel();
//		contentPane.add(AppetizersView, BorderLayout.CENTER);
		EntreeView.setLayout(new BorderLayout(0, 0));
		
		northPanel = new JPanel();
		northPanel.setBackground(new Color(112, 128, 144));
		EntreeView.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		btnBack_EntreeView = new JButton("back");
		btnBack_EntreeView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		northPanel.add(btnBack_EntreeView, BorderLayout.WEST);
		btnBack_EntreeView.addActionListener(this);

		lblEntree = new JLabel("ENTREES");
		lblEntree.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblEntree.setHorizontalAlignment(SwingConstants.CENTER);
		northPanel.add(lblEntree, BorderLayout.CENTER);
		
		CenterPanel = new JPanel();
		EntreeView.add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		westPanel = new JPanel();
		CenterPanel.add(westPanel);
		westPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		NorthWestPanel = new JPanel();
		NorthWestPanel.setBackground(new Color(112, 128, 144));
		westPanel.add(NorthWestPanel);
		NorthWestPanel.setLayout(new BorderLayout(0, 0));
		
		lblEntreeName1 = new JLabel("EntreeName");
		lblEntreeName1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblEntreeName1.setHorizontalAlignment(SwingConstants.CENTER);
		NorthWestPanel.add(lblEntreeName1, BorderLayout.NORTH);
		
		/*
		 * 
		 */


		btnImage1 = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(90, 50);
            }

        };
        loadButtomimage(btnImage1,"hamburger.jpg",1);
		
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
		
		lblEntreeName3 = new JLabel("AppetizerName");
		lblEntreeName3.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblEntreeName3.setHorizontalAlignment(SwingConstants.CENTER);
		southWestPanel.add(lblEntreeName3, BorderLayout.NORTH);
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
        loadButtomimage(btnImage3,"chicken parmesan.jpg",3);
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
		
		lblEntreeName2 = new JLabel("AppetizerName");
		lblEntreeName2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblEntreeName2.setHorizontalAlignment(SwingConstants.CENTER);
		northEastPanel.add(lblEntreeName2, BorderLayout.NORTH);
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
        loadButtomimage(btnImage2,"steak.jpg",2);
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
		
		lblEntreeName4 = new JLabel("AppetizerName");
		lblEntreeName4.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblEntreeName4.setHorizontalAlignment(SwingConstants.CENTER);
		southEastpanel.add(lblEntreeName4, BorderLayout.NORTH);
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
        loadButtomimage(btnImage4,"shepard's pie.jpg",4);
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
