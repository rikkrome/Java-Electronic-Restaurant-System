
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataBase {
	
	/*
	 * 
	 * 
	 * "DELETE FROM `prototype`.`test` WHERE `test`.`id` = 5"?
	 * DELETE TOP (1) FROM   mytable
	 * DELETE TOP 1 FROM `OrderQueue` 
	 * 
	 * DELETE FROM `OrderQueue` LIMIT  1
	 * 
	 * move only one. To move all remove LIMIT 1
	 * INSERT INTO `cooking`(`tableNumber`, `foodName`, `comments`, `status`)
		SELECT * FROM OrderQueue
		LIMIT 1
		
		//move only some items over. here we are only move items in table 2
		INSERT INTO `cooking`(`tableNumber`, `foodName`, `comments`, `status`)
		SELECT * FROM OrderQueue
		WHERE tableNumber = '2'
	 */
	
	public static String sendCode(String gencode) throws Exception{

		String query = "INSERT INTO `promocodes` (`code`) VALUES '"+gencode+"'";
		   try{
			    Connection con = DataBase.getConnection();
				PreparedStatement post = con.prepareStatement(query);
				post.executeUpdate();
				System.out.println("Sent");
		   }catch(Exception e){ 
				System.out.println(e);
			}finally{ 
				System.out.println("Insert complete"); 
			}
		return null;
	}
	public static void postToLogin(String username,String Password,String Bday) throws Exception{

		String query = "";

		query = "INSERT INTO `rewardProgram`(`username`, `password`,`birthday`) VALUES ('"+username+"','"+Password+"','"+Bday+"')";


		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(query);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Insert complete"); 
		}
	}
	public static boolean loginCheck(String username) throws Exception{


		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();
		String query = "";
		String check = "";
		query = "SELECT  `username` FROM `rewardProgram` WHERE `username` = '"+username+"'";
			
		
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				
				check = result.getString("username");
			}

			System.out.println(" All records have been selected!");
			if(check != ""){
				
				return true;
			}else{
				return false;
			}
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return false;
	}
	public static String TopItemsReport(String type) throws Exception{


		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();
		String amount = "";
		String query = "";
		
		query = "select `foodName`, COUNT(`foodName`) AS topItems from `TotalSales`  GROUP BY `foodName` ORDER BY COUNT(`foodName`) DESC LIMIT  3";
			
			
			
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				amount = result.getString("totalAmount");

			}
			System.out.println(amount+" All records have been selected!");

			return amount;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	public static int getTotalAmount(String date) throws Exception{


		   
		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();

		String query = "";
		int amount = 0;
		query = "SELECT SUM(  `price` ) AS totalAmount FROM  `TotalSales` WHERE `date` = '"+date+"'";
			
		
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				 amount = Integer.parseInt(result.getString("totalAmount"));
			}
			
			
			System.out.println("Amount: "+amount+" All records have been selected!");

			return amount;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return 0;
	}
	public static void paybill(String tableNumber) throws Exception{
		
			
		
		
		  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		   //get current date time with Date()
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
		   String dateStr = dateFormat.format(date);
		String query = "";
		String Deletequery = "";

		 query = "INSERT INTO `TotalSales`(`foodName`, `price`,`date`) SELECT `foodName`, `price`,'"+dateStr+"' FROM billing WHERE `tableNumber` = '"+tableNumber+"'";
		 
		Deletequery = "DELETE FROM `billing` WHERE `tableNumber` = '"+tableNumber+"'";

		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(query);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Insert complete"); 
		}
		
		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(Deletequery);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Delete complete"); 
		}
		
		
	}
	public static void postToComp(String id , String saffName,String foodName,String price,String des) throws Exception{

		/*
		 * 
INSERT INTO `compItems`( `waitStaffName`, `FoodName`, `price`, `CompDescription`) VALUES ('ricky','test1','5','');
DELETE FROM `billing` WHERE `id` = '3';
		 */
		String query1 = "";
		String query2 = "";

		
		query1 = "INSERT INTO `compItems`(`waitStaffName`, `FoodName`, `price`, `CompDescription`) VALUES ('"+saffName+"','"+foodName+"','"+price+"','"+des+"');";
//		query2 = " DELETE FROM `billing` WHERE `id` = '"+id+"';";
			

		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(query1);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Insert complete"); 
		}
	}

	public static String getSUMofCompReport(String type) throws Exception{


		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();
		String amount = "";
		String query = "";
		
			query = "SELECT SUM(`price`) AS totalAmount FROM `compItems`";
			
			
			
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				amount = result.getString("totalAmount");

			}
			System.out.println(amount+" All records have been selected!");

			return amount;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	public static String getSUMofBill(String tableNumber) throws Exception{


		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();
		String amount = "";
		String query = "";
		
			query = "SELECT SUM(`price`) AS totalAmount FROM `billing` WHERE `tableNumber` = '"+tableNumber+"'";
			
			
			
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				amount = result.getString("totalAmount");

			}
			System.out.println(amount+" All records have been selected!");

			return amount;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	public static void updateFoodStatus(String all ,String table,String update, String tableNumber ,String id) throws Exception{

		String query = "";
		if(all == "yes"){
			query = "UPDATE `"+table+"` SET `status`='"+update+"' WHERE `tableNumber` = '"+tableNumber+"' ";
//			UPDATE `OrderQueue` SET `status`= 'cooking' WHERE `tableNumber` = 4 AND `id` = 3
		}else{
			System.out.println("updating "+table); 
			query = "UPDATE `"+table+"` SET `status`='"+update+"' WHERE `id` = "+id+"";

		}
		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(query);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Insert complete"); 
		}
	}
	public static void updateTableStatus(String Columns,String update, String tableNumber ) throws Exception{

		String query = "";
			query = "UPDATE `tableStatus` SET `"+Columns+"`= '"+update+"' WHERE `tableNumber` = '"+tableNumber+"' ;";


		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(query);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Insert complete"); 
		}
	}
	
	public static void moveOneItemToOtherTable(String newTable, String oldTable,String tablenumber,String view,String status) throws Exception{

		String query = "";
		if(view == "kitchen"){
			query = "INSERT INTO `"+newTable+"`(`id`,`food_ID`,`tableNumber`, `foodName`, `comments`, `status`) SELECT `id`, `food_ID`, `tableNumber`, `foodName`, `comments`, '"+status+"'  FROM "+oldTable+" LIMIT 1";

		}else if(view == "orderView"){
			query = "INSERT INTO `"+newTable+"`(`id`,`food_ID`,`tableNumber`, `foodName`, `comments`, `status`) SELECT * FROM "+oldTable+" WHERE  `tableNumber` = "+tablenumber;

		}else if(view == "kitchenToBilling"){
			query = "INSERT INTO `"+newTable+"`(`tableNumber`, `foodName`, `comments`, `status`) SELECT * FROM "+oldTable+" LIMIT 1";

		}else if(view == "FoodStatus"){
			query = "INSERT INTO `"+newTable+"`(`id`, `tableNumber`, `foodName`, `status`) SELECT `id`, `tableNumber`, `foodName`, '"+status+"' FROM "+oldTable+" WHERE  `tableNumber` = "+tablenumber;

		}	
			
		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(query);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Insert complete"); 
		}
	}
	public static void moveOneItemfromKitchenToBilling(String id ,String tablenumber,String foodName,String comments,String price,String status) throws Exception{

		String query = "";
			query = "INSERT INTO `billing`(`food_ID`,`tableNumber`, `foodName`, `comments`,`price`, `status`) VALUES ('"+id+"','"+tablenumber+"','"+foodName+"','"+comments+"','"+price+"','"+status+"')";


		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(query);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Insert complete"); 
		}
	}
	public static void deleteOneItemFromTable(String Table,String tableNumber,String view) throws Exception{
		String query = "";

		if(view == "kitchen"){
			
		 query = "DELETE FROM `"+Table+"` LIMIT  1";
		}else if(view == "orderView"){
			
			 query = "DELETE FROM `"+Table+"` WHERE  `tableNumber` = "+tableNumber;
		}else if(view == "CompView"){
			
			 query = "DELETE FROM `billing` WHERE `id` = '"+tableNumber+"';";
		}
		
		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(query);
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Delete complete"); 
		}
	}
	public static PreparedStatement get(String view, String database,String tablenumber) throws Exception{

		//SELECT * FROM tablename //<- * select all
		//SELECT * FROM tablename LIMIT 1//<- returns 1
		//"SELECT first,last FROM users ORDER BY last DESC" 
		//SELECT first,last FROM tablename
		String query = "";
		if(view == "kitchen"){
			
			query = "SELECT `tableNumber`,`foodName`,`comments`,`status` FROM "+database;
			
		}else if(view == "orderView"){
			query = "SELECT `tableNumber`,`foodName`,`comments`,`status` FROM "+database+" WHERE  `tableNumber` = "+tablenumber;
		}else if(view == "billingView"){
			query = "SELECT `tableNumber`, `foodName`, `comments`,`price`, `status` FROM "+database+" WHERE  `tableNumber` = "+tablenumber;
			
		}else if(view == "CompView"){
			query = "SELECT `id`,`tableNumber`, `foodName`, `comments`,`price`, `status` FROM "+database+" WHERE  `tableNumber` = "+tablenumber;
			
		}else if(view == "FoodStatus"){
			query = "SELECT `foodName`, `status` FROM "+database+" WHERE  `tableNumber` = "+tablenumber;
			
		}else if(view == "CompReport"){
			query = "SELECT * FROM `compItems`";
			
		}
		else {
			query = "SELECT * FROM "+database;
			
		}
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			System.out.println("All records have been selected!");

			return get;

			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	public static ArrayList<String> getArrayOneItem(String view, String database,String Item) throws Exception{

		//SELECT * FROM tablename //<- * select all
		//SELECT * FROM tablename LIMIT 1//<- returns 1
		//"SELECT first,last FROM users ORDER BY last DESC" 
		//SELECT first,last FROM tablename
		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();

		String query = "";
		if(view != ""){
			query = "SELECT * FROM `"+database+"` WHERE `menuItemType` = '"+view+"'";
			
		}else {
			query = "SELECT * FROM "+database;
		}
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				//do a if else save array data 
				array.add(result.getString(Item));
			}
			System.out.println("All records have been selected!");

			return array;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	public static ArrayList<String> getArrayOneItemFromKitReadyQueue(String table) throws Exception{

		ArrayList<String> array = new ArrayList<String>();

		String query = "";
			query = "SELECT * FROM `"+table+"` LIMIT 1";
			
		
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				//do a if else save array data 
				array.add(result.getString("id"));
				array.add(result.getString("food_ID"));
				array.add(result.getString("tableNumber"));
				array.add(result.getString("foodName"));
				array.add(result.getString("comments"));
			}
			System.out.println("All records have been selected!");

			return array;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	public static ArrayList<String> getItembyID(String id, String database) throws Exception{


		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();

		String query = "";
		if(id != ""){
			query = "SELECT * FROM `"+database+"` WHERE `id` = '"+id+"'";
			
		}else {
			query = "SELECT * FROM "+database;
		}
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				//do a if else save array data 
				array.add(result.getString("name"));
				array.add(result.getString("price"));
				array.add(result.getString("description"));
				array.add(result.getString("health"));

			}
			System.out.println("All records have been selected!");

			return array;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	public static ArrayList<String> getItembyIDBilling(String id) throws Exception{


		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();

		String query = "";
		if(id != ""){
			query = "SELECT * FROM `billing` WHERE `id` = "+id+"";
		}
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				//do a if else save array data 
				array.add(result.getString("foodName"));
				array.add(result.getString("price"));


			}
			System.out.println("All records have been selected!");

			return array;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	
	public static void postDataBaseTable(String dataBaseName,String id,String tableNumber,String name,String comments,String status) throws Exception{



		try{
			//connect to database
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO "+dataBaseName+"(food_ID,tableNumber,foodName,comments,status) VALUES('"+id+"','"+tableNumber+"','"+name+"','"+comments+"','"+status+"')");
			posted.executeUpdate();

		} catch(Exception e){ 
			System.out.println(e);
		}
		finally{ 
			System.out.println("Insert complete"); 
		}
	}
	
	
	public static Connection getConnection() throws Exception{
		System.out.println("getConnection");

		try{
		String driver = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://phpmy.cjtsabhtufj6.us-west-2.rds.amazonaws.com/prototype";
//		String url = "jdbc:mysql://localhost/prototype";
		String username = "phpmy";
		String password = "phpmyadmin";
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connected");
		return conn;
		
		} catch(Exception e){
			System.out.println(e);
		} 
		
		
		return null;
	}
	
	//pulling info from table status
	public static ArrayList<String> getItemStatus(String tableNumber) throws Exception{


		//SELECT * FROM `MenuDB` WHERE `id` = '1'
		ArrayList<String> array = new ArrayList<String>();

		String query = "";
		
		query = "SELECT  `Status`, `refill`, `help` FROM `tableStatus` WHERE `tableNumber` = '"+tableNumber+"'";
			
		
		try{
			Connection con = getConnection();
			PreparedStatement get = con.prepareStatement(query);
			
			ResultSet result = get.executeQuery();
			
			while(result.next()){
				//do a if else save array data 
				array.add(result.getString("Status"));
				array.add(result.getString("refill"));
				array.add(result.getString("help"));
				

			}
			System.out.println("All records have been selected!");

			return array;
			
		} catch(Exception e){ 
			System.out.println(e);
		}
		return null;
	}
	

}
