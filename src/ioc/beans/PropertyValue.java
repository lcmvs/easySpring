package ioc.beans;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-18 09:25
 **/

public class PropertyValue {

    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
