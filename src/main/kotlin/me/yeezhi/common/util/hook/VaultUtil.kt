package me.yeezhi.common.util.hook

import net.milkbowl.vault.economy.Economy
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer

/**
 * 金币工具
 * 插件: Vault
 */
object VaultUtil {
    private var economy: Economy = Bukkit.getServicesManager().getRegistration(Economy::class.java).provider

    /**
     * 插件玩家金币数量
     *
     * @param player 玩家
     * @return 玩家金币数量
     */
    operator fun get(player: OfflinePlayer): Double {
        return economy.getBalance(player)
    }

    /**
     * 给予玩家金币
     *
     * @param player 玩家
     * @param amount 金币数量
     */
    fun give(player: OfflinePlayer, amount: Double) {
        economy.depositPlayer(player, amount)
    }

    /**
     * 扣除玩家金币
     *
     * @param player 玩家
     * @param amount 金币数量
     */
    fun take(player: OfflinePlayer, amount: Double) {
        economy.withdrawPlayer(player, amount)
    }

    /**
     * 判断玩家是否拥有指定数量的金币
     *
     * @param player 玩家
     * @param amount 金币数量
     * @return true: 玩家金币满足,false: 玩家金币不满足
     */
    fun has(player: OfflinePlayer, amount: Double): Boolean {
        return amount <= get(player)
    }
}
