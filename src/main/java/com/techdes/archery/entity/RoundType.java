package com.techdes.archery.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "round_type")
@Table(name = "round_type")
public class RoundType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "roundType", fetch = FetchType.LAZY)
    private List<Range> ranges;
    @OneToMany(mappedBy = "roundType", fetch = FetchType.LAZY)
    private List<ArcherRound> archerRounds;
}
