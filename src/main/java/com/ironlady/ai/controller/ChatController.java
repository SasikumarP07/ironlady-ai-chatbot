package com.ironlady.ai.controller;

import com.ironlady.ai.dto.ChatRequest;
import com.ironlady.ai.dto.ChatResponse;
import com.ironlady.ai.service.AiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String reply = aiService.getAiReply(request.getMessage());
        return new ChatResponse(reply);
    }
}
