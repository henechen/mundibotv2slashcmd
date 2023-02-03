package br.com.mundi.main;

import br.com.mundi.commands.Food;
import br.com.mundi.commands.Ping;
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

        // Carrega o token pela variável criada em computador.
        // Instância que inicia o bot.
        JDA api = JDABuilder.createDefault(token, EnumSet.allOf(GatewayIntent.class))
                .setActivity(Activity.watching("Sessão da tarde"))
                .build().awaitReady();

        // Registra os comandos no bot.
        api.addEventListener(new Ping());
        api.addEventListener(new Food());
        api.addEventListener(new Soma());

        // Eventos
        api.addEventListener(new MemberJoin());
        api.addEventListener(new MemberLeave());
        api.addEventListener(new MessageReceived());
        api.addEventListener(new DeleteChannel());

        // Especifica um canal onde o slash command irá aparecer.
        Guild guild = api.getGuildById("1040548001803948042");

        // Verifica se o canal não é nulo/deletado e retorna o preview
        // Do nome do comando com uma descrição do que ele faz.
        if (guild != null) {

            guild.upsertCommand("ping", "retorna pong!").queue();

            guild.upsertCommand("comida", "retorna sua comida favorita")
                    .addOption(OptionType.STRING, "comida", "o nome da sua comida favorita", true)
                    .queue();

            guild.upsertCommand("soma", "adição de 2 números.")
                    .addOption(OptionType.INTEGER, "operador1", "primeiro número", true)
                    .addOption(OptionType.INTEGER, "operador2", "segundo número", true)
                    .queue();
        }
    }

}