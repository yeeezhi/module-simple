package taboolib.module.simple.util.hook

import org.black_ixx.playerpoints.PlayerPoints
import org.black_ixx.playerpoints.PlayerPointsAPI
import org.bukkit.OfflinePlayer
import taboolib.common.platform.Awake

/**
 * 点券工具
 * 插件: PlayerPoints
 */
object PlayerPointsUtil {
//    @Awake
    var playerPointsAPI: PlayerPointsAPI =
        PlayerPoints.getPlugin(PlayerPoints::class.java).api.also { PlayerPointsUtil.playerPointsAPI = it }

    /**
     * 查看玩家点券
     *
     * @param player 玩家
     * @return 玩家点券数量
     */
    fun look(player: OfflinePlayer): Int {
        return playerPointsAPI.look(player.uniqueId)
    }

    /**
     * 判断玩家是否拥有指定数量的点券
     *
     * @param player 玩家
     * @param amount 点券数量
     * @return true: 玩家点券数量满足,false: 玩家点券数量不满足
     */
    fun has(player: OfflinePlayer, amount: Int): Boolean {
        return amount <= look(player)
    }

    /**
     * 设置玩家点券
     *
     * @param player 玩家
     * @param amount 点券数量
     */
    operator fun set(player: OfflinePlayer, amount: Int) {
        if (amount < Int.MAX_VALUE && amount >= 0) {
            playerPointsAPI.set(player.uniqueId, amount)
        }
    }

    /**
     * 给予玩家点券
     *
     * @param player 玩家
     * @param amount 点券数量
     */
    fun give(player: OfflinePlayer, amount: Int) {
        set(player, look(player) + amount)
    }

    /**
     * 扣除玩家点券
     *
     * @param player 玩家
     * @param amount 点券数量
     */
    fun take(player: OfflinePlayer, amount: Int) {
        set(player, look(player) - amount)
    }
}
