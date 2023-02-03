package br.com.mundi.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Date;

public class MemberLeave extends ListenerAdapter {

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {

        /// <Summary>
        /// Identifica o nome do membro que saiu do servidor.
        /// </Summary>
        String removedMember = event.getUser().getAsMention();

        /// <Summary>
        /// ID do canal que mostrará a pessoa que saiu do Discord.
        /// </Summary>
        TextChannel canalDeLogs = event.getGuild().getTextChannelById(1040589609836494859L);

        /// <Summary>
        /// Verifica se o canal é nulo e caso não seja, retorna um embed com informações nenhum pouco importantes.
        /// </Summary>
        if ( canalDeLogs != null ) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("Adios, fdp")
                    .setDescription("Foi de Vasco e foi cedo, " + removedMember)
                    .setColor(Color.BLACK)
                    .setThumbnail("https://i.imgur.com/dgLBXe4.png")
                    .setTimestamp(new Date().toInstant());

            canalDeLogs.sendMessageEmbeds(embed.build()).queue();
        }
    }
}
