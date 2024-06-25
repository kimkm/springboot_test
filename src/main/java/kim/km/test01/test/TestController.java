package kim.km.test01.test;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.*;

@Controller
public class TestController {
    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User("userA", 10));
        List<User> us = new ArrayList<>();
        us.add(new User("UserAaaaa", 10));
        us.add(new User("UserB", 20));
        us.add(new User("UserC", 30));

        model.addAttribute("users", us);

        return "javascript";
    }

    @GetMapping("layout")
    public String testController(Model model){
        model.addAttribute("title","thymeleaf_title...");
        model.addAttribute("content","thymeleaf_content...");

        return "layout";

    }

    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = new ArrayList<>(Arrays.asList(userA, userB));

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "variable";
    }

    @Data
    static class User {
        private String username;
        private int age;
        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }


    // Spring Boot 3.0 이상: 직저
    @GetMapping("/basic-objects")
    public String basicObjects2(
            Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session) {
        session.setAttribute("sessionData", "Hello Session");
        model.addAttribute("request", request);
        model.addAttribute("response", response);
        model.addAttribute("servletContext", request.getServletContext());
        return "basic-objects";
    }

    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello " + data;
        }
    }

    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "date";
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring!");
        return "operation";
    }

    @GetMapping("/each")
    public String each(Model model) {
        addUsers(model);
        return "each";
    }

    private void addUsers(Model model) {
        List<User> users = new ArrayList<>(
                Arrays.asList(
                        new User("userA", 10),
                        new User("userB", 20),
                        new User("userC", 30)
                ));

        model.addAttribute("users", users);
    }

    @GetMapping("/condition")
    public String contition(Model model) {
        addUsers(model);
        return "condition";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data", "Spring!");
        return "comments";
    }

    @GetMapping("/block")
    public String block(Model model) {
        addUsers(model);
        return "block";
    }

    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "text-basic";
    }
}
