package com.upala.wong.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*****************************
 *  @author 王鹏
 *  @version 2019/4/7 11:37
 *  @package com.upala.wong.utils
 *  @project document
 *  @describe
 *****************************/

@Configuration
public class WebInterceptor implements WebMvcConfigurer
{

    /**
     * 页面的跳转
     *
     * @param registry 参数
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/upala").setViewName("index");
    }

    /**
     * 加载静态资源
     * @param registry 参数
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
