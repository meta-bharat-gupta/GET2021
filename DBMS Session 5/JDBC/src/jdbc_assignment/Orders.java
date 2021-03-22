package jdbc_assignment;

import java.sql.Timestamp;

public class Orders {

	private int orderId;
	private int orderAmount;
	private String orderStatus;
	private Timestamp orderDate;
	
	public Orders(int oid, int amount, String status, Timestamp date){
		this.orderId = oid;
		this.orderAmount = amount;
		this.orderStatus = status;
		this.orderDate = date;
	}
	
	public String toString() {
		return "Order Id=" + this.orderId + ", orderDate=" + this.orderDate
				+ ", orderAmount=" + this.orderAmount + ", orderStatus=" + this.orderStatus;
	}

	// Getters and Setters for class attributes
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
