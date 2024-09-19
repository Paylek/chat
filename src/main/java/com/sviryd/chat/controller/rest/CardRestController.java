package com.sviryd.chat.controller.rest;

import com.sviryd.chat.domain.Message;
import com.sviryd.chat.domain.User;
import com.sviryd.chat.dto.CardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/method")

public class CardRestController {

    @GetMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Object, Object> pasha() {
        return null;
    }

    @PostMapping(value = "/post")
    public CardDTO misha(
            @AuthenticationPrincipal User user,
            HttpServletResponse response,
            HttpServletRequest request,
            HttpSession session,
            @RequestBody String text) {
        Map<Object, Object> map = new HashMap<>();
        map.put("search", text);

//        if (user == null) {
//            user = userService.findByUsername(principal.getName());
//        }
        Message message = new Message();
        message.setText(text);
        message.setAuthorId(user.getId());
        return CardDTO.toDTO(message);
    }

    @GetMapping(value = "/request/{id}/{name}/{color}")
    public int pathVariable(
            @PathVariable int id,
            @PathVariable String name,
            @PathVariable String color
    ) {
        return id;
    }
}
