package com.marcola.tieasaaiapp.controllers;

import com.marcola.tieasaaiapp.model.Fase;
import com.marcola.tieasaaiapp.model.SessionFase;
import com.marcola.tieasaaiapp.repos.FaseRepository;
import com.marcola.tieasaaiapp.repos.SessionfaseRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    SessionfaseRepository sfr;

    @Autowired
    FaseRepository fr;


    @GetMapping("/")
    public String index(HttpSession session){
        Optional<SessionFase> sfOp = sfr.findById(session.getId());
        if(sfOp.isEmpty()) {
            SessionFase newSessionFase = new SessionFase(session.getId(), 1);
            sfr.save(newSessionFase);
            return "fase1.html";
        }

        if(sfOp.get().getFase() == 4){
            return "fasesecreta.html";
        }

        return "fase" + sfOp.get().getFase() + ".html";
    }

    public void iniciarBanco(){
        Fase fase1 = new Fase("1", "A cruel angel thesis");
        Fase fase2 = new Fase("2", "will soon take flight through the window.");
        Fase fase3 = new Fase("3", "EL PSY CONGROO");
        fr.save(fase1);
        fr.save(fase2);
        fr.save(fase3);
    }
    @GetMapping("ITWASHEREALLALONG")
    public String itwashere(){
        return "ITWASHEREALLALONG.html";
    }
}

