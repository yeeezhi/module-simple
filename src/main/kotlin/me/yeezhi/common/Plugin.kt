package me.yeezhi.common

import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.info
import taboolib.platform.util.bukkitPlugin

object Plugin {
    @Awake(LifeCycle.ENABLE)
    fun showEnable() {
        info("-------------------------------------------------------------------------")
        info("                   [" + bukkitPlugin.description.name + "] 插件载入成功!")
        info("                   感谢您对我的支持!")
        info("                   插件定制10元起!")
        info("                   更多插件定制请找作者!")
        info("                   QQ: 15568820")
        info("                                        by.Yeezhi")
        info("-------------------------------------------------------------------------")
    }

    @Awake(LifeCycle.DISABLE)
    fun showDisable() {
        info("-------------------------------------------------------------------------")
        info("                   [" + bukkitPlugin.description.name + "] 插件卸载成功!")
        info("                   感谢您对我的支持!")
        info("                   插件定制10元起!")
        info("                   更多插件定制请找作者!")
        info("                   QQ: 15568820")
        info("                                        by.Yeezhi")
        info("-------------------------------------------------------------------------")
    }
}
