package service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import domain.User;

public class UserService {

	private UserDAO db = new UserDAO();

    public List<User> getCurrentUser() {
        try {
        	List<User> users= new ArrayList<>();
        	// Get session object from Session        	  
        	FacesContext context = FacesContext.getCurrentInstance();
        	HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        	HttpSession httpSession = request.getSession(false);
        	User user = (User) httpSession.getAttribute("user");
        	//--------------------------------
        	if (user != null){
				users.add(user);
        		return users;
        	}
        	return null;
       	} catch (Exception e) {
               e.printStackTrace();
        }
		return null;
	}	

    public User getSessionUser() {
        try {
        	// Get session object from Session        	  
        	FacesContext context = FacesContext.getCurrentInstance();
        	HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        	HttpSession httpSession = request.getSession(false);
        	User user = (User) httpSession.getAttribute("user");
        	//--------------------------------
        	if (user != null){
        		return user;
        	}
        	return null;
       	} catch (Exception e) {
               e.printStackTrace();
        }
		return null;
	}	    
    
    public User isUsuarioReadyToLogin(String login, String pass) {
        try {
        		login = login.toLowerCase().trim();

        		List<User> query = db.getUserAutentication(login);

        		if (query.size() == 1) {
        			if ( query.get(0).getPassword().equals(pass)){
            	   //if ( query.get(0).getPass().equals(convertStringToMd5(pass))){
        				User userFound = (User) query.get(0);
        				//Set user object in session
        				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userFound);
        				//--------------------------
        				//<h:outputText value="#{sessionScope.key}" />
        				
        				return userFound;
        			}
        		}
        	return null;
        	} catch (Exception e) {
               e.printStackTrace();
        }
		return null;
	}	
}