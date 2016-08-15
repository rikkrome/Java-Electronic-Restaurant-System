
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class CompReportView implements ActionListener{
	
	private JPanel mainView;
	private JTable table;
	private String tableNumber;
	private JButton btnBack;
	private String compAmount;
	private JLabel lblAlert;
	private JPanel newView;
	
	public CompReportView(String TableNumber){
		tableNumber = TableNumber;

		
		table = new JTable();

		reloadTables();
		
		
		loadView();


	}
	 public void reloadTables(){   
			ResultSet resultForOrder = null;
			String resultSUMAmount = "";

			try {
				resultForOrder = DataBase.get("CompReport","","").executeQuery();
				resultSUMAmount = DataBase.getSUMofCompReport("");
				System.out.print(resultSUMAmount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			table.setModel(DbUtils.resultSetToTableModel(resultForOrder));
			if(resultSUMAmount != null){
				compAmount = resultSUMAmount;
			}
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
		public JPanel returnView(){    	
	    	
			return mainView;
	    }
	    public void  loadView(){
	    	
			mainView = new JPanel();

			mainView.setLayout(new BorderLayout(0, 0));
			
			JPanel panel = new JPanel();
			mainView.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane);
			
			scrollPane.setViewportView(table);
			
			JPanel panel_1 = new JPanel();
			panel.add(panel_1);
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2);
			panel_2.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel label_1 = new JLabel("Total Cost $"+compAmount);
			panel_2.add(label_1);
			label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			
			JPanel panel_3 = new JPanel();
			panel_1.add(panel_3);
			panel_3.setLayout(new GridLayout(0, 1, 0, 0));

			JPanel panel_4 = new JPanel();
			mainView.add(panel_4, BorderLayout.NORTH);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			 btnBack = new JButton("back");
			panel_4.add(btnBack, BorderLayout.WEST);
			
			lblAlert = new JLabel("");
			panel_4.add(lblAlert, BorderLayout.EAST);
			btnBack.addActionListener(this);
	    	
	    }

}
