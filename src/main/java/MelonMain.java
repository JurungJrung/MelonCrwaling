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

        MelonCrwaling melonCrwaling = new MelonCrwaling();

        melonCrwaling.serchTimeInfo(); // 멜론 크롤링 출력물
        melonCrwaling.top100Info();


        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Gson -> Json 변환 시 이쁘게 데이터가 이쁘게 출력되어 .setPrettyPrinting() 매서드 사용

        String json = gson.toJson(melonCrwaling.getTimeInfo()); // 시간조회 값 -> json 값으로 추가 시 json 파일에서 최상위값 1개만 허용하라고 오류남
        String json1 = gson.toJson(melonCrwaling.getTop100()); //


//        try (FileWriter writer = new FileWriter("output.json")) { // 데이터의 양이 적을 경우 FileWirter 클래스를 이용하는게 더 효율적일 수 있다
//            writer.write(json); //
//        }

        try (BufferedWriter writer =new BufferedWriter(new FileWriter("mellon.output.json"))){ // 버퍼 캐시로 관리되기 때문에 데이터의 양이 많을수록 I/O 메모리 관리에 이득
            writer.write(json); // json 최상위값 복수로 인하여 json 파일 내 에러 발생
            writer.newLine();
            writer.write(json1);
        }
    }
}
