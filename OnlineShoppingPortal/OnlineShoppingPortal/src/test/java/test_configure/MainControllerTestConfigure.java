package test_configure;

import org.mockito.Mockito;
import org.onlineshoppingportal.authentication.SecurityService;
import org.onlineshoppingportal.authentication.SecurityServiceImpl;
import org.onlineshoppingportal.dao.AccountDao;
import org.onlineshoppingportal.dao.AccountDaoImpl;
import org.onlineshoppingportal.dao.OrderDao;
import org.onlineshoppingportal.dao.OrderDaoImpl;
import org.onlineshoppingportal.dao.ProductDao;
import org.onlineshoppingportal.dao.ProductDaoImpl;
import org.onlineshoppingportal.validator.AccountValidator;
import org.springframework.context.annotation.Bean;

public class MainControllerTestConfigure {

	/*@Bean
	public AccountDaoImpl accountdao() {
		return Mockito.mock(AccountDaoImpl.class);
	}
	
	@Bean
	public ProductDao productDao() {
		return Mockito.mock(ProductDaoImpl.class);
	}
	
	@Bean
	public OrderDao orderDao() {
		return Mockito.mock(OrderDaoImpl.class);
	}
	
	@Bean
	public SecurityService securityService() {
		return Mockito.mock(SecurityServiceImpl.class);
	}
	
	@Bean
	public AccountValidator accountValidator() {
		return Mockito.mock(AccountValidator.class);
	}*/
}
