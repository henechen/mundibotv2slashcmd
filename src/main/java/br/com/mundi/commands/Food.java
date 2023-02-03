package br.com.mundi.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class Food extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        // Verifica se o comando é /comida e responde com a comida favorita caso seja true.
        if (event.getName().equals("comida")) {

            OptionMapping opcao = event.getOption("comida");

            if ( opcao == null ){
                event.reply("Por algum motivo, o nome da comida não foi passado").queue();

                return;
            }

            String comidaFavorita = opcao.getAsString();

            // event.reply responde de forma instantânea o comando quando é algo que demora
            // Menos de 3s segundos para gerar uma resposta (não tenho certeza se esse é o tempo mesmo)
            event.reply("Sua comida favorita é: " + comidaFavorita).queue();
        }
    }
}
