
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class prototype_standard extends JFrame  {

	private static JPanel contentPane;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					prototype_standard frame = new prototype_standard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public prototype_standard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 397);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		try {
			testConnectionDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loadUserTypeSelectionView();
		
		/*
		 * If you click on the Design tap on this file. Eclipse will close. due to 'setUndecorated(true);'
		 * there is nothing to edit on windowbuilder on this file.
		 * 
		 * To edit in window builder highlight the file you want to edit
		 * right click on it and go to - open with - windowbuilder editor
		 * should open a new tap and should have the two taps on the bottom.'Source' 'Design'
		 */
		
		
	}
	
    public static  JPanel returnContentPaneView(){    	
    	
    	
    	return contentPane;
    }
    public void loadUserTypeSelectionView(){
//    	CompItemView userTypeSelection = new CompItemView();
//		JPanel userTypeSelectionView = userTypeSelection.returnView()();

		UserTypeSelectionView userTypeSelection = new UserTypeSelectionView();
		JPanel userTypeSelectionView = userTypeSelection.returnUserTypeSelectionView();
		
		contentPane.removeAll();
	   	contentPane.add(userTypeSelectionView);
    
    }
	public static void testConnectionDB() throws Exception{
		
		DataBase.getConnection();
		
//		
//		try {
//			DataBase.updateTableStatus("help","no","3");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}


    	

}




