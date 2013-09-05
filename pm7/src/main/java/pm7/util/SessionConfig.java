package pm7.util;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import pm7.domain.Account;
import pm7.domain.User;


@XmlType(namespace = "pm7/utils", name = "SessionConfig")
@XmlRootElement(namespace = "pm7/utils")
public class SessionConfig implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement
	private String sessionId;
	@XmlElement
	private Account sessionAcct;
	@XmlElement
	private User sessionUser;
	@XmlElement
	private HashMap<String, Object> nameValue;
	
	public SessionConfig() {
		super();
		this.nameValue = new HashMap<String, Object>();
	}
	public SessionConfig(String sessionId, Account sessionAcct, User sessionUser) {
		this();
		this.sessionId = sessionId;
		this.sessionAcct = sessionAcct;
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
	public Account getSessionAccount() {
		return sessionAcct;
	}
	public void setsessionAcct(Account sessionAcct) {
		this.sessionAcct = sessionAcct;
	}
	public User getSessionUser() {
		return sessionUser;
	}
	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}
	
	public boolean isAcctActive() {
		//return (sessionAcct.getActiveYn()==1);
		return true;
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
		return "SessionConfig - SessionId=" + sessionId + "; User=" + sessionUser.toString() + "; TswAcct=" + sessionAcct.toString();
	}
}
