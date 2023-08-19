package taboolib.module.simple.util.hook

import com.google.common.collect.Lists
import com.mchim.ItemLoreOrigin.Config.Settings
import com.mchim.ItemLoreOrigin.ItemLoreData.ItemLoreManager
import com.mchim.ItemLoreOrigin.ItemLoreData.Origin.LoreOrigin
import net.md_5.bungee.api.ChatColor
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

object ItemLoreOriginUtil {
    /**
     * 处理ilo属性
     * 一般在ItemLoreStatusEvent,ItemLoreDamageEvent,ItemLoreTickEvent触发时使用
     *
     * @param player    玩家
     * @param managers  事件中获取
     * @param loreList 生效的属性Lore
     */
    fun handleAttribute(player: Player, managers: List<ItemLoreManager>, loreList: List<String>) {
        val ilm = managers[0]
        ilm.loreData.addAll(getLoreOriginList(player, loreList))
    }

    /**
     * 通过Lore获取属性
     *
     * @param player 玩家
     * @param loreList   Lore
     * @return 玩家属性
     */
    fun getLoreOriginList(player: Player, loreList: List<String>): List<LoreOrigin> {
        val lists: MutableList<LoreOrigin> = Lists.newArrayList()
        if (loreList.isEmpty()) {
            return lists
        }
        for (str in loreList) {
            var lore = ChatColor.stripColor(str)
            var loreType: String? = null
            for (type in Settings.I.loreType.keys) {
                val list = Settings.I.loreType[type]!!
                for (ss in list) {
                    if (lore.contains(ss!!)) {
                        loreType = type
                        break
                    }
                }
            }
            if (loreType != null && LoreOrigin.originMap.containsKey(loreType)) {
                try {
                    val lo = LoreOrigin.originMap[loreType]!!.getConstructor(
                        *arrayOf<Class<*>>(
                            LivingEntity::class.java
                        )
                    ).newInstance(*arrayOf<Any?>(player))
                    lo.init(lore)
                    if (lo.name != null) {
                        lists.add(lo)
                    }
                } catch (var12: Exception) {
                    var12.printStackTrace()
                }
            }
        }
        return lists
    }
}
