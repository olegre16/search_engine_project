package searchengine.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.services.StatisticsService;

import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final StatisticsService statisticsService;



    public ApiController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


}
