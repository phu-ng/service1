package com.example.micro1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XSSVulnerableController {

    @GetMapping("/vulnerable")
    public String vulnerableEndpoint(@RequestParam(name = "input", defaultValue = "Guest") String input) {
        // **VULNERABILITY**: User input directly included in the response
        return "<html>" +
                "<body>" +
                "<h1>Welcome, " + input + "!</h1>" + // Potential XSS vulnerability
                "</body>" +
                "</html>";
    }
}
