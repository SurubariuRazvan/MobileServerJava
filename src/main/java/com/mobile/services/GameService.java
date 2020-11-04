package com.mobile.services;

import com.mobile.domain.model.Game;

import java.util.List;

public interface GameService {
    List<Game> getGames();

    Game getGameById(Long id);

    Game addGame(Game game);

    Game updateGame(Game game);

    void deleteGame(Long id);
}
