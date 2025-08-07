package com.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.entity.Catagory;
import com.project.entity.Emp;
import com.project.entity.Mobile;
import com.project.entity.Product;
import com.project.repository.CatagoryDao;
import com.project.repository.EmpDao;
import com.project.repository.MobileDao;
import com.project.repository.ProductDao;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private EmpDao empDao;	
	@Autowired
	private MobileDao mobileDao;
	@Autowired
	private CatagoryDao catagoryDao;
	@Autowired
	private ProductDao productDao;

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// one to one
		/*
		 * Emp emp = new Emp(); emp.setEmpName("hari"); Mobile mobile = new Mobile();
		 * mobile.setMobileName("IPhane 16");
		 * 
		 * // emp.setMobile(mobile);			//  not want to show forgien in emp table
		 * mobile.setEmp(emp); 						
		 * 
		 * empDao.save(emp); mobileDao.save(mobile);
		 * 
		 * System.out.println("Save Successfully");
		 */
		 
		
		
//		 Emp emp = empDao.findById(1).get(); 
//		 System.out.println("Name: "+emp.getEmpName());
//		 System.out.println("Mobile: "+emp.getMobile().getMobileName());
//		 
//		 System.out.println("...........................");
//		 
//		 Mobile mobile = mobileDao.findById(1).get();
//		 System.out.println("Name: "+mobile.getEmp().getEmpName());
//		 System.out.println("Mobile: "+mobile.getMobileName());
		 
		
		
		
		
		// many to many
		 /*Catagory ca1 = new Catagory();
		 ca1.setCatagoryType("Electonics");
		 Catagory ca2 = new Catagory();
		 ca2.setCatagoryType("Grosory");
		 
		 Product pa1= new Product();
		 pa1.setPruductName("TV");
		 Product pa2 = new Product();
		 pa2.setPruductName("Shop");
		 Product pa3 = new Product();
		 pa3.setPruductName("Mobile");
		 
		 ca1.getProducts().add(pa1);
		 ca1.getProducts().add(pa3);
		 ca2.getProducts().add(pa2);
		 
		 pa1.getCatagories().add(ca1);
		 pa2.getCatagories().add(ca2);
		 pa3.getCatagories().add(ca1);
		 
		 catagoryDao.save(ca1);
		 catagoryDao.save(ca2);*/
		 //or
		 
		/*
		 * productDao.save(pa1); productDao.save(pa2); productDao.save(pa3);
		 */
		
		
		Catagory catagory = catagoryDao.findById(1).get();
		System.out.println(catagory.getCatagoryType()+":=");
		catagory.getProducts().forEach(x -> System.out.println(x.getPruductName()));
		
		System.out.println("..............................");
		
		Product product = productDao.findById(2).get();
//		product.getCatagories()
		System.out.println(product.getPruductName());
		product.getCatagories().forEach(x -> System.out.println(x.getCatagoryType()));
		 
		 
		 
		 
		
	}

}
