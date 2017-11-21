/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.demo.freemarkerdemo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import ru.demo.bean.TUsers;
import ru.demo.DAO.TUsersDAO;

/**
 *
 * @author vasil
 */
public class maindemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Configuration cfg = new Configuration();
        try {
            //Load template from source folder

            EntityManager em = Persistence.createEntityManagerFactory("freemarkerDemo_JPA").createEntityManager();

            TUsersDAO dao = new TUsersDAO();
            List<TUsers> itemList = dao.getUsers(em);

            Template template = cfg.getTemplate("src/helloworld.ftl");

            // Build the data-model
            Map<String, Object> data = new HashMap<>();
            data.put("message", "Hello World!");

            //List parsing 
            List<String> countries = new ArrayList<>();
            countries.add("India");
            countries.add("United States");
            countries.add("Germany");
            countries.add("France");

            data.put("countries", countries);
            data.put("users", itemList);

            // Console output
            Writer out = new OutputStreamWriter(System.out);
            template.process(data, out);
            out.flush();

            try ( // File output
                    Writer file = new FileWriter(new File("C:/temp/FTL_helloworld.html"))) {
                template.process(data, file);
                file.flush();
            }

        } catch (IOException | TemplateException e) {
        }

    }

}
