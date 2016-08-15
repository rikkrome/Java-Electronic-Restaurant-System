


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel; 




public class DailySummaryReportView implements ActionListener {

	
	
	
	private JPanel mainView;
	private String tableNumber;

	private JButton btnBack;
	public DailySummaryReportView(String TableNumber){
		
		tableNumber = TableNumber;

		
		loadView("TOTAL SALES BY LOCATION", "TOTAL SALES");
		
	}
	public void actionPerformed(ActionEvent ae){
        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();
		
		if(button == btnBack){
			interfaceView view = new interfaceView(tableNumber);
			JPanel newView = view.returnView();
			
			contentPane.removeAll();
		   	contentPane.add(newView);
		}

		 // reload the window
    	contentPane.revalidate();
    	contentPane.repaint();	
		
		
 }
	private CategoryDataset createDataset(){
		
		int topAppetiz = 0;
		int topEntress = 0;
		int topDesserts = 0;
		int topDrinks = 0;

		  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		  DateFormat dateFormatOD= new SimpleDateFormat("yyyy/MM/");

		   //get current date time with Date()
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
		   String dateStr = dateFormat.format(date);


		   
		   
		try {
			
			
//			topAppetiz = DataBase.getTotalAmount(dateStr);
//			topEntress = DataBase.getTotalAmount("Dallas");
//			topDesserts = DataBase.getTotalAmount("NewYork");
//			topDrinks = DataBase.getTotalAmount("NewYork");

			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	      final String AItem1 = "Nachos";        
	      final String AItem2 = "Potato Skins";        
	      final String AItem3 = "Spring Rolls";  
	      
	      final String EItem1 = "Hamburger";        
	      final String EItem2 = "Steak";        
	      final String EItem3 = "Chicken Parmesan";
	      
	      final String DessItem1 = "Cheesecake";        
	      final String DessItem2 = "Ice Cream Sundae";        
	      final String DessItem3 = "Flan";
	      
	      final String DrItem1 = "Soda";        
	      final String DrItem2 = "Sweet Tea";        
	      final String DrItem3 = "Beer";
	      
	    String Item1data = "";
		String Item2data = "";
		String Item3data = "";
			
	      final String Appetizers = "Appetizers";        
	      final String Entrees = "Entrees";        
	      final String Desserts = "Desserts";        
	      final String Drinks = "Drinks";        

	      
	      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

	      dataset.addValue( 5.0 , AItem1 , Appetizers );   
	      dataset.addValue( 3.0 , AItem2 , Appetizers );        
	      dataset.addValue( 2.0 , AItem3 , Appetizers );        

	      
	      dataset.addValue( 4.0 , EItem1 , Entrees );  
	      dataset.addValue( 3.0 , EItem2 , Entrees ); 
	      dataset.addValue( 1.0 , EItem3 , Entrees );        


	      dataset.addValue( 5.0 , DessItem1 , Desserts ); 
	      dataset.addValue( 2.0 , DessItem2 , Desserts );        
	      dataset.addValue( 1.0 , DessItem3 , Desserts );        

	      dataset.addValue( 3.0 , DrItem1 , Drinks );           
	      dataset.addValue( 2.0 , DrItem2 , Drinks );
	      dataset.addValue( 1.0 , DrItem3 , Drinks );               

	      return dataset; 
	  }
	
	public void loadDB(){
		
		
		
		
	}
	public void loadView(String applicationTitle , String chartTitle){

		
		mainView = new JPanel();
		mainView.setBackground(Color.BLACK);
		mainView.setLayout(new BorderLayout(0, 0));

	      JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,           
	         "Category",            
	         "amount",            
	         createDataset(),          
	         PlotOrientation.VERTICAL,           
	         true, true, false);
	      
	      JPanel panel = new JPanel();
	      mainView.add(panel, BorderLayout.NORTH);
	      panel.setLayout(new BorderLayout(0, 0));
	      
	      btnBack = new JButton("back");
	      panel.add(btnBack, BorderLayout.WEST);
	      btnBack.addActionListener(this);

	      JPanel panel_1 = new JPanel();
	      mainView.add(panel_1, BorderLayout.CENTER);
	      panel_1.setLayout(new BorderLayout(0, 0));
	      
	      ChartPanel chartPanel = new ChartPanel( barChart );        
	      panel_1.add(chartPanel);
	      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
	      chartPanel.setLayout(new BorderLayout(0, 0));
		
		
	}
	
	
    public JPanel returnView(){    	
    	
		return mainView;
    }
}
