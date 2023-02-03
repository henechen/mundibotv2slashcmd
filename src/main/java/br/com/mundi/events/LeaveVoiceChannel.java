package br.com.mundi.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LeaveVoiceChannel extends ListenerAdapter {

    /// <Summary>
    /// Evento que verifica quando uma pessoa entrou em um voice channel e informa qual voice channel ela entrou
    /// </Summary>
    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {

        VoiceChannel voiceChannel = (VoiceChannel) event.getChannelLeft();

        /// <Summary>
        /// Seta o canal de logs do Discord.
        /// Passado manualmente
        /// </Summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(1067806975401918475L);

        /// <Summary>
        /// Verifica tanto se o canal de logs quanto o canal de voz existem
        /// E caso seja true, retorna o log.
        /// </Summary>
        if ( canalDeLogs != null && voiceChannel != null) {

            canalDeLogs.sendMessage(event.getMember().getAsMention() + " saiu do canal de voz " + voiceChannel.getAsMention()).queue();
        }
    }
}
