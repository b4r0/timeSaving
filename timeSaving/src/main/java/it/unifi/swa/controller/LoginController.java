package it.unifi.swa.controller;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import it.unifi.swa.bean.UserSessionBean;
import it.unifi.swa.dao.ClientDAO;
import it.unifi.swa.dao.OperatorDAO;
import it.unifi.swa.domain.User;

@Model
public class LoginController {
	
	private User userData;

    @Inject
    private UserSessionBean userSession;
    
    @Inject
    private ClientDAO clientDao;
    @Inject
    private OperatorDAO operatorDao;

    private String username;
    private String password;
    
    public String login(){
    	
    	userData= new User();
        userSession.setUser(null);
        userSession.setType(4);

    	userData.setUsername(username);
    	userData.setPassword(password);

    	User loggedUser = clientDao.findByLoginInfo(userData);
    	
    	if (loggedUser == null){
    		
    		loggedUser=operatorDao.findByLoginInfo(userData);
    		if (loggedUser == null){
                throw new RuntimeException("Login Failed");
    		}
 
    		userSession.setType(operatorDao.findByLoginInfo(userData).getoType());
    	}else{
    		userSession.setType(0);
    	}
    	
    	userSession.setUser(loggedUser);
    	System.out.println(loggedUser.getUsername()+" loggato");
    	
    	return "index";
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    

}