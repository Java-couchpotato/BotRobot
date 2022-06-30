package org.example;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyFirstBot extends TelegramLongPollingBot {
    SendMessage sendMessage = new SendMessage();
    List<String> list = Arrays.asList(
            "The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela",
            "The way to get started is to quit talking and begin doing. -Walt Disney",
            "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking. -Steve Jobs",
            "If life were predictable it would cease to be life, and be without flavor. -Eleanor Roosevelt",
            "If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough. -Oprah Winfrey",
            "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. -James Cameron",
            "Life is what happens when you're busy making other plans. -John Lennon"
    );

    public static String wordsChecker(List<String> list) {
        Random random = new Random();
        String str = "";

        int n = random.nextInt(list.size());
        str = list.get(n);
        return str;
    }

    @Override
    public String getBotUsername() {
        return "BotRobot";
    }

    @Override
    public String getBotToken() {
        return "5231792200:AAE76zJiMmjfG-lLJ-elCFwwTDshzO2WhXU";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            sendMessage.setChatId(update.getMessage().getChatId().toString());
            sendMessage.setText(wordsChecker(list));


            try {
                execute(sendMessage); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

}
