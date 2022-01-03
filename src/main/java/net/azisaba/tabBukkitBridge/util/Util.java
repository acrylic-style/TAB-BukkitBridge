package net.azisaba.tabBukkitBridge.util;

import net.azisaba.tabBukkitBridge.data.Skip;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.function.Function;
import java.util.function.Predicate;

public class Util {
    private static final DecimalFormat FORMATTER_COMMAS = new DecimalFormat("#,###.00");
    private static final DecimalFormat FORMATTER = new DecimalFormat("#.00");

    @Contract(pure = true)
    @NotNull
    public static <T> Predicate<T> isPluginEnabledPredicate(@NotNull String plugin) {
        return v -> Bukkit.getPluginManager().isPluginEnabled(plugin);
    }

    @NotNull
    public static <T, R> Function<T, R> nonNullMapper(@NotNull Function<@NotNull T, R> function) {
        return t -> {
            if (t == null) throw Skip.SKIP;
            return function.apply(t);
        };
    }

    @NotNull
    public static String format(double d) {
        return FORMATTER.format(d);
    }

    @NotNull
    public static String formatWithCommas(double d) {
        return FORMATTER_COMMAS.format(d);
    }
}
