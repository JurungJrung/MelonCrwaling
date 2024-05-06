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

        String URL = "https://www.melon.com/chart/index.htm"; // URL : 크롤링 하고자 하는 사이트 주소를 변수로 만들어 코드 축약

        Document melonTopList = Jsoup.connect(URL).get();

        Elements e0 = melonTopList.getElementsByAttributeValue("class", "title");
        Element chartType = e0.get(1);
        System.out.println("멜론 차트: " + chartType.text() + "\n");


        Elements title = melonTopList.getElementsByAttributeValue("class", "ellipsis rank01"); // TOP100 제목
        Elements singer = melonTopList.getElementsByAttributeValue("class", "checkEllipsis"); // TOP100 가수
        Elements albumJacketImageUrl = melonTopList.getElementsByAttributeValue("class","image_typeAll"); // TOP100 앨범자켓 URL -> 링크 파싱 안되는 문제



        for (int i = 0; i < 100; i++) {
            Element titleResult = title.get(i);
            Element singerResult = singer.get(i);
            String albumJacketImageSrc = albumJacketImageUrl.get(i).child(0).attr("src");

            System.out.println((i + 1) + "위 " + "제목: " + titleResult.text() + " ,가수: " + singerResult.text() + "\n"+" ,앨범재킷 URL: "+albumJacketImageSrc);
            // TOP100 출력 코드
        }
    }
}
