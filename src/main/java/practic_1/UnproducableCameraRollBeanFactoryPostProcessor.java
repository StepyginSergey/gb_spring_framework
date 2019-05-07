package practic_1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
public class UnproducableCameraRollBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //Этот код как вариант решения обхода ошибки NullPointerExceptioon
        /*
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : configurableListableBeanFactory.getBeanDefinitionNames()) {
            String beanClassName = getBeanClassName(beanDefinitionName, configurableListableBeanFactory);

            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
            try {
                Class<?> beaClass = Class.forName(beanClassName);

                UnproducableCameraRoll annotation = beaClass.getAnnotation(UnproducableCameraRoll.class);

                if(annotation != null){
                    Class usingCameraRollName = annotation.usingCameraRollClass();
                    beanDefinition.setBeanClassName(usingCameraRollName.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
*/
        //Код из методички как есть
        String [] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames ();
        for ( String name : beanDefinitionNames ){

            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition ( name );

            String className = beanDefinition . getBeanClassName ();
            try {
                Class <?> beanClass = Class . forName ( className );
                UnproducableCameraRoll annotation = ( UnproducableCameraRoll )beanClass . getAnnotation ( UnproducableCameraRoll . class );
                if ( annotation != null ){
                    Class usingCameraRollName = annotation . usingCameraRollClass ();
                    beanDefinition . setBeanClassName ( usingCameraRollName . getName ());
                }
            } catch ( ClassNotFoundException e ) {
                e . printStackTrace ();
            }
        }
    }


    private String getBeanClassName(String beanName, ConfigurableListableBeanFactory beanFactory) {
        String beanClassName;
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
        if (beanDefinition instanceof AnnotatedBeanDefinition) {
            AnnotationMetadata metadata = ((AnnotatedBeanDefinition) beanDefinition).getMetadata();
            beanClassName = metadata.getClassName();
        } else {
            beanClassName = beanDefinition.getBeanClassName();
            while (beanClassName == null) {
                BeanDefinition parentBeanDefinition = beanFactory.getBeanDefinition(beanDefinition.getParentName());
                beanClassName = parentBeanDefinition.getBeanClassName();
                beanDefinition = parentBeanDefinition;
            }
        }

        return beanClassName;
    }
}
