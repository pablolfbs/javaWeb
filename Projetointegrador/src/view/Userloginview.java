package view;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import domain.User;
import service.UserService;

@SuppressWarnings("deprecation")
@ManagedBean(name = "userloginview")
public class Userloginview {

	private UserService userService;
	private User user;
	private String username;
	private String password;

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

	public void login(ActionEvent event) {
		try {
			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			boolean loggedIn = false;

			userService = new UserService();
			user = userService.isUsuarioReadyToLogin(username, password);

			if (user == null) {
				FacesContext.getCurrentInstance().validationFailed();
				loggedIn = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de Login", "Acesso inválido");
			} else {
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				Map<String, Object> sessionMap = externalContext.getSessionMap();
				sessionMap.put("loggeduser", userService);
				loggedIn = true;
				FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo ", user.getName());
			}

			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", loggedIn);

		} catch (Exception e) {
			e.printStackTrace();
			// return "";
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
