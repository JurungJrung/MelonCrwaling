package youtube;

import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class YoutubeMain {

    public static void main(String[] args) throws IOException, InterruptedException {

        YoutubeCrawling youtubeCrawling = new YoutubeCrawling();

        youtubeCrawling.youtubeSearch();

        Thread.sleep(3000);
    }
}
