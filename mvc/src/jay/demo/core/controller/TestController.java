package jay.demo.core.controller;

import jay.demo.annotation.JayController;
import jay.demo.annotation.JayQualifier;
import jay.demo.annotation.JayRequestMapping;
import jay.demo.annotation.JayRequestParam;
import jay.demo.core.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Jay.Jia
 * @Date 2021/1/18 16:10
 * @Version 1.0
 */
@JayController
@JayRequestMapping("/jay")
public class TestController {

    @JayQualifier("testServiceImpl")
    private TestService testService;

    @JayRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @JayRequestParam("name") String name,
                      @JayRequestParam("age") String age) {
        try {
            PrintWriter pw = response.getWriter();
            String result = testService.query(name,age);
            pw.write(result);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
}
