package jay.demo.core.service.impl;

import jay.demo.annotation.JayService;
import jay.demo.core.service.TestService;

/**
 * @ClassName TestServiceImpl
 * @Description TODO
 * @Author Jay.Jia
 * @Date 2021/1/18 16:14
 * @Version 1.0
 */
@JayService("testServiceImpl")
public class TestServiceImpl implements TestService {

    @Override
    public String query(String name, String age) {
        return "{name="+name+",age="+age+"}";
    }
}
