package searchengine.parsesites;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveAction;

public class Parse extends RecursiveAction {
    private MapLinks mapLinks;
    private static CopyOnWriteArrayList<String> linkSite = new CopyOnWriteArrayList<>();

    public Parse(MapLinks mapLinks) {
        this.mapLinks = mapLinks;
    }

    @Override
    protected void compute() {
        linkSite.add(mapLinks.getUrl());
        ConcurrentSkipListSet<String> link = ParseHtml.getPageLinks(mapLinks.getUrl());
        for (String l : link) {
            if (!linkSite.contains(l)) {
                linkSite.add(l);
                mapLinks.addSiteMap(new MapLinks(l));
                System.out.println(l);
            }
        }
        List<Parse> taskList = new ArrayList<>();
        for (MapLinks child : mapLinks.getSiteMap()) {
            Parse task = new Parse(child);
            task.fork();
            taskList.add(task);
        }
        for (Parse task : taskList) {
            task.join();
        }
    }
}



