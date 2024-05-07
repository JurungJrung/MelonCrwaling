import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MelonMain {

    public static void main(String[] args) throws IOException {

        MelonCrwaling melonCrwaling = new MelonCrwaling();

        melonCrwaling.serchTimeInfo();
        melonCrwaling.top100Info();
    }
}
