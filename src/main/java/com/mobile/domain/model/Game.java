package com.mobile.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
@javax.persistence.Table(name = "games")
public class Game implements Entity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "appid")
    private long appid;

    @Column(name = "name")
    private String name;

    @Column(name = "developer")
    private String developer;

    @Column(name = "positive")
    private long positive;

    @Column(name = "negative")
    private long negative;

    @Column(name = "owners")
    private String owners;

    @Column(name = "price")
    private float price;

    @Override
    public Long getId() {
        return id;
    }
}
