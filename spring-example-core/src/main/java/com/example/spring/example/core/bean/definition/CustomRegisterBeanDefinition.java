package com.example.spring.example.core.bean.definition;

import com.example.spring.example.core.bean.Cat;
import com.example.spring.example.core.bean.Dog;
import com.example.spring.example.core.bean.Zoo;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.stereotype.Component;

/**
 * 手动注册Bean Definition
 *
 * @author zhanghui
 * @date 2021/6/28 11:19 上午
 */
@Component
public class CustomRegisterBeanDefinition implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        processCustomBeanDefinitions(registry);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }


    private void processCustomBeanDefinitions(BeanDefinitionRegistry registry) {
        AnnotationBeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
        registerDogDefinition(registry, beanNameGenerator);
        registryCatDefinition(registry, beanNameGenerator);
        registryZooDefinition(registry, beanNameGenerator);
    }

    private void registerDogDefinition(BeanDefinitionRegistry registry, BeanNameGenerator beanNameGenerator) {
        // 生成BeanDefinition
       BeanDefinition beanDefinition = getBeanDefinition(Dog.class);
        // 生成BeanName
        String beanName = getBeanName(registry, beanNameGenerator, beanDefinition);
        // 指定BeanDefinition构造参数
        setConstructorArgument(beanDefinition, "xiaohei");
        // 注册BeanDefinition
        registry.registerBeanDefinition(beanName, beanDefinition);
    }


    private void registryCatDefinition(BeanDefinitionRegistry registry, BeanNameGenerator beanNameGenerator) {
        // 注册工厂
        GenericBeanDefinition factoryDefinition = new GenericBeanDefinition();
        factoryDefinition.setBeanClass(Cat.Factory.class);
        String factoryBeanName = beanNameGenerator.generateBeanName(factoryDefinition, registry);
        registry.registerBeanDefinition(factoryBeanName, factoryDefinition);

        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(Cat.class);
        // 指定创建Bean使用的工厂类名字
        definition.setFactoryBeanName(factoryBeanName);
        // 指定创建Bean使用的工厂类的方法名
        definition.setFactoryMethodName("create");
        // 传递参数给创建对象的方法
        setConstructorArgument(definition, "cat1");
        registry.registerBeanDefinition(beanNameGenerator.generateBeanName(definition, registry), definition);
    }


    private void registryZooDefinition(BeanDefinitionRegistry registry, BeanNameGenerator beanNameGenerator) {
        BeanDefinition definition = getBeanDefinition(Zoo.class);
        if (definition instanceof GenericBeanDefinition) {
            // ((GenericBeanDefinition) definition).setAbstract(true);
            // 通过 autowire可以自动注入dog属性
            ((GenericBeanDefinition) definition).setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
        }
        setPropertyArgumentValue(definition, "cat", "cat");
        // setPropertyArgumentValue(definition, "dog", Dog.class);
        registry.registerBeanDefinition(beanNameGenerator.generateBeanName(definition, registry), definition);
    }


    private String getBeanName(BeanDefinitionRegistry registry, BeanNameGenerator beanNameGenerator, BeanDefinition beanDefinition) {
        return beanNameGenerator.generateBeanName(beanDefinition, registry);
    }

    private BeanDefinition getBeanDefinition(Class<?> clazz) {
        return BeanDefinitionBuilder
            .genericBeanDefinition(clazz)
            .getBeanDefinition();
    }

    private void setConstructorArgument(BeanDefinition beanDefinition, String value) {
        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0, value);
        ((GenericBeanDefinition)beanDefinition).setConstructorArgumentValues(constructorArgumentValues);
    }

    private void setPropertyArgumentValue(BeanDefinition beanDefinition, String property, String value) {
        PropertyValue pv = new PropertyValue(property, new RuntimeBeanReference(value));
        beanDefinition.getPropertyValues().addPropertyValue(pv);
    }

    private void setPropertyArgumentValue(BeanDefinition beanDefinition, String property, Class<?> value) {
        PropertyValue pv = new PropertyValue(property, new RuntimeBeanReference(value));
        beanDefinition.getPropertyValues().addPropertyValue(pv);
    }
}
