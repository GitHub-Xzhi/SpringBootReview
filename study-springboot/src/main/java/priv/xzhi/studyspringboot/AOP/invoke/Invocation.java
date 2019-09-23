package priv.xzhi.studyspringboot.AOP.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Desc:
 * Created by Xzhi on 2019-09-23 15:57.
 */
@Data
@AllArgsConstructor
public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    /**
     * 反射方法
     */
    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }

}
