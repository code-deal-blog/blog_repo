package org.onlineshoppingportal.dao;

import java.util.Date;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.onlineshoppingportal.entity.Account;
import org.onlineshoppingportal.entity.Order;
import org.onlineshoppingportal.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
    private SessionFactory sessionFactory;
 
    @Autowired
    private ProductDao productDAO;
    
    @Autowired
    private AccountDao accountDao;
 
    private int getMaxOrderNum() {
        String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        Integer value = (Integer) query.uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }
 
    @Override
    public Order saveOrder(String code,int quantity,String username) {
        Session session = sessionFactory.getCurrentSession();

        int orderNum = this.getMaxOrderNum() + 1;
       
        Account account = accountDao.findAccount(username); 
        Product product = productDAO.findProduct(code);
        product.setQuantity(product.getQuantity()-quantity);
        Order order = new Order();
        order.setOrderNum(orderNum);
        order.setOrderDate(new Date());
        order.setAmount(quantity * (product.getPrice()));
        order.setQuantity(quantity);
        order.setAccount(account);
        order.setProduct(product);
        session.save(order);
       
        return order;
    }
 
    /*// @page = 1, 2, ...
    @Override
    public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
        String sql = "Select new " + OrderInfo.class.getName()//
                + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
                + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
                + Order.class.getName() + " ord "//
                + " order by ord.orderNum desc";
        Session session = this.sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
 
        return new PaginationResult<OrderInfo>(query, page, maxResult, maxNavigationPage);
    }*/
 
    public Order findOrder(String orderId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Order.class);
        crit.add(Restrictions.eq("id", orderId));
        return (Order) crit.uniqueResult();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrdersByUserName(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Account account =accountDao.findAccount(username); 
        Criteria crit = session.createCriteria(Order.class);
        crit.add(Restrictions.eq("account.userId", account.getUserId()));
        List<Order> list = (List<Order>) crit.list();
        /*list.forEach(Order::getProduct);*/
		return list;
	}
 
   

}
