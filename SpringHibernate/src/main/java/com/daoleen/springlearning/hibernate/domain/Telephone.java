package com.daoleen.springlearning.hibernate.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 12/31/13
 * Time: 2:56 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "Telephone")
public class Telephone {
    @Column(name = "author_id")
    private long authorId;

    @Id
    @Column(name = "tel")
    private String tel;


    // Определение связи "Многие-к-одному
    // В @JoinColumn свойстве name указываем имя поля-внешнего ключа
    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;



    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Telephone{" +
                "authorId=" + authorId +
                ", tel='" + tel + '\'' +
                ", author=" + author +
                '}';
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
