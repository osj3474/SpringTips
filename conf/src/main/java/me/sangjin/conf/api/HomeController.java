package me.sangjin.conf.api;

import me.sangjin.conf.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping()
    public String home(){
        return AppProperties.getProperty("USERNAME")+"의 직업은 "
                + AppProperties.getProperty("JOB")+"입니다";
    }
}
