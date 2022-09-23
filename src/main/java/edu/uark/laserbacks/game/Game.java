package edu.uark.laserbacks.game;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

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

