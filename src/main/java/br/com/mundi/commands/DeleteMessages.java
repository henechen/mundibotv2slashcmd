package br.com.mundi.commands;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class DeleteMessages extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        /// <summary>
        /// Verifica se o comando se chama "delete" e caso seja true, segue. (avá)
        /// </summary>
        if (event.getName().equals("delete")) {

            /// <summary>
            /// qntd registra o número de mensagens que será apagado.
            /// </summary>
            OptionMapping qntd = event.getOption("amount");

            /// <summary>
            /// Verifica em qual canal está sendo chamado o comando.
            /// </summary>
            TextChannel getChannelId = (TextChannel) event.getChannel();


            /// <summary>
            /// Retorna ao usuário de que o bot está processando o comando
            /// É necessário pois dependendo da quantidade de mensagens
            /// O bot leve mais tempo que o máximo permitido para
            /// Executar o comando sem o deferReply()
            /// </summary>
            event.deferReply().queue();


            /// <summary>
            /// getIterableHistory -> Itera em cima das mensagens recentes
            /// Captadas no canal o qual o comando é executado.
            /// takeAsync -> Recupera as mensagens e só permite fazer algo com elas
            /// Quando elas estiverem "prontas" (eu acho) xD
            /// purgeMessages -> Deleta em bulk se for possível (se não for eu não sei o que fazer)
            /// </summary>
            if (qntd != null) {
                getChannelId.getIterableHistory()
                        .takeAsync(qntd.getAsInt())
                        .thenAccept(getChannelId::purgeMessages);

            }


            /// <summary>
            /// Aqui ele aponta que possivelmente o método getAsString() possa retornar nulo
            /// Mas eu acho que não porque no Main.java eu setei o campo de quantidade como obrigatório
            /// Ou seja, o comando nem roda se não passar um valor entre 2 e 100
            /// </summary>
            event.getHook().sendMessage(qntd.getAsString() + " mensagens foram apagadas.").queue();
        }
    }
}
