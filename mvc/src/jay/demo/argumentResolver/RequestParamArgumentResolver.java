package jay.demo.argumentResolver;

import jay.demo.annotation.JayRequestParam;
import jay.demo.annotation.JayService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Description  解析声明注解为RequestParam, 获取注解的值
 * @Param
 * @Author Jay.Jia
 * @Date 2021/1/18 15:56
 * @return
 **/
@JayService("requestParamArgumentResolver")
public class RequestParamArgumentResolver implements ArgumentResolver {

    /**
     * @Description 判断传进来的参数是否为EnjoyRequestParam
     * @Param [type, paramIndex, method]
     * @Author Jay.Jia
     * @Date 2021/1/18 15:56
     * @return boolean
     **/
    @Override
    public boolean support(Class<?> type, int paramIndex, Method method) {
        //参数注解
        Annotation[][] an = method.getParameterAnnotations();
        //参数
        Annotation[] paramAns = an[paramIndex];
        
        for (Annotation paramAn : paramAns) {
        	//判断传进的paramAn.getClass()是不是 EnjoyRequestParam 类型
        	if (JayRequestParam.class.isAssignableFrom(paramAn.getClass())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description 参数解析,并获取注解的值
     * @Param [request, response, type, paramIndex, method]
     * @Author Jay.Jia
     * @Date 2021/1/18 15:57
     * @return java.lang.Object
     **/
    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method) {
        //参数注解
        Annotation[][] an = method.getParameterAnnotations();
        //参数
        Annotation[] paramAns = an[paramIndex];
        
        for (Annotation paramAn : paramAns) {
            if (JayRequestParam.class.isAssignableFrom(paramAn.getClass())) {
                JayRequestParam rp = (JayRequestParam)paramAn;
                String value = rp.value();
                return request.getParameter(value);
            }
        }
        return null;
    }
    
}
