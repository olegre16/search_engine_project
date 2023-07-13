package searchengine.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.services.IndexService;

@RestController
@RequestMapping("/api")
public class IndexController {
    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }
    @GetMapping("/indexing")
    public ResponseEntity<StatisticsResponse> startIndexing() {
        return ResponseEntity.ok(statisticsService.getStatistics());
    }
}
