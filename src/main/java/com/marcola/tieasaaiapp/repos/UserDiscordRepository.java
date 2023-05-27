package com.marcola.tieasaaiapp.repos;

import com.marcola.tieasaaiapp.model.UserDiscord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDiscordRepository extends CrudRepository<UserDiscord, String> {

}
