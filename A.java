package com.cognizant.banking.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import jakarta.annotation.PreDestroy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Customer implements BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {

    Logger logger = LoggerFactory.getLogger(Customer.class);

    protected long accountNo;

    @Autowired
    protected FullName fullName;

    @Autowired
    protected Address address;

    protected long contactNumber;
    protected String email;
    protected String password;

    @Override
    public void destroy() throws Exception {
        logger.info("Customer Bean is destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Customer Bean is initialized");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("Application context is set in customer bean "
                + applicationContext.getApplicationName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("Bean Factory is set in Customer Bean "
                + beanFactory.getClass().getName());
    }

    @Override
    public void setBeanName(String name) {
        logger.info("Bean Name is set in Customer Bean :" + name);
    }

    public void customInit() {
        logger.info("Custom init method called for Customer Bean");
    }

    public void customDestroy() {
        logger.info("Custom Destroy method called for Customer Bean");
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("Pre Destroy Method called for Customer Bean");
    }
  }
