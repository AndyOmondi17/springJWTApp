package com.andy.springapp.repo;


import com.andy.springapp.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmRepo extends JpaRepository<Film,Integer> {

    @Query("SELECT f FROM Film f inner join f.categories d where d.name=?1")
    public List<Film> findByCategoryName(String category);

    @Query("SELECT f FROM Film f inner join f.actors a where a.firstName=?1 OR a.lastName=?2")
    public List<Film> findByActor(String fName,String lName);

//    @Query(value = "SELECT film.title, category.name FROM ((film_category INNER JOIN film ON film_category.films_id = film.id)INNER JOIN category ON film_category.categories_id1 = category.id1)where film.title=:firstName",nativeQuery = true)
//    public List<Film> findByCategoryName(@Param("firstName")String category);

//    @Query("SELECT u FROM Staff u WHERE u.email=?1  OR u.username=?2") public  Optional <Staff> findByUsernameOrEmail(String username, String email);

}
