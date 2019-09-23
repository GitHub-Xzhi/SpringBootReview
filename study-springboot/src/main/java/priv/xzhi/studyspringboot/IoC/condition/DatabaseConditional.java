package priv.xzhi.studyspringboot.IoC.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Desc: 定义初始化数据库的条件
 * Created by Xzhi on 2019-09-05 14:58.
 */
public class DatabaseConditional implements Condition {

    /**
     * 数据库装配条件
     * @param context 条件上下文
     * @param metadata 注释类型的元数据
     * @return true装配Bean，否则不装配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 取出环境配置
        Environment env = context.getEnvironment();
        // 判断属性文件是否存在对应的数据库配置
        return env.containsProperty("database.driverName") &&
                env.containsProperty("database.url") &&
                env.containsProperty("database.username") &&
                env.containsProperty("database.password");
    }
}
