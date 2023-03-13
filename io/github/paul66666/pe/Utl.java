package io.github.paul66666.pe;

import java.util.Formatter;

public enum Utl {
    ;

    public static void msg(String chat, Object... args) {
        if (args.length > 0) {
            chat = new Formatter().format(chat, args).toString();
        }
        System.out.println(chat);
    }
}
