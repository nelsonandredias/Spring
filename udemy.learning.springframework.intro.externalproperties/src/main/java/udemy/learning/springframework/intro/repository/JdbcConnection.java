package udemy.learning.springframework.intro.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/*
 * When inject JdbcConnection, it will use the proxy and thus, it will make sure there is always a new instance
 * of JdbcConnection (even though the scope is prototype)
 * */

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JdbcConnection {

	public void JdbcConnection() {
		System.out.println("JDBC Connection");
	}
	
}
