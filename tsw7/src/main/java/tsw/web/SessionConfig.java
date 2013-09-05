package tsw.web;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import tsw.domain.Tswacct;
import tsw.domain.Users;

@XmlType(namespace = "tsw7/tsw/utils", name = "SessionConfig")
@XmlRootElement(namespace = "tsw7/tsw/utils")
public class SessionConfig implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement
	private String sessionId;
	@XmlElement
	private Tswacct sessionTswAcct;
	@XmlElement
	private Users sessionUser;
	@XmlElement
	private HashMap<String, Object> nameValue;
	
	public SessionConfig() {
		super();
		this.nameValue = new HashMap<String, Object>();
	}
	public SessionConfig(String sessionId, Tswacct sessionTswAcct, Users sessionUser) {
		this();
		this.sessionId = sessionId;
		this.sessionTswAcct = sessionTswAcct;
		this.sessionUser = sessionUser;
	}
	/**
	 * 
	 */
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Tswacct getSessionTswAcct() {
		return sessionTswAcct;
	}
	public void setSessionTswAcct(Tswacct sessionTswAcct) {
		this.sessionTswAcct = sessionTswAcct;
	}
	public Users getSessionUser() {
		return sessionUser;
	}
	public void setSessionUser(Users sessionUser) {
		this.sessionUser = sessionUser;
	}
	
	public Integer getResultsPerPage() {
		return sessionUser.getResultsPerPage();
	}
	public Integer getDefaultResourceId() {
		return sessionTswAcct.getDefaultResourceId();
	}
	public boolean isAcctActive() {
		return (sessionTswAcct.getActiveYn()==1);
	}
	public Object getValue4Name(String name){
		return getNameValue().get(name);
	}
	public void setValue4Name(String name, Object value){
		getNameValue().put(name, value);
	}
	private HashMap<String, Object> getNameValue() {
		return nameValue;
	}

	@Override
	public String toString() {  
		return "SessionConfig - SessionId=" + sessionId + "; User=" + sessionUser.toString() + "; TswAcct=" + sessionTswAcct.toString();
	}
}
