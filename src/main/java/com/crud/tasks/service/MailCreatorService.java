package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminMail());
        context.setVariable("preview_message", "Welcome!");
        context.setVariable("goodbye_message", "Thanks for using our app!");
        context.setVariable("company_name",adminConfig.getCompanyName());
        context.setVariable("company_email",adminConfig.getCompanyEmail());
        context.setVariable("company_phone",adminConfig.getCompanyPhone());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", getListOfAppFunctionality());

        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    private List<String> getListOfAppFunctionality() {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("application allows sending tasks to Trello");

        return functionality;
    }

    public String buildTasksInfoMail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminMail());
        context.setVariable("show_button", true);
        context.setVariable("goodbye_message", "Thanks for using our app!");
        context.setVariable("company_name",adminConfig.getCompanyName());
        context.setVariable("company_email",adminConfig.getCompanyEmail());
        context.setVariable("company_phone",adminConfig.getCompanyPhone());
        context.setVariable("admin_config", adminConfig);

        return templateEngine.process("mail/task-info-mail", context);
    }
}
