package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;


/**
 * @desc 电影实体类
 * @author lushusheng
 * @date 2018-11-21
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
@Data
@NoArgsConstructor
public class Movie {

    @Id
    @GraphId
    private Long id;
    private String title;
    private String year;
    private String tagLine;

    @Relationship(type = "ACTS_IN", direction = Relationship.INCOMING)
    List<Role> roleList = new ArrayList<>();

    public Role add(Actor actor, String roleName) {
        Role role = new Role(actor, this, roleName);
        roleList.add(role);
        return role;
    }
}
