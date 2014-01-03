package com.daoleen.springlearning.mvc.domain;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
//import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by alex on 1/3/14.
 */

@Entity
@Table(name = "ARTICLE")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "name", length = 255)
    private String name;

    @NotNull
    @Size(min = 5, max = 4000)
    @Column(name = "description", length = 4000)
    private String description;

    //@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @Temporal(TemporalType.TIME)
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Size(max = 255)
    @Column(name = "logo", length = 255)
    private String logo;


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
//                ", created_at=" + created_at +
                ", logo='" + logo + '\'' +
                '}';
    }


    // Getters/Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
