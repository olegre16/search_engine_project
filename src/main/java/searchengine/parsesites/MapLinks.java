package searchengine.parsesites;

import java.util.concurrent.CopyOnWriteArrayList;

public class MapLinks {
    private String url;
    private CopyOnWriteArrayList<MapLinks> siteMap;

    public MapLinks(String url){
        this.url = url;
        siteMap = new CopyOnWriteArrayList<>();
    }
    public void addSiteMap(MapLinks link){
        siteMap.add(link);
    }
    public CopyOnWriteArrayList<MapLinks> getSiteMap() {
        return siteMap;
    }
    public String getUrl() {
        return url;
    }
}
