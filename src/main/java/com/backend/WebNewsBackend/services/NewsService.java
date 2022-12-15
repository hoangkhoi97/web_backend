package com.backend.WebNewsBackend.services;

import com.backend.WebNewsBackend.dtos.ColumnChartDto;
import com.backend.WebNewsBackend.entites.NewsEntity;
import com.backend.WebNewsBackend.repositories.NewsRepository;
import com.backend.WebNewsBackend.constant.Common;
import com.backend.WebNewsBackend.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.text.ParseException;
import java.util.*;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<NewsEntity> getNews(){
        return newsRepository.findAll();
    }

    // LEFT-HAND WEB
    // 左手WEB
    public List<NewsEntity> getTop10NewsByType(int type){
        return newsRepository.findTop10NewsByType(type);
    }

    public List<NewsEntity> getTop10NewsByWeb(String web){
        return newsRepository.findTop10NewsByWeb(web);
    }

    // RIGHT-HAND WEB
    // 右手WEB

    // Pie chart
    // 円グラフ
    public Long countToDayNewsByType(Date currentDate, int type){
        return newsRepository.countToDayNewsByType(type, currentDate);
    }

    // Column chart
    // 欄グラフ
    public List<ColumnChartDto> getColumnChartData(Date currentDate) {
        //欄グラフのリストデータを定義
        List<ColumnChartDto> chartDtoList = new ArrayList<>();

        Date endDate = DateUtil.addDays(currentDate,1); //現在　+　１日
        Date starDate = DateUtil.addDays(currentDate,-6); //現在　-　6日

        Date curDate = currentDate; //現在
        Date limitDate = DateUtil.addDays(currentDate,-7); //現在　-　7日
        //オブジェクトリスト取得
        //オブジェクトリスト構造： object[0]:ニュースウェブ名　 ;  object[1]:日付  ;  object[2]:日中のニュース件数
        List<Object[]> objList = newsRepository.listCountRangeNewsByWeb(starDate,endDate);

        //欄グラフのオブジェクトを定義
        ColumnChartDto dto = new ColumnChartDto();
        for(Object[] o : objList){
            //curDateの日付　==　object[1]の日付
            if(Objects.equals(DateUtil.getStrDate(curDate), o[1].toString())){
                this.setQuantityColumnChart(dto, o[0].toString(), o[2].toString());
            }

            //curDateの日付　!＝　object[1]の日付
            else{
                dto.setStr_date(DateUtil.convertDateToStringJP(curDate)); //DB日付 -> 画面表示日付 (フォーマット:_月_日)
                chartDtoList.add(dto); //欄グラフのリストデータに追加

                dto = new ColumnChartDto(); //欄グラフのオブジェクトを再び定義
                curDate =DateUtil.addDays(curDate,-1); //curDateの日付　- 1

                //curDateの日付　！=　limitDateの日付
                if(!Objects.equals(DateUtil.getStrDate(curDate), DateUtil.getStrDate(limitDate)))
                    this.setQuantityColumnChart(dto, o[0].toString(), o[2].toString());
            }
        }

        // 最後のアイテムの場合 (elseのステップに入らないので, ここで欄グラフのリストデータに追加)
        dto.setStr_date(DateUtil.convertDateToStringJP(curDate));
        chartDtoList.add(dto);

        // リスト逆
        Collections.reverse(chartDtoList);

        return chartDtoList;
    }

    //ウェブによって、ニュース件数をセット
    private void setQuantityColumnChart(ColumnChartDto dto, String web, String total ){
        switch (web){
            case "NHK":
                dto.setNHK_news_quantity(Long.parseLong(total));
                break;
            case "TBS":
                dto.setTBS_news_quantity(Long.parseLong(total));
                break;
            case "NIKKEI":
                dto.setNIKKEI_news_quantity(Long.parseLong(total));
                break;
        }

    }
}
