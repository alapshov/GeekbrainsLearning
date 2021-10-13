import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestEngine {
    private static List<Method> testMethods = new ArrayList<>();
    private static List<Method> beforeSuiteMethods = new ArrayList<>();
    private static List<Method> afterSuiteMethods = new ArrayList<>();

    public static void start(Class testClass) {
        Method[] methods = testClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteMethods.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteMethods.add(method);
            }

        }

        if (beforeSuiteMethods.size() > 1 || afterSuiteMethods.size() > 1) {
            throw new RuntimeException();
        }

        for (Method getMethod : beforeSuiteMethods) {
            try {
                getMethod.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        testMethods.sort(Comparator.comparing(m -> m.getAnnotation(Test.class).priority()));
        for (Method getMethod : testMethods) {
            try {
                getMethod.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        for (Method getMethod : afterSuiteMethods) {
            try {
                getMethod.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

}
