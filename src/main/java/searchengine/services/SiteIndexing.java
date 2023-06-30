package searchengine.services;

public interface SiteIndexing {
    IndexResponse startIndexing();

    IndexResponse stopIndexing();

    IndexResponse indexPage(String url);
}
