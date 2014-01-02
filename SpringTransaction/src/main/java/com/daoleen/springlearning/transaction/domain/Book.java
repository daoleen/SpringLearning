package com.daoleen.springlearning.transaction.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "Book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Здесь используется поле version для optimistic concurrency
    // В данном случае version - int, т.е. просто номер версии, начиная с нуля
    // Можно также использовать Timestamp, однако это менее эффективно изза потоков,
    // которые возможно одновременно обновят запись
    @Version
    @Column(name = "version")
    private int version;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "pages_count")
    private int pagesCount;

    // @Temporal используется для преобразования java.util.Date в java.sql.Date и обратно
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", pagesCount=" + pagesCount +
                ", created_at=" + createdAt +
                ", version=" + version +
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
