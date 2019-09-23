package priv.xzhi.studyspringboot.IoC.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Desc: 定义作用域
 * Bean的作用域：
 *      singleton 单例（所有spring应用）
 *      prototype 原型（所有spring应用）
 *      session HTTP会话（spring web应用）
 *      application web工程生命周期（spring web应用）
 *      request web工程单次请求（spring web应用）
 *      globalSession 在一个全局的HTTP session中，实践中基本不使用（spring web应用）
 * Created by Xzhi on 2019-09-05 15:27.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ScopeBean {

}
