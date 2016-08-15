import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;

public class interfaceView implements ActionListener{
	private JPanel mainView;
	private JButton btnDailyRevenue,btnDailySummary,btnCompReport;
	private JPanel panel;
	private JButton btnBack;
	private JPanel panel_1;
	private String tableNumber;
	public interfaceView(String TableNumber){
		tableNumber = TableNumber;
		loadView();
		

		
	}
	
	

	 public void actionPerformed(ActionEvent ae){
	        JButton button = (JButton) ae.getSource();
			JPanel contentPane = prototype_standard.returnContentPaneView();
			
			if(button == btnDailyRevenue){
				dailyRevenue view = new dailyRevenue(tableNumber);
				JPanel newView = view.returnView();
				
				contentPane.removeAll();
			   	contentPane.add(newView);
			}else if(button == btnDailySummary){
				DailySummaryReportView view = new DailySummaryReportView(tableNumber);
				JPanel newView = view.returnView();
				
				contentPane.removeAll();
			   	contentPane.add(newView);
			}else if(button == btnCompReport){
				CompReportView view = new CompReportView(tableNumber);
				JPanel newView = view.returnView();
				
				contentPane.removeAll();
			   	contentPane.add(newView);
			}else if(button == btnBack){
				
				managerView view = new managerView(tableNumber);
				JPanel newView = view.returnManagerView();
				
				contentPane.removeAll();
			   	contentPane.add(newView);
			}

			 // reload the window
	    	contentPane.revalidate();
	    	contentPane.repaint();	
			
			
	 }
    public JPanel returnView(){    	
    	
		return mainView;
    }
    
    
	public void loadView(){

		
		mainView = new JPanel();
		mainView.setBackground(Color.BLACK);
		mainView.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		mainView.add(panel, BorderLayout.CENTER);
				panel.setLayout(new GridLayout(0, 1, 0, 0));
		
				btnDailySummary = new JButton("daily summary");
				panel.add(btnDailySummary);
				btnDailySummary.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
						
						btnCompReport = new JButton("comp report");
						panel.add(btnCompReport);
						btnCompReport.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
						btnCompReport.addActionListener(this);
				
						btnDailyRevenue = new JButton("daily revenue");
						panel.add(btnDailyRevenue);
						btnDailyRevenue.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
						
						panel_1 = new JPanel();
						mainView.add(panel_1, BorderLayout.NORTH);
						panel_1.setLayout(new BorderLayout(0, 0));
						
						btnBack = new JButton("back");
						panel_1.add(btnBack, BorderLayout.WEST);
						btnDailyRevenue.addActionListener(this);
		btnDailySummary.addActionListener(this);
		btnBack.addActionListener(this);

		
		
	}
}
