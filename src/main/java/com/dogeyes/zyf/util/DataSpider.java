package com.dogeyes.zyf.util;

import com.dogeyes.zyf.pojo.Cinema;
import com.dogeyes.zyf.resource.movie.MovieInfoResource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.dogeyes.zyf.util.StringUtil.colon;
import static com.dogeyes.zyf.util.StringUtil.getInt;

/**
 * 数据爬取器
 *
 * @author ZYF
 * @create 2021-4-12 20:06
 */
public class DataSpider {

    /**
     * 动态代理
     */
    private static final String[] USER_AGENTS = {
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36 OPR/37.0.2178.32",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586",
            "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko",
            "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)",
            "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0)",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 BIDUBrowser/8.3 Safari/537.36",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36 Core/1.47.277.400 QQBrowser/9.4.7658.400",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 UBrowser/5.6.12150.8 Safari/537.36",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE 2.X MetaSr 1.0",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 TheWorld 7",
            "Mozilla/5.0 (Windows NT 6.1; W…) Gecko/20100101 Firefox/60.0"
    };

    /**
     * 爬取电影信息
     *
     * @return 电影信息列表
     * @throws IOException 访问失败
     */
    public static List<MovieInfoResource> getMovieInfos() throws IOException {
        List<MovieInfoResource> movieInfos = new ArrayList<>();

        Document doc = Jsoup.connect("https://dianying.taobao.com/showList.htm?n_s=new")
                .userAgent(USER_AGENTS[new Random().nextInt(14)])
                .timeout(3000)
                .post();
        Elements movieItems = doc.getElementsByClass("tab-movie-list")
                .get(0)
                .getElementsByClass("movie-card-wrap");

        for (Element item : movieItems) {
            MovieInfoResource movieInfo = new MovieInfoResource();

            movieInfo.setDbName(item.getElementsByClass("bt-l").first().text());

            String rate = item.getElementsByClass("bt-r").first().text();
            if (!rate.isEmpty()) {
                movieInfo.setRate(Float.parseFloat(rate));
            }

            movieInfo.setPicURL(item.getElementsByClass("movie-card-poster")
                    .first()
                    .child(0)
                    .attr("src"));

            Elements movieCardList = item.getElementsByClass("movie-card-list").first().children();
            movieInfo.setDirectedBy(colon(movieCardList.get(0).text()));
            movieInfo.setActor(colon(movieCardList.get(1).text()));
            movieInfo.setTpe(colon(movieCardList.get(2).text()));
            movieInfo.setArea(colon(movieCardList.get(3).text()));
            movieInfo.setLange(colon(movieCardList.get(4).text()));
            if (movieCardList.size() > 5) movieInfo.setEndureTime(getInt(movieCardList.get(5).text()));


            movieInfos.add(movieInfo);
        }

        System.out.println("共" + movieItems.size() + "部最新电影");
        return movieInfos;
    }

    /**
     * 爬取影院信息
     *
     * @return 影院信息列表
     * @throws IOException 爬取失败
     */
    public static List<Cinema> getCinemaInfos() throws IOException {
        List<Cinema> cinemas = new ArrayList<>();
        File directory = new File("src/main/resources");
        File file = new File(directory.getCanonicalPath() + "/static/cinemas.html");
        if (file.isFile() && file.exists()) {
            Document doc = Jsoup.parse(file, "UTF-8");
            Elements cinemaItems = doc.getElementsByClass("sortbar-detail J_cinemaList").first().children();
            for (Element item : cinemaItems) {
                String dbName = item.getElementsByClass("middle-hd").select("a[href]").first().text();
                String address = item.getElementsByClass("limit-address").first().text();
                String tel = item.getElementsByClass("middle-p-list").get(1).text();
                BigDecimal rate = BigDecimal.valueOf(Float.parseFloat(item.getElementsByClass("right-score").select("strong").first().text()));
                tel = tel.substring(tel.indexOf("：") + 1);
                Cinema cinema = new Cinema();
                cinema.setDbName(dbName);
                cinema.setAddress(address);
                cinema.setTel(tel);
                cinema.setRate(rate);
                cinema.setAreaId(350104L);
                cinema.setCityId(350100L);
                cinema.setProvinceId(350000L);
                cinemas.add(cinema);
            }
        }

        return cinemas;
    }
}
