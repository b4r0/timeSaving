package it.unifi.swa.startup;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.unifi.swa.dao.ClientDAO;
import it.unifi.swa.dao.MenuDAO;
import it.unifi.swa.dao.OperatorDAO;
import it.unifi.swa.dao.ProductDAO;
import it.unifi.swa.dao.PubDAO;
import it.unifi.swa.domain.Client;
import it.unifi.swa.domain.Menu;
import it.unifi.swa.domain.Operator;
import it.unifi.swa.domain.Product;
import it.unifi.swa.domain.Pub;


@Singleton
@Startup
public class StartupBean {

	@Inject
	MenuDAO menuDao;
	
	@Inject
	PubDAO pubDao;
	
	@Inject
	OperatorDAO operatorDao;
	
	@Inject
	ProductDAO productDao;
	
//	@PersistenceContext
//	EntityManager entityManager;
//	
//	@Inject
//	ClientDAO clientDao;
	
	@PostConstruct
    private void init() {
        // when app is deployed

//		Client papu= new Client();
//		papu.setUsername("user");
//		papu.setPassword("password");
//		clientDao.save(papu);
//		 List<Client> result =entityManager.createQuery("from Client where username = :username and password = :password", Client.class)
//					.setParameter("username", "user")
//					.setParameter("password", "password")
//					.getResultList();
//		 System.out.println(result.get(0).getUsername());
		 
		Menu menu=new Menu();
		menu.setDescr("Menu favoloso!!!");
		
		Pub undicesimo=new Pub();
		undicesimo.setNome("Undicesimo");
		undicesimo.setIndirizzo("Via prulli di sopra");
		undicesimo.setMenu(menu);
		
		Operator cuoco=new Operator();
		cuoco.setIdUser(1);
		cuoco.setLocal(undicesimo);
		
		Operator barista=new Operator();
		barista.setIdUser(2);
		barista.setLocal(undicesimo);
		
		Product negroni=new Product();
		negroni.setProdName("negroni");
		negroni.setPrice(3.5);
		negroni.setTpProduct('d');
		negroni.setMenu(menu);
			
		Product panino=new Product();
		panino.setProdName("panino");
		panino.setPrice(5);
		panino.setTpProduct('f');
		panino.setMenu(menu);
		
		menuDao.save(menu);
		productDao.save(negroni);
		productDao.save(panino);
    }
 
//    @PreDestroy
//    private void cleanUp() {
//        // when app is undeployed
//    }
}
