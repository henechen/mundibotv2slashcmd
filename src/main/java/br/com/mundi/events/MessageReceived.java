package br.com.mundi.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageReceived extends ListenerAdapter {


    /// <Summary>
    /// Arquivo de teste somente para estudo.
    /// </Summary>
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        // Verifica se o autor da mensagem não é o bot, e caso não seja, procede com o código.
//        if (!event.getAuthor().isBot()) {
//
//            // Capta a mensagem recebida em qualquer canal.
//            String mensagemEnviada = event.getMessage().getContentRaw();
//
//            // Responde com o texto "A mensagem enviada foi:" + a mensagem captada.
//            event.getGuildChannel().sendMessage("A mensagem enviada foi: " + mensagemEnviada).queue();
//        }
    }
}
