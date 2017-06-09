package com.pelucco.telegram.samplebot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.User;
import ru.skuptsov.telegram.bot.platform.client.TelegramBotApi;
import ru.skuptsov.telegram.bot.platform.client.command.Reply;
import ru.skuptsov.telegram.bot.platform.config.BotPlatformStarter;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageHandler;
import ru.skuptsov.telegram.bot.platform.handler.annotation.MessageMapping;
import ru.skuptsov.telegram.bot.platform.model.UpdateEvent;

import static ru.skuptsov.telegram.bot.platform.client.command.ReplyTo.to;

/**
 * @author Sergey Kuptsov
 * @since 30/08/2016
 */
@MessageHandler
public class ExampleCallApi {

    @Autowired
    private TelegramBotApi api;

    public static void main(String[] args) {
        BotPlatformStarter.start(ExampleCallApi.class, "351282811:AAFKesahgYryA8pMPTOOVqhwQCHue6lly48");
    }

    @MessageMapping(text = "/me")
    public Reply getMe(UpdateEvent updateEvent) {
        User me = api.getMe().get();

        Message reply = api.reply(to(updateEvent).withMessage(getMessageText(me))).get();

        return to(updateEvent).withMessage("Yes, that is me above!!!");
    }

    private String getMessageText(User me) {
        return "Me is : " + me.getFirstName() + " " + me.getLastName();
    }
}