package br.com.mundi.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Ping extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {


        /// <summary>
        /// Verifica se o comando é /ping e responde com pong! caso seja true.
        /// </summary>
        if (event.getName().equals("ping")) {

            /// <summary>
            /// Linha 22 é usada como forma de comunicar ao usuário de que o bot
            /// Recebeu o comando e está analisando/processando o mesmo.
            /// </summary>
            event.deferReply().queue();

            /// <summary>
            /// Por causa do deferReply, para enviar uma mensagem ao invés de utilizar "event.reply"
            /// Se utiliza "event.getHook().sendMessage()".
            /// </summary>
            event.getHook().sendMessage("pong!").queue();
        }
    }
}
