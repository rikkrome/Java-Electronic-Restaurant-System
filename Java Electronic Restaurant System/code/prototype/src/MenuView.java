
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class MenuView extends JFrame implements ActionListener{
	
	private JPanel MenuView,northPanel_MenuView , centerPanel_MenuView , WestPanel, EastPanel;
	private JButton btnBacktoCustomerView , btnToAppetizers, btnToDesserts, btnToEntrees, btnToDrinks;
	private JLabel  lblMenu;
	private String tableNumber , mainView;
	private JPanel view;
	
	public MenuView(String TableNumber,String View){
		System.out.print("MenuView: "+TableNumber+"\n");
		tableNumber = TableNumber;
		mainView = View;
		loadMenuView();
		
		if(View == "customerView"){
			customerView customer = new customerView(tableNumber);
    		 view = customer.returnCustomerView();
		}else if(View == "waitStaff"){
			waitStaffView customer = new waitStaffView(tableNumber);
   		 	view = customer.returnWaitStaffView();
		}else if(View == "managerView"){
			managerView customer = new managerView(tableNumber);
   		 	view = customer.returnManagerView();
		}
	}

	
    public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

    	/*
    	 * Menu view actions
    	 */
        if (button == btnBacktoCustomerView){
        	
        	
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(view);
        	

        	
       	}else if (button == btnToAppetizers){
       		AppetizersView Appetizers = new AppetizersView(tableNumber,mainView);
    		JPanel AppetizersView = Appetizers.returnAppetizersView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(AppetizersView);

       		
       	}else if (button == btnToDesserts){
       		DessertView Dessert = new DessertView(tableNumber,mainView);
    		JPanel dessertView = Dessert.returnDessertView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(dessertView);

       		
       	}else if (button == btnToEntrees){
       		EntreeView Entree = new EntreeView(tableNumber,mainView);
    		JPanel entreeView = Entree.returnEntreeView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(entreeView);
       		
       	}else if (button == btnToDrinks){
       		DrinksView Drink = new DrinksView(tableNumber,mainView);
    		JPanel drinkView = Drink.returnDrinksView();
    		
    		//remove what is on the window and add the new view
        	contentPane.removeAll();
        	contentPane.add(drinkView);
       	}
        
    	// reload the window
    	contentPane.revalidate();
    	contentPane.repaint();
        
    }
    public JPanel returnMenuView(){    	
    	
		return MenuView;
    }
    public void loadMenuView(){
    	
    	MenuView = new JPanel();
//    	contentPane.add(MenuView, BorderLayout.CENTER);
    	MenuView.setLayout(new BorderLayout(0, 0));
    	
    	northPanel_MenuView = new JPanel();
    	northPanel_MenuView.setBackground(new Color(112, 128, 144));
    	MenuView.add(northPanel_MenuView, BorderLayout.NORTH);
    	northPanel_MenuView.setLayout(new BorderLayout(0, 0));
    	
    	btnBacktoCustomerView = new JButton("back");
    	btnBacktoCustomerView.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	northPanel_MenuView.add(btnBacktoCustomerView, BorderLayout.WEST);
    	btnBacktoCustomerView.addActionListener(this);

    	lblMenu = new JLabel("MENU");
    	lblMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
    	northPanel_MenuView.add(lblMenu, BorderLayout.CENTER);
    	
    	centerPanel_MenuView = new JPanel();
    	MenuView.add(centerPanel_MenuView, BorderLayout.CENTER);
    	centerPanel_MenuView.setLayout(new GridLayout(0, 2, 0, 0));
    	
    	WestPanel = new JPanel();
    	WestPanel.setBackground(new Color(112, 128, 144));
    	centerPanel_MenuView.add(WestPanel);
    	WestPanel.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	btnToAppetizers = new JButton("appetizers");
    	btnToAppetizers.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	WestPanel.add(btnToAppetizers);
    	btnToAppetizers.addActionListener(this);

    	btnToDesserts = new JButton("desserts");
    	btnToDesserts.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	WestPanel.add(btnToDesserts);
    	btnToDesserts.addActionListener(this);

    	EastPanel = new JPanel();
    	EastPanel.setBackground(new Color(112, 128, 144));
    	centerPanel_MenuView.add(EastPanel);
    	EastPanel.setLayout(new GridLayout(0, 1, 0, 0));
    	
    	btnToEntrees = new JButton("entrees");
    	btnToEntrees.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	EastPanel.add(btnToEntrees);
    	btnToEntrees.addActionListener(this);

    	btnToDrinks = new JButton("drinks");
    	btnToDrinks.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    	EastPanel.add(btnToDrinks);
    	btnToDrinks.addActionListener(this);



    }
}
