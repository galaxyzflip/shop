package basket.db;

import java.util.Date;

public class BasketBean {

	private int basketNum;
	private String basketMemberId;
	private int basketGoodsNum;
	private int basketGoodsAmount;
	private String basketGoodsSize;
	private String basketGoodsColor;
	private Date basketDate;

	public int getBasketNum() {
		return basketNum;
	}

	public void setBasketNum(int basketNum) {
		this.basketNum = basketNum;
	}

	public String getBasketMemberId() {
		return basketMemberId;
	}

	public void setBasketMemberId(String basketMemberId) {
		this.basketMemberId = basketMemberId;
	}

	public int getBasketGoodsNum() {
		return basketGoodsNum;
	}

	public void setBasketGoodsNum(int basketGoodsNum) {
		this.basketGoodsNum = basketGoodsNum;
	}

	public int getBasketGoodsAmount() {
		return basketGoodsAmount;
	}

	public void setBasketGoodsAmount(int basketGoodsAmount) {
		this.basketGoodsAmount = basketGoodsAmount;
	}

	public String getBasketGoodsSize() {
		return basketGoodsSize;
	}

	public void setBasketGoodsSize(String basketGoodsSize) {
		this.basketGoodsSize = basketGoodsSize;
	}

	public String getBasketGoodsColor() {
		return basketGoodsColor;
	}

	public void setBasketGoodsColor(String basketGoodsColor) {
		this.basketGoodsColor = basketGoodsColor;
	}

	public Date getBasketDate() {
		return basketDate;
	}

	public void setBasketDate(Date basketDate) {
		this.basketDate = basketDate;
	}

}
