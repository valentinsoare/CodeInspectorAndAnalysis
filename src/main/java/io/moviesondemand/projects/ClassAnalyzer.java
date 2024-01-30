package io.moviesondemand.projects;

import java.util.*;

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
                .setInterfacesImplemented(getAllImplementedInterfaces(inputClass, new ArrayList<>()))
                .setType();
    }

    private static boolean isJdkClass(Class<?> inputClass) {
        return JDK_PACKAGE_PREFIXES.stream().anyMatch(packagePrefix -> inputClass.getPackage() == null ||
                        inputClass.getPackage().getName().startsWith(packagePrefix));
    }

    private static String[] getAllInheritedClassNames(Class<?> inputClass) {
        String[] inheritedClasses = new String[] {};

        Class<?> inheritedClass = inputClass.getSuperclass();

        if (inheritedClass != null) {
            inheritedClasses = new String[] {inputClass.getSuperclass().getSimpleName()};
        }

        return inheritedClasses;
    }

    private static List<String> getAllImplementedInterfaces(Class<?> inputClass, List<String> allImplementedInterfaces) {
        Class<?>[] inputInterfaces = inputClass.getInterfaces();

        for (Class<?> currentInterface : inputInterfaces) {
            allImplementedInterfaces.add(currentInterface.getSimpleName());

            getAllImplementedInterfaces(currentInterface, allImplementedInterfaces);
        }

        return allImplementedInterfaces;
    }
}
