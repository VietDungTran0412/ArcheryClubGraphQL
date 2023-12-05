package com.techdes.archery.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "category_equipment",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    @OneToMany(mappedBy = "equipment",fetch = FetchType.LAZY)
    private List<ArcherRound> archerRounds;
}
