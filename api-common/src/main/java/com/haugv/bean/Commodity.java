package com.haugv.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commodity {

    private int id;
    private String name;
    private String type;
    private String brand;
    private String model;
    private BigDecimal price;
    private double discount;
    private int stock;
    private String description;
    private Timestamp createTime;
    private Timestamp updateTime;

}
