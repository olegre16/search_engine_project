package searchengine.parsesites;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ConcurrentSkipListSet;

import static java.lang.Thread.sleep;

public class ParseHtml {
    private static ConcurrentSkipListSet<String> links;

    public static ConcurrentSkipListSet<String> getPageLinks(String url) {
        links = new ConcurrentSkipListSet<>();
        try {
            sleep(150);
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();
            Elements elements = document.select("body").select("a");
            for (Element page : elements) {
                String pageLink = page.attr("abs:href");
                if (pageLink.contains("//skillbox.ru") &&
                        pageLink.matches("^((http[s]?|ftp):\\/)?\\/?([^:\\/\\s]+)((\\/\\w+)*\\/)")) {
                    links.add(pageLink);
//                    ^((http[s]?|ftp):\/)?\/?([^:\/\s]+)
                }
            }
        } catch (HttpStatusException e) {
            System.out.println("Invalid website");

        } catch (InterruptedException | SocketTimeoutException e) {
            System.out.println(e + " - " + url);
        } catch (IOException e) {
            System.out.println(e + " - " + url);
        }
        return links;
    }
}

