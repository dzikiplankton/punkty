package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PlayerRestController {

    @Autowired
    private PlayerDAO playerDAO;

    @GetMapping("/players")
    public Object[] getPlayers(){
        return playerDAO.list();
    }

    @GetMapping(value = "/players/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPlayer(@PathVariable("id") String id) {

        Player player = playerDAO.get(id);
        if (player == null) {
            return new ResponseEntity("No Player found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(player, HttpStatus.OK);
    }

    @GetMapping(value = "/players-xml/{id}" , produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getPlayerXml(@PathVariable("id") String id) {

        Player player = playerDAO.get(id);
        if (player == null) {
            return new ResponseEntity("No Player found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(player, HttpStatus.OK);
    }


}
