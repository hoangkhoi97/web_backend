package com.backend.WebNewsBackend.response;

import com.backend.WebNewsBackend.dtos.ColumnChartDto;
import com.backend.WebNewsBackend.entites.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class NewsResponse {

    private List<NewsEntity> top10NewsLife = new ArrayList<>();
    private List<NewsEntity> top10NewsInternational = new ArrayList<>();
    private List<NewsEntity> top10NewsSport = new ArrayList<>();
    private List<NewsEntity> top10NewsOther = new ArrayList<>();
    private List<NewsEntity> top10NewsNHK = new ArrayList<>();
    private List<NewsEntity> top10NewsTBS = new ArrayList<>();
    private List<NewsEntity> top10NewsNIKKEI = new ArrayList<>();

    private Long countTodayNewsLife = 0L;
    private Long countTodayNewsInternational = 0L;
    private Long countTodayNewsSport = 0L;
    private Long countTodayNewsOther = 0L;
    private Long countTodayNewsTotal = 0L;

    private List<ColumnChartDto> columnChartDtos = new ArrayList<>();

    public List<ColumnChartDto> getColumnChartDtos() {
        return columnChartDtos;
    }

    public void setColumnChartDtos(List<ColumnChartDto> columnChartDtos) {
        this.columnChartDtos = columnChartDtos;
    }

    public Long getCountTodayNewsInternational() {
        return countTodayNewsInternational;
    }

    public Long getCountTodayNewsLife() {
        return countTodayNewsLife;
    }

    public Long getCountTodayNewsOther() {
        return countTodayNewsOther;
    }

    public Long getCountTodayNewsSport() {
        return countTodayNewsSport;
    }

    public List<NewsEntity> getTop10NewsInternational() {
        return top10NewsInternational;
    }

    public List<NewsEntity> getTop10NewsLife() {
        return top10NewsLife;
    }

    public List<NewsEntity> getTop10NewsNHK() {
        return top10NewsNHK;
    }

    public List<NewsEntity> getTop10NewsNIKKEI() {
        return top10NewsNIKKEI;
    }

    public List<NewsEntity> getTop10NewsOther() {
        return top10NewsOther;
    }

    public List<NewsEntity> getTop10NewsSport() {
        return top10NewsSport;
    }

    public List<NewsEntity> getTop10NewsTBS() {
        return top10NewsTBS;
    }

    public Long getCountTodayNewsTotal() {
        return countTodayNewsTotal;
    }

    public void setCountTodayNewsInternational(Long countTodayNewsInternational) {
        this.countTodayNewsInternational = countTodayNewsInternational;
    }

    public void setCountTodayNewsLife(Long countTodayNewsLife) {
        this.countTodayNewsLife = countTodayNewsLife;
    }

    public void setCountTodayNewsOther(Long countTodayNewsOther) {
        this.countTodayNewsOther = countTodayNewsOther;
    }

    public void setCountTodayNewsSport(Long countTodayNewsSport) {
        this.countTodayNewsSport = countTodayNewsSport;
    }

    public void setCountTodayNewsTotal(Long countLife, Long countInternational, Long countSport, Long countOther ) {
        this.countTodayNewsTotal = countLife + countInternational + countSport + countOther;
    }

    public void setTop10NewsInternational(List<NewsEntity> top10NewsInternational) {
        this.top10NewsInternational = top10NewsInternational;
    }

    public void setTop10NewsLife(List<NewsEntity> top10NewsLife) {
        this.top10NewsLife = top10NewsLife;
    }

    public void setTop10NewsNHK(List<NewsEntity> top10NewsNHK) {
        this.top10NewsNHK = top10NewsNHK;
    }

    public void setTop10NewsNIKKEI(List<NewsEntity> top10NewsNIKKEI) {
        this.top10NewsNIKKEI = top10NewsNIKKEI;
    }

    public void setTop10NewsOther(List<NewsEntity> top10NewsOther) {
        this.top10NewsOther = top10NewsOther;
    }

    public void setTop10NewsSport(List<NewsEntity> top10NewsSport) {
        this.top10NewsSport = top10NewsSport;
    }

    public void setTop10NewsTBS(List<NewsEntity> top10NewsTBS) {
        this.top10NewsTBS = top10NewsTBS;
    }
}
