package taboolib.module.simple.util.hook

import org.black_ixx.playerpoints.PlayerPoints
import org.black_ixx.playerpoints.PlayerPointsAPI
import org.bukkit.OfflinePlayer

/**
 * 点券工具
 * 插件: PlayerPoints
 */
object PlayerPointsUtil {
    var playerPointsAPI: PlayerPointsAPI =
        PlayerPoints.getPlugin(PlayerPoints::class.java).api.also { PlayerPointsUtil.playerPointsAPI = it }

    /**
     * 查看玩家点券
     *
     * @param player 玩家
     * @return 玩家点券数量
     */
    operator fun get(player: OfflinePlayer): Int {
        return playerPointsAPI.look(player.uniqueId)
    }

    /**
     * 设置玩家点券
     *
     * @param player 玩家
     * @param amount 点券数量
     */
    operator fun set(player: OfflinePlayer, amount: Int) {
        if (amount < 0) {
            return
        }
        playerPointsAPI.set(player.uniqueId, amount)
    }


    /**
     * 给予玩家点券
     *
     * @param player 玩家
     * @param amount 点券数量
     */
    fun give(player: OfflinePlayer, amount: Int) {
        set(player, get(player) + amount)
    }

    /**
     * 扣除玩家点券
     *
     * @param player 玩家
     * @param amount 点券数量
     */
    fun take(player: OfflinePlayer, amount: Int) {
        set(player, get(player) - amount)
    }

    /**
     * 判断玩家是否拥有指定数量的点券
     *
     * @param player 玩家
     * @param amount 点券数量
     * @return true: 玩家点券数量满足,false: 玩家点券数量不满足
     */
    fun has(player: OfflinePlayer, amount: Int): Boolean {
        return amount <= get(player)
    }
}
