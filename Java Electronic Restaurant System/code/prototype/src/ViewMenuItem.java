
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Color;

public class ViewMenuItem implements ActionListener{
	private String tableNumber;

	private JPanel ItemView;
    private BufferedImage master;

	ArrayList<String> result = new ArrayList<String>();
	private String name,price,description,health;
	
	private JLabel lblhealth , lbltitle , lblDes, lblprice;
	private JButton btnImage,backButton,btnAdd;
	private JPanel panel_6;
	private JEditorPane dtrpnComments;
	private JPanel panel_7;
	private JLabel lblSubmitLabel;
	private JPanel panel_8;
	private JPanel newView;
	
	private String food_ID, food_type;
	private String mainView;
	public ViewMenuItem(String ID,String TableNumber, String type,String View){
		mainView = View;
		tableNumber = TableNumber;
		food_ID = ID;
		food_type = type;
		if (food_type == "Appetizers"){
			AppetizersView view = new AppetizersView(tableNumber,mainView);
			newView = view.returnAppetizersView();
		}
		else if (food_type == "Entree"){
			EntreeView view = new EntreeView(tableNumber,mainView);
			newView = view.returnEntreeView();
		}
		else if (food_type == "Dessert"){
			DessertView view = new DessertView(tableNumber,mainView);
			newView = view.returnDessertView();
		}
		else if (food_type == "Drink"){
			DrinksView view = new DrinksView(tableNumber,mainView);
			newView = view.returnDrinksView();
		}

		loadView();
		
		LoadData(ID);
	}
	
	
	
	
	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();
		if(button == backButton){
			
			System.out.print("backButtom");
			
		    contentPane.removeAll();
		    contentPane.add(newView);
	    
		}else if(button == btnAdd){
			
			btnAdd.setVisible(false);
			
			lblSubmitLabel.setText("Added to your list");
			String comment = dtrpnComments.getText();
			System.out.println(comment);

			
			try {
				DataBase.postDataBaseTable("orderFromTable",food_ID, tableNumber, name, comment, "Placed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	       
	    	 // reload the window
	    	contentPane.revalidate();
	    	contentPane.repaint();

	}
	
	
	public void LoadData(String ID){
		
		System.out.println(ID);
		
		try {
			result = DataBase.getItembyID(ID,"MenuDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 name = result.get(0);
	 price = result.get(1);
	 description = result.get(2);
	 health = result.get(3);

	 System.out.println(name+" "+price+" "+description+" "+health);
	 
	 lblhealth.setText(health);
	 lbltitle.setText(name);
	 lblDes.setText(description);
	 lblprice.setText("$"+price);
	 
	 loadButtomimage(btnImage,name+".jpg");
	 
	}
    public void loadButtomimage(JButton button,String ImageName){
        try {
			master = ImageIO.read(new File(ImageName));
			
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
                if (size.width > size.height) {
                    size.width = -1;
                } else {
                    size.height = -1;
                }
                Image scaled = master.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(scaled));
            }
        });
    }
	
	
	
    public JPanel returnView(){    	
    	
		return ItemView;
    }
    
    public void loadView(){    	

		ItemView = new JPanel();

		ItemView.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(112, 128, 144));
		ItemView.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lbltitle = new JLabel("title");
		lbltitle.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_4.add(lbltitle);
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		backButton = new JButton("back");
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		panel_4.add(backButton, BorderLayout.WEST);
		backButton.addActionListener(this);
		
		JPanel panel = new JPanel();
		ItemView.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		 panel_1.setLayout(new BorderLayout(0, 0));
		
//		 btnImage = new JButton("image");
		 btnImage = new JButton(){

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(90, 50);
                }

            };
		 panel_1.add(btnImage);
		  
		  panel_7 = new JPanel();
		  panel_7.setBackground(new Color(112, 128, 144));
		  panel.add(panel_7);
		  panel_7.setLayout(new BorderLayout(0, 0));
		    
		    		
		    		JPanel panel_5 = new JPanel();
		    		panel_5.setBackground(new Color(112, 128, 144));
		    		panel_7.add(panel_5, BorderLayout.SOUTH);
		    		panel_5.setLayout(new BorderLayout(0, 0));
		    		
		    		btnAdd = new JButton("add");
		    		btnAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		    		panel_5.add(btnAdd, BorderLayout.CENTER);
		    		btnAdd.addActionListener(this);

		    		panel_8 = new JPanel();
		    		panel_7.add(panel_8, BorderLayout.CENTER);
		    		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		    		
		    		JPanel panel_2 = new JPanel();
		    		panel_2.setBackground(new Color(112, 128, 144));
		    		panel_8.add(panel_2);
		    		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		    		
		    		JPanel panel_3 = new JPanel();
		    		panel_3.setBackground(new Color(112, 128, 144));
		    		panel_2.add(panel_3);
		    		panel_3.setLayout(new BorderLayout(0, 0));
		    		
		    		 lblDes = new JLabel("des");
		    		 lblDes.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    		 lblDes.setForeground(new Color(255, 255, 255));
		    		 panel_3.add(lblDes);
		    		 
		    		 lblhealth = new JLabel("health");
		    		 lblhealth.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    		 lblhealth.setForeground(new Color(255, 255, 255));
		    		 panel_3.add(lblhealth, BorderLayout.NORTH);
		    		 
		    		  lblprice = new JLabel("$");
		    		  lblprice.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    		  lblprice.setForeground(new Color(255, 255, 255));
		    		  panel_3.add(lblprice, BorderLayout.SOUTH);
		    		  
		    		  lblSubmitLabel = new JLabel("");
		    		  lblSubmitLabel.setForeground(new Color(255, 255, 255));
		    		  lblSubmitLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    		  panel_2.add(lblSubmitLabel);
		    		
		    		panel_6 = new JPanel();
		    		panel_8.add(panel_6);
		    		panel_6.setLayout(new BorderLayout(0, 0));
		    		
		    		dtrpnComments = new JEditorPane();
		    		dtrpnComments.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		    		dtrpnComments.setText("comments");
		    		panel_6.add(dtrpnComments, BorderLayout.CENTER);

    }

}
