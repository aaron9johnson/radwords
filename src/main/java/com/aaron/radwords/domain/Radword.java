package com.aaron.radwords.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
@Entity
@Table(name = "word")
public class Radword extends AbstractAuditingEntity {
    @Id
    @Column(name = "id")
    private String word;

    @Column(name = "count")
    private Integer count;

    @Column(name = "created")
    private Instant created;

    @Column(name = "last_modified")
    private Instant lastModified;

    public Radword() {
        super();
        this.setCreatedBy("RADWORDS");
    }

    public Radword(String word, Integer count, Instant created, Instant lastModified){
        super();
        this.setCreatedBy("RADWORDS");
        this.count = count;
        this.word = word;
        this.created = created;
        this.lastModified = lastModified;
    }
    public void addOneCount() {
        this.count += 1;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }
}
