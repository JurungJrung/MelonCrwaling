package melon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MelonCrawling {


    private String URL = "https://www.melon.com/chart/index.htm"; // URL : 크롤링 하고자 하는 사이트 주소를 변수로 만들어 코드 축약
    private Document melonTopList;
    private List<Music> top100;
    private List<Music> youtubeTiles;

    public MelonCrawling() throws IOException {
        melonTopList = Jsoup.connect(URL).get();
        top100 = new ArrayList<>();
        youtubeTiles = new ArrayList<>();
//        top100Info();
    }


    public void top100Info(){ //

        Elements body = melonTopList.select("body");
        Elements yyyymmdd = body.select("span.yyyymmdd");
        Elements hhmm = body.select("span.hhmm");

        System.out.println("조회 일자: "+yyyymmdd.text()+" ,조회 시간: "+hhmm.text());
        System.out.println("=====================================================================");

        MelonTime melonTime = new MelonTime(yyyymmdd.text(),hhmm.text()); // 조회 시간 관련 코드


        Elements tbody = melonTopList.select("tbody"); //안정적 크롤링을 위한 요소 추출
        Elements ranks = tbody.select("span.rank");// TOP100 ranking
        Elements titles = tbody.select(".rank01"); // TOP100 제목
        Elements singers = tbody.select( ".checkEllipsis"); // TOP100 가수
        Elements albumJacketImageUrls = tbody.select(".image_typeAll"); // TOP100 앨범자켓 URL


        for (int i = 0; i < 100; i++) {
            Element rank = ranks.get(i);
            Element title = titles.get(i);
            Element singer = singers.get(i);
            String albumJacketImage = albumJacketImageUrls.get(i).child(0).attr("src");

            Music musicInfo = new Music(rank.text(),title.text(),singer.text(),albumJacketImage);
            top100.add(musicInfo);

            System.out.println(rank.text()+ "위 " + "제목: " + title.text() + " ,가수: " + singer.text() + "\n"+" ,앨범재킷 URL: "+albumJacketImage);
            System.out.println(melonTime);

            Music youtube = new Music(title.text());
            youtubeTiles.add(youtube);
        }

        Music musicTime = new Music(melonTime);
        top100.add(musicTime);

    }
    public List<Music> getTop100(){
        return top100;
    }

    public List<Music> getYoutubeTiles(){
        return youtubeTiles;
    }

}

