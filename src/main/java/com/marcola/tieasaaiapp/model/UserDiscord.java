package com.marcola.tieasaaiapp.model;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@RedisHash("user-discord")
public class UserDiscord {
    @Id
    public String Id;
    public String discordUser;
}
