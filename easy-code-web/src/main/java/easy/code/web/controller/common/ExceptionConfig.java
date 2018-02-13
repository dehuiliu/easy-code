package easy.code.web.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理
 */
//@ControllerAdvice
public class ExceptionConfig {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionConfig.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.addObject("uri", request.getRequestURI());
        modelAndView.setViewName("/error/error");
        return modelAndView;
    }

    /**
     * 响应json类型
     *
     * @param request
     * @param e
     * @return
     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Map defaultErrorHandler(HttpServletRequest request, Exception e) {
//        logger.info("响应json 类型 自定异常处理 start {}", e.toString());
//        Map map = new HashMap();
//        map.put("error", "true");
//        return map;
//    }
}
