package bfs.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private Queue<String> queue;
    private Set<String> discoverdWebsites;

    public WebCrawler() {
        queue = new LinkedList<String>();
        discoverdWebsites = new HashSet<String>();
    }

    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoverdWebsites.add(root);

        while (!queue.isEmpty()) {
            String url = queue.remove();
            String rawHtml = readUrl(url);
            String regex = "http://(\\w+\\.)*(\\w+)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()) {
                String actualUrl = matcher.group();
                if (!discoverdWebsites.contains(actualUrl)) {
                    discoverdWebsites.add(actualUrl);
                    System.out.println("Website has been found: " + actualUrl);
                    queue.add(actualUrl);
                }
            }
        }
    }

    private String readUrl(String url) {
        StringBuilder rawHtml = new StringBuilder();

        try {
            URL url1 = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url1.openStream()));
            String inputLine = "";
            while ((inputLine = reader.readLine()) != null) {
                rawHtml.append(inputLine);
            }
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawHtml.toString();
    }
}
