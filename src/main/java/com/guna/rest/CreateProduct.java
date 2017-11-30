package com.guna.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.guna.dao.InMemoryDao;

@Path("/create")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class CreateProduct {
	@POST
	public String createProduct(@PathParam("PRODUCT") Product product) {
		try {
			SessionFactory factory = InMemoryDao.buildSessionFactory(Product.class);
			Session ses = factory.openSession();
			ses.save(product);
			Product p = ses.get(Product.class, 1);
			System.out.println(p.getName());
			return "product inserted success fully";
		} catch (Exception e) {
			return "product inserted failed";
		}
	}
}
