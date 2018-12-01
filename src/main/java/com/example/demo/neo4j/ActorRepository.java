package com.example.demo.neo4j;


import com.example.demo.entity.Actor;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long> {
    Actor findByName(@Param("name") String name);
}
