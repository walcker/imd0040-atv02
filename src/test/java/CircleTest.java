

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void existsCircle() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("Circle");
        assertNotNull(clazz);
    }

    @Test
    void existsAttrRadius() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazz = Class.forName("Circle");
        Field fieldRadius = clazz.getDeclaredField("radius");

        assertNotNull(fieldRadius);
        assertEquals("float", fieldRadius.getGenericType().getTypeName());

    }

    @Test
    void existsMethodArea() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("Circle");
        Method methodArea = clazz.getDeclaredMethod("area");
        assertNotNull(methodArea);
        assertEquals(0, methodArea.getParameterCount());
        assertEquals("double", methodArea.getGenericReturnType().getTypeName());
    }

    @Test
    void existsMethodCircumference() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("Circle");
        Method method = clazz.getDeclaredMethod("circumference");
        assertNotNull(method);
        assertEquals(0, method.getParameterCount());
        assertEquals("double", method.getGenericReturnType().getTypeName());
    }

    @Test
    void existsConstructor() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("Circle");
        Constructor<?> constructor = clazz.getDeclaredConstructor(float.class);
        assertNotNull(constructor);
    }

    @Test()
    void notExistsEmptyConstructor() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = Class.forName("Circle");
        assertThrows(NoSuchMethodException.class, () -> {
            clazz.getDeclaredConstructor();
        });
    }

    @Test
    void assertCalculationArea() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("Circle");
        Constructor<?> constructor = clazz.getDeclaredConstructor(float.class);
        float radius = 10f;
        Object instance = constructor.newInstance(radius);
        Method methodCalcular = clazz.getDeclaredMethod("area");
        double response = (double) methodCalcular.invoke(instance);
        assertEquals(Math.PI * radius * radius, response, 0.01);
    }

    @Test
    void assertCalculationArea0() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("Circle");
        Constructor<?> constructor = clazz.getDeclaredConstructor(float.class);
        float radius = 0f;
        Object instance = constructor.newInstance(radius);
        Method methodCalcular = clazz.getDeclaredMethod("area");
        double response = (double) methodCalcular.invoke(instance);
        assertEquals(Math.PI * radius * radius, response, 0.01);
    }

    @Test
    void assertCalculationCirc10() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("Circle");
        Constructor<?> constructor = clazz.getDeclaredConstructor(float.class);
        float radius = 10f;
        Object instance = constructor.newInstance(radius);
        Method methodCalcular = clazz.getDeclaredMethod("circumference");
        double response = (double) methodCalcular.invoke(instance);
        assertEquals(2 * Math.PI * radius, response, 0.01);
    }

    @Test
    void assertCalculationCirc0() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("Circle");
        Constructor<?> constructor = clazz.getDeclaredConstructor(float.class);
        float radius = 0f;
        Object instance = constructor.newInstance(radius);
        Method methodCalcular = clazz.getDeclaredMethod("circumference");
        double response = (double) methodCalcular.invoke(instance);
        assertEquals(2 * Math.PI * radius, response, 0.01);
    }

}