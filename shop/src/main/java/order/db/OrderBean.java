package order.db;

import java.util.Date;

public class OrderBean {

	private int orderNum;
	private String orderTradeNum;
	private String orderTransNum;
	private int orderGoodsNum;
	private String orderGoodsName;
	private int orderGoodsAmount;
	private String orderGoodsSize;
	private String orderGoodsColor;
	private String orderMemberId;
	private String orderReceiveName;
	private String orderReceiveAddr1;
	private String orderReceiveAddr2;
	private String orderReceivePhone;
	private String orderReceiveMobile;
	private String orderMemo;
	private int orderSumMoney;
	private String orderTradeType;
	private Date orderTradeDate;
	private String orderTradePayer;
	private Date orderDate;
	private int orderStatus;

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderTradeNum() {
		return orderTradeNum;
	}

	public void setOrderTradeNum(String orderTradeNum) {
		this.orderTradeNum = orderTradeNum;
	}

	public String getOrderTransNum() {
		return orderTransNum;
	}

	public void setOrderTransNum(String orderTransNum) {
		this.orderTransNum = orderTransNum;
	}

	public int getOrderGoodsNum() {
		return orderGoodsNum;
	}

	public void setOrderGoodsNum(int orderGoodsNum) {
		this.orderGoodsNum = orderGoodsNum;
	}

	public String getOrderGoodsName() {
		return orderGoodsName;
	}

	public void setOrderGoodsName(String orderGoodsName) {
		this.orderGoodsName = orderGoodsName;
	}

	public int getOrderGoodsAmount() {
		return orderGoodsAmount;
	}

	public void setOrderGoodsAmount(int orderGoodsAmount) {
		this.orderGoodsAmount = orderGoodsAmount;
	}

	public String getOrderGoodsSize() {
		return orderGoodsSize;
	}

	public void setOrderGoodsSize(String orderGoodsSize) {
		this.orderGoodsSize = orderGoodsSize;
	}

	public String getOrderGoodsColor() {
		return orderGoodsColor;
	}

	public void setOrderGoodsColor(String orderGoodsColor) {
		this.orderGoodsColor = orderGoodsColor;
	}

	public String getOrderMemberId() {
		return orderMemberId;
	}

	public void setOrderMemberId(String orderMemberId) {
		this.orderMemberId = orderMemberId;
	}

	public String getOrderReceiveName() {
		return orderReceiveName;
	}

	public void setOrderReceiveName(String orderReceiveName) {
		this.orderReceiveName = orderReceiveName;
	}

	public String getOrderReceiveAddr1() {
		return orderReceiveAddr1;
	}

	public void setOrderReceiveAddr1(String orderReceiveAddr1) {
		this.orderReceiveAddr1 = orderReceiveAddr1;
	}

	public String getOrderReceiveAddr2() {
		return orderReceiveAddr2;
	}

	public void setOrderReceiveAddr2(String orderReceiveAddr2) {
		this.orderReceiveAddr2 = orderReceiveAddr2;
	}

	public String getOrderReceivePhone() {
		return orderReceivePhone;
	}

	public void setOrderReceivePhone(String orderReceivePhone) {
		this.orderReceivePhone = orderReceivePhone;
	}

	public String getOrderReceiveMobile() {
		return orderReceiveMobile;
	}

	public void setOrderReceiveMobile(String orderReceiveMobile) {
		this.orderReceiveMobile = orderReceiveMobile;
	}

	public String getOrderMemo() {
		return orderMemo;
	}

	public void setOrderMemo(String orderMemo) {
		this.orderMemo = orderMemo;
	}

	public int getOrderSumMoney() {
		return orderSumMoney;
	}

	public void setOrderSumMoney(int orderSumMoney) {
		this.orderSumMoney = orderSumMoney;
	}

	public String getOrderTradeType() {
		return orderTradeType;
	}

	public void setOrderTradeType(String orderTradeType) {
		this.orderTradeType = orderTradeType;
	}

	public Date getOrderTradeDate() {
		return orderTradeDate;
	}

	public void setOrderTradeDate(Date orderTradeDate) {
		this.orderTradeDate = orderTradeDate;
	}

	public String getOrderTradePayer() {
		return orderTradePayer;
	}

	public void setOrderTradePayer(String orderTradePayer) {
		this.orderTradePayer = orderTradePayer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

}
