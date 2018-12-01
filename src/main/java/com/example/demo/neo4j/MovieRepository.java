package com.example.demo.neo4j;

import com.example.demo.entity.Movie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.neo4j.repository.Neo4jRepository;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    Movie findByTitle(@Param("title") String title);
}
