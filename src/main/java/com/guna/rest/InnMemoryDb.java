package com.guna.rest;

	import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

	// H2 In-Memory Database Example shows about storing the database contents into memory.

	public class InnMemoryDb {

	   public static void main(String args[]) {
		  Product product = new Product();
		   product.setName("Zambi");
		   product.setType("ZAMBIA");
		  /* SessionFactory factory = buildSessionFactory(Product.class);
		   Session ses=factory.openSession();
		   ses.save(product);*/
		   CreateProduct c= new CreateProduct();
		   c.createProduct(product);
		   ViewAllProducts v = new ViewAllProducts();
		   List<Product> l = v.getProductList("ZAMBIA");
		   for(Product p:l) {
			   System.out.println(p.getName());
		   }
		   
		   RemoveProduct removeProductImpl = new RemoveProduct();
		   removeProductImpl.deleteProduct(1);
		   
	   }
	   
	   private static SessionFactory buildSessionFactory(Class clazz) {
		   return new Configuration()
				   .configure()
				   .addAnnotatedClass(clazz)
				   .buildSessionFactory();
	   }
	}
