package br.com.mundi.events;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DeleteChannel extends ListenerAdapter {

//    @Override
//    public void onChannelDelete(@NotNull ChannelDeleteEvent event) {
//
//        /// <summary>
//        /// Identifica o nome do canal deletado.
//        /// </summary>
//        String nomeDoCanal = event.getChannel().getAsMention();
//
//        /// <summary>
//        /// ID do canal de logs para qual será enviado a mensagem de canal deletado.
//        /// </summary>
//        TextChannel canalDeLogs = event.getGuild().getTextChannelById(1067806975401918475L);
//
//        /// <summary>
//        /// Verificação para assegurar que o canal de logs não foi deletado.
//        /// Resposta do bot para caso o canal seja deletado.
//        /// </summary>
//        if (canalDeLogs != null) {
//            canalDeLogs.sendMessage("O canal: " + nomeDoCanal + " foi deletado.").queue();
//        }
//    }
}
