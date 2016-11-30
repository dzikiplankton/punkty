package com.example;

/**
 * Created by zakp2 on 2016-11-30.
 */
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Component
public class PlayerDAO {

    // Dummy database. Initialize with some dummy values.
    private static Map<String,Player> players;
    {
        players = new HashMap<String,Player>();
        String csvFile = "C:/Users/zakp2/git/punkty/src/main/resources/static/dane.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] playerData = line.split(cvsSplitBy);


                if (players.containsKey(playerData[2])) {
                    players.get(playerData[2]).update(
                                    Integer.parseInt(playerData[3]),
                                    Integer.parseInt(playerData[4]),
                                    Integer.parseInt(playerData[5])
                            );
                } else {
                    players.put(
                            playerData[2],
                            new Player(
                                    playerData[0],
                                    playerData[1],
                                    playerData[2],
                                    Integer.parseInt(playerData[3]),
                                    Integer.parseInt(playerData[4]),
                                    Integer.parseInt(playerData[5]))
                    );
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Object[] list() {
        return players.keySet().toArray();
    }


    public Player get(String id) {

        if(players.containsKey(id))
            return (Player) players.get(id);
        return null;
    }


    public Player create(Player player) {
        players.put(player.getNick(),player);
        return player;
    }


    public Long delete(String id) {

        players.remove(id);

        return null;
    }


    public Player update(String id, Player player) {

        players.remove(id);
        players.put(id,player);

        return null;
    }

}