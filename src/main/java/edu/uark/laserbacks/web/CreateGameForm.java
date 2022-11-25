package edu.uark.laserbacks.web;

import lombok.Data;

import java.util.List;

@Data
public class CreateGameForm {
    List<Integer> team1;
    List<Integer> team2;
}
