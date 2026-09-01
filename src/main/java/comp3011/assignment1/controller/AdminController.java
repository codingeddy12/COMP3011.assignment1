package comp3011.assignment1.controller;

import comp3011.assignment1.dto.UptimeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

@RestController
public class AdminController {

    private final Instant serverStart = Instant.now();

    @GetMapping("/api/v1/admin/uptime")
    public UptimeResponse getUptime() {
        Instant now = Instant.now();
        double uptimeSeconds = Duration.between(serverStart, now).toMillis() / 1000.0;
        return new UptimeResponse(serverStart, now, uptimeSeconds);
    }
}