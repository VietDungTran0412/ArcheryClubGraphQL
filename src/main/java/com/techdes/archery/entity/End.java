package com.techdes.archery.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity(name = "end")
@Table(name = "end")
public class End {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "archer_round_id")
    private ArcherRound round;
    @Column(name = "score")
    private Integer score;

    public End(ArcherRound round, Integer score) {
        this.round = round;
        this.score = score;
    }

    public End() {

    }
}
