package com.marcola.tieasaaiapp.controllers;

import com.marcola.tieasaaiapp.model.Fase;
import com.marcola.tieasaaiapp.model.Resposta;
import com.marcola.tieasaaiapp.model.SessionFase;
import com.marcola.tieasaaiapp.model.UserDiscord;
import com.marcola.tieasaaiapp.repos.FaseRepository;
import com.marcola.tieasaaiapp.repos.SessionfaseRepository;
import com.marcola.tieasaaiapp.repos.UserDiscordRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Controller
public class ResponseController {
    @Autowired
    FaseRepository fr;
    @Autowired
    SessionfaseRepository sfr;

    @Autowired
    UserDiscordRepository udr;

    @GetMapping("/response")
        public String response(@RequestParam(name = "resposta") String resposta,
                                 @RequestParam(name = "fase") String fase,
                                 HttpSession session){
            LocalDateTime ldt = LocalDateTime.now();
            Optional<Fase> faseOp = fr.findById(fase);
            if(faseOp.isPresent()){
                if(faseOp.get().getResposta().equals(resposta)){
                    Optional<SessionFase> sfOp = sfr.findById(session.getId());
                    if(sfOp.isPresent()) {
                        SessionFase sf = sfOp.get();
                        sf.setFase(sf.getFase() + 1);
                        System.out.println("Resposta certa - Fase: " + fase
                                            + " - SESSIONID: "  + session.getId()
                                            + " - Resposta: " + resposta
                                            + " - Tempo:" + ldt);
                        sfr.save(sf);
                        return "redirect:/";
                    }
                    System.out.println("Algo deu errado quando o sistema verificou se a sessão estava presente no banco, alerta!!!" + " - Tempo: " + ldt);
                }
                else{
                    System.out.println("Resposta errada - Fase: " + fase
                            + " - SESSIONID: "  + session.getId()
                            + " - Resposta: " + resposta
                            + " - Tempo: " + ldt);
                    return "redirect:/";
                }
                System.out.println("Algo deu errado quando o usuário tentou enviar a resposta, tentou enviar uma resposta com fase inexistente." +
                        " Fase solicitada: " + fase + " - Tempo: " + ldt);
            }
                System.out.println("Algo deu errado quando o usuário tentou enviar a resposta, tentou enviar uma resposta com fase inexistente." +
                        " Fase solicitada: " + fase + " - Tempo: " + ldt);
                return "redirect:/";
        }

        @PostMapping("/response")
        public String postUserDiscord(@RequestParam(name = "userDiscord") String userDiscord,
                                        HttpSession session){
            UserDiscord ud = new UserDiscord(session.getId(), userDiscord);
            udr.save(ud);
            System.out.println("Usuário discord salvo no banco, nome: " + userDiscord);
            return "redirect:/";
        }
}
