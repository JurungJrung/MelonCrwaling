package youtube;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.json.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class YoutubeCrawling {

    private String q;
    private String URL = "https://www.youtube.com/results?search_query="+q;
    private Document youtubeDoc;


    public YoutubeCrawling() throws IOException {

        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader("melon.output.json"));
        Type userListType = new TypeToken<List<YoutubeDto>>(){}.getType();
        List<YoutubeDto> userList = gson.fromJson(reader, userListType);


        if (!userList.isEmpty()) {
            YoutubeDto firstUser = userList.get(0);
            this.q = firstUser.getTitle();
            this.URL = "https://www.youtube.com/results?search_query="+q;
            youtubeDoc = Jsoup.connect(URL).get();
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void youtubeSearch() {
        if (youtubeDoc != null) {
            Elements scriptElements = youtubeDoc.select("script");

            for (Element script : scriptElements) {
                String scriptData = script.toString();
                if (scriptData.contains("var ytInitialData")) {
                    String videoId = VideoId(scriptData);
                    System.out.println("Video ID: " + videoId);
                    break;
                }
            }
        } else {
            System.out.println("Youtube doc is not loaded.");
        }
    }

    private String VideoId(String scriptData) {

        int startIndex = scriptData.indexOf("videoId") + 10;
        int endIndex = scriptData.indexOf("\"", startIndex);
        return scriptData.substring(startIndex, endIndex);
    }

}
