package com.backend.WebNewsBackend.repositories;

import com.backend.WebNewsBackend.entites.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Long> {
    @Query(value = "SELECT * FROM news  " +
            "WHERE type = :type " +
            "ORDER BY date_time DESC "+
            " LIMIT 10 "
            , nativeQuery = true)
    List<NewsEntity> findTop10NewsByType(@Param("type") int type);

    @Query(value = "SELECT * FROM news  " +
            "WHERE web = :web" +
            " ORDER BY date_time DESC "+
            " LIMIT 10 "
            , nativeQuery = true)
    List<NewsEntity> findTop10NewsByWeb(@Param("web") String web);

    @Query(value = "SELECT count(*) FROM news  " +
            "WHERE type = :type" +
            " AND DATE (date_time) = DATE (:date) "
            , nativeQuery = true)
    Long countToDayNewsByType(@Param("type") int type, @Param("date") Date date);

    @Query(value = "SELECT count(*) FROM news  " +
            "WHERE web = :web" +
            " AND date_time >= :start_date " +
            "AND date_time < :end_date"
            , nativeQuery = true)
    Long countRangeNewsByWeb(@Param("web") String web, @Param("start_date") Date start_date, @Param("end_date") Date end_date);

    @Query(value = "SELECT web, date(date_time) as dateTime, count(*) as total " +
            "FROM news" +
            " WHERE DATE(date_time) >= DATE (:start_date) " +
            " AND DATE(date_time) < DATE (:end_date)  " +
            " group by DATE(date_time) , web " +
            " order by DATE(date_time) DESC"
            , nativeQuery = true)
    List<Object[]> listCountRangeNewsByWeb(@Param("start_date") Date start_date, @Param("end_date") Date end_date);

}
