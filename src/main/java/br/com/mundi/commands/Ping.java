package br.com.mundi.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Ping extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        // Verifica se o comando é /ping e responde com pong! caso seja true.
        if (event.getName().equals("ping")) {

            // Uma forma do bot comunicar de que recebeu o comando e está processando o mesmo.
            event.deferReply().queue();

            // Por causa do deferReply, para enviar uma mensagem ao invés de utilizar "event.reply"
            // Se utiliza "event.getHook().sendMessage()".
            event.getHook().sendMessage("pong!").queue();
        }
    }
}
