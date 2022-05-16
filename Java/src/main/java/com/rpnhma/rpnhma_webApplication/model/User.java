package com.rpnhma.rpnhma_webApplication.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
public class User {


    @Id
    @Column(nullable = false)
    @GeneratedValue
    private String Id;

    @Column(name = "username")
    private String userName;

    @OneToMany(mappedBy = "user")
    private List<Topic> topics;

    @OneToMany(mappedBy = "user")
    private List<Answer> answers;


}
