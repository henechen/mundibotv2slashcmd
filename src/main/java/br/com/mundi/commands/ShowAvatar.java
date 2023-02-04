package br.com.mundi.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ShowAvatar extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        /// <summary>
        /// O comando verifica se a palavra depois do / é "avatar", e caso seja segue com o comando
        /// </summary>
        if ( event.getName().equals("avatar") ) {

            /// <summary>
            /// Adicionado a opção para passar um "user".
            /// </summary>
            OptionMapping user = event.getOption("user");

            /// <summary>
            /// Como o comando nao é instântaneo, deferReply() foi adicionado para o bot conseguir lidar com o comando.
            /// </summary>
            event.deferReply().queue();

            /// <summary>
            /// O comando verifica se o usuário passado é nulo, e caso seja retorna o avatar de quem chamou o comando.
            /// "?size=4096" é adicionado junto método de pegar o avatar porque eu fui incapaz
            /// De achar um método que retornasse o avatar com seu tamanho maior
            /// PS: era pra ser o "getEffectiveAvatarUrl()" mas não funcionou não sei porque
            /// Então vai ficar assim mesmo.
            /// </summary>
            if ( user == null ) {

                String authorAvatar = event.getUser().getEffectiveAvatarUrl();

                event.getHook().sendMessage(Objects.requireNonNull(authorAvatar) + "?size=4096").queue();
            }


            /// <summary>
            /// O comando verifica se o usuário passado não é nulo, e caso não seja retorna o avatar do usuário mencionado.
            /// "?size=4096" é adicionado junto método de pegar o avatar porque eu fui incapaz
            /// De achar um método que retornasse o avatar com seu tamanho maior
            /// PS: era pra ser o "getEffectiveAvatarUrl()" mas não funcionou não sei porque
            /// Então vai ficar assim mesmo.
            /// </summary>
            if ( user != null ) {

                String mentionedUser = user.getAsUser().getEffectiveAvatarUrl();

                event.getHook().sendMessage(Objects.requireNonNull(mentionedUser) + "?size=4096").queue();
            }

        }

    }
}
