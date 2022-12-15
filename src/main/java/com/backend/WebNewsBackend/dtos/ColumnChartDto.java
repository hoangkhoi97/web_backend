package com.backend.WebNewsBackend.dtos;

public class ColumnChartDto {
    private String str_date = "";
    private Long NHK_news_quantity = 0L;
    private Long TBS_news_quantity = 0L;
    private Long NIKKEI_news_quantity = 0L;

    public Long getNHK_news_quantity() {
        return NHK_news_quantity;
    }

    public Long getNIKKEI_news_quantity() {
        return NIKKEI_news_quantity;
    }

    public Long getTBS_news_quantity() {
        return TBS_news_quantity;
    }

    public void setNHK_news_quantity(Long NHK_news_quantity) {
        this.NHK_news_quantity = NHK_news_quantity;
    }

    public void setNIKKEI_news_quantity(Long NIKKEI_news_quantity) {
        this.NIKKEI_news_quantity = NIKKEI_news_quantity;
    }

    public void setTBS_news_quantity(Long TBS_news_quantity) {
        this.TBS_news_quantity = TBS_news_quantity;
    }

    public String getStr_date() {
        return str_date;
    }

    public void setStr_date(String str_date) {
        this.str_date = str_date;
    }
}
