package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import shop.web.inteceptor.FaviconInterceptor;
import shop.web.inteceptor.RequestInterceptor;
import shop.web.inteceptor.PageTitleInterceptor;

@Configuration
public class AppWebMvcConfig implements WebMvcConfigurer {

    private final PageTitleInterceptor pageTitleInterceptor;
    private final RequestInterceptor requestInterceptor;

    @Autowired
    public AppWebMvcConfig(PageTitleInterceptor pageTitleInterceptor,
                           RequestInterceptor requestInterceptor) {
        this.pageTitleInterceptor = pageTitleInterceptor;
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pageTitleInterceptor);
        registry.addInterceptor(requestInterceptor);
    }
}
