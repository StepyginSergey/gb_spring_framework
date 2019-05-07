package practic_1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class TestBFPP implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanDefinitioonNames = configurableListableBeanFactory.getBeanDefinitionNames();

        for (String name: beanDefinitioonNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            System.out.println(beanDefinition.toString());
        }
    }
}
