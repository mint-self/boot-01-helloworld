package com.xm.boot;

import ch.qos.logback.core.db.DBHelper;
import com.xm.boot.bean.Pet;
import com.xm.boot.bean.User;
import com.xm.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


/**
 * @author mintFM
 * @create 2021-12-04 8:49
 * 这是一个主程序类
 *
 */

//一个@SpringBootApplication注解相当于这三个注解：@SpringBootConfiguration，@EnableAutoConfiguration，@ComponetScan
@SpringBootApplication  //该注解是表示这是一个Springboot应用 最后Springboot可以直接运行这个主程序就可以了
public class MainApplication {
    public static void main(String[] args) {
        //让springboot跑起来
//        SpringApplication.run(MainApplication.class,args);

        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);

        //查看容器中的组件
        String[] names = run.getBeanDefinitionNames();
        //输出组件名
        System.out.println("组件名是：");
        for (String name : names) {
            System.out.println( name);
        }

        //从容器中获取组件
        Pet pet1 = run.getBean("tom11",Pet.class);
        Pet pet2 = run.getBean("tom11",Pet.class);
        System.out.println("组件判断：" + (pet1 == pet2));

        System.out.println("获取Myconfig即配置类这个组件：");
        MyConfig myConfigbean = run.getBean(MyConfig.class);
        System.out.println(myConfigbean);

        //通过配置类获取注入的组件；
        User user1 = myConfigbean.user01();
        User user2 = myConfigbean.user01();
        System.out.println("判断创建的是否是同一个组件：" + (user1 == user2));

        User user01 = run.getBean("user01",User.class);
        Pet pettom = run.getBean("tom11",Pet.class);
        System.out.println("用户的宠物是pettom吗:" + (user01.getPet() == pettom));

        System.out.println("判断条件注解中是否有注入Tom组件:");
        boolean tom = run.containsBean("tom");
        System.out.println("容器中的Tom组件：" + tom);
        boolean user011 = run.containsBean("user01");
        System.out.println("容器中的user01组件：" + user011);
        boolean tom11 = run.containsBean("tom11");
        System.out.println("容器中的Tom11组件：" + tom11);

        System.out.println("测试通过引入原生配置文件：");
        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha:" + haha);
        System.out.println("hehe:" + hehe);
    }
}

