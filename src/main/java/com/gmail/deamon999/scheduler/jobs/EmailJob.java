package com.gmail.deamon999.scheduler.jobs;

import com.gmail.deamon999.scheduler.Const;
import com.gmail.deamon999.scheduler.entity.ProjectModel;
import com.gmail.deamon999.scheduler.entity.SchedulerJobInfo;
import com.gmail.deamon999.scheduler.repository.SchedulerJopRepo;
import com.gmail.deamon999.scheduler.repository_mongo.AcquisitionPlannerUserRepo;
import com.gmail.deamon999.scheduler.repository_mongo.ProjectRepo;
import com.gmail.deamon999.scheduler.service.EmailService;
import com.gmail.deamon999.scheduler.service.SchedulerService;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class EmailJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(EmailJob.class);

    @Autowired
    private SchedulerJopRepo schedulerJopRepo;
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private EmailService emailService;
    @Autowired
    private Environment env;
    @Autowired
    private AcquisitionPlannerUserRepo acquisitionPlannerUserRepo;
    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    private SchedulerService schedulerService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        logger.info("Executing Job with key {}", jobExecutionContext.getJobDetail().getKey());

        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        String projectId = jobDataMap.getString("projectId");
        int jobId = jobDataMap.getInt("jobId");

        ProjectModel projectModel = projectRepo.findFirstById(projectId);
        SchedulerJobInfo schedulerJobInfo = schedulerJopRepo.findFirstById(jobId);
        if (projectModel != null) {
//            AcquisitionPlannerUser user = acquisitionPlannerUserRepo.findFirstById(s);
//
//            MimeMessage message = emailService.getMimeEmail();
//            MimeMessageHelper helper = null;
//            try {
//                helper = new MimeMessageHelper(message, true);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//
//            String appUrl = null;
////                if (env.getProperty("spring.profiles.active").equalsIgnoreCase("dev")) {
////                    appUrl = request.getScheme() + "://" + request.getServerName() + ":8080";
////                } else {
////                    appUrl = request.getScheme() + "://" + request.getServerName();
////                }
//            Context ctx = new Context(Locale.getDefault());
//            ctx.setVariable("name", user.getFirstName() + " " + user.getLastName());
//            ctx.setVariable("product_name", env.getProperty("product_name"));
//            ctx.setVariable("action_home", appUrl);
//            String support_url = null;
//            if (user.getLangCode() == null) {
//                support_url = env.getProperty("support_url");
//            } else {
//                support_url = env.getProperty("support_url") + "_" + user.getLangCode();
//            }
//            ctx.setVariable("support_url", support_url);
//            // Provides the current date to the template engine
//            ctx.setVariable("year", LocalDate.now().getYear());
//            //in feature will be changed to name with lang suffix
//            String html = templateEngine.process(schedulerJobInfo.getTemplateName(), ctx);
//
//            try {
//                helper.setTo(user.getEmail().toLowerCase());
//                helper.setText(html, true);
//                helper.setSubject("Reset your password!");
//                helper.setFrom("noreply@acquisitionplanner.com");
//                helper.addInline("acquisition-planner-logo-color.png", new ClassPathResource("templates/assets/img" +
//                        "/acquisition-planner-logo-color.png"), "image/png");
//                helper.addInline("acquisition-simplicity-logo-grey.png", new ClassPathResource("templates/assets/img" +
//                        "/acquisition-simplicity-logo-grey.png"), "image/png");
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            emailService.sendASynchronousMailMime(message);
        }
        System.out.println("****************************************************************************");
        System.out.println("test work done, test group type is: " + jobDataMap.getString("group"));

        schedulerJobInfo.setState(Const.JOB_DONE);
        schedulerJopRepo.save(schedulerJobInfo);
        schedulerService.unScheduleJob(schedulerJobInfo.getId());
    }
}