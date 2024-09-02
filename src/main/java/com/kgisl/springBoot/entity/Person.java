package com.kgisl.springBoot.entity;

import org.springframework.data.annotation.Id;

public record Person( @Id Long id, String uname, String email) {
}
