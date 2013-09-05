package tsw.web;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class NotifySessionUnbound implements HttpSessionBindingListener {

	private SessionConfigCache sessConfigCache;

	public NotifySessionUnbound(SessionConfigCache sessConfigCache) {
		super();
		this.sessConfigCache = sessConfigCache;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// DO Auto-generated method stub

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// DO Auto-generated method stub
		sessConfigCache.removeSession(event.getSession().getId());
	}
}
