import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MelonCrwaling {


    private String URL = "https://www.melon.com/chart/index.htm"; // URL : 크롤링 하고자 하는 사이트 주소를 변수로 만들어 코드 축약
    Document melonTopList = Jsoup.connect(URL).get();

    public MelonCrwaling() throws IOException {
    }


    Elements title = melonTopList.getElementsByAttributeValue("class", "ellipsis rank01"); // TOP100 제목
    Elements singer = melonTopList.getElementsByAttributeValue("class", "checkEllipsis"); // TOP100 가수
    Elements albumJacketImageUrl = melonTopList.getElementsByAttributeValue("class","image_typeAll"); // TOP100 앨범자켓 URL



    public void top100(){ // TOP100(제목+가수+앨범URL) 출력 코드
        for (int i = 0; i < 100; i++) {
                Element titleResult = title.get(i);
                Element singerResult = singer.get(i);
                String albumJacketImageSrc = albumJacketImageUrl.get(i).child(0).attr("src");

                System.out.println((i + 1) + "위 " + "제목: " + titleResult.text() + " ,가수: " + singerResult.text() + "\n"+" ,앨범재킷 URL: "+albumJacketImageSrc);
            }
        }
    }

