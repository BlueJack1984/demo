package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

/**
 * @desc 演员和电影之间的角色实体
 * @author lushusheng
 * @date 2018-11-23
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type = "ACTS_IN")
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GraphId
    private Long id;
    private String roleName;
    @StartNode
    private Actor actor;
    @EndNode
    private Movie movie;

    public Role(Actor actor, Movie movie, String roleName) {
        this.actor = actor;
        this.movie = movie;
        this.roleName = roleName;
    }
}
