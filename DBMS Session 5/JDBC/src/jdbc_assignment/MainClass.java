package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainClass {

	private String JDBCDriver = "com.mysql.cj.jdbc.Driver";
	private String host = "jdbc:mysql://localhost:3306/";
	private String userId = "root";
	private String pass = "root";

	// function to set up the connection with database and return connection object
	public Connection setUpConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(this.JDBCDriver);
		connection = DriverManager.getConnection(this.host+"storefront", this.userId, this.pass);
		return connection;
	}
	
	/**
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user 
	 * which are in shipped state. Orders should be sorted by 
	 * order date column in chronological order.
	 * @param userId
	 * 				integer userId for which we have to display all the orders
	 * @return
	 * 				ArrayList of the orders
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Orders> fetchAllOrders(int userId) throws SQLException,ClassNotFoundException{
		String query = "select o.orderId, o.totalAmount, o.status, o.date from orders as o"
				+ " inner join user as u on u.userId = o.userId and u.userId = "
				+ userId + " where o.status = 'Shipped' order by o.date";
		Connection connection = setUpConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Orders> orderList = new ArrayList<Orders>();

		while (resultSet.next()) {
			Orders order = new Orders(resultSet.getInt(1),resultSet.getInt(2), 
					resultSet.getString(3),resultSet.getTimestamp(4));
			orderList.add(order);
		}
		connection.close();
		preparedStatement.close();
		return orderList;
	}

	/**
	 * Delete all those products which were not ordered by any Shopper in last 1
	 * year. Return the number of products deleted
	 * 
	 * @return 
	 * 			number of products deleted
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteProduts() throws SQLException, ClassNotFoundException {
		String safeUpdate = "set foreign_key_checks=0; ";
		String query = "delete from products where productId not in ("
				+ " select distinct(od.productId) from orderDetails as od"
				+ " inner join orders as o on o.orderId = od.orderId"
				+ " where datediff(now(), o.date)<365);";
		Connection connection = setUpConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(safeUpdate);
		preparedStatement.execute();
		preparedStatement = connection.prepareStatement(query);
		int result = preparedStatement.executeUpdate();
		connection.close();
		preparedStatement.close();
		return result;
	}

	/**
	 * Insert five or more images of a product using batch insert technique
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void insertImage() throws SQLException, ClassNotFoundException {
		String[] queries = {
			"INSERT INTO productImages (imageId, productId, path) values (416, 3010, 'Redmi Note 7 Image 1')",
			"INSERT INTO productImages (imageId, productId, path) values (417, 3010, 'Redmi Note 7 Image 2')",
			"INSERT INTO productImages (imageId, productId, path) values (418, 3010, 'Redmi Note 7 Image 3')",
			"INSERT INTO productImages (imageId, productId, path) values (419, 3010, 'Redmi Note 7 Image 4')",
			"INSERT INTO productImages (imageId, productId, path) values (420, 3010, 'Redmi Note 7 Image 5')" };
		Connection connection = setUpConnection();
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		for (String query : queries){
			statement.addBatch(query);			
		}

		statement.executeBatch();
		connection.commit();
		connection.close();
		statement.close();

	}

	/**
	 * Select and display the category title of all top parent categories sorted
	 * alphabetically and the count of their child categories
	 * 
	 * @return 
	 * 			ArrayList of categories
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Category> displayTopCategories() throws SQLException,
			ClassNotFoundException {
		String query = "select c.cid, c.cname, count(chld.cid) from category as c"+
						" left join category as chld on c.cid = chld.parentId"+
						" where c.parentId is null "+
						"group by c.cid order by c.cname;";

		Connection connection = setUpConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Category> categoryList = new ArrayList<Category>();

		while (resultSet.next()) {
			Category category = new Category(resultSet.getInt(1),
					resultSet.getString(2), resultSet.getInt(3));
			categoryList.add(category);
		}
		connection.close();
		preparedStatement.close();
		return categoryList;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
	try {
		MainClass jdbcMain = new MainClass();
		ArrayList<Orders> orderList = jdbcMain.fetchAllOrders(1004);
		for (Orders order : orderList)
			System.out.println(order);
//		System.out.println(jdbcMain.deleteProduts());
//		jdbcMain.insertImage();
		ArrayList<Category> categoryList = jdbcMain.displayTopCategories();
		for (Category category : categoryList)
			System.out.println(category);
	} catch (SQLException sqlException) {
		System.out.println(sqlException.getMessage());
	}
}
}
