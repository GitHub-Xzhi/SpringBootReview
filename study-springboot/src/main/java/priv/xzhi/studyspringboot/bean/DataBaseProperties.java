package priv.xzhi.studyspringboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Desc: 使用属性配置
 * Created by Xzhi on 2019-09-03 15:11.
 */
@Component
public class DataBaseProperties {

	@Value("${database.driverName}")
	private String driverName;
	@Value("${database.url}")
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

	@Value("${database.username}")
	public void setUsername(String username) {
		System.out.println("【" + this.getClass().getSimpleName() + "】" + ">>>" + username);
		this.username = username;
	}

	@Value("${database.password}")
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
