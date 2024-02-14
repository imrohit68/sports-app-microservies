package com.sportsapppoc.users.users.Respository;

import com.sportsapppoc.users.users.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilesRepo extends JpaRepository<Profile,String> {
}
