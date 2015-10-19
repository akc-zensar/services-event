package org.akc.controller;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class OcmsEventControllerFactory implements ApplicationContextAware {
    private static ApplicationContext context;
    private static OcmsEventControllerFactory instance;

    private OcmsEventControllerFactory() {
        super();
    }

    public synchronized void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    
    public synchronized OcmsEventControllerFactory getInstance() {
        if (instance == null) {
            instance = new OcmsEventControllerFactory();
        }

        return instance;
    }

    public static OcmsEventController getOcmsEventController() {
        return (OcmsEventController)context.getBean("ocmsEventController");
    }
}
