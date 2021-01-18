package jay.demo.argumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description 参数解析
 * @Param
 * @Author Jay.Jia
 * @Date 2021/1/18 15:52
 * @return
 **/
public interface ArgumentResolver {
    
    public boolean support(Class<?> type, int paramIndex, Method method);
    
    /**
     * @Description 参数解析方法
     * @Param [request, response, type, paramIndex, method]
     * @Author Jay.Jia
     * @Date 2021/1/18 15:54
     * @return java.lang.Object
     **/
    public Object argumentResolver(HttpServletRequest request,
                                   HttpServletResponse response, Class<?> type,
                                   int paramIndex,//参数索引下坐标,有很多注解,你得知道是哪个参数的注解,每个参数的索引顺序不一样
                                   Method method);
}
