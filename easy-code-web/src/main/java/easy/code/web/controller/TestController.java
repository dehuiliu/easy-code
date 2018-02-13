package easy.code.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/index/{name}")
    @ResponseBody
    public String index(@PathVariable String name) {

        if (null == name) {
            name = "boy";
        }

        return "hello world " + name;
    }

    @RequestMapping("/calculate/{param1}/{param2}")
    public ModelAndView calculate(@PathVariable int param1, @PathVariable int param2) {
        int result = 0;
        try {
            result = param1 / param2;
        } catch (Exception e) {
            logger.error("计算错误 ", e);
            throw new RuntimeException(e);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("calculate", result);
        return modelAndView;
    }
}
