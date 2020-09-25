package com.horustek.gda.infra.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.horustek.gda.infra.utils.json.JsonUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableAsync
@EnableWebMvc
@EnableAspectJAutoProxy
@SuppressWarnings("serial")
public class SpringCoreConfig implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * Enable CORS DOMAIN for all public url
     *
     * @param registry Cors Object for add restriction
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowCredentials(true).allowedOrigins("*");
    }

    /**
     * Bean to handle LazyIntitializationException in controllers. The plain text and html
     * mediatypes are added so that it is not mandatory to specify the header.
     *
     * @return MappingJackson2HttpMessageConverter
     * @apiNote //Content-Type: application/json when invoking services
     */
    @Bean
    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter(JsonUtils.getObjectMapper());

        List<MediaType> mediaTypes = new ArrayList<>();
        if (messageConverter.getSupportedMediaTypes() != null)
            mediaTypes.addAll(messageConverter.getSupportedMediaTypes());
        mediaTypes.add(new MediaType("text", "plain"));
        mediaTypes.add(new MediaType("text", "html"));
        messageConverter.setSupportedMediaTypes(mediaTypes);
        messageConverter.setPrettyPrint(true);
        return messageConverter;
    }

    /**
     * Replace the default ObjectMapper when injected with Autowired
     *
     * @return new ObjectMapper object
     */
    @Bean
    @Primary
    public ObjectMapper serializingObjectMapper() {
        return JsonUtils.getObjectMapper();
    }

    /**
     * You must add these Jackson and UTF-8 converters so that it also applies to RequestBody
     * in PUT and POST requests. The String converter must be put first to avoid
     * Strings with quotes
     *
     * @param converters List of converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter());
        converters.add(jacksonMessageConverter());
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


}
