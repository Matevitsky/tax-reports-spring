package com.matevytskyi.taxreports.config;

import com.matevytskyi.taxreports.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final String REPORTS = "reports";

    private ReportRepository reportRepository;

    @Autowired
    public CustomAuthenticationSuccessHandler(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // changeLastLoginTime(username)
        System.out.println("hello world");
        reportRepository.findAllByClient_Id()
        request.setAttribute(REPORTS, reports));
        super.onAuthenticationSuccess(request, response, authentication);
    }
}