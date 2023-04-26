package com.purchaseOrder.dto;

import java.util.List;

import com.purchaseOrder.entity.ShoppingCart;
import com.purchaseOrder.entity.Customer.MyEnum;

public class OrderDTO {

	private String orderDescription;
    private List<ShoppingCart> cartItems;
    private String customerEmail;
    private String customerName;
    
    
    //
    private MyEnum customerGender;
    private Integer customerAge;
    private String customerCity;
    
    public OrderDTO() {
    }

    public OrderDTO(String orderDescription, List<ShoppingCart> cartItems, String customerEmail, String customerName,MyEnum gender,Integer age,String city) {
        this.orderDescription = orderDescription;
        this.cartItems = cartItems;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerGender= gender;
		this.customerAge= age;
		this.customerCity=city;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public MyEnum getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(MyEnum customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }
    
    public void setCustomerAge(Integer customerAge) {
    	this.customerAge = customerAge;
    }
    
    public Integer getCustomerAge() {
    	return customerAge;
    }
 
    @Override
	public String toString() {
		return "OrderDTO [orderDescription=" + orderDescription + ", cartItems=" + cartItems + ", customerEmail="
				+ customerEmail + ", customerName=" + customerName + ", gender=" + customerGender + ", age=" + customerAge + ", city="
				+ customerCity + "]";
	}
}
