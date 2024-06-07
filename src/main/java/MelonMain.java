import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MelonMain {

    public static void main(String[] args) throws IOException {

        MelonCrawling melonCrawling = new MelonCrawling(); // top100Info() 매서드로 인해 정상 출력 바로 확인 가능


        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Gson -> Json 변환 시 이쁘게 데이터가 이쁘게 출력되어 .setPrettyPrinting() 매서드 사용

        String json = gson.toJson(melonCrawling.getTop100()); // Json 변환을 위해 매서드가 아닌 제네릭 타입으로 변환 하여 시도

        try (BufferedWriter writer =new BufferedWriter(new FileWriter("mellon.output.json"))){ // 버퍼 캐시로 관리되기 때문에 데이터의 양이 많을수록 I/O 메모리 관리에 이득
            writer.write(json);
        }
    }
}
