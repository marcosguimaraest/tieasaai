package com.marcola.tieasaaiapp.controllers;

import com.marcola.tieasaaiapp.model.SessionFase;
import com.marcola.tieasaaiapp.repos.SessionfaseRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    SessionfaseRepository sfr;

    @GetMapping("/")
    public String index(HttpSession session){
        Optional<SessionFase> sf = sfr.findById(session.getId());

       // SessionFase sf = new SessionFase("" + session.getId(), 0);
        //sfr.save(sf);
        if(sf.isPresent()) {
            return "" + session.getId();
        }
        return ":(" + session.getId();
    }
}

