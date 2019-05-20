package spring.boot.cloud.uifeignservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.boot.cloud.uifeignservice.controller.CustomerController;

@SpringBootApplication
@Controller
@EnableFeignClients
public class UiFeignServiceApplication {

    @Autowired
    private CustomerController customerController;

    public static void main(String[] args) {
        SpringApplication.run(UiFeignServiceApplication.class, args);
    }

    @RequestMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerController.getAllCustomers().getBody());
        return "index";
    }

}
