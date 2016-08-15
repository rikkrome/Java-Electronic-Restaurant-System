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




public class dailyRevenue implements ActionListener {

	
	
	
	private JPanel mainView;
	private String tableNumber;

	private JButton btnBack;
	
	
	public dailyRevenue(String TableNumber){
		tableNumber = TableNumber;


		
		loadView("Daily Revenue", "daily revenue");
		
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
		
		int topAmountToday = 0;
		int topAmountYest = 0;
//		int topAmountNY = 0;
		
		  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		  DateFormat dateFormatOD= new SimpleDateFormat("yyyy/MM/");

		   //get current date time with Date()
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
		   String dateStr = dateFormat.format(date);
		   
//		   String[] ary = dateStr.split("/");
////			
////
//		   int date1 = Integer.parseInt(ary[3]);
//		   String yest = ""+date1;
//		   int yesterday = Integer.parseInt(yest) - 1;
//		   
//		   String yestDate = dateFormatOD.format(date)+yesterday;
//
		   System.out.println(dateStr); //0
//		   
		   
		try {
			topAmountToday = DataBase.getTotalAmount(dateStr);
//			 topAmountYest = database.getTotalAmount("Dallas");
//			 topAmountNY = database.getTotalAmount("NewYork");
			 
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		topAmountYest = 24;
	      final String Item1 = "today $"+topAmountToday;        
	      final String Item2 = "yesterday $"+topAmountYest;        
//	      final String Item3 = "Item3";  
	      
	      
	      final String today = "today";        
	      final String yest = "yesterday";        
	      final String ny = "New York";        
	      
	      
	      final DefaultCategoryDataset dataset = 
	      new DefaultCategoryDataset( );  

	      dataset.addValue( topAmountToday , Item1 , today );        
	      dataset.addValue( topAmountYest , Item2 , yest );        
//	      dataset.addValue( topAmountNY , Item1 , ny ); 
//	      dataset.addValue( 5.0 , Item1 , safety );           

//	      dataset.addValue( 5.0 , Item2 , speed );        
//	      dataset.addValue( 6.0 , Item2 , userrating );       
//	      dataset.addValue( 10.0 , Item2 , millage );        
//	      dataset.addValue( 4.0 , Item2 , safety );
//
//	      dataset.addValue( 4.0 , Item3 , speed );        
//	      dataset.addValue( 2.0 , Item3 , userrating );        
//	      dataset.addValue( 3.0 , Item3 , millage );        
//	      dataset.addValue( 6.0 , Item3 , safety );               

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
