package kim.km.test01.test;

import org.springframework.stereotype.Component;

@Component("testbean")
public class TestBean {
    public String test(String data) {
        return "Hello " + data;
    }
}
