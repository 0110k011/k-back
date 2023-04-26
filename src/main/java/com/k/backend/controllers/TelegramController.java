package com.k.backend.controllers;

import com.k.backend.Configs;
import com.kb0t.api.telegram.response.SendMessageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class TelegramController {
  private static String token = Configs.getToken();

  @RequestMapping("/send-message")
  public String sendMessage(@RequestParam Map<String,String> params) {

    try {
      SendMessageResponse sendMessageResponse = new SendMessageResponse();
      sendMessageResponse.sendMessage(token, params.get("chatId"), params.get("text"));
      return "enviado.";

    } catch (Exception e) {
      return e.getMessage();
    }
  }

}
