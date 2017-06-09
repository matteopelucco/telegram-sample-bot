package com.pelucco.telegram.samplebot;

import ru.skuptsov.telegram.bot.platform.client.command.Reply;
import ru.skuptsov.telegram.bot.platform.client.command.ReplyTo;
import ru.skuptsov.telegram.bot.platform.config.BotPlatformStarter;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageHandler;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageMapping;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;

@MessageHandler
public class ExampleBotStarter {

    public static void main(String[] args) {
        BotPlatformStarter.start(ExampleBotStarter.class, "351282811:AAFKesahgYryA8pMPTOOVqhwQCHue6lly48");
    }

    @MessageMapping(text = "hi")
    public Reply sayGoodMorning(UpdateEvent updateEvent) {
        return ReplyTo.to(updateEvent).withMessage("Good morning! Happy to see you!");
    }
}