package com.techdes.archery.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "distance")
@Table(name = "distance")
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "length")
    private Integer length;
    @OneToMany(mappedBy = "distance")
    private Set<Range> ranges;
}
