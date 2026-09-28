package com.student;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import com.student.controller.AdminLoginServlet;
import com.student.controller.DashboardServlet;
import com.student.controller.LogoutServlet;
import com.student.controller.PublicRegistrationServlet;
import com.student.controller.RegisterPageServlet;
import com.student.controller.RegisterServlet;
import com.student.controller.RegistrationSuccessServlet;
import com.student.controller.StudentListServlet;
import com.student.util.DatabaseInitializer;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseInitializer.initialize();

        String webappPath = new File("src/main/webapp").getAbsolutePath();
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);
        tomcat.setBaseDir(new File("target/tomcat").getAbsolutePath());
        tomcat.getConnector();

        Context context = tomcat.addWebapp("/student-management-system", webappPath);
        context.setParentClassLoader(Main.class.getClassLoader());

        register(context, "dashboardServlet", new DashboardServlet(), "/dashboard");
        register(context, "studentListServlet", new StudentListServlet(), "/students");
        register(context, "registerPageServlet", new RegisterPageServlet(), "/add-student");
        register(context, "registerServlet", new RegisterServlet(), "/register");
        register(context, "publicRegistrationServlet", new PublicRegistrationServlet(), "/register-student");
        register(context, "registrationSuccessServlet", new RegistrationSuccessServlet(), "/registration-success");
        register(context, "adminLoginServlet", new AdminLoginServlet(), "/admin-login");
        register(context, "logoutServlet", new LogoutServlet(), "/logout");

        tomcat.start();

        System.out.println();
        System.out.println("==============================================");
        System.out.println(" Student Management System is running!");
        System.out.println("Home:  http://localhost:8080/student-management-system/");
        System.out.println("Admin: http://localhost:8080/student-management-system/admin-login");
        System.out.println("Public registration: http://localhost:8080/student-management-system/register-student");
        System.out.println("==============================================");
        System.out.println();

        tomcat.getServer().await();
    }

    private static void register(Context context, String name, jakarta.servlet.http.HttpServlet servlet, String path) {
        Wrapper wrapper = Tomcat.addServlet(context, name, servlet);
        wrapper.setLoadOnStartup(1);
        context.addServletMappingDecoded(path, name);
    }
}
