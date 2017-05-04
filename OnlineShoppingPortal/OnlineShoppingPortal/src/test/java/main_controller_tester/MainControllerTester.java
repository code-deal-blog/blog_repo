package main_controller_tester;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.onlineshoppingportal.authentication.SecurityService;
import org.onlineshoppingportal.authentication.SecurityServiceImpl;
import org.onlineshoppingportal.config.ApplicationContextConfig;
import org.onlineshoppingportal.config.SpringSecurityInitializer;
import org.onlineshoppingportal.config.SpringWebAppInitializer;
import org.onlineshoppingportal.config.WebMvcConfig;
import org.onlineshoppingportal.config.WebSecurityConfig;
import org.onlineshoppingportal.controller.MainController;
import org.onlineshoppingportal.dao.AccountDao;
import org.onlineshoppingportal.dao.AccountDaoImpl;
import org.onlineshoppingportal.dao.OrderDao;
import org.onlineshoppingportal.dao.OrderDaoImpl;
import org.onlineshoppingportal.dao.ProductDao;
import org.onlineshoppingportal.dao.ProductDaoImpl;
import org.onlineshoppingportal.dao.RoleDao;
import org.onlineshoppingportal.entity.Order;
import org.onlineshoppingportal.entity.Product;
import org.onlineshoppingportal.exceptions.AlreadyLoginException;
import org.onlineshoppingportal.model.PaginationResult;
import org.onlineshoppingportal.validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import test_configure.MainControllerTestConfigure;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationContextConfig.class,
							   WebMvcConfig.class,
							   SpringWebAppInitializer.class,
							   SpringSecurityInitializer.class,
							   WebSecurityConfig.class,
							   MainControllerTestConfigure.class})
@WebAppConfiguration
public class MainControllerTester{

	
	private MockMvc mockMvc;
	
	@Autowired
	private MainController mainCtrl;
	
	@Autowired
	@Qualifier("accountDaoImpl")
	private AccountDao accountDao;
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderDao ordderDao;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private AccountValidator accountValidator;
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Before
    public void setUp() {
		productDao = mock(ProductDao.class);
 
		Mockito.reset(productDao);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	@Test
    public void normalLoginTest() throws Exception {
        
 
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/pages/login.jsp"));
                
    }
	
	
	@Test
    public void signUpTest() throws Exception {
 
        mockMvc.perform(get("/signUp"))
                .andExpect(status().isOk())
                .andExpect(view().name("signUp"))
                .andExpect(forwardedUrl("/WEB-INF/pages/signUp.jsp")); 
    }
	
	@Test
    public void productListTest() throws Exception {
		
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("productList"))
                .andExpect(forwardedUrl("/WEB-INF/pages/productList.jsp"))
                .andExpect(model().attribute("list",hasSize(7))); 
        
    }
	
	
	
	@Test
	public void notFoundTest()throws Exception{
		
		mockMvc.perform(post("/happy"))
		.andExpect(status().isNotFound());
    	
	}
	
	
}

	
	

