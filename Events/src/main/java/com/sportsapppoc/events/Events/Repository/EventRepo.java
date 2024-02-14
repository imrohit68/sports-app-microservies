package com.sportsapppoc.events.Events.Repository;

import com.sportsapppoc.events.Events.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Events,Integer> {
}
