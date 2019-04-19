package ioc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-18 09:27
 **/

public class PropertyValues {

    private final List<PropertyValue> list=new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        list.add(propertyValue);
    }

}
