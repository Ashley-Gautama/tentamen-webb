/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Game;

@Repository
public class GameDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    private String hql;
    private Query query;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addGame(Game game) {
        getCurrentSession().save(game);
    }

    public void updateGame(Game game) {
        Game gameToUpdate = getGame(game.getId());
//        gameToUpdate.setName(game.getName());
//        gameToUpdate.setCoach(game.getCoach());
        getCurrentSession().update(gameToUpdate);
    }

    public Game getGame(int id) {
        hql = "from Game t where t.id= :id";
        query = getCurrentSession().createQuery(hql);
        query.setParameter("id", id);
        Game game = (Game) query.list().get(0);
        return game;
    }

//    public void deleteGame(int id) {
//        Game game = getGame(id);
//        if (game != null) {
//            getCurrentSession().delete(game);
//        }
//    }

    @SuppressWarnings("unchecked")
    public List<Game> getGames() {
        hql = "from Game";
        query = getCurrentSession().createQuery(hql);
        return (List<Game>) query.list();
    }

    public void storeAllGames(List<Game> games) {
        for (Game game : games) {
            getCurrentSession().save(game);
        }
    }
}
