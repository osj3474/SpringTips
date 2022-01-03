package me.sangjin.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.sangjin.swagger.config.SwaggerConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Api(tags = {SwaggerConfig.HOME})
public class HomeController {

    @ApiOperation(value = "(API 이름)", notes = "(API 설명)")
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @ApiOperation(value = "(API 이름)", notes = "(API 설명)")
    @GetMapping("/{id}")
    public String homeWithParam(@ApiParam(value = "(파라미터 이름)", required = true) @PathVariable Long id) {  // required는 필수인지 아닌지
        return "home에 "+id.toString()+" 방문";
    }
}
