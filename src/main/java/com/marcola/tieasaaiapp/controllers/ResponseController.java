package com.marcola.tieasaaiapp.controllers;

import com.marcola.tieasaaiapp.model.Fase;
import com.marcola.tieasaaiapp.model.Resposta;
import com.marcola.tieasaaiapp.model.SessionFase;
import com.marcola.tieasaaiapp.repos.FaseRepository;
import com.marcola.tieasaaiapp.repos.SessionfaseRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ResponseController {
    @Autowired
    FaseRepository fr;
    @Autowired
    SessionfaseRepository sfr;

    @GetMapping("/response")
        public String response(@RequestParam(name = "resposta") String resposta,
                                 @RequestParam(name = "fase") String fase,
                                 HttpSession session){
            Optional<Fase> faseOp = fr.findById(fase);
            if(faseOp.isPresent()){
                if(faseOp.get().getResposta().equals(resposta)){
                    Optional<SessionFase> sfOp = sfr.findById(session.getId());
                    if(sfOp.isPresent()) {
                        SessionFase sf = sfOp.get();
                        sf.setFase(sf.getFase() + 1);
                        System.out.println("Resposta certa!!");
                        sfr.save(sf);
                        return "redirect:/";
                    }
                    System.out.println("Pegou a fase e resposta certa");
                }
                else{
                    System.out.println("Pegou a fase e resposta errada");
                    return "redirect:/";
                }
                System.out.println("Pegou a fase");
            }
        System.out.println("Não pegou a fase");
                return "redirect:/";
        }
}
