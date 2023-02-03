package br.com.mundi.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class DeleteChannel extends ListenerAdapter {

    @Override
    public void onChannelDelete(@NotNull ChannelDeleteEvent event) {

        // Identifica o nome do canal deletado.
        String nomeDoCanal = event.getChannel().getName();

        // ID do canal de logs para qual será enviado a mensagem de canal deletado.
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(1067806975401918475L);

        // Verificação para assegurar que o canal de logs não foi deletado.
        // Resposta do bot para caso o canal seja deletado.
        if (canalDeLogs != null) {
            canalDeLogs.sendMessage("O canal: " + nomeDoCanal + " foi deletado.").queue();
        }
    }
}
