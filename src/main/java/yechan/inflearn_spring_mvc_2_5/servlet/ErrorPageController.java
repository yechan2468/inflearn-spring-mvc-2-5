package yechan.inflearn_spring_mvc_2_5.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/error-page")
public class ErrorPageController {

    @RequestMapping("/404")
    public String errorPage404() {
        return "error-page/404";
    }

    @RequestMapping("/500")
    public String errorPage500() {
        return "error-page/500";
    }
}
