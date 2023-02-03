package br.com.mundi.main;

import br.com.mundi.commands.Food;
import br.com.mundi.commands.Ping;
import br.com.mundi.commands.ShowAvatar;
import br.com.mundi.commands.Soma;
import br.com.mundi.events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String token = System.getenv("BOT_TOKEN");
        /// <summary>
        /// Carrega o token pela variável criada em computador.
        /// Instância que inicia o bot.
        /// </summary>
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

        /// <summary>
        /// Registro de eventos do bot
        /// Funciona da mesma forma citada acima, porém, para eventos ao invés de comandos.
        /// </summary>
        api.addEventListener(new MemberJoin());
        api.addEventListener(new MemberLeave());
        api.addEventListener(new MessageReceived());
        api.addEventListener(new DeleteChannel());


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
                    .addOption(OptionType.INTEGER, "operador1", "primeiro número", true)
                    .addOption(OptionType.INTEGER, "operador2", "segundo número", true)
                    .queue();

            guild.upsertCommand("avatar", "mostra o avatar de um usuário")
                    .addOption(OptionType.MENTIONABLE, "user", "mencione o usuário que deseja ver o avatar", false)
                    .queue();
        }
    }

}