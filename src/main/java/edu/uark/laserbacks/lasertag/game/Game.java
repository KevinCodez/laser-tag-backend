package edu.uark.laserbacks.lasertag.game;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Game {
    @Id @GeneratedValue
    private Integer id;
    private LocalDateTime start_time;
    private Integer duration;
}

