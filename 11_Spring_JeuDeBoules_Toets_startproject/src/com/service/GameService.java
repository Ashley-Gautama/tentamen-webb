/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.GameDAO;
import com.model.Game;

@Service
@Transactional
public class GameService {

	@Autowired
	private GameDAO gameDAO;

	public void addGame(Game game) {
		gameDAO.addGame(game);
	}

	public void updateGame(Game game) {
		gameDAO.updateGame(game);
	}

	public Game getGame(int id) {
		return gameDAO.getGame(id);
	}

//	public void deleteGame(int id) {
//		gameDAO.deleteGame(id);
//	}

	public List<Game> getGames() {
		return gameDAO.getGames();
	}

	public void storeAllGames(List<Game> games) {
		gameDAO.storeAllGames(games);
	}
}
