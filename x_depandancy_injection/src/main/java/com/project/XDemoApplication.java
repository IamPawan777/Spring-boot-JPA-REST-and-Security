package com.project;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

import com.project.items.Items;
import com.project.product.Product;

//@ComponentScan("com")
@SpringBootApplication
public class XDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con = SpringApplication.run(XDemoApplication.class, args);
		
		Product bean = (Product)con.getBean("pdt1");
		System.out.println(bean);
		System.out.println(bean.getP_id());
		System.out.println(bean.getItem().getNoOfItem());
		System.out.println(bean.getItem().getItemName());
	}
	
	
	
	
	@Bean("pdt1")
	public Product funProduct() {
		Product pt = new Product(1);
		return pt;		
	}
	
//	@Primary
	@Bean("itm2")
	public Items funItems() {
		Items obj = new Items();
		obj.setNoOfItem(34);
		ArrayList<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		obj.setItemName(list);
		return obj;
	}

}
