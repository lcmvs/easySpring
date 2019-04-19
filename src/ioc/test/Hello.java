package ioc.test;

import ioc.annotation.Autowired;
import ioc.annotation.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-18 09:38
 **/
@Component
public class Hello {

    @Autowired
    Dog dog;

    public void say(){
        System.out.println("你好:"+dog.toString());
    }

}
