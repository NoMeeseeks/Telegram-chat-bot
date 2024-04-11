package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "ChatBotBootCamp_bot";
    public static final String TOKEN = "";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        setUserGlory(0);
        //este metodo reacciona cuando interactua con el bot
        //escribiremos la funcionalidad principal del bot aquí

        //vamos agregar un metodo para obtener una respuesta
        //equals es para comparar textos
         if(getMessageText().equals("/start")) {
             //con el underscore podemos hacer el texto en cursiva
             //con el simbolo de multiplicar podemos hacer negritas
             //sendTextMessageAsync("Hola, Cual es tu nombre ?");
             sendPhotoMessageAsync("step_1_pic");
             sendTextMessageAsync(STEP_1_TEXT,
                     Map.of("Hackea la nevera","step_one_btn",
                             "No quiero hackearla","step_cancel_btn"));
             //map es un tipo de objeto que guarda informacion tipo llave valor
         }
        if(getCallbackQueryButtonKey().equals("step_cancel_btn")){
            sendTextMessageAsync("Para volver a jugar escribe /start");
        }


        if(getCallbackQueryButtonKey().equals("step_one_btn")){
setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
sendTextMessageAsync(STEP_2_TEXT,
        Map.of("Tomar una salchicha! + 20 de fama","step_two_btn",
                "Tomar un pescado! + 20 de fama","step_two_btn",
                "Tirar una lata de pepinillos! + 20 de fama","step_two_btn"));
         }

        if(getCallbackQueryButtonKey().equals("step_two_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspirador","step_three_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_three_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robor aspirador a por comida! + 30 de fama","step_four_btn",
                            "Dar un paseo en el robot aspirador! + 30 de fama","step_four_btn",
                            "Huir del robot aspirador! + 30 de fama","step_four_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_four_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Ponerte la go pro","step_five_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_five_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Hacer un blog en el techo! + 50 de fama","step_six_btn",
                            "Grabar un blog de tu dia! + 50 de fama","step_six_btn",
                            "Grabar los fails en la patineta! + 50 de fama","step_six_btn"));

        }
        if(getCallbackQueryButtonKey().equals("step_six_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear la gatocomputadora","step_seven_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_seven_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Subir el video a Youtube! + 50 de fama","step_eight_btn",
                            "Subir el video a Instagram! + 50 de fama","step_eight_btn",
                            "Subir el video a Reddit! + 50 de fama","step_eight_btn"));

        }
        if(getCallbackQueryButtonKey().equals("step_eight_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of("Acabar el dia y descansar","step_nine_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_nine_btn")){
            sendTextMessageAsync("Gracias por jugar, Proximamente traeremos nuevos juegos");
        }
        /*
        // con contais podemos verificar si el mensaje tiene la palabra hola
        if(getMessageText().contains("hola") || getMessageText().contains("Hola")) {
            sendTextMessageAsync("Hola, Cual es tu nombre ?");
        }

        if(getMessageText().contains("me llamo") || getMessageText().contains("mi nombre")) {
            sendTextMessageAsync("Es un placer, soy *Gato*");
        }
         */
    }

    public static void main(String[] args) throws TelegramApiException {
        //puerta de entrada de nuestro programa
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}