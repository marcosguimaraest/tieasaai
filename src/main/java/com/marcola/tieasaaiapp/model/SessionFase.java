package com.marcola.tieasaaiapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@RedisHash("session-fase")
public class SessionFase {
    @Id private String session;
    private int fase;
}

