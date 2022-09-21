package edu.uark.laserbacks.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HitsRepository extends JpaRepository<Hits, Integer> {

}
