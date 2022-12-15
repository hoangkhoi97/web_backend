package com.backend.WebNewsBackend.controllers;

import com.backend.WebNewsBackend.constant.Common;
import com.backend.WebNewsBackend.entites.NewsEntity;
import com.backend.WebNewsBackend.response.NewsResponse;
import com.backend.WebNewsBackend.services.NewsService;
import com.backend.WebNewsBackend.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class NewsController {
    @Autowired
    private NewsService newsService;

// @GetMapping("dashboard/GET")
   @RequestMapping(value = "/dashboard/get", method = RequestMethod.GET)
   @ResponseBody
    public ResponseEntity<?> findAllNews()  {
        NewsResponse newsResponse = new NewsResponse();

        newsResponse.setTop10NewsLife(newsService.getTop10NewsByType(Common.typeLife));
        newsResponse.setTop10NewsInternational(newsService.getTop10NewsByType(Common.typeInternational));
        newsResponse.setTop10NewsSport(newsService.getTop10NewsByType(Common.typeSport));
        newsResponse.setTop10NewsOther(newsService.getTop10NewsByType(Common.typeOther));

        newsResponse.setTop10NewsNHK(newsService.getTop10NewsByWeb(Common.webNHK));
        newsResponse.setTop10NewsTBS(newsService.getTop10NewsByWeb(Common.webTBS));
        newsResponse.setTop10NewsNIKKEI(newsService.getTop10NewsByWeb(Common.webNIKKEI));

        newsResponse.setCountTodayNewsLife(newsService.countToDayNewsByType(DateUtil.now(), Common.typeLife));
        newsResponse.setCountTodayNewsInternational(newsService.countToDayNewsByType(DateUtil.now(),Common.typeInternational));
        newsResponse.setCountTodayNewsSport(newsService.countToDayNewsByType(DateUtil.now(),Common.typeSport));
        newsResponse.setCountTodayNewsOther(newsService.countToDayNewsByType(DateUtil.now(),Common.typeOther));

        newsResponse.setColumnChartDtos(newsService.getColumnChartData(DateUtil.now()));
        return new ResponseEntity<>(newsResponse, HttpStatus.OK);
    }
}
