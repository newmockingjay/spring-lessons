package ru.spring.zayceva.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // локация спринг-конфигурации
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    // посылаем все запросы на диспетчер-сервлет
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
