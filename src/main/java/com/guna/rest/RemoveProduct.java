package com.guna.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.guna.dao.InMemoryDao;

@Path("/remove")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class RemoveProduct {
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	String deleteProduct(@PathParam("ProductId") Integer productId) {
		try {
			SessionFactory factory = InMemoryDao.buildSessionFactory(Product.class);
			Session ses = factory.openSession();
			Product dProduct = ses.load(Product.class, productId);
			ses.delete(dProduct);
			Product p = ses.get(Product.class, 1);
			System.out.println("In delete"+p.getName());
			return "product inserted success fully";
		} catch (Exception e) {
			e.printStackTrace();
			return "product inserted failed";
		}
	}
}
