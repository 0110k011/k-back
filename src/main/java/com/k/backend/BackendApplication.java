package com.k.backend;

import com.google.gson.Gson;
import com.kb0t.api.telegram.TelegramConnectionService;
import com.kb0t.api.telegram.request.GetUpdatesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@SpringBootApplication
public class BackendApplication {
	@Autowired(required = false)
	private TelegramConnectionService telegramConnectionService;
	private GetUpdatesRequest getUpdatesRequest;
	private static String token = "dfjdsjfhksjdf";

	@RequestMapping("/")
	public Object test() {


		try {
			//TelegramConnectionService telegramConnectionService = new TelegramConnectionService();
			GetUpdatesRequest getUpdatesRequest = new GetUpdatesRequest();
			//return telegramConnectionService.connectToAPI(new String(token), "");
			Gson gson = new Gson();
			String test = getUpdatesRequest.getUpdates(token);
			Info obj = gson.fromJson(test, Info.class);

			String userJson = obj.getOk().toString();
			User[] userArray = gson.fromJson(userJson, User[].class);
			//for(User user : userArray) {
			//	System.out.println(user);
			//}

			return gson.toJson(obj.getOk());
			//return getUpdatesRequest.getUpdates(token);
			//Informacoes obj = gson.fromJson(getUpdatesRequest.getUpdates(token), Informacoes.class);
			//return obj;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public class Info{
		private String ok;
		private Object result;

		public Object getOk() {
			return this.result;
		}

	}

	public class User
	{
		private Object message;
		private Float update_id;

		// Getters and Setters
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
