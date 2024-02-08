package me.qingshou.common.command

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class CommandHeader(
    val label: Array<String>,
)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class CommandBody(
    // 指令排序
    val order: Int = 0,
    // 指令命名
    val cmd: String = "", val args: Array<String> = [],
    // 命令描述
    val describe: String = "命令描述",
    // 需要权限
    val permission: String = "",
    // 需要管理员
    val needAdmin: Boolean = false,
    // 可以玩家执行
    val canPlayer: Boolean = true,
    // 可以后台执行
    val canConsole: Boolean = false,
    // 隐藏指令
    val hide: Boolean = false,
    // 异步执行
    val async: Boolean = false
)