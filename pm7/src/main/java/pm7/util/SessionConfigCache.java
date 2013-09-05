package pm7.util;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import pm7.domain.Account;
import pm7.web.PersonController;
import pm7.web.UserController;


public class SessionConfigCache {
	static int defaultMaxRows = 100;
	
	UserController customerController;
	
	private HashMap<Object, Object> sessionCache = new HashMap<Object, Object>();
	
    public SessionConfigCache() { }

	public HashMap<Object, Object> getSessionCache() {
		return sessionCache;
	}

	public SessionConfig getConfig4Session(String sessionId) {
		return (SessionConfig)sessionCache.get(sessionId);
	}

	public void removeSession(String sessionId) {
		sessionCache.remove(sessionId);
	}
	
	public void setConfig4Session(String sessionId, SessionConfig sessConfig) {
		sessionCache.put(sessionId, sessConfig);
	}

	public pm7.domain.User getUser4Session(String sessionId) {
		return getConfig4Session(sessionId).getSessionUser();
	}
	public pm7.domain.User getUser4Session(HttpServletRequest request) {
		pm7.domain.User sessionUser = null;
		try {
			sessionUser = getUser4Session(request.getSession().getId());
		} catch (Exception e) {
			// DO: handle exception - fall-back method?
		}
		return sessionUser;
	}
	
	public boolean isSessionAuthenitcated(HttpServletRequest request){
		HttpSession sess = request.getSession(true);
		return sessionCache.containsKey(sess.getId());
	}

	public void resestSessionConfig(HttpServletRequest request){
		removeSessionConfig(request);
		setupSessionConfig(request, customerController);
	}
	
	// TODO: [assignedTo] (Cache-Low) update SessionConfig to use ehCache
	public void setupSessionConfig(HttpServletRequest request, UserController customerController){
		if(this.customerController==null){
			this.customerController = customerController;			
		}
		pm7.domain.User sessUser = null;		
		try {
			SecurityContext securityContext = SecurityContextHolder.getContext();
			Authentication auth = securityContext.getAuthentication();
			org.springframework.security.core.userdetails.User principalUser = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
//			sessUser = userService.findUserbyName(principalUser.getUsername());
		} catch (Exception e) {
			// DO: handle exception?
		}
		HttpSession sess = request.getSession(true);
		SessionConfig sessionConfig = new SessionConfig(sess.getId(), sessUser.getAccount(), sessUser);
		setConfig4Session(sess.getId(), sessionConfig);
		// binding this object will keep our cache clean (remove old/invalid sessions)
		sess.setAttribute("notifySessionUnbound", new NotifySessionUnbound(this));
//		sess.setAttribute("selectTheme", sessUser.getSelectTheme());
	}	

	public void removeSessionConfig(HttpServletRequest request){	
		removeSession(request.getSession().getId());
		request.getSession().invalidate();
	}
	
	public int getResultsPerPage(HttpServletRequest request) {
		return defaultMaxRows;
	}
	
	public Account getAccount(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		if(sess!=null){
			SessionConfig sessConfig = getConfig4Session(sess.getId());
			if(sessConfig!=null){
				return sessConfig.getSessionAccount();
			}			
		}
		return null;
	}
	
	public ImportFile getImportFile4Session(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		if(sess!=null){
			SessionConfig sessConfig = getConfig4Session(sess.getId());
			if(sessConfig!=null){
				return (ImportFile)sessConfig.getValue4Name("importFile");
			}			
		}
		return null;
	}
	public void setImportFile4Session(HttpServletRequest request, ImportFile importFile) {
		HttpSession sess = request.getSession();
		if(sess!=null){
			SessionConfig sessConfig = getConfig4Session(sess.getId());
			if(sessConfig!=null){
				sessConfig.setValue4Name("importFile",importFile);
			}			
		}
	}
}