package com.controller;

import com.model.Member;
import com.model.Game;
import com.service.GameService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private GameService gameService;

    private static String titelNieuw = "Nieuw game";
    private static String titelWijzig = "Wijzig game";

    @RequestMapping(value = "/list")
    public ModelAndView ledenlijst() {
        ModelAndView gameListView = new ModelAndView("/game/gamelist");
        List<Game> games = gameService.getGames();
        gameListView.addObject("games", games);
        return gameListView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView gameAddPage() {
        ModelAndView gameAddView = new ModelAndView("notYetImplemented");
        gameAddView.addObject("paginaTitel", titelNieuw);
        gameAddView.addObject("game", new Game());
        return gameAddView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView gameAdd(@ModelAttribute Game game) {
        ModelAndView gameListView = new ModelAndView("notYetImplemented");
        gameService.addGame(game);
        List<Game> games = gameService.getGames();
        gameListView.addObject("games", games);
        String message = "Game was successfully added.";
        gameListView.addObject("message", message);
        return gameListView;
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable Integer id) {
        ModelAndView gameEditView = new ModelAndView("notYetImplemented");
        Game game=gameService.getGame(id);
        gameEditView.addObject("game",game );
        gameEditView.addObject("paginaTitel", titelWijzig);
        return gameEditView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("game") Game game) {
        ModelAndView gamelistView = new ModelAndView("notYetImplemented");
        gameService.updateGame(game);
        List<Game> games = gameService.getGames();
        gamelistView.addObject("games", games);
        String message = "Game was successfully edited.";
        gamelistView.addObject("message", message);
        return gamelistView;
    }

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteGame(@PathVariable Integer id) {
//        ModelAndView modelAndView = new ModelAndView("/game/list");
//        gameService.deleteGame(id);
//        List<Game> games = gameService.getGames();
//        modelAndView.addObject("games", games);
//        String message = "Game was successfully deleted.";
//        modelAndView.addObject("message", message);
//        return modelAndView;
//    }
    
   
}
