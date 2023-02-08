package br.com.mundi.events;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoin extends ListenerAdapter {

    /// <summary>
    /// Comentei o código inteiro pois o mesmo foi implantando
    /// Em forma de comando na pasta "commands/SetJoinChannel"
    /// </summary>

//    @Override
//    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
//
//        /// <summary>
//        /// Identifica o nome do membro que entrou no canal.
//        /// </summary>
//        String joinedMember = event.getUser().getAsMention();
//
//        /// <summary>
//        /// ID do canal que mostrará a pessoa que entrou nos servidor.
//        /// </summary>
//        TextChannel canalDeLogs = event.getGuild().getTextChannelById(1040589609836494859L);
//
//        /// <summary>
//        /// Verifica se o canal é nulo e caso não seja, retorna um embed com informações nenhum pouco importantes.
//        /// </summary>
//        if ( canalDeLogs != null ) {
//            EmbedBuilder embed = new EmbedBuilder()
//                    .setTitle("Bem-vindo")
//                    .setDescription("Que a sua estadia seja curta, " + joinedMember)
//                    .setColor(Color.BLACK)
//                    .setThumbnail("https://i.imgur.com/dgLBXe4.png")
//                    .setTimestamp(new Date().toInstant());
//
//            canalDeLogs.sendMessageEmbeds(embed.build()).queue();
//        }
//
//    }
}
