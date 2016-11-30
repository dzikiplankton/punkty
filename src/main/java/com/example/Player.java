package com.example;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * Created by zakp2 on 2016-11-29.
 */
@XmlRootElement
public class Player {

    public Player() {
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getSurname() {
        return surname;
    }

    @XmlElement
    public String getNick() {
        return nick;
    }

    @XmlElement
    public int getWin() {
        return win;
    }

    @XmlElement
    public int getLost() {
        return lost;
    }

    @XmlElement
    public int getWithdraw() {
        return withdraw;
    }


    private String name;
    private String surname;
    private String nick;
    private int win;
    private int lost;
    private int withdraw;



    public Player(String name, String surname, String nick, int win, int lost, int withdraw) {
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.win = win;
        this.lost = lost;
        this.withdraw = withdraw;
    }

    public void update(int win, int lost, int withdraw){
        this.win+=win;
        this.lost+=lost;
        this.withdraw+=withdraw;
    }


}
