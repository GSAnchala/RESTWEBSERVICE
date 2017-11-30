package com.guna.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.guna.dao.InMemoryDao;

@Path("/view")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ViewAllProducts {

	@GET
	List<Product> getProductList(@PathParam("PRODUCTTYPE") String productType){
		SessionFactory factory = InMemoryDao.buildSessionFactory(Product.class);
		Session ses = factory.openSession();
		Query query = ses.createQuery("from Product where type = :p1");
		query.setParameter("p1", productType);
		List<Product> pList = query.list(); 
		System.out.println(pList.size());
		return pList;
	}
}
