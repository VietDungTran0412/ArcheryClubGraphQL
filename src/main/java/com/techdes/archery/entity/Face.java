package com.techdes.archery.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "face")
@Table(name = "face")
public class Face {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "target")
    private Integer target;
    @OneToMany(mappedBy = "face")
    private Set<Range> ranges;
}
