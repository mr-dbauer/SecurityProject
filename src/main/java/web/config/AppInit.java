package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //для настройки корневого контекста приложения
        return new Class<?>[]  {WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //для DispatcherServlet настройки контекста приложения
        return new Class<?>[]  {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}