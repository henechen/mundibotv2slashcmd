package br.com.mundi.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RandomGen extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        /// <summary>
        /// Eu me recuso a explicar este pedaço de código.
        /// </summary>
        Random randola = new Random();

        int numeroAleatorio = randola.nextInt(11);

        if ( event.getName().equals("random") ) {

            event.deferReply().queue();

            event.getHook().sendMessage(event.getUser().getAsMention() + ", o número gerado foi: " + numeroAleatorio).queue();
        }
    }
}
