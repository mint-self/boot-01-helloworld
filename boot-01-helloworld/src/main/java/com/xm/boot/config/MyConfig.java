package com.xm.boot.config;

/**
 * @author mintFM
 * @create 2021-12-04 10:19
 * 相当于配置文件
 */

import ch.qos.logback.core.db.DBHelper;
import com.xm.boot.bean.Pet;
import com.xm.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;

/**
 * 配置类使用@Bean标注在方法上给容器注册组件，默认注册的是单实例的
 * 配置类本身也是组件
 */

@Configuration(proxyBeanMethods = true) //告诉springboot这是一个配置类，相当于配置文件
@Import({User.class, DBHelper.class}) //给容器自动创建者两个类型的组件
@ConditionalOnMissingBean(name = "tom") //条件装配注解，满足condition注解指定的条件就进行组件的注入
//@ConditionalOnBean(name = "tom")
@ImportResource("classpath:beans.xml") //通过这个注解 引入原生配置文件
public class MyConfig {

    @Bean //给容器添加组件，返回值是组件实例，方法名就是组件ID
    public User user01() {
        User user1 = new User("zhangsan",18);
        //让组件user依赖组件pet
        user1.setPet(tomcatPet());
        return user1;
    }

    @Bean("tom11")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
