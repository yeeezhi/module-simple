package me.yeezhi.common

import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import taboolib.common.platform.function.submit


open class SimpleInventory {
    lateinit var inventory: Inventory
    var backPage = true

    // GUI内部占位符
    var placeholder: MutableMap<String, String> = mutableMapOf()


    /**
     * 构建页面
     */
    open fun build(player: Player): SimpleInventory {
        return this
    }

    /**
     * 打开界面
     */
    open fun open(player: HumanEntity) {
        // 套一层submit减少页面闪烁
        submit {
            player.openInventory(inventory)
            backPage = true
        }
    }


    // 用于记录玩家上次点击的时间和槽位
    private var lastClickTime: Long = 0
    private var lastSlot = -1

    /**
     * 判断玩家是否双击
     *
     * @param rawSlot 点击的槽位
     * @return 如果是双击返回 true，否则返回 false
     */
    fun isDoubleClick(rawSlot: Int): Boolean {
        // 获取当前点击的时间和槽位
        val currentTime = System.currentTimeMillis()
        // 检查是否是双击
        return if (rawSlot == lastSlot && currentTime - lastClickTime <= 200) {
            // 重置双击检测
            lastClickTime = 0
            lastSlot = -1
            true
        } else {
            // 更新最后一次点击的时间和槽位
            lastClickTime = currentTime
            lastSlot = rawSlot
            false
        }
    }


}

