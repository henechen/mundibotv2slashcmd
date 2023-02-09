package br.com.mundi.main;

import br.com.mundi.commands.*;
import br.com.mundi.events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        /// <summary>
        /// Carrega o token pela variável criada em computador.
        /// Instância que inicia o bot.
        /// </summary>
        String token = System.getenv("BOT_TOKEN");

        JDA api = JDABuilder.createDefault(token, EnumSet.allOf(GatewayIntent.class))
                .setActivity(Activity.watching("Sessão da tarde"))
                .build().awaitReady();


        /// <summary>
        /// Registro de comandos do bot
        /// É necessário sempre adicionar um eventListener após criar um comando para o bot saber da existência.
        /// </summary>
        api.addEventListener(new Ping());
        api.addEventListener(new Food());
        api.addEventListener(new Soma());
        api.addEventListener(new ShowAvatar());
        api.addEventListener(new RandomGen());
        api.addEventListener(new DeleteMessages());
        api.addEventListener(new SetJoinChannel());
        api.addEventListener(new SetLeaveChannel());
        api.addEventListener(new SetLogChannel());

        /// <summary>
        /// Registro de eventos do bot
        /// Funciona da mesma forma citada acima, porém, para eventos ao invés de comandos.
        /// </summary>
        api.addEventListener(new MemberJoin());
        api.addEventListener(new MemberLeave());
        api.addEventListener(new MessageReceived());
        api.addEventListener(new DeleteChannel());
        api.addEventListener(new CreateChannel());
        api.addEventListener(new JoinedVoiceChannel());
        api.addEventListener(new LeaveVoiceChannel());


        /// <summary>
        /// Especifica em qual servidor os comandos rodarão.
        /// Neste caso, como inicialmente o projeto abrange somente um servidor em específico
        /// É passado o guildId (id do servidor) para se rodar os comandos.
        /// </summary>
        Guild guild = api.getGuildById("1040548001803948042");

        /// <summary>
        /// Verificação para saber se o servidor é nulo ou não.
        /// Caso não seja, os comandos são criados.
        ///
        /// upsertCommand é uma das formas para se criar/registrar um comando para aparecer no Discord
        /// Quando se digitar /alguma coisa, consultar documentação do Discord caso tenha dúvidas
        /// Ou se um dia eu tiver a paciência e boa vontade de colocar aqui.
        /// </summary>
        if (guild != null) {

            guild.upsertCommand("ping", "retorna pong!").queue();

            guild.upsertCommand("comida", "retorna sua comida favorita")
                    .addOption(OptionType.STRING, "comida", "o nome da sua comida favorita", true)
                    .queue();

            guild.upsertCommand("soma", "adição de 2 números.")
                    .addOptions(
                            new OptionData(OptionType.INTEGER, "operador1", "primeiro número a ser somado", true),
                            new OptionData(OptionType.INTEGER, "operador2", "segundo número a ser somado", true)
                    )
                    .queue();

            guild.upsertCommand("avatar", "mostra o avatar de um usuário")
                    .addOption(OptionType.MENTIONABLE, "user", "mencione o usuário que deseja ver o avatar", false)
                    .queue();

            guild.upsertCommand("random", "gera um número aleatório entre 0 e 10.").queue();

            guild.upsertCommand("delete", "Deleta mensagens da sala, mínimo 2 máximo 100 em um período de 2 semanas.")
                    .addOptions(
                            new OptionData(OptionType.INTEGER, "amount", "Quantidade de mensagens a ser apagada. Limite de 2 a 100 em 2 semanas.", true)
                                    .setRequiredRange(2, 100)
                    )
                    .queue();

            guild.upsertCommand("setjoinchannel", "Seta o canal atual como canal de logs de entrada.").queue();

            guild.upsertCommand("setleavechannel", "Seta o canal atual como canal de logs de saída.").queue();

            guild.upsertCommand("setlogchannel", "Seta o canal triggado como canal de logs.").queue();
        }
    }

}