package net.equj65.spring.mybatis.util;

import net.equj65.spring.mybatis.entity.BaseEntity;

import java.io.PrintStream;

public class EntityOutputUtils {

    private static final String INDENT = "    ";

    /**
     * 引数に指定されたEntityをインデント付きでStreamに出力します。
     * @param t
     * @param stream
     * @param <T>
     */
    public static <T extends BaseEntity> void indentOut(T t, PrintStream stream) {
        StringBuilder builder = new StringBuilder();
        builder.append(INDENT).append(t.toString());
        stream.println(builder.toString());
    }

    /**
     * 引数に指定されたEntityをインデント付きで標準出力します。
     * @param t
     * @param <T>
     */
    public static <T extends BaseEntity> void indentStdOut(T t) {
        indentOut(t, System.out);
    }
}
