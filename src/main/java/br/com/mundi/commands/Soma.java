package br.com.mundi.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class Soma extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        // verifica se o comando é /soma e responde com a soma caso seja true.
        if ( event.getName().equals("soma")) {

            OptionMapping operador1 = event.getOption("operador1");
            OptionMapping operador2 = event.getOption("operador2");

            if ( operador1 == null || operador2 == null ) {

                event.reply("Informe 2 números").queue();

                return;
            }

            int sum = operador1.getAsInt() + operador2.getAsInt();

            event.reply("A soma é: " + sum).queue();
        }
    }
}
