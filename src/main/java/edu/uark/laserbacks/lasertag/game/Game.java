package edu.uark.laserbacks.lasertag.game;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Game {
    @Id @GeneratedValue
    private Integer id;
    private LocalDateTime start_time;
    private Integer duration;
    @OneToMany
    private Set<Team> teams;
}

