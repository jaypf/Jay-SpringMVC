package jay.demo.argumentResolver;


import jay.demo.annotation.JayService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description Response解析器
 * @Param
 * @Author Jay.Jia
 * @Date 2021/1/18 15:55
 * @return
 **/
@JayService("httpServletResponseArgumentResolver")
public class HttpServletResponseArgumentResolver implements ArgumentResolver {

    /**
     * @Description  判断传进来的参数是否为response
     * @Param [type, paramIndex, method]
     * @Author Jay.Jia
     * @Date 2021/1/18 15:55
     * @return boolean
     **/
    @Override
    public boolean support(Class<?> type, int paramIndex, Method method) {
        return ServletResponse.class.isAssignableFrom(type);
    }

    /**
     * @Description 如果返回的参数是response,则直接返回
     * @Param [request, response, type, paramIndex, method]
     * @Author Jay.Jia
     * @Date 2021/1/18 15:56
     * @return java.lang.Object
     **/
    @Override
    public Object argumentResolver(HttpServletRequest request,
                                   HttpServletResponse response, Class<?> type, int paramIndex,
                                   Method method) {
        return response;
    }
    
}
