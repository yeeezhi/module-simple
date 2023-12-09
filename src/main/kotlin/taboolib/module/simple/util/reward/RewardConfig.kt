package me.qingshou.suohalottery.entity

import taboolib.module.simple.util.GsonUtil.toAny


/**
 * 奖励配置
 */
data class RewardConfig(
    var id: String = "",

    // Name
    val name: String = "",
    // 权重
    val weight: Int = 0,
    // 奖励列表
    val list: List<String> = listOf(),
    // 保底
    val must: Int = 0
) {
    fun rewardList(): MutableList<Reward> {
        return list.map {
            "{$it}".toAny(Reward::class.java)
        }.toMutableList()
    }
}

