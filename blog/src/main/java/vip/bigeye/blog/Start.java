package vip.bigeye.blog;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Author wolf  VX:a815193474
 * @Date 2019-09-03 13:40
 */
public class Start extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        //Application的类名
        return application.sources(BlogApplication.class);
    }
}
