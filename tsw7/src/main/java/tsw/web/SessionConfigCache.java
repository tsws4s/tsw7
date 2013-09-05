package tsw.web;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import tsw.domain.ImportFile;
import tsw.domain.Resource;
import tsw.domain.Tswacct;
import tsw.domain.Users;


public class SessionConfigCache {
	static int defaultMaxRows = 100;
	
    CustomerController customerController;
	
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

	public Users getUser4Session(String sessionId) {
		return getConfig4Session(sessionId).getSessionUser();
	}
	public Users getUser4Session(HttpServletRequest request) {
		Users sessionUser = null;
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
	public void setupSessionConfig(HttpServletRequest request, CustomerController customerController){
		if(this.customerController==null){
			this.customerController = customerController;			
		}
		Users sessUser = null;		
		try {
			SecurityContext securityContext = SecurityContextHolder.getContext();
			Authentication auth = securityContext.getAuthentication();
			User principalUser = (User) auth.getPrincipal();
			sessUser = customerController.getUser4Username(principalUser.getUsername());
		} catch (Exception e) {
			// DO: handle exception?
		}
		HttpSession sess = request.getSession(true);
		SessionConfig sessionConfig = new SessionConfig(sess.getId(), sessUser.getTswacct(), sessUser);
		setConfig4Session(sess.getId(), sessionConfig);
		// binding this object will keep our cache clean (remove old/invalid sessions)
		sess.setAttribute("notifySessionUnbound", new NotifySessionUnbound(this));
		sess.setAttribute("selectTheme", sessUser.getSelectTheme());
	}	

	public void removeSessionConfig(HttpServletRequest request){	
		removeSession(request.getSession().getId());
		request.getSession().invalidate();
	}
	
	public int getResultsPerPage(HttpServletRequest request) {
		return defaultMaxRows;
	}
	
	public Tswacct getTswacct(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		if(sess!=null){
			SessionConfig sessConfig = getConfig4Session(sess.getId());
			if(sessConfig!=null){
				return sessConfig.getSessionTswAcct();
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
	
	public Set<Resource> getResources4Session(HttpServletRequest request) {
		return getTswacct(request).getResources();
	}
	
	public Resource getEvents4Resource(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		if(sess!=null){
			SessionConfig sessConfig = getConfig4Session(sess.getId());
			if(sessConfig!=null){
				return (Resource)sessConfig.getValue4Name("events4Resource");
			}			
		}
		return null;
	}
	public void setEvents4Resource(HttpServletRequest request, Resource res) {
		HttpSession sess = request.getSession();
		if(sess!=null){
			SessionConfig sessConfig = getConfig4Session(sess.getId());
			if(sessConfig!=null){
				sessConfig.setValue4Name("events4Resource", res);
			}			
		}
	}
}