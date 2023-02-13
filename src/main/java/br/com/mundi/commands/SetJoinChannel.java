package br.com.mundi.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Date;

public class SetJoinChannel extends ListenerAdapter {

    long currChannel;
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("setjoinchannel")) {

            currChannel = event.getChannel().getIdLong();

            event.deferReply(true).queue();

            event.getHook().sendMessage("O canal " + event.getChannel().getAsMention() + " foi setado como canal de join log.").queue();
        }
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        /// <summary>
        /// Identifica o nome do membro que entrou no canal.
        /// </summary>
        String joinedMember = event.getUser().getAsMention();

        /// <summary>
        /// ID do canal que mostrará a pessoa que entrou nos servidor
        /// O ID agora é captado com o slash command acima.
        /// Valeu serpinha seu lindo <3
        /// </summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(currChannel);

        /// <summary>
        /// Verifica se o canal é nulo e caso não seja, retorna um embed com informações nenhum pouco importantes.
        /// </summary>
        if ( canalDeLogs != null ) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setColor(new Color((int) (Math.random() * 0x1000000)))
                    .setThumbnail(event.getUser().getAvatarUrl())
                    .setTitle("Bem-vindo")
                    .setDescription("Que a sua estadia seja curta, " + joinedMember)
                    .setTimestamp(new Date().toInstant())
                    .setFooter("MVNDI", event.getGuild().getIconUrl());

            canalDeLogs.sendMessageEmbeds(embed.build()).queue();
        }
    }
}
