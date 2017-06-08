/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Game {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	private int clubnight;
	
	@ManyToOne
	private Team teamA;
	@ManyToOne
	private Team teamB;
	@ManyToOne
	private Team winner;
	
	public Game(){
		super();
	}

	public Game( int clubnight, Team teamA, Team teamB, Team winner) {
		super();
		this.id = 0;
		this.clubnight = clubnight;
		this.teamA = teamA;
		this.teamB = teamB;
		this.winner = winner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClubnight() {
		return clubnight;
	}

	public void setClubnight(int clubnight) {
		this.clubnight = clubnight;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

}

