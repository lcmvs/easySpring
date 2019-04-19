package ioc.framework.IO;

import ioc.annotation.Component;
import ioc.beans.BeanDefinition;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-18 11:54
 **/

public class AnnotationReader {

    public static ClassLoader getClassLodader(){
        return  Thread.currentThread().getContextClassLoader();
    }

    public static void doRegister(String path, Map<String,BeanDefinition> beanDefinitionMap) throws ClassNotFoundException {
        File dir=new File(getClassLodader().getResource(path.replaceAll("\\.","/")).getFile());
        for(File file:dir.listFiles()){
            if (file.isDirectory()){
                doRegister(path+"."+file.getName(),beanDefinitionMap);
            }else{
                BeanDefinition beanDefinition=new BeanDefinition();
                String beanName=path+"."+file.getName().replace(".class","").trim();
                Class clazz = Class.forName(beanName);
                beanDefinition.setBeanName(beanName);
                beanDefinition.setBeanClass(clazz);
                if (!clazz.isAnnotation()&&clazz.isAnnotationPresent(Component.class)){
                    Component compoment = (Component) clazz.getDeclaredAnnotation(Component.class);
                    String name;
                    if (compoment.value().equals("")){
                        name=clazz.getSimpleName();
                    }else{
                        name=compoment.value();
                    }
                    beanDefinitionMap.put(name,beanDefinition);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String packageNmae="ioc.beans";
        System.out.println("./"+packageNmae.replaceAll("\\.","/"));
        URL url = getClassLodader().getResource("./"+packageNmae.replaceAll("\\.","/"));
        File file=new File(url.getFile());
        for(File f:file.listFiles()){
            System.out.println(f);
        }
    }

}
