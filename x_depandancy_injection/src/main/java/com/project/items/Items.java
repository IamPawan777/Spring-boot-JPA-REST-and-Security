package com.project.items;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component("itm1")
public class Items {
	private int noOfItem;
	private ArrayList<String> itemName;
	
	
	public Items() {
		super();
//		System.out.println("Item class...");
	}
	public int getNoOfItem() {
		return noOfItem;
	}
	public void setNoOfItem(int noOfItem) {
		this.noOfItem = noOfItem;
	}
	public ArrayList<String> getItemName() {
		return itemName;
	}
	public void setItemName(ArrayList<String> itemName) {
		this.itemName = itemName;
	}
	
	
}
