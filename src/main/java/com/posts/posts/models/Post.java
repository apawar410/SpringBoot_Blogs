package com.posts.posts.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table (name = "posts")
@Getter
@Setter

public class Post extends AuditModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column (unique = true)
    private String title;

    @javax.validation.constraints.NotNull
    @Size (max = 200)
    private String description;

    @Lob
    @javax.validation.constraints.NotNull
    private String content;

}
