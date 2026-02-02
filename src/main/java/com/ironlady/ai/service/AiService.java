package com.ironlady.ai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AiService {

    @Value("${ai.api.key}")
    private String apiKey;

    private static final String SYSTEM_PROMPT = """
You are the Iron Lady AI Career Advisor.

Iron Lady is a women-focused career and leadership platform that helps:
- College students
- Working professionals
- Women returning after a career break

Ask about education, career status, and goals.
Recommend ONE suitable program and explain benefits.
Use a friendly and motivating tone.
""";

    public String getAiReply(String userMessage) {

        String msg = userMessage.toLowerCase();

        // Greeting
        if (msg.contains("hi") || msg.contains("hello")) {
            return "Hi! Welcome to Iron Lady 🌸 I’m your AI Career Advisor. "
                    + "Can you tell me your highest education?";
        }

        // Education
        if (msg.contains("b.tech") || msg.contains("be") || msg.contains("mba")
                || msg.contains("bsc") || msg.contains("degree")) {
            return "Nice! Thanks for sharing your education. "
                    + "Are you currently a student, a working professional, or on a career break?";
        }

        // Career break
        if (msg.contains("career break") || msg.contains("break")) {
            return "Thank you for sharing that. Many women successfully restart their careers with the right support 💪 "
                    + "I recommend the Career Restart Program. "
                    + "This program helps you rebuild confidence, update professional skills, "
                    + "and become job-ready. What is your career goal right now?";
        }

        // Working professional
        if (msg.contains("working") || msg.contains("job") || msg.contains("employee")) {
            return "That’s great! Since you are currently working, I recommend the Leadership Accelerator program. "
                    + "It focuses on leadership skills, communication, and career growth. "
                    + "Are you aiming for a promotion or a leadership role?";
        }

        // Student
        if (msg.contains("student") || msg.contains("final year") || msg.contains("graduate")) {
            return "That’s exciting! As a student, the Tech Foundations for Women program would be a great fit. "
                    + "It helps you build strong fundamentals, confidence, and career clarity. "
                    + "What kind of career are you interested in?";
        }

        // Career goal
        if (msg.contains("restart") || msg.contains("career") || msg.contains("job") || msg.contains("leadership")) {
            return "That’s a wonderful goal 🌸 "
                    + "Based on what you’ve shared, Iron Lady has programs designed to support you. "
                    + "Next step: I recommend booking a counseling session with Iron Lady to create "
                    + "a personalized learning plan. Would you like help with that?";
        }

        // Default
        return "Thanks for reaching out to Iron Lady 🌸 "
                + "To guide you better, could you please tell me your education and current career status?";
    }


}
