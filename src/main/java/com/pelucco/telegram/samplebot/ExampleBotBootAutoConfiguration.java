package com.pelucco.telegram.samplebot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import ru.skuptsov.telegram.bot.platform.client.TelegramBotApi;
import ru.skuptsov.telegram.bot.platform.client.command.Reply;
import ru.skuptsov.telegram.bot.platform.client.command.ReplyTo;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageHandler;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageMapping;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;

@EnableAutoConfiguration
@MessageHandler
public class ExampleBotBootAutoConfiguration {

	@Autowired
    private TelegramBotApi api;
	
    public static void main(String[] args) {
        SpringApplication.run(ExampleBotBootAutoConfiguration.class);
    }

    @MessageMapping(text = "hi")
    public Reply sayGoodMorning(UpdateEvent updateEvent) {
        return ReplyTo.to(updateEvent).withMessage("Good morning! Happy to see you!");
    }
    
    
    @MessageMapping(regexp = "/.*")
    public Reply replyToCommand(UpdateEvent updateEvent) {
        return ReplyTo.to(updateEvent).withMessage(updateEvent.getUpdate().getMessage().getText() + " is not implemented yet. Be patient Darling..");
    }
    
}