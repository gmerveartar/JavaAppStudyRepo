package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.lang.reflect.Parameter;

import static com.karandev.io.util.console.CommandLineArgs.*;

class Application {
    private static String getParametersStr(Parameter[] parameters)
    {
        var sb = new StringBuilder();
        for (var parameter : parameters)
            sb.append(parameter.getType().getSimpleName()).append(' ').append(parameter.getName()).append(", ");

        return sb.isEmpty() ? "" : sb.substring(0, sb.length() - ", ".length());
    }
    private static void printAnnotations(Class<?> cls)
    {
        try {
            Console.writeLine("-----------------------------");
            Console.writeLine("Annotations: ");
            Console.writeLine("-----------------------------");

            for (var annotations : cls.getAnnotations())
                Console.writeLine("@ %s", annotations.annotationType().getSimpleName());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Annotation exception: %s", ex.getMessage());
        }
    }
    private static void printConstructors(Class<?> cls)
     {
        try {
            Console.writeLine("-----------------------------");
            Console.writeLine("Constructors: ");
            Console.writeLine("-----------------------------");
            for (var ctor : cls.getConstructors())
                Console.writeLine("%s(%s)", cls.getSimpleName(), getParametersStr(ctor.getParameters()));
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Constructor exception: %s", ex.getMessage());
        }
    }
    private static void printFields(Class<?> cls)
    {
        try {
            Console.writeLine("-----------------------------");
            Console.writeLine("Fields: ");
            Console.writeLine("-----------------------------");

            for (var field : cls.getFields())
                Console.writeLine("%s %s", field.getType().getSimpleName(), field.getName());
        }
       catch (Throwable ex) {
            Console.Error.writeLine("Field exception: %s", ex.getMessage());
       }
    }
    private static void printInterfaces(Class<?> cls)
    {
        try {
            Console.writeLine("-----------------------------");
            Console.writeLine("Interfaces: ");
            Console.writeLine("-----------------------------");

            for (var i : cls.getInterfaces())
                Console.writeLine("%s", i.getSimpleName());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Interface exception: %s", ex.getMessage());
        }
    }
    private static void printMethods(Class<?> cls)
    {
        try {
            Console.writeLine("-----------------------------");
            Console.writeLine("Methods: ");
            Console.writeLine("-----------------------------");
            for (var method : cls.getDeclaredMethods())
                Console.writeLine("%s %s(%s)", method.getReturnType().getSimpleName(), method.getName(),
                        getParametersStr(method.getParameters()));
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Method exception: %s", ex.getMessage());
        }
    }

    private static void printSuperClass(Class<?> cls)
    {
        try {
            Console.writeLine("-----------------------------");
            Console.writeLine("Super Class: ");
            Console.writeLine("-----------------------------");
            Console.writeLine("%s", cls.getSuperclass().getSimpleName());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Super Class exception: %s", ex.getMessage());
        }
    }
    private static void printMetadata(Class<?> cls)
    {
        printAnnotations(cls);
        printSuperClass(cls);
        printInterfaces(cls);
        printFields(cls);
        printMethods(cls);
        printConstructors(cls);
    }
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1,  "Usage: java -jar  DemoDeclaredElementsApp <fully qualified typename>");

        try {
            printMetadata(Class.forName(args[0]));
        }
        catch (ClassNotFoundException ex){
            Console.Error.writeLine("Cannot find type: %s", args[0]);
        }
        catch (Throwable ex){
            Console.Error.writeLine("Exception occured: %s", ex.getMessage());
        }
    }
}
