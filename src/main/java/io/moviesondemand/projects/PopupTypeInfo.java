package io.moviesondemand.projects;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class PopupTypeInfo {

    private boolean isPrimitive;
    private boolean isBoolean;
    private boolean isInterface;
    private boolean isEnum;
    private String name;
    private boolean isJdk;
    private List<String> inheritedClassNames;
    private List<String> interfacesImplemented;
    private String type;

    public PopupTypeInfo() {
        this.name = "none";
        this.interfacesImplemented = new ArrayList<>();
        this.inheritedClassNames = new ArrayList<>();
    }

    public PopupTypeInfo setPrimitive(boolean primitive) {
        this.isPrimitive = primitive;
        return this;
    }

    public PopupTypeInfo setBoolean(boolean isBoolean) {
        this.isBoolean = isBoolean;
        return this;
    }

    public PopupTypeInfo setInterface(boolean isInterface) {
        this.isInterface = isInterface;
        return this;
    }

    public PopupTypeInfo setEnum(boolean isEnum) {
        this.isEnum = isEnum;
        return this;
    }

    public PopupTypeInfo setName(String name) {
        this.name = name;
        return  this;
    }

    public PopupTypeInfo setJdk(boolean isJdk) {
        this.isJdk = isJdk;
        return this;
    }

    public PopupTypeInfo setInheritedClassNames(List<String> inheritedClassNames) {
        this.inheritedClassNames =  Collections.unmodifiableList(inheritedClassNames);
        return this;
    }

    public PopupTypeInfo setInterfacesImplemented(List<String> interfacesImplemented) {
        this.interfacesImplemented = interfacesImplemented;
        return this;
    }

    public PopupTypeInfo setType() {
        if (isPrimitive) {
            this.type = "Primitive";
        } else if (isInterface) {
            this.type = "Interface";
        } else {
            this.type = "Class";
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder("Information:\n")
                .append(String.format("%sType: %s%n", " ".repeat(2), ((isJdk) ? "JDK" : "Custom")))
                .append(String.format("%sName: %s%n", " ".repeat(2), name))
                .append(String.format("%sType: %s%n", " ".repeat(2), type));

        if (!inheritedClassNames.isEmpty()) {
            bld.append(String.format("%sInherits from: %s%n", " ".repeat(2),
                    String.join(", ", inheritedClassNames)));
        }

        if (!interfacesImplemented.isEmpty()) {
            bld.append(String.format("%sImplements: %s%n", " ".repeat(2),
                    String.join(", ", interfacesImplemented)));
        }

        return bld.toString();
    }
}
