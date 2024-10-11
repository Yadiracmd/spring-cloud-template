package top.mqx.demo.app.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class DemoController {

    @Value("${example.property}")
    private String exampleProperty;

    @GetMapping("/getConfig")
    public String getConfig() {
        return exampleProperty;
    }
}
