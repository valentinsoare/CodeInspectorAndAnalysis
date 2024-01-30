package io.moviesondemand.projects;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        String toTest = "testing whatever";
        Boolean checking = true;

        List<String> elements = new ArrayList<>();

        PopupTypeInfo popupTypeInfoFromClass = ClassAnalyzer.createPopupTypeInfoFromClass(toTest.getClass());

        System.out.printf("%n%s", popupTypeInfoFromClass);
        System.out.printf("%n%s", ClassAnalyzer.createPopupTypeInfoFromClass(Student.class));
        System.out.printf("%n%s", ClassAnalyzer.createPopupTypeInfoFromClass(checking.getClass()));
        System.out.printf("%n%s", ClassAnalyzer.createPopupTypeInfoFromClass(elements.getClass()));
    }
}
