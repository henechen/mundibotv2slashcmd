package br.com.mundi.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class DeleteChannel extends ListenerAdapter {

    @Override
    public void onChannelDelete(@NotNull ChannelDeleteEvent event) {

        /// <Summary>
        /// Identifica o nome do canal deletado.
        /// </Summary>
        String nomeDoCanal = event.getChannel().getName();

        /// <Summary>
        /// ID do canal de logs para qual será enviado a mensagem de canal deletado.
        /// </Summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(1067806975401918475L);

        /// <Summary>
        /// Verificação para assegurar que o canal de logs não foi deletado.
        /// Resposta do bot para caso o canal seja deletado.
        /// </Summary>
        if (canalDeLogs != null) {
            canalDeLogs.sendMessage("O canal: " + nomeDoCanal + " foi deletado.").queue();
        }
    }
}
