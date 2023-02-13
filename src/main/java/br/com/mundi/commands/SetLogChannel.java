package br.com.mundi.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SetLogChannel extends ListenerAdapter {

    long currentChannel;

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equalsIgnoreCase("setlogchannel")) {

            if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {

                currentChannel = event.getChannel().getIdLong();

                event.deferReply(true).queue();

                event.getHook().sendMessage("O canal " + event.getChannel().getAsMention() + " foi setado como canal de logs.").queue();
            } else {
                event.getHook().sendMessage("Você não tem acesso a este comando.").queue();
            }
        }
    }


    /// <summary>
    /// Evento que verifica quando uma pessoa entrou ou saiu de um voice channel e informa qual voice channel ela entrou ou saiu.
    /// </summary>
    @Override
    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {

        VoiceChannel voiceChannelJoin = (VoiceChannel) event.getChannelJoined();
        VoiceChannel voiceChannelLeft = (VoiceChannel) event.getChannelLeft();


        /// <summary>
        /// Seta o canal de logs do Discord.
        /// Passado através do commando que pega o currentChannel.
        /// </summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(currentChannel);

        /// <summary>
        /// Verifica tanto se o canal de logs quanto o canal de voz existem
        /// E caso seja true, retorna o log.
        /// </summary>
        if ( canalDeLogs != null && voiceChannelJoin != null) {

            canalDeLogs.sendMessage(event.getMember().getAsMention() + " entrou no canal de voz " + voiceChannelJoin.getAsMention()).queue();
        }

        if (canalDeLogs != null && voiceChannelLeft != null) {

            canalDeLogs.sendMessage(event.getMember().getAsMention() + " saiu do canal de voz " + voiceChannelLeft.getAsMention()).queue();
        }
    }

    @Override
    public void onChannelCreate(@NotNull ChannelCreateEvent event) {

        /// <summary>
        /// Identifica o nome do canal criado.
        /// </summary>
        String nomeDoCanal = event.getChannel().getAsMention();

        /// <summary>
        /// ID do canal de logs para qual será enviado a mensagem de canal deletado.
        /// </summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(currentChannel);

        /// <summary>
        /// Verificação para assegurar que o canal de logs não foi deletado.
        /// Resposta do bot para caso o canal seja deletado.
        /// </summary>
        if (canalDeLogs != null) {
            canalDeLogs.sendMessage("O canal: " + nomeDoCanal + " foi criado.").queue();
        }
    }

    @Override
    public void onChannelDelete(@NotNull ChannelDeleteEvent event) {

        /// <summary>
        /// Identifica o nome do canal criado.
        /// </summary>
        String nomeDoCanal = event.getChannel().getAsMention();

        /// <summary>
        /// ID do canal de logs para qual será enviado a mensagem de canal deletado.
        /// </summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(currentChannel);

        /// <summary>
        /// Verificação para assegurar que o canal de logs não foi deletado.
        /// Resposta do bot para caso o canal seja deletado.
        /// </summary>
        if (canalDeLogs != null) {
            canalDeLogs.sendMessage("O canal: " + nomeDoCanal + " foi deletado.").queue();
        }
    }

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {

        String member = event.getMember().getAsMention();

        /// <summary>
        /// ID do canal de logs para qual será enviado a mensagem de role adicionada.
        /// </summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(currentChannel);

        /// <summary>
        /// Verificação para assegurar que o canal de logs não foi deletado.
        /// Resposta do bot para caso o usuário tenha a role adicionada.
        /// </summary>
        if (canalDeLogs != null) {
            canalDeLogs.sendMessage("O usuário " + member + " teve a role " + event.getRoles().get(0).getAsMention() + " adicionada.").queue();
        }
    }

    @Override
    public void onGuildMemberRoleRemove(@NotNull GuildMemberRoleRemoveEvent event) {

        String member = event.getMember().getAsMention();

        /// <summary>
        /// ID do canal de logs para qual será enviado a mensagem de role adicionada.
        /// </summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(currentChannel);

        /// <summary>
        /// Verificação para assegurar que o canal de logs não foi deletado.
        /// Resposta do bot para caso o usuário tenha a role adicionada.
        /// </summary>
        if (canalDeLogs != null) {
            canalDeLogs.sendMessage("O usuário " + member + " teve a role " + event.getRoles().get(0).getAsMention() + " removida.").queue();
        }
    }
}
