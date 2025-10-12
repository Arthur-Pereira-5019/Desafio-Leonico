package com.art5019.desafio_leonico.entities.dtos;

public record CreateMatchRequest(String password, int questions, String[] allowedThemes) {
}
