package org.onlineshoppingportal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.onlineshoppingportal.entity.Product;
import org.onlineshoppingportal.model.PaginationResult;
import org.onlineshoppingportal.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	 	@Autowired
	    private SessionFactory sessionFactory;
	 
	    @Override
	    public Product findProduct(String code) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Product.class);
	        crit.add(Restrictions.eq("code", code));
	        return (Product) crit.uniqueResult();
	    }
	 
	    
	    
	    @Override
	    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
	            String likeName) {
	        String sql = "Select new " + ProductInfo.class.getName() //
	                + "(p.code, p.name, p.price,p.quantity) " + " from "//
	                + Product.class.getName() + " p ";
	        if (likeName != null && likeName.length() > 0) {
	            sql += " Where lower(p.name) like :likeName ";
	        }
	        sql += " order by p.createDate desc ";
	        //
	        Session session = sessionFactory.getCurrentSession();
	 
	        Query query = session.createQuery(sql);
	        if (likeName != null && likeName.length() > 0) {
	            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
	        }
	        return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
	    }
	 
	    @Override
	    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
	        return queryProducts(page, maxResult, maxNavigationPage, null);
	    }



		@Override
		public List<Product> getAllProducts() {
			 Session session = sessionFactory.getCurrentSession();
		     Criteria crit = session.createCriteria(Product.class);
			return crit.list();
		}

}
