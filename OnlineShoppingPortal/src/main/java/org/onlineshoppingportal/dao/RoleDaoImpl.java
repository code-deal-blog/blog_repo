package org.onlineshoppingportal.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.onlineshoppingportal.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoleDaoImpl implements RoleDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Role findRoleByRoleNAme(String role) {
		 Session session = sessionFactory.getCurrentSession();
		 Criteria crit = session.createCriteria(Role.class);
		 crit.add(Restrictions.eq("name", role));
		 return (Role)crit.uniqueResult();
	}

}
