package priv.xzhi.studyspringboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Desc: 使用@ConfigurationProperties
 * Created by Xzhi on 2019-09-03 15:11.
 */
@Component
@ConfigurationProperties("database")
public class DataBasePropertiesOfConfigurationProperties {

	private String driverName;
	private String url;
	private String username;
	private String password;

	public void setDriverName(String driverName) {
		System.out.println("【" + this.getClass().getSimpleName() + "】" + ">>>" + driverName);
		this.driverName = driverName;
	}

	public void setUrl(String url) {
		System.out.println("【" + this.getClass().getSimpleName() + "】" + ">>>" + url);
		this.url = url;
	}

	public void setUsername(String username) {
		System.out.println("【" + this.getClass().getSimpleName() + "】" + ">>>" + username);
		this.username = username;
	}

	public void setPassword(String password) {
		System.out.println("【" + this.getClass().getSimpleName() + "】" + ">>>" + password);
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
