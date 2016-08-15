
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class kitchenStaffView extends JFrame implements ActionListener{
	
	private JPanel kitchenStaffView , panel_northSection, panel_STS_labelHolder,panel_2_buttonLayout ; 
	private JLabel lblKitchenStaffView ; 
	private JButton btnBack_KitchenStaffView , btnViewMenu_KitchenStaffView ,btnOrderQueue_KitchenStaffView;
	
	public kitchenStaffView(){
		System.out.print("kitchenStaffView\n");

		loadKitchenStaffView();
	}
	
    public void actionPerformed(ActionEvent ae){

        JButton button = (JButton) ae.getSource();
		JPanel contentPane = prototype_standard.returnContentPaneView();

        /*
         * Kitchen Staff buttons	
         */
         if (button == btnBack_KitchenStaffView){
        	 
        	 staffTypeSelectionView staffTypeSelection = new staffTypeSelectionView();
         	JPanel GoBackToView = staffTypeSelection.returnStaffTypeSelectionView();
         	
      	    contentPane.removeAll();
      	    contentPane.add(GoBackToView);
	
        }else if (button == btnOrderQueue_KitchenStaffView){
        	
        	KitchenOrderQueueView staffTypeSelection = new KitchenOrderQueueView();
        	JPanel GoToView = staffTypeSelection.returnKitchenOrderQueueView();
        	
     	    contentPane.removeAll();
     	    contentPane.add(GoToView);
        	
        	
        }else if (button == btnViewMenu_KitchenStaffView){
        	//contentPane.removeAll();
        	//get table status page        	
        }
         
       	contentPane.revalidate();
       	contentPane.repaint();
        
    }
    
    public JPanel returnKitchenStaffView(){    	
    	
		return kitchenStaffView;
    }
    
    public void loadKitchenStaffView(){

    	kitchenStaffView = new JPanel();
//    	contentPane.add(kitchenStaffView, BorderLayout.CENTER);
    	kitchenStaffView.setLayout(new BorderLayout(0, 0));
    	
    	panel_northSection = new JPanel();
    	kitchenStaffView.add(panel_northSection, BorderLayout.NORTH);
    	panel_northSection.setLayout(new BorderLayout(0, 0));
    	
    	btnBack_KitchenStaffView = new JButton("back");
    	panel_northSection.add(btnBack_KitchenStaffView, BorderLayout.WEST);
    	
    	panel_STS_labelHolder = new JPanel();
    	panel_northSection.add(panel_STS_labelHolder, BorderLayout.SOUTH);
    	
    	    	
    	lblKitchenStaffView = new JLabel("Kitchen Staff View");
    	panel_STS_labelHolder.add(lblKitchenStaffView);
    	btnBack_KitchenStaffView.addActionListener(this);
    	
    	panel_2_buttonLayout = new JPanel();
    	kitchenStaffView.add(panel_2_buttonLayout, BorderLayout.CENTER);
    	panel_2_buttonLayout.setLayout(new GridLayout(0, 2, 0, 0));
    	
    	btnViewMenu_KitchenStaffView = new JButton("View Menu");
    	panel_2_buttonLayout.add(btnViewMenu_KitchenStaffView);
    	btnViewMenu_KitchenStaffView.addActionListener(this);
    	
    	btnOrderQueue_KitchenStaffView = new JButton("Order Queue");
    	panel_2_buttonLayout.add(btnOrderQueue_KitchenStaffView);
    	btnOrderQueue_KitchenStaffView.addActionListener(this);

    }

}
