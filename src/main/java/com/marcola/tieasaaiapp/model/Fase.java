package com.marcola.tieasaaiapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@RedisHash("fase")
public class Fase {
    @Id private String id;
    private String resposta;
}
