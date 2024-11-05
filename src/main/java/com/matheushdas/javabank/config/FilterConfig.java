package com.matheushdas.javabank.config;

import com.matheushdas.javabank.filter.IpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    private final IpFilter ipFilter;

    public FilterConfig(IpFilter ipFilter) {
        this.ipFilter = ipFilter;
    }

    @Bean
    public FilterRegistrationBean<IpFilter> ipFilterFilterRegistrationBean() {
        FilterRegistrationBean<IpFilter> filterRegistrationBean = new FilterRegistrationBean<IpFilter>();
        filterRegistrationBean.setFilter(ipFilter);
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;
    }
}
