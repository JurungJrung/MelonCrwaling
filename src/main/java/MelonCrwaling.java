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
    Elements tbody = melonTopList.select("tbody"); //안정적 크롤링을 위한 요소 추출

    Elements rank = tbody.select("span.rank");// TOP100 ranking
    Elements title = tbody.select(".rank01"); // TOP100 제목
    Elements singer = tbody.select( ".checkEllipsis"); // TOP100 가수
    Elements albumJacketImageUrl = tbody.select(".image_typeAll"); // TOP100 앨범자켓 URL

    Elements body = melonTopList.select("body");
    Elements time = body.select("span.yyyymmdd");
    Elements time1 = body.select("span.hhmm");


    public void serchTimeInfo(){
        System.out.println("조회 일자: "+time.text()+" ,조회 시간: "+time1.text());
        System.out.println("=====================================================================");
    }


    public void top100Info(){ // TOP100(제목+가수+앨범URL) 출력 코드
        for (int i = 0; i < 100; i++) {
                Element rank1 = rank.get(i);
                Element titleResult = title.get(i);
                Element singerResult = singer.get(i);
                String albumJacketImageSrc = albumJacketImageUrl.get(i).child(0).attr("src");

                System.out.println(rank1.text()+ "위 " + "제목: " + titleResult.text() + " ,가수: " + singerResult.text() + "\n"+" ,앨범재킷 URL: "+albumJacketImageSrc);

            }
        }
}

