package io.moviesondemand.projects;

import java.util.Arrays;
import java.util.List;
public class ClassAnalyzer {

    private ClassAnalyzer() {}

    private static final List<String> JDK_PACKAGE_PREFIXES =
            Arrays.asList("com.sun.", "java", "javax", "jdk", "org.w3c", "org.xml");

    public static PopupTypeInfo createPopupTypeInfoFromClass(Class<?> inputClass) {
        return new PopupTypeInfo().setPrimitive(inputClass.isPrimitive())
                .setInterface(inputClass.isInterface())
                .setEnum(inputClass.isEnum())
                .setName(inputClass.getSimpleName())
                .setJdk(isJdkClass(inputClass))
                .setInheritedClassNames(Arrays.asList(getAllInheritedClassNames(inputClass)))
                .setType();
    }

    private static boolean isJdkClass(Class<?> inputClass) {
        return JDK_PACKAGE_PREFIXES.stream().anyMatch(packagePrefix -> inputClass.getPackage() == null ||
                        inputClass.getPackage().getName().startsWith(packagePrefix));
    }

    private static String[] getAllInheritedClassNames(Class<?> inputClass) {
        String[] inheritedClasses = new String[] {};

        if (inputClass.isInterface()) {
            inheritedClasses = Arrays.stream(inputClass.getInterfaces())
                    .map(Class::getSimpleName)
                    .toArray(String[]::new);
        } else {
            Class<?> inheritedClass = inputClass.getSuperclass();

            if (inheritedClass != null) {
                inheritedClasses = new String[] {inputClass.getSuperclass().getSimpleName()};
            }
        }

        return inheritedClasses;
    }

}
