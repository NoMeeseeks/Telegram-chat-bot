package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "ChatBotBootCamp_bot";
    public static final String TOKEN = "7066479450:AAF2_-GV90nUXW96QGGqEm7OgXhGfLgiY_s";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        //este metodo reacciona cuando interactua con el bot
        //escribiremos la funcionalidad principal del bot aquí

        //vamos agregar un metodo para obtener una respuesta
        //equals es para comparar textos
         if(getMessageText().equals("/start")) {
             //con el underscore podemos hacer el texto en cursiva
             //con el simbolo de multiplicar podemos hacer negritas
             sendTextMessageAsync("Holaaaaaaaaaaaaaaa, \n _futuro_ *programador* Xavier!!!");
         }

        // con contais podemos verificar si el mensaje tiene la palabra hola
        if(getMessageText().contains("hola") || getMessageText().contains("Hola")) {
            sendTextMessageAsync("Hola, Cual es tu nombre ?");
        }

        if(getMessageText().contains("me llamo") || getMessageText().contains("mi nombre")) {
            sendTextMessageAsync("Es un placer, soy *Gato*");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        //puerta de entrada de nuestro programa
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}