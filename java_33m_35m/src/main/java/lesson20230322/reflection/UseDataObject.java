package lesson20230322.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UseDataObject {

    public static void main(String[] args) throws Exception {

        DataObject dataObject = new DataObject(10, "My Object");
        dataObject.method1();

        Class<? extends DataObject> dataObjectClass = dataObject.getClass();

        Field dataObjectClassField = dataObjectClass.getDeclaredField("count");
        dataObjectClassField.setAccessible(true);
        dataObjectClassField.set(dataObject, 20);
        dataObject.method1();

        Method method1FromClass = dataObjectClass.getDeclaredMethod("method1");
        method1FromClass.invoke(dataObject);

        Method updateCountFromClass = dataObjectClass.getDeclaredMethod("updateCount", int.class);
        updateCountFromClass.setAccessible(true);
        updateCountFromClass.invoke(dataObject, 30);
        dataObject.method1();

//        dataObject.updateCount(20); // impossible


        Class<?> forName = Class.forName("lesson20230322.reflection.DataObject");
        Object newInstance = forName.getDeclaredConstructor(int.class, String.class).newInstance(5, "New instance");
        DataObject newDataObject = (DataObject) newInstance;
        newDataObject.method1();

        @SuppressWarnings(value = "deprecation")
        Object newInstance2 = forName.newInstance();
    }


}
