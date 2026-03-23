package com.biblio.command;

import com.biblio.exception.CommandException;
import com.biblio.repository.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CommandException {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setClassForTemplateLoading(ReportCommand.class, "/");
            cfg.setDefaultEncoding("UTF-8");

            Template template = cfg.getTemplate("report.ftl");

            Map<String, Object> templateData = new HashMap<>();
            templateData.put("catalog", catalog);

            File reportFile = new File("catalog_report.html");
            Writer fileWriter = new FileWriter(reportFile);
            template.process(templateData, fileWriter);
            fileWriter.close();

            Desktop.getDesktop().browse(reportFile.toURI());
        } catch (Exception e) {
            throw new CommandException("Failed to generate or open HTML report", e);
        }
    }
}