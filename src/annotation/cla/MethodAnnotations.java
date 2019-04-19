package annotation.cla;

import annotation.ann.DefaultValue;
import annotation.ann.QueryParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-12 10:03
 **/

public class MethodAnnotations {

    public void hello(@QueryParam("action") String action, @QueryParam("sort") @DefaultValue() String sort){

    }

    public static void main(String[] srgs) throws NoSuchMethodException {
        Class cls=MethodAnnotations.class;

        Method method=cls.getMethod("hello", String.class, String.class);
        Annotation[][] anns = method.getParameterAnnotations();

        for(Annotation[] ann:anns){
            System.out.println("参数：");
            for(Annotation an:ann){
                if(an instanceof QueryParam){
                    QueryParam queryParam=(QueryParam)an;
                    System.out.println(an.annotationType().getName()+":"+queryParam.value());
                }else if(an instanceof DefaultValue){
                    DefaultValue defaultValue=(DefaultValue)an;
                    System.out.println(an.annotationType().getName()+":"+defaultValue.value());
                }
            }
        }
    }

}
