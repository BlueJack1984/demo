package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;



/**
 * @desc 演员类
 * @author lushusheng
 * @date 2018-11-23
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
@Data
@NoArgsConstructor
public class Actor {
    @Id
    @GraphId
    private Long id;
    private String name;
    private int born;
}
