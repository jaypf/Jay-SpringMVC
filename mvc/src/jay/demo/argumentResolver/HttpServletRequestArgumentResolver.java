package jay.demo.argumentResolver;


import jay.demo.annotation.JayService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description 入参解析器
 * @Param
 * @Author Jay.Jia
 * @Date 2021/1/18 15:54
 * @return
 **/
@JayService("httpServletRequestArgumentResolver")
public class HttpServletRequestArgumentResolver implements ArgumentResolver {

	/**
	 * @Description 判断传进来的参数是否为request
	 * @Param [type, paramIndex, method]
	 * @Author Jay.Jia
	 * @Date 2021/1/18 15:54
	 * @return boolean
	 **/
    @Override
    public boolean support(Class<?> type, int paramIndex, Method method) {
        return ServletRequest.class.isAssignableFrom(type);
    }

    /**
     * @Description  如果返回的参数是request,则直接返回
     * @Param [request, response, type, paramIndex, method]
     * @Author Jay.Jia
     * @Date 2021/1/18 15:54
     * @return java.lang.Object
     **/
    @Override
    public Object argumentResolver(HttpServletRequest request,
                                   HttpServletResponse response, Class<?> type, int paramIndex,
                                   Method method) {
        return request;
    }
    
}
