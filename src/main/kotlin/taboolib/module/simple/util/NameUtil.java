package taboolib.module.simple.util;

import org.bukkit.Material;

/**
 * 物品名工具
 */
public class NameUtil {
    /**
     * 通过Material获取物品中文名
     *
     * @param ma 物品Material
     * @return 物品中文名
     */
    public static String toChinese(Material ma) {
        if (ma == Material.AIR) {
            return "空气";
        } else if (ma == Material.STONE) {
            return "石头";
        } else if (ma == Material.GRASS) {
            return "草";
        } else if (ma == Material.DIRT) {
            return "泥土";
        } else if (ma == Material.COBBLESTONE) {
            return "鹅卵石";
        } else if (ma == Material.WOOD) {
            return "木头";
        } else if (ma == Material.SAPLING) {
            return "幼树";
        } else if (ma == Material.BEDROCK) {
            return "基岩";
        } else if (ma == Material.WATER) {
            return "水";
        } else if (ma == Material.STATIONARY_WATER) {
            return "静止水";
        } else if (ma == Material.LAVA) {
            return "熔岩";
        } else if (ma == Material.STATIONARY_LAVA) {
            return "静止熔岩";
        } else if (ma == Material.SAND) {
            return "沙子";
        } else if (ma == Material.GRAVEL) {
            return "砾石";
        } else if (ma == Material.GOLD_ORE) {
            return "金矿";
        } else if (ma == Material.IRON_ORE) {
            return "铁矿石";
        } else if (ma == Material.COAL_ORE) {
            return "煤矿";
        } else if (ma == Material.LOG) {
            return "日志";
        } else if (ma == Material.LEAVES) {
            return "树叶";
        } else if (ma == Material.SPONGE) {
            return "海绵";
        } else if (ma == Material.GLASS) {
            return "玻璃";
        } else if (ma == Material.LAPIS_ORE) {
            return "青金石";
        } else if (ma == Material.LAPIS_BLOCK) {
            return "青金石块";
        } else if (ma == Material.DISPENSER) {
            return "分配器";
        } else if (ma == Material.SANDSTONE) {
            return "砂岩";
        } else if (ma == Material.NOTE_BLOCK) {
            return "注释块";
        } else if (ma == Material.BED_BLOCK) {
            return "床挡";
        } else if (ma == Material.POWERED_RAIL) {
            return "动力钢轨";
        } else if (ma == Material.DETECTOR_RAIL) {
            return "探测轨";
        } else if (ma == Material.PISTON_STICKY_BASE) {
            return "活塞粘性底座";
        } else if (ma == Material.WEB) {
            return "网状物";
        } else if (ma == Material.LONG_GRASS) {
            return "长草";
        } else if (ma == Material.DEAD_BUSH) {
            return "死灌木";
        } else if (ma == Material.PISTON_BASE) {
            return "活塞座";
        } else if (ma == Material.PISTON_EXTENSION) {
            return "活塞伸出";
        } else if (ma == Material.WOOL) {
            return "羊毛";
        } else if (ma == Material.PISTON_MOVING_PIECE) {
            return "活塞活动件";
        } else if (ma == Material.YELLOW_FLOWER) {
            return "黄花";
        } else if (ma == Material.RED_ROSE) {
            return "红玫瑰";
        } else if (ma == Material.BROWN_MUSHROOM) {
            return "褐蘑菇";
        } else if (ma == Material.RED_MUSHROOM) {
            return "红蘑菇";
        } else if (ma == Material.GOLD_BLOCK) {
            return "金块";
        } else if (ma == Material.IRON_BLOCK) {
            return "铁块";
        } else if (ma == Material.DOUBLE_STEP) {
            return "双台阶";
        } else if (ma == Material.STEP) {
            return "步骤";
        } else if (ma == Material.BRICK) {
            return "砖";
        } else if (ma == Material.TNT) {
            return "梯恩梯";
        } else if (ma == Material.BOOKSHELF) {
            return "书架";
        } else if (ma == Material.MOSSY_COBBLESTONE) {
            return "苔藓鹅卵石";
        } else if (ma == Material.OBSIDIAN) {
            return "黑曜石";
        } else if (ma == Material.TORCH) {
            return "火炬";
        } else if (ma == Material.FIRE) {
            return "火";
        } else if (ma == Material.MOB_SPAWNER) {
            return "怪物产卵器";
        } else if (ma == Material.WOOD_STAIRS) {
            return "木楼梯";
        } else if (ma == Material.CHEST) {
            return "胸围";
        } else if (ma == Material.REDSTONE_WIRE) {
            return "红石线";
        } else if (ma == Material.DIAMOND_ORE) {
            return "金刚石矿";
        } else if (ma == Material.DIAMOND_BLOCK) {
            return "金刚石块";
        } else if (ma == Material.WORKBENCH) {
            return "工作台";
        } else if (ma == Material.CROPS) {
            return "作物";
        } else if (ma == Material.SOIL) {
            return "土壤";
        } else if (ma == Material.FURNACE) {
            return "熔炉";
        } else if (ma == Material.BURNING_FURNACE) {
            return "燃烧炉";
        } else if (ma == Material.SIGN_POST) {
            return "标志杆";
        } else if (ma == Material.WOODEN_DOOR) {
            return "木门";
        } else if (ma == Material.LADDER) {
            return "梯子";
        } else if (ma == Material.RAILS) {
            return "轨道";
        } else if (ma == Material.COBBLESTONE_STAIRS) {
            return "鹅卵石楼梯";
        } else if (ma == Material.WALL_SIGN) {
            return "墙壁标志";
        } else if (ma == Material.LEVER) {
            return "杠杆";
        } else if (ma == Material.STONE_PLATE) {
            return "石板";
        } else if (ma == Material.IRON_DOOR_BLOCK) {
            return "铁门挡";
        } else if (ma == Material.WOOD_PLATE) {
            return "木板";
        } else if (ma == Material.REDSTONE_ORE) {
            return "红石矿";
        } else if (ma == Material.GLOWING_REDSTONE_ORE) {
            return "发光红石矿";
        } else if (ma == Material.REDSTONE_TORCH_OFF) {
            return "红石手电筒关闭";
        } else if (ma == Material.REDSTONE_TORCH_ON) {
            return "红石手电筒打开";
        } else if (ma == Material.STONE_BUTTON) {
            return "石头按钮";
        } else if (ma == Material.SNOW) {
            return "下雪";
        } else if (ma == Material.ICE) {
            return "冰";
        } else if (ma == Material.SNOW_BLOCK) {
            return "雪块";
        } else if (ma == Material.CACTUS) {
            return "仙人掌";
        } else if (ma == Material.CLAY) {
            return "粘土";
        } else if (ma == Material.SUGAR_CANE_BLOCK) {
            return "甘蔗块";
        } else if (ma == Material.JUKEBOX) {
            return "自动存储塔";
        } else if (ma == Material.FENCE) {
            return "围栏";
        } else if (ma == Material.PUMPKIN) {
            return "南瓜";
        } else if (ma == Material.NETHERRACK) {
            return "尼日拉克";
        } else if (ma == Material.SOUL_SAND) {
            return "灵魂之沙";
        } else if (ma == Material.GLOWSTONE) {
            return "辉石";
        } else if (ma == Material.PORTAL) {
            return "门户";
        } else if (ma == Material.JACK_O_LANTERN) {
            return "杰克灯";
        } else if (ma == Material.CAKE_BLOCK) {
            return "蛋糕块";
        } else if (ma == Material.DIODE_BLOCK_OFF) {
            return "二极管关闭";
        } else if (ma == Material.DIODE_BLOCK_ON) {
            return "二极管块打开";
        } else if (ma == Material.STAINED_GLASS) {
            return "彩色玻璃";
        } else if (ma == Material.TRAP_DOOR) {
            return "活板门";
        } else if (ma == Material.MONSTER_EGGS) {
            return "怪物蛋";
        } else if (ma == Material.SMOOTH_BRICK) {
            return "光滑的砖";
        } else if (ma == Material.HUGE_MUSHROOM_1) {
            return "大蘑菇1";
        } else if (ma == Material.HUGE_MUSHROOM_2) {
            return "大蘑菇2";
        } else if (ma == Material.IRON_FENCE) {
            return "铁栅栏";
        } else if (ma == Material.THIN_GLASS) {
            return "薄玻璃";
        } else if (ma == Material.MELON_BLOCK) {
            return "瓜块";
        } else if (ma == Material.PUMPKIN_STEM) {
            return "南瓜茎";
        } else if (ma == Material.MELON_STEM) {
            return "甜瓜茎";
        } else if (ma == Material.VINE) {
            return "藤蔓植物";
        } else if (ma == Material.FENCE_GATE) {
            return "栅栏门";
        } else if (ma == Material.BRICK_STAIRS) {
            return "砖砌楼梯";
        } else if (ma == Material.SMOOTH_STAIRS) {
            return "光滑的楼梯";
        } else if (ma == Material.MYCEL) {
            return "菌丝体";
        } else if (ma == Material.WATER_LILY) {
            return "睡莲";
        } else if (ma == Material.NETHER_BRICK) {
            return "地下砖";
        } else if (ma == Material.NETHER_FENCE) {
            return "幽冥篱笆";
        } else if (ma == Material.NETHER_BRICK_STAIRS) {
            return "下砖楼梯";
        } else if (ma == Material.NETHER_WARTS) {
            return "下疣";
        } else if (ma == Material.ENCHANTMENT_TABLE) {
            return "附魔台";
        } else if (ma == Material.BREWING_STAND) {
            return "酿造台";
        } else if (ma == Material.CAULDRON) {
            return "大锅";
        } else if (ma == Material.ENDER_PORTAL) {
            return "ENDER入口";
        } else if (ma == Material.ENDER_PORTAL_FRAME) {
            return "端部门架";
        } else if (ma == Material.ENDER_STONE) {
            return "安德石";
        } else if (ma == Material.DRAGON_EGG) {
            return "龙蛋";
        } else if (ma == Material.REDSTONE_LAMP_OFF) {
            return "红石灯熄灭";
        } else if (ma == Material.REDSTONE_LAMP_ON) {
            return "红石灯亮";
        } else if (ma == Material.WOOD_DOUBLE_STEP) {
            return "木双台阶";
        } else if (ma == Material.WOOD_STEP) {
            return "木台阶";
        } else if (ma == Material.COCOA) {
            return "可可";
        } else if (ma == Material.SANDSTONE_STAIRS) {
            return "砂岩楼梯";
        } else if (ma == Material.EMERALD_ORE) {
            return "翡翠矿";
        } else if (ma == Material.ENDER_CHEST) {
            return "文胸";
        } else if (ma == Material.TRIPWIRE_HOOK) {
            return "三线钩";
        } else if (ma == Material.TRIPWIRE) {
            return "三线";
        } else if (ma == Material.EMERALD_BLOCK) {
            return "翡翠块";
        } else if (ma == Material.SPRUCE_WOOD_STAIRS) {
            return "云杉木楼梯";
        } else if (ma == Material.BIRCH_WOOD_STAIRS) {
            return "桦木楼梯";
        } else if (ma == Material.JUNGLE_WOOD_STAIRS) {
            return "丛林木楼梯";
        } else if (ma == Material.COMMAND) {
            return "命令";
        } else if (ma == Material.BEACON) {
            return "信标";
        } else if (ma == Material.COBBLE_WALL) {
            return "卵石墙";
        } else if (ma == Material.FLOWER_POT) {
            return "花盆";
        } else if (ma == Material.CARROT) {
            return "胡萝卜";
        } else if (ma == Material.POTATO) {
            return "马铃薯";
        } else if (ma == Material.WOOD_BUTTON) {
            return "木扣";
        } else if (ma == Material.SKULL) {
            return "颅骨";
        } else if (ma == Material.ANVIL) {
            return "铁砧";
        } else if (ma == Material.TRAPPED_CHEST) {
            return "陷胸";
        } else if (ma == Material.GOLD_PLATE) {
            return "金盘";
        } else if (ma == Material.IRON_PLATE) {
            return "铁板";
        } else if (ma == Material.REDSTONE_COMPARATOR_OFF) {
            return "红石比较仪关";
        } else if (ma == Material.REDSTONE_COMPARATOR_ON) {
            return "红石比较仪开启";
        } else if (ma == Material.DAYLIGHT_DETECTOR) {
            return "日光探测器";
        } else if (ma == Material.REDSTONE_BLOCK) {
            return "红石块";
        } else if (ma == Material.QUARTZ_ORE) {
            return "石英矿";
        } else if (ma == Material.HOPPER) {
            return "漏斗";
        } else if (ma == Material.QUARTZ_BLOCK) {
            return "石英块";
        } else if (ma == Material.QUARTZ_STAIRS) {
            return "石英楼梯";
        } else if (ma == Material.ACTIVATOR_RAIL) {
            return "激活器轨道";
        } else if (ma == Material.DROPPER) {
            return "滴管";
        } else if (ma == Material.STAINED_CLAY) {
            return "染色粘土";
        } else if (ma == Material.STAINED_GLASS_PANE) {
            return "彩色窗格玻璃";
        } else if (ma == Material.LEAVES_2) {
            return "叶2";
        } else if (ma == Material.LOG_2) {
            return "日志2";
        } else if (ma == Material.ACACIA_STAIRS) {
            return "金合欢木楼梯";
        } else if (ma == Material.DARK_OAK_STAIRS) {
            return "黑橡木楼梯";
        } else if (ma == Material.SLIME_BLOCK) {
            return "煤块";
        } else if (ma == Material.BARRIER) {
            return "屏障";
        } else if (ma == Material.IRON_TRAPDOOR) {
            return "铁活板门";
        } else if (ma == Material.PRISMARINE) {
            return "棱柱";
        } else if (ma == Material.SEA_LANTERN) {
            return "海晶灯";
        } else if (ma == Material.HAY_BLOCK) {
            return "干草块";
        } else if (ma == Material.CARPET) {
            return "地毯";
        } else if (ma == Material.HARD_CLAY) {
            return "硬粘土";
        } else if (ma == Material.COAL_BLOCK) {
            return "煤块";
        } else if (ma == Material.PACKED_ICE) {
            return "积冰";
        } else if (ma == Material.DOUBLE_PLANT) {
            return "双重植物";
        } else if (ma == Material.STANDING_BANNER) {
            return "横幅";
        } else if (ma == Material.WALL_BANNER) {
            return "墙壁横幅";
        } else if (ma == Material.DAYLIGHT_DETECTOR_INVERTED) {
            return "日光探测器倒置";
        } else if (ma == Material.RED_SANDSTONE) {
            return "红砂岩";
        } else if (ma == Material.RED_SANDSTONE_STAIRS) {
            return "红砂岩楼梯";
        } else if (ma == Material.DOUBLE_STONE_SLAB2) {
            return "双层石板2";
        } else if (ma == Material.STONE_SLAB2) {
            return "石板2";
        } else if (ma == Material.SPRUCE_FENCE_GATE) {
            return "云杉篱笆门";
        } else if (ma == Material.BIRCH_FENCE_GATE) {
            return "桦木栅栏门";
        } else if (ma == Material.JUNGLE_FENCE_GATE) {
            return "丛林栅栏门";
        } else if (ma == Material.DARK_OAK_FENCE_GATE) {
            return "黑橡树篱笆门";
        } else if (ma == Material.ACACIA_FENCE_GATE) {
            return "金合欢篱笆门";
        } else if (ma == Material.SPRUCE_FENCE) {
            return "云杉篱笆";
        } else if (ma == Material.BIRCH_FENCE) {
            return "桦树篱笆";
        } else if (ma == Material.JUNGLE_FENCE) {
            return "丛林篱笆";
        } else if (ma == Material.DARK_OAK_FENCE) {
            return "黑橡树篱笆";
        } else if (ma == Material.ACACIA_FENCE) {
            return "金合欢篱笆";
        } else if (ma == Material.SPRUCE_DOOR) {
            return "云杉门";
        } else if (ma == Material.BIRCH_DOOR) {
            return "桦木门";
        } else if (ma == Material.JUNGLE_DOOR) {
            return "丛林之门";
        } else if (ma == Material.ACACIA_DOOR) {
            return "金合欢木门";
        } else if (ma == Material.DARK_OAK_DOOR) {
            return "黑橡木门";
        } else if (ma == Material.END_ROD) {
            return "端杆";
        } else if (ma == Material.CHORUS_PLANT) {
            return "合唱植物";
        } else if (ma == Material.CHORUS_FLOWER) {
            return "合唱花";
        } else if (ma == Material.PURPUR_BLOCK) {
            return "紫癜块";
        } else if (ma == Material.PURPUR_PILLAR) {
            return "紫柱";
        } else if (ma == Material.PURPUR_STAIRS) {
            return "紫色楼梯";
        } else if (ma == Material.PURPUR_DOUBLE_SLAB) {
            return "紫色双层板";
        } else if (ma == Material.PURPUR_SLAB) {
            return "紫色板";
        } else if (ma == Material.END_BRICKS) {
            return "端砖";
        } else if (ma == Material.BEETROOT_BLOCK) {
            return "甜菜块根";
        } else if (ma == Material.GRASS_PATH) {
            return "草径";
        } else if (ma == Material.END_GATEWAY) {
            return "终端网关";
        } else if (ma == Material.COMMAND_REPEATING) {
            return "循环型命令方块";
        } else if (ma == Material.COMMAND_CHAIN) {
            return "连锁型命令方块";
        } else if (ma == Material.FROSTED_ICE) {
            return "冰霜";
        } else if (ma == Material.MAGMA) {
            return "岩浆";
        } else if (ma == Material.NETHER_WART_BLOCK) {
            return "地狱疣块";
        } else if (ma == Material.RED_NETHER_BRICK) {
            return "红色地狱砖";
        } else if (ma == Material.BONE_BLOCK) {
            return "骨块";
        } else if (ma == Material.STRUCTURE_VOID) {
            return "结构空位";
        } else if (ma == Material.OBSERVER) {
            return "侦察器";
        } else if (ma == Material.WHITE_SHULKER_BOX) {
            return "白色潜影盒";
        } else if (ma == Material.ORANGE_SHULKER_BOX) {
            return "橙色潜影盒";
        } else if (ma == Material.MAGENTA_SHULKER_BOX) {
            return "品红潜影盒";
        } else if (ma == Material.LIGHT_BLUE_SHULKER_BOX) {
            return "浅蓝色潜影盒";
        } else if (ma == Material.YELLOW_SHULKER_BOX) {
            return "黄色潜影盒";
        } else if (ma == Material.LIME_SHULKER_BOX) {
            return "石灰箱";
        } else if (ma == Material.PINK_SHULKER_BOX) {
            return "粉色潜影盒";
        } else if (ma == Material.GRAY_SHULKER_BOX) {
            return "灰色潜影盒";
        } else if (ma == Material.SILVER_SHULKER_BOX) {
            return "银色潜影盒";
        } else if (ma == Material.CYAN_SHULKER_BOX) {
            return "青色潜影盒";
        } else if (ma == Material.PURPLE_SHULKER_BOX) {
            return "紫色潜影盒";
        } else if (ma == Material.BLUE_SHULKER_BOX) {
            return "蓝色潜影盒子";
        } else if (ma == Material.BROWN_SHULKER_BOX) {
            return "棕色潜影盒";
        } else if (ma == Material.GREEN_SHULKER_BOX) {
            return "绿色潜影盒";
        } else if (ma == Material.RED_SHULKER_BOX) {
            return "红色潜影盒子";
        } else if (ma == Material.BLACK_SHULKER_BOX) {
            return "黑色潜影盒";
        } else if (ma == Material.WHITE_GLAZED_TERRACOTTA) {
            return "白釉陶土";
        } else if (ma == Material.ORANGE_GLAZED_TERRACOTTA) {
            return "橘色釉面陶土";
        } else if (ma == Material.MAGENTA_GLAZED_TERRACOTTA) {
            return "品红釉陶土";
        } else if (ma == Material.LIGHT_BLUE_GLAZED_TERRACOTTA) {
            return "浅蓝色釉面陶土";
        } else if (ma == Material.YELLOW_GLAZED_TERRACOTTA) {
            return "黄釉陶土";
        } else if (ma == Material.LIME_GLAZED_TERRACOTTA) {
            return "石灰釉陶土";
        } else if (ma == Material.PINK_GLAZED_TERRACOTTA) {
            return "粉釉陶土";
        } else if (ma == Material.GRAY_GLAZED_TERRACOTTA) {
            return "灰釉陶土";
        } else if (ma == Material.SILVER_GLAZED_TERRACOTTA) {
            return "银釉陶土";
        } else if (ma == Material.CYAN_GLAZED_TERRACOTTA) {
            return "青釉陶土";
        } else if (ma == Material.PURPLE_GLAZED_TERRACOTTA) {
            return "紫釉陶土";
        } else if (ma == Material.BLUE_GLAZED_TERRACOTTA) {
            return "青釉陶土";
        } else if (ma == Material.BROWN_GLAZED_TERRACOTTA) {
            return "褐色釉面陶土";
        } else if (ma == Material.GREEN_GLAZED_TERRACOTTA) {
            return "青釉陶土";
        } else if (ma == Material.RED_GLAZED_TERRACOTTA) {
            return "红釉陶土";
        } else if (ma == Material.BLACK_GLAZED_TERRACOTTA) {
            return "黑釉陶土";
        } else if (ma == Material.CONCRETE) {
            return "混凝土";
        } else if (ma == Material.CONCRETE_POWDER) {
            return "混凝土粉";
        } else if (ma == Material.STRUCTURE_BLOCK) {
            return "结构块";
        } else if (ma == Material.IRON_SPADE) {
            return "铁锹";
        } else if (ma == Material.IRON_PICKAXE) {
            return "铁镐";
        } else if (ma == Material.IRON_AXE) {
            return "铁斧";
        } else if (ma == Material.FLINT_AND_STEEL) {
            return "打火石";
        } else if (ma == Material.APPLE) {
            return "苹果";
        } else if (ma == Material.BOW) {
            return "弓";
        } else if (ma == Material.ARROW) {
            return "箭头";
        } else if (ma == Material.COAL) {
            return "煤";
        } else if (ma == Material.DIAMOND) {
            return "钻石";
        } else if (ma == Material.IRON_INGOT) {
            return "铁锭";
        } else if (ma == Material.GOLD_INGOT) {
            return "金锭";
        } else if (ma == Material.IRON_SWORD) {
            return "铁剑";
        } else if (ma == Material.WOOD_SWORD) {
            return "木剑";
        } else if (ma == Material.WOOD_SPADE) {
            return "木铲";
        } else if (ma == Material.WOOD_PICKAXE) {
            return "木镐";
        } else if (ma == Material.WOOD_AXE) {
            return "木斧";
        } else if (ma == Material.STONE_SWORD) {
            return "石剑";
        } else if (ma == Material.STONE_SPADE) {
            return "石铲";
        } else if (ma == Material.STONE_PICKAXE) {
            return "石镐";
        } else if (ma == Material.STONE_AXE) {
            return "石斧";
        } else if (ma == Material.DIAMOND_SWORD) {
            return "钻石剑";
        } else if (ma == Material.DIAMOND_SPADE) {
            return "金刚石铲";
        } else if (ma == Material.DIAMOND_PICKAXE) {
            return "金刚石镐";
        } else if (ma == Material.DIAMOND_AXE) {
            return "金刚石斧头";
        } else if (ma == Material.STICK) {
            return "棍子";
        } else if (ma == Material.BOWL) {
            return "碗";
        } else if (ma == Material.MUSHROOM_SOUP) {
            return "蘑菇汤";
        } else if (ma == Material.GOLD_SWORD) {
            return "金剑";
        } else if (ma == Material.GOLD_SPADE) {
            return "金铲";
        } else if (ma == Material.GOLD_PICKAXE) {
            return "金镐";
        } else if (ma == Material.GOLD_AXE) {
            return "金斧";
        } else if (ma == Material.STRING) {
            return "字符串";
        } else if (ma == Material.FEATHER) {
            return "羽毛";
        } else if (ma == Material.SULPHUR) {
            return "硫磺";
        } else if (ma == Material.WOOD_HOE) {
            return "木锄";
        } else if (ma == Material.STONE_HOE) {
            return "石锄";
        } else if (ma == Material.IRON_HOE) {
            return "铁制锄头";
        } else if (ma == Material.DIAMOND_HOE) {
            return "金刚石锄头";
        } else if (ma == Material.GOLD_HOE) {
            return "金锄";
        } else if (ma == Material.SEEDS) {
            return "种子";
        } else if (ma == Material.WHEAT) {
            return "小麦";
        } else if (ma == Material.BREAD) {
            return "面包";
        } else if (ma == Material.LEATHER_HELMET) {
            return "皮头盔";
        } else if (ma == Material.LEATHER_CHESTPLATE) {
            return "皮箱板";
        } else if (ma == Material.LEATHER_LEGGINGS) {
            return "皮革紧身裤";
        } else if (ma == Material.LEATHER_BOOTS) {
            return "皮靴";
        } else if (ma == Material.CHAINMAIL_HELMET) {
            return "链式头盔";
        } else if (ma == Material.CHAINMAIL_CHESTPLATE) {
            return "链式信箱";
        } else if (ma == Material.CHAINMAIL_LEGGINGS) {
            return "链式绑腿";
        } else if (ma == Material.CHAINMAIL_BOOTS) {
            return "链锁靴";
        } else if (ma == Material.IRON_HELMET) {
            return "铁盔";
        } else if (ma == Material.IRON_CHESTPLATE) {
            return "铁制胸板";
        } else if (ma == Material.IRON_LEGGINGS) {
            return "铁绑腿";
        } else if (ma == Material.IRON_BOOTS) {
            return "铁靴";
        } else if (ma == Material.DIAMOND_HELMET) {
            return "钻石头盔";
        } else if (ma == Material.DIAMOND_CHESTPLATE) {
            return "菱形胸板";
        } else if (ma == Material.DIAMOND_LEGGINGS) {
            return "钻石紧身裤";
        } else if (ma == Material.DIAMOND_BOOTS) {
            return "钻石靴";
        } else if (ma == Material.GOLD_HELMET) {
            return "金盔";
        } else if (ma == Material.GOLD_CHESTPLATE) {
            return "金胸板";
        } else if (ma == Material.GOLD_LEGGINGS) {
            return "金色紧身裤";
        } else if (ma == Material.GOLD_BOOTS) {
            return "金靴";
        } else if (ma == Material.FLINT) {
            return "打火石";
        } else if (ma == Material.PORK) {
            return "猪肉";
        } else if (ma == Material.GRILLED_PORK) {
            return "烤猪肉";
        } else if (ma == Material.PAINTING) {
            return "绘画";
        } else if (ma == Material.GOLDEN_APPLE) {
            return "金苹果";
        } else if (ma == Material.SIGN) {
            return "标志";
        } else if (ma == Material.WOOD_DOOR) {
            return "木门";
        } else if (ma == Material.BUCKET) {
            return "铲斗";
        } else if (ma == Material.WATER_BUCKET) {
            return "水桶";
        } else if (ma == Material.LAVA_BUCKET) {
            return "熔岩桶";
        } else if (ma == Material.MINECART) {
            return "地雷车";
        } else if (ma == Material.SADDLE) {
            return "马鞍";
        } else if (ma == Material.IRON_DOOR) {
            return "铁门";
        } else if (ma == Material.REDSTONE) {
            return "红石";
        } else if (ma == Material.SNOW_BALL) {
            return "雪球";
        } else if (ma == Material.BOAT) {
            return "船";
        } else if (ma == Material.LEATHER) {
            return "皮革";
        } else if (ma == Material.MILK_BUCKET) {
            return "牛奶桶";
        } else if (ma == Material.CLAY_BRICK) {
            return "粘土砖";
        } else if (ma == Material.CLAY_BALL) {
            return "粘土球";
        } else if (ma == Material.SUGAR_CANE) {
            return "甘蔗";
        } else if (ma == Material.PAPER) {
            return "纸张";
        } else if (ma == Material.BOOK) {
            return "书";
        } else if (ma == Material.SLIME_BALL) {
            return "粘液球";
        } else if (ma == Material.STORAGE_MINECART) {
            return "储存地雷车";
        } else if (ma == Material.POWERED_MINECART) {
            return "动力矿车";
        } else if (ma == Material.EGG) {
            return "鸡蛋";
        } else if (ma == Material.COMPASS) {
            return "指南针";
        } else if (ma == Material.FISHING_ROD) {
            return "钓鱼竿";
        } else if (ma == Material.WATCH) {
            return "观察";
        } else if (ma == Material.GLOWSTONE_DUST) {
            return "辉石粉尘";
        } else if (ma == Material.RAW_FISH) {
            return "生鱼";
        } else if (ma == Material.COOKED_FISH) {
            return "熟鱼";
        } else if (ma == Material.INK_SACK) {
            return "墨水袋";
        } else if (ma == Material.BONE) {
            return "骨头";
        } else if (ma == Material.SUGAR) {
            return "糖";
        } else if (ma == Material.CAKE) {
            return "蛋糕";
        } else if (ma == Material.BED) {
            return "床";
        } else if (ma == Material.DIODE) {
            return "二极管";
        } else if (ma == Material.COOKIE) {
            return "曲奇";
        } else if (ma == Material.MAP) {
            return "地图";
        } else if (ma == Material.SHEARS) {
            return "剪刀";
        } else if (ma == Material.MELON) {
            return "甜瓜";
        } else if (ma == Material.PUMPKIN_SEEDS) {
            return "南瓜子";
        } else if (ma == Material.MELON_SEEDS) {
            return "瓜子";
        } else if (ma == Material.RAW_BEEF) {
            return "生牛肉";
        } else if (ma == Material.COOKED_BEEF) {
            return "熟牛肉";
        } else if (ma == Material.RAW_CHICKEN) {
            return "生鸡肉";
        } else if (ma == Material.COOKED_CHICKEN) {
            return "熟鸡肉";
        } else if (ma == Material.ROTTEN_FLESH) {
            return "腐烂的肉";
        } else if (ma == Material.ENDER_PEARL) {
            return "安德珍珠";
        } else if (ma == Material.BLAZE_ROD) {
            return "燃烧棒";
        } else if (ma == Material.GHAST_TEAR) {
            return "恶魂之泪";
        } else if (ma == Material.GOLD_NUGGET) {
            return "金块";
        } else if (ma == Material.NETHER_STALK) {
            return "下茎";
        } else if (ma == Material.POTION) {
            return "一剂";
        } else if (ma == Material.GLASS_BOTTLE) {
            return "玻璃瓶";
        } else if (ma == Material.SPIDER_EYE) {
            return "蜘蛛眼";
        } else if (ma == Material.FERMENTED_SPIDER_EYE) {
            return "发酵蜘蛛眼";
        } else if (ma == Material.BLAZE_POWDER) {
            return "火焰粉";
        } else if (ma == Material.MAGMA_CREAM) {
            return "岩浆霜";
        } else if (ma == Material.BREWING_STAND_ITEM) {
            return "酿造台项目";
        } else if (ma == Material.CAULDRON_ITEM) {
            return "大锅物品";
        } else if (ma == Material.EYE_OF_ENDER) {
            return "安德之眼";
        } else if (ma == Material.SPECKLED_MELON) {
            return "闪烁的西瓜";
        } else if (ma == Material.MONSTER_EGG) {
            return "僵尸蛋";
        } else if (ma == Material.EXP_BOTTLE) {
            return "经验瓶";
        } else if (ma == Material.FIREBALL) {
            return "火球";
        } else if (ma == Material.BOOK_AND_QUILL) {
            return "书和羽毛笔";
        } else if (ma == Material.WRITTEN_BOOK) {
            return "书写本";
        } else if (ma == Material.EMERALD) {
            return "翡翠的";
        } else if (ma == Material.ITEM_FRAME) {
            return "项目框架";
        } else if (ma == Material.FLOWER_POT_ITEM) {
            return "花盆物品";
        } else if (ma == Material.CARROT_ITEM) {
            return "胡萝卜菜";
        } else if (ma == Material.POTATO_ITEM) {
            return "马铃薯项目";
        } else if (ma == Material.BAKED_POTATO) {
            return "烤土豆";
        } else if (ma == Material.POISONOUS_POTATO) {
            return "毒土豆";
        } else if (ma == Material.EMPTY_MAP) {
            return "空地图";
        } else if (ma == Material.GOLDEN_CARROT) {
            return "金胡萝卜";
        } else if (ma == Material.SKULL_ITEM) {
            return "头骨项目";
        } else if (ma == Material.CARROT_STICK) {
            return "胡萝卜钓竿";
        } else if (ma == Material.NETHER_STAR) {
            return "下界之星";
        } else if (ma == Material.PUMPKIN_PIE) {
            return "南瓜派";
        } else if (ma == Material.FIREWORK) {
            return "烟花";
        } else if (ma == Material.FIREWORK_CHARGE) {
            return "烟花爆竹费";
        } else if (ma == Material.ENCHANTED_BOOK) {
            return "附魔书";
        } else if (ma == Material.REDSTONE_COMPARATOR) {
            return "红石比较器";
        } else if (ma == Material.NETHER_BRICK_ITEM) {
            return "地狱砖块";
        } else if (ma == Material.QUARTZ) {
            return "石英";
        } else if (ma == Material.EXPLOSIVE_MINECART) {
            return "TNT矿车";
        } else if (ma == Material.HOPPER_MINECART) {
            return "漏斗式矿车";
        } else if (ma == Material.PRISMARINE_SHARD) {
            return "棱柱体碎片";
        } else if (ma == Material.PRISMARINE_CRYSTALS) {
            return "棱柱状晶体";
        } else if (ma == Material.RABBIT) {
            return "兔子";
        } else if (ma == Material.COOKED_RABBIT) {
            return "熟兔肉";
        } else if (ma == Material.RABBIT_STEW) {
            return "兔肉煲";
        } else if (ma == Material.RABBIT_FOOT) {
            return "兔子脚";
        } else if (ma == Material.RABBIT_HIDE) {
            return "兔子皮";
        } else if (ma == Material.ARMOR_STAND) {
            return "盔甲架";
        } else if (ma == Material.IRON_BARDING) {
            return "铁马铠";
        } else if (ma == Material.GOLD_BARDING) {
            return "金马铠";
        } else if (ma == Material.DIAMOND_BARDING) {
            return "钻石马铠";
        } else if (ma == Material.LEASH) {
            return "拴绳";
        } else if (ma == Material.NAME_TAG) {
            return "命名牌";
        } else if (ma == Material.COMMAND_MINECART) {
            return "命令方块矿车";
        } else if (ma == Material.MUTTON) {
            return "羊肉";
        } else if (ma == Material.COOKED_MUTTON) {
            return "熟羊肉";
        } else if (ma == Material.BANNER) {
            return "黑色旗帜";
        } else if (ma == Material.END_CRYSTAL) {
            return "末影水晶";
        } else if (ma == Material.SPRUCE_DOOR_ITEM) {
            return "云杉木门";
        } else if (ma == Material.BIRCH_DOOR_ITEM) {
            return "白桦木门";
        } else if (ma == Material.JUNGLE_DOOR_ITEM) {
            return "丛林木门";
        } else if (ma == Material.ACACIA_DOOR_ITEM) {
            return "金合欢木门";
        } else if (ma == Material.DARK_OAK_DOOR_ITEM) {
            return "深色橡木门";
        } else if (ma == Material.CHORUS_FRUIT) {
            return "紫颂果";
        } else if (ma == Material.CHORUS_FRUIT_POPPED) {
            return "爆裂紫颂果";
        } else if (ma == Material.BEETROOT) {
            return "甜菜根";
        } else if (ma == Material.BEETROOT_SEEDS) {
            return "甜菜种子";
        } else if (ma == Material.BEETROOT_SOUP) {
            return "甜菜汤";
        } else if (ma == Material.DRAGONS_BREATH) {
            return "龙息";
        } else if (ma == Material.SPLASH_POTION) {
            return "喷溅药水";
        } else if (ma == Material.SPECTRAL_ARROW) {
            return "光灵箭";
        } else if (ma == Material.TIPPED_ARROW) {
            return "喷射之箭";
        } else if (ma == Material.LINGERING_POTION) {
            return "滞留药水";
        } else if (ma == Material.SHIELD) {
            return "盾牌";
        } else if (ma == Material.ELYTRA) {
            return "鞘翅";
        } else if (ma == Material.BOAT_SPRUCE) {
            return "云杉木船";
        } else if (ma == Material.BOAT_BIRCH) {
            return "白桦木船";
        } else if (ma == Material.BOAT_JUNGLE) {
            return "丛林木船";
        } else if (ma == Material.BOAT_ACACIA) {
            return "金合欢木船";
        } else if (ma == Material.BOAT_DARK_OAK) {
            return "深色橡木船";
        } else if (ma == Material.TOTEM) {
            return "不死图腾";
        } else if (ma == Material.SHULKER_SHELL) {
            return "潜影壳";
        } else if (ma == Material.IRON_NUGGET) {
            return "铁块";
        } else if (ma == Material.KNOWLEDGE_BOOK) {
            return "知识书";
        } else if (ma == Material.GOLD_RECORD) {
            return "黄金唱片";
        } else if (ma == Material.GREEN_RECORD) {
            return "绿色记录";
        } else if (ma == Material.RECORD_3) {
            return "音乐唱片";
        } else if (ma == Material.RECORD_4) {
            return "音乐唱片";
        } else if (ma == Material.RECORD_5) {
            return "音乐唱片";
        } else if (ma == Material.RECORD_6) {
            return "音乐唱片";
        } else if (ma == Material.RECORD_7) {
            return "音乐唱片";
        } else if (ma == Material.RECORD_8) {
            return "音乐唱片";
        } else if (ma == Material.RECORD_9) {
            return "音乐唱片";
        } else if (ma == Material.RECORD_10) {
            return "音乐唱片";
        } else if (ma == Material.RECORD_11) {
            return "音乐唱片";
        } else {
            return ma == Material.RECORD_12 ? "记录12" : ma.toString();
        }
    }

    public static String clientName(Material ma) {
        if (ma == Material.AIR) {
            return "air";
        } else if (ma == Material.STONE) {
            return "stone";
        } else if (ma == Material.GRASS) {
            return "grass";
        } else if (ma == Material.DIRT) {
            return "dirt";
        } else if (ma == Material.COBBLESTONE) {
            return "cobblestone";
        } else if (ma == Material.WOOD) {
            return "planks";
        } else if (ma == Material.SAPLING) {
            return "sapling";
        } else if (ma == Material.BEDROCK) {
            return "bedrock";
        } else if (ma == Material.SAND) {
            return "sand";
        } else if (ma == Material.GRAVEL) {
            return "gravel";
        } else if (ma == Material.GOLD_ORE) {
            return "gold_ore";
        } else if (ma == Material.IRON_ORE) {
            return "iron_ore";
        } else if (ma == Material.COAL_ORE) {
            return "coal_ore";
        } else if (ma == Material.LOG) {
            return "log";
        } else if (ma == Material.LEAVES) {
            return "leaves";
        } else if (ma == Material.SPONGE) {
            return "sponge";
        } else if (ma == Material.GLASS) {
            return "glass";
        } else if (ma == Material.LAPIS_ORE) {
            return "lapis_ore";
        } else if (ma == Material.LAPIS_BLOCK) {
            return "lapis_block";
        } else if (ma == Material.DISPENSER) {
            return "dispenser";
        } else if (ma == Material.SANDSTONE) {
            return "sandstone";
        } else if (ma == Material.NOTE_BLOCK) {
            return "noteblock";
        } else if (ma == Material.POWERED_RAIL) {
            return "golden_rail";
        } else if (ma == Material.DETECTOR_RAIL) {
            return "detector_rail";
        } else if (ma == Material.PISTON_STICKY_BASE) {
            return "sticky_piston";
        } else if (ma == Material.WEB) {
            return "web";
        } else if (ma == Material.LONG_GRASS) {
            return "tallgrass";
        } else if (ma == Material.DEAD_BUSH) {
            return "deadbush";
        } else if (ma == Material.PISTON_BASE) {
            return "piston";
        } else if (ma == Material.WOOL) {
            return "wool";
        } else if (ma == Material.YELLOW_FLOWER) {
            return "yellow_flower";
        } else if (ma == Material.RED_ROSE) {
            return "red_flower";
        } else if (ma == Material.BROWN_MUSHROOM) {
            return "brown_mushroom";
        } else if (ma == Material.RED_MUSHROOM) {
            return "red_mushroom";
        } else if (ma == Material.GOLD_BLOCK) {
            return "gold_block";
        } else if (ma == Material.IRON_BLOCK) {
            return "iron_block";
        } else if (ma == Material.STEP) {
            return "stone_slab";
        } else if (ma == Material.BRICK) {
            return "brick_block";
        } else if (ma == Material.TNT) {
            return "tnt";
        } else if (ma == Material.BOOKSHELF) {
            return "bookshelf";
        } else if (ma == Material.MOSSY_COBBLESTONE) {
            return "mossy_cobblestone";
        } else if (ma == Material.OBSIDIAN) {
            return "obsidian";
        } else if (ma == Material.TORCH) {
            return "torch";
        } else if (ma == Material.MOB_SPAWNER) {
            return "mob_spawner";
        } else if (ma == Material.WOOD_STAIRS) {
            return "oak_stairs";
        } else if (ma == Material.CHEST) {
            return "chest";
        } else if (ma == Material.DIAMOND_ORE) {
            return "diamond_ore";
        } else if (ma == Material.DIAMOND_BLOCK) {
            return "diamond_block";
        } else if (ma == Material.WORKBENCH) {
            return "crafting_table";
        } else if (ma == Material.SOIL) {
            return "farmland";
        } else if (ma == Material.FURNACE) {
            return "furnace";
        } else if (ma == Material.LADDER) {
            return "ladder";
        } else if (ma == Material.RAILS) {
            return "rail";
        } else if (ma == Material.COBBLESTONE_STAIRS) {
            return "stone_stairs";
        } else if (ma == Material.LEVER) {
            return "lever";
        } else if (ma == Material.STONE_PLATE) {
            return "stone_pressure_plate";
        } else if (ma == Material.WOOD_PLATE) {
            return "wooden_pressure_plate";
        } else if (ma == Material.REDSTONE_ORE) {
            return "redstone_ore";
        } else if (ma == Material.REDSTONE_TORCH_ON) {
            return "redstone_torch";
        } else if (ma == Material.STONE_BUTTON) {
            return "stone_button";
        } else if (ma == Material.SNOW) {
            return "snow_layer";
        } else if (ma == Material.ICE) {
            return "ice";
        } else if (ma == Material.SNOW_BLOCK) {
            return "snow";
        } else if (ma == Material.CACTUS) {
            return "cactus";
        } else if (ma == Material.CLAY) {
            return "clay";
        } else if (ma == Material.JUKEBOX) {
            return "jukebox";
        } else if (ma == Material.FENCE) {
            return "fence";
        } else if (ma == Material.PUMPKIN) {
            return "pumpkin";
        } else if (ma == Material.NETHERRACK) {
            return "netherrack";
        } else if (ma == Material.SOUL_SAND) {
            return "soul_sand";
        } else if (ma == Material.GLOWSTONE) {
            return "glowstone";
        } else if (ma == Material.JACK_O_LANTERN) {
            return "lit_pumpkin";
        } else if (ma == Material.STAINED_GLASS) {
            return "stained_glass";
        } else if (ma == Material.TRAP_DOOR) {
            return "trapdoor";
        } else if (ma == Material.MONSTER_EGGS) {
            return "monster_egg";
        } else if (ma == Material.SMOOTH_BRICK) {
            return "stonebrick";
        } else if (ma == Material.HUGE_MUSHROOM_1) {
            return "brown_mushroom_block";
        } else if (ma == Material.HUGE_MUSHROOM_2) {
            return "red_mushroom_block";
        } else if (ma == Material.IRON_FENCE) {
            return "iron_bars";
        } else if (ma == Material.THIN_GLASS) {
            return "glass_pane";
        } else if (ma == Material.MELON_BLOCK) {
            return "melon_block";
        } else if (ma == Material.VINE) {
            return "vine";
        } else if (ma == Material.FENCE_GATE) {
            return "fence_gate";
        } else if (ma == Material.BRICK_STAIRS) {
            return "brick_stairs";
        } else if (ma == Material.SMOOTH_STAIRS) {
            return "stone_brick_stairs";
        } else if (ma == Material.MYCEL) {
            return "mycelium";
        } else if (ma == Material.WATER_LILY) {
            return "waterlily";
        } else if (ma == Material.NETHER_BRICK) {
            return "nether_brick";
        } else if (ma == Material.NETHER_FENCE) {
            return "nether_brick_fence";
        } else if (ma == Material.NETHER_BRICK_STAIRS) {
            return "nether_brick_stairs";
        } else if (ma == Material.ENCHANTMENT_TABLE) {
            return "enchanting_table";
        } else if (ma == Material.ENDER_PORTAL_FRAME) {
            return "end_portal_frame";
        } else if (ma == Material.ENDER_STONE) {
            return "end_stone";
        } else if (ma == Material.DRAGON_EGG) {
            return "dragon_egg";
        } else if (ma == Material.REDSTONE_LAMP_OFF) {
            return "redstone_lamp";
        } else if (ma == Material.WOOD_STEP) {
            return "wooden_slab";
        } else if (ma == Material.SANDSTONE_STAIRS) {
            return "sandstone_stairs";
        } else if (ma == Material.EMERALD_ORE) {
            return "emerald_ore";
        } else if (ma == Material.ENDER_CHEST) {
            return "ender_chest";
        } else if (ma == Material.TRIPWIRE_HOOK) {
            return "tripwire_hook";
        } else if (ma == Material.EMERALD_BLOCK) {
            return "emerald_block";
        } else if (ma == Material.SPRUCE_WOOD_STAIRS) {
            return "spruce_stairs";
        } else if (ma == Material.BIRCH_WOOD_STAIRS) {
            return "birch_stairs";
        } else if (ma == Material.JUNGLE_WOOD_STAIRS) {
            return "jungle_stairs";
        } else if (ma == Material.COMMAND) {
            return "command_block";
        } else if (ma == Material.BEACON) {
            return "beacon";
        } else if (ma == Material.COBBLE_WALL) {
            return "cobblestone_wall";
        } else if (ma == Material.WOOD_BUTTON) {
            return "wooden_button";
        } else if (ma == Material.ANVIL) {
            return "anvil";
        } else if (ma == Material.TRAPPED_CHEST) {
            return "trapped_chest";
        } else if (ma == Material.GOLD_PLATE) {
            return "light_weighted_pressure_plate";
        } else if (ma == Material.IRON_PLATE) {
            return "heavy_weighted_pressure_plate";
        } else if (ma == Material.DAYLIGHT_DETECTOR) {
            return "daylight_detector";
        } else if (ma == Material.REDSTONE_BLOCK) {
            return "redstone_block";
        } else if (ma == Material.QUARTZ_ORE) {
            return "quartz_ore";
        } else if (ma == Material.HOPPER) {
            return "hopper";
        } else if (ma == Material.QUARTZ_BLOCK) {
            return "quartz_block";
        } else if (ma == Material.QUARTZ_STAIRS) {
            return "quartz_stairs";
        } else if (ma == Material.ACTIVATOR_RAIL) {
            return "activator_rail";
        } else if (ma == Material.DROPPER) {
            return "dropper";
        } else if (ma == Material.STAINED_CLAY) {
            return "stained_hardened_clay";
        } else if (ma == Material.STAINED_GLASS_PANE) {
            return "stained_glass_pane";
        } else if (ma == Material.LEAVES_2) {
            return "leaves2";
        } else if (ma == Material.LOG_2) {
            return "log2";
        } else if (ma == Material.ACACIA_STAIRS) {
            return "acacia_stairs";
        } else if (ma == Material.DARK_OAK_STAIRS) {
            return "dark_oak_stairs";
        } else if (ma == Material.SLIME_BLOCK) {
            return "slime";
        } else if (ma == Material.BARRIER) {
            return "barrier";
        } else if (ma == Material.IRON_TRAPDOOR) {
            return "iron_trapdoor";
        } else if (ma == Material.PRISMARINE) {
            return "prismarine";
        } else if (ma == Material.SEA_LANTERN) {
            return "sea_lantern";
        } else if (ma == Material.HAY_BLOCK) {
            return "hay_block";
        } else if (ma == Material.CARPET) {
            return "carpet";
        } else if (ma == Material.HARD_CLAY) {
            return "hardened_clay";
        } else if (ma == Material.COAL_BLOCK) {
            return "coal_block";
        } else if (ma == Material.PACKED_ICE) {
            return "packed_ice";
        } else if (ma == Material.DOUBLE_PLANT) {
            return "double_plant";
        } else if (ma == Material.RED_SANDSTONE) {
            return "red_sandstone";
        } else if (ma == Material.RED_SANDSTONE_STAIRS) {
            return "red_sandstone_stairs";
        } else if (ma == Material.STONE_SLAB2) {
            return "stone_slab2";
        } else if (ma == Material.SPRUCE_FENCE_GATE) {
            return "spruce_fence_gate";
        } else if (ma == Material.BIRCH_FENCE_GATE) {
            return "birch_fence_gate";
        } else if (ma == Material.JUNGLE_FENCE_GATE) {
            return "jungle_fence_gate";
        } else if (ma == Material.DARK_OAK_FENCE_GATE) {
            return "dark_oak_fence_gate";
        } else if (ma == Material.ACACIA_FENCE_GATE) {
            return "acacia_fence_gate";
        } else if (ma == Material.SPRUCE_FENCE) {
            return "spruce_fence";
        } else if (ma == Material.BIRCH_FENCE) {
            return "birch_fence";
        } else if (ma == Material.JUNGLE_FENCE) {
            return "jungle_fence";
        } else if (ma == Material.DARK_OAK_FENCE) {
            return "dark_oak_fence";
        } else if (ma == Material.ACACIA_FENCE) {
            return "acacia_fence";
        } else if (ma == Material.END_ROD) {
            return "end_rod";
        } else if (ma == Material.CHORUS_PLANT) {
            return "chorus_plant";
        } else if (ma == Material.CHORUS_FLOWER) {
            return "chorus_flower";
        } else if (ma == Material.PURPUR_BLOCK) {
            return "purpur_block";
        } else if (ma == Material.PURPUR_PILLAR) {
            return "purpur_pillar";
        } else if (ma == Material.PURPUR_STAIRS) {
            return "purpur_stairs";
        } else if (ma == Material.PURPUR_SLAB) {
            return "purpur_slab";
        } else if (ma == Material.END_BRICKS) {
            return "end_bricks";
        } else if (ma == Material.GRASS_PATH) {
            return "grass_path";
        } else if (ma == Material.COMMAND_REPEATING) {
            return "repeating_command_block";
        } else if (ma == Material.COMMAND_CHAIN) {
            return "chain_command_block";
        } else if (ma == Material.MAGMA) {
            return "magma";
        } else if (ma == Material.NETHER_WART_BLOCK) {
            return "nether_wart_block";
        } else if (ma == Material.RED_NETHER_BRICK) {
            return "red_nether_brick";
        } else if (ma == Material.BONE_BLOCK) {
            return "bone_block";
        } else if (ma == Material.STRUCTURE_VOID) {
            return "structure_void";
        } else if (ma == Material.OBSERVER) {
            return "observer";
        } else if (ma == Material.WHITE_SHULKER_BOX) {
            return "white_shulker_box";
        } else if (ma == Material.ORANGE_SHULKER_BOX) {
            return "orange_shulker_box";
        } else if (ma == Material.MAGENTA_SHULKER_BOX) {
            return "magenta_shulker_box";
        } else if (ma == Material.LIGHT_BLUE_SHULKER_BOX) {
            return "light_blue_shulker_box";
        } else if (ma == Material.YELLOW_SHULKER_BOX) {
            return "yellow_shulker_box";
        } else if (ma == Material.LIME_SHULKER_BOX) {
            return "lime_shulker_box";
        } else if (ma == Material.PINK_SHULKER_BOX) {
            return "pink_shulker_box";
        } else if (ma == Material.GRAY_SHULKER_BOX) {
            return "gray_shulker_box";
        } else if (ma == Material.SILVER_SHULKER_BOX) {
            return "silver_shulker_box";
        } else if (ma == Material.CYAN_SHULKER_BOX) {
            return "cyan_shulker_box";
        } else if (ma == Material.PURPLE_SHULKER_BOX) {
            return "purple_shulker_box";
        } else if (ma == Material.BLUE_SHULKER_BOX) {
            return "blue_shulker_box";
        } else if (ma == Material.BROWN_SHULKER_BOX) {
            return "brown_shulker_box";
        } else if (ma == Material.GREEN_SHULKER_BOX) {
            return "green_shulker_box";
        } else if (ma == Material.RED_SHULKER_BOX) {
            return "red_shulker_box";
        } else if (ma == Material.BLACK_SHULKER_BOX) {
            return "black_shulker_box";
        } else if (ma == Material.WHITE_GLAZED_TERRACOTTA) {
            return "white_glazed_terracotta";
        } else if (ma == Material.ORANGE_GLAZED_TERRACOTTA) {
            return "orange_glazed_terracotta";
        } else if (ma == Material.MAGENTA_GLAZED_TERRACOTTA) {
            return "magenta_glazed_terracotta";
        } else if (ma == Material.LIGHT_BLUE_GLAZED_TERRACOTTA) {
            return "light_blue_glazed_terracotta";
        } else if (ma == Material.YELLOW_GLAZED_TERRACOTTA) {
            return "yellow_glazed_terracotta";
        } else if (ma == Material.LIME_GLAZED_TERRACOTTA) {
            return "lime_glazed_terracotta";
        } else if (ma == Material.PINK_GLAZED_TERRACOTTA) {
            return "pink_glazed_terracotta";
        } else if (ma == Material.GRAY_GLAZED_TERRACOTTA) {
            return "gray_glazed_terracotta";
        } else if (ma == Material.SILVER_GLAZED_TERRACOTTA) {
            return "silver_glazed_terracotta";
        } else if (ma == Material.CYAN_GLAZED_TERRACOTTA) {
            return "cyan_glazed_terracotta";
        } else if (ma == Material.PURPLE_GLAZED_TERRACOTTA) {
            return "purple_glazed_terracotta";
        } else if (ma == Material.BLUE_GLAZED_TERRACOTTA) {
            return "blue_glazed_terracotta";
        } else if (ma == Material.BROWN_GLAZED_TERRACOTTA) {
            return "brown_glazed_terracotta";
        } else if (ma == Material.GREEN_GLAZED_TERRACOTTA) {
            return "green_glazed_terracotta";
        } else if (ma == Material.RED_GLAZED_TERRACOTTA) {
            return "red_glazed_terracotta";
        } else if (ma == Material.BLACK_GLAZED_TERRACOTTA) {
            return "black_glazed_terracotta";
        } else if (ma == Material.CONCRETE) {
            return "concrete";
        } else if (ma == Material.CONCRETE_POWDER) {
            return "concrete_powder";
        } else if (ma == Material.STRUCTURE_BLOCK) {
            return "structure_block";
        } else if (ma == Material.IRON_SPADE) {
            return "iron_shovel";
        } else if (ma == Material.IRON_PICKAXE) {
            return "iron_pickaxe";
        } else if (ma == Material.IRON_AXE) {
            return "iron_axe";
        } else if (ma == Material.FLINT_AND_STEEL) {
            return "flint_and_steel";
        } else if (ma == Material.APPLE) {
            return "apple";
        } else if (ma == Material.BOW) {
            return "bow";
        } else if (ma == Material.ARROW) {
            return "arrow";
        } else if (ma == Material.COAL) {
            return "coal";
        } else if (ma == Material.DIAMOND) {
            return "diamond";
        } else if (ma == Material.IRON_INGOT) {
            return "iron_ingot";
        } else if (ma == Material.GOLD_INGOT) {
            return "gold_ingot";
        } else if (ma == Material.IRON_SWORD) {
            return "iron_sword";
        } else if (ma == Material.WOOD_SWORD) {
            return "wooden_sword";
        } else if (ma == Material.WOOD_SPADE) {
            return "wooden_shovel";
        } else if (ma == Material.WOOD_PICKAXE) {
            return "wooden_pickaxe";
        } else if (ma == Material.WOOD_AXE) {
            return "wooden_axe";
        } else if (ma == Material.STONE_SWORD) {
            return "stone_sword";
        } else if (ma == Material.STONE_SPADE) {
            return "stone_shovel";
        } else if (ma == Material.STONE_PICKAXE) {
            return "stone_pickaxe";
        } else if (ma == Material.STONE_AXE) {
            return "stone_axe";
        } else if (ma == Material.DIAMOND_SWORD) {
            return "diamond_sword";
        } else if (ma == Material.DIAMOND_SPADE) {
            return "diamond_shovel";
        } else if (ma == Material.DIAMOND_PICKAXE) {
            return "diamond_pickaxe";
        } else if (ma == Material.DIAMOND_AXE) {
            return "diamond_axe";
        } else if (ma == Material.STICK) {
            return "stick";
        } else if (ma == Material.BOWL) {
            return "bowl";
        } else if (ma == Material.MUSHROOM_SOUP) {
            return "mushroom_stew";
        } else if (ma == Material.GOLD_SWORD) {
            return "golden_sword";
        } else if (ma == Material.GOLD_SPADE) {
            return "golden_shovel";
        } else if (ma == Material.GOLD_PICKAXE) {
            return "golden_pickaxe";
        } else if (ma == Material.GOLD_AXE) {
            return "golden_axe";
        } else if (ma == Material.STRING) {
            return "string";
        } else if (ma == Material.FEATHER) {
            return "feather";
        } else if (ma == Material.SULPHUR) {
            return "gunpowder";
        } else if (ma == Material.WOOD_HOE) {
            return "wooden_hoe";
        } else if (ma == Material.STONE_HOE) {
            return "stone_hoe";
        } else if (ma == Material.IRON_HOE) {
            return "iron_hoe";
        } else if (ma == Material.DIAMOND_HOE) {
            return "diamond_hoe";
        } else if (ma == Material.GOLD_HOE) {
            return "golden_hoe";
        } else if (ma == Material.SEEDS) {
            return "wheat_seeds";
        } else if (ma == Material.WHEAT) {
            return "wheat";
        } else if (ma == Material.BREAD) {
            return "bread";
        } else if (ma == Material.LEATHER_HELMET) {
            return "leather_helmet";
        } else if (ma == Material.LEATHER_CHESTPLATE) {
            return "leather_chestplate";
        } else if (ma == Material.LEATHER_LEGGINGS) {
            return "leather_leggings";
        } else if (ma == Material.LEATHER_BOOTS) {
            return "leather_boots";
        } else if (ma == Material.CHAINMAIL_HELMET) {
            return "chainmail_helmet";
        } else if (ma == Material.CHAINMAIL_CHESTPLATE) {
            return "chainmail_chestplate";
        } else if (ma == Material.CHAINMAIL_LEGGINGS) {
            return "chainmail_leggings";
        } else if (ma == Material.CHAINMAIL_BOOTS) {
            return "chainmail_boots";
        } else if (ma == Material.IRON_HELMET) {
            return "iron_helmet";
        } else if (ma == Material.IRON_CHESTPLATE) {
            return "iron_chestplate";
        } else if (ma == Material.IRON_LEGGINGS) {
            return "iron_leggings";
        } else if (ma == Material.IRON_BOOTS) {
            return "iron_boots";
        } else if (ma == Material.DIAMOND_HELMET) {
            return "diamond_helmet";
        } else if (ma == Material.DIAMOND_CHESTPLATE) {
            return "diamond_chestplate";
        } else if (ma == Material.DIAMOND_LEGGINGS) {
            return "diamond_leggings";
        } else if (ma == Material.DIAMOND_BOOTS) {
            return "diamond_boots";
        } else if (ma == Material.GOLD_HELMET) {
            return "golden_helmet";
        } else if (ma == Material.GOLD_CHESTPLATE) {
            return "golden_chestplate";
        } else if (ma == Material.GOLD_LEGGINGS) {
            return "golden_leggings";
        } else if (ma == Material.GOLD_BOOTS) {
            return "golden_boots";
        } else if (ma == Material.FLINT) {
            return "flint";
        } else if (ma == Material.PORK) {
            return "porkchop";
        } else if (ma == Material.GRILLED_PORK) {
            return "cooked_porkchop";
        } else if (ma == Material.PAINTING) {
            return "painting";
        } else if (ma == Material.GOLDEN_APPLE) {
            return "golden_apple";
        } else if (ma == Material.SIGN) {
            return "sign";
        } else if (ma == Material.WOOD_DOOR) {
            return "wooden_door";
        } else if (ma == Material.BUCKET) {
            return "bucket";
        } else if (ma == Material.WATER_BUCKET) {
            return "water_bucket";
        } else if (ma == Material.LAVA_BUCKET) {
            return "lava_bucket";
        } else if (ma == Material.MINECART) {
            return "minecart";
        } else if (ma == Material.SADDLE) {
            return "saddle";
        } else if (ma == Material.IRON_DOOR) {
            return "iron_door";
        } else if (ma == Material.REDSTONE) {
            return "redstone";
        } else if (ma == Material.SNOW_BALL) {
            return "snowball";
        } else if (ma == Material.BOAT) {
            return "boat";
        } else if (ma == Material.LEATHER) {
            return "leather";
        } else if (ma == Material.MILK_BUCKET) {
            return "milk_bucket";
        } else if (ma == Material.CLAY_BRICK) {
            return "brick";
        } else if (ma == Material.CLAY_BALL) {
            return "clay_ball";
        } else if (ma == Material.SUGAR_CANE) {
            return "reeds";
        } else if (ma == Material.PAPER) {
            return "paper";
        } else if (ma == Material.BOOK) {
            return "book";
        } else if (ma == Material.SLIME_BALL) {
            return "slime_ball";
        } else if (ma == Material.STORAGE_MINECART) {
            return "chest_minecart";
        } else if (ma == Material.POWERED_MINECART) {
            return "furnace_minecart";
        } else if (ma == Material.EGG) {
            return "egg";
        } else if (ma == Material.COMPASS) {
            return "compass";
        } else if (ma == Material.FISHING_ROD) {
            return "fishing_rod";
        } else if (ma == Material.WATCH) {
            return "clock";
        } else if (ma == Material.GLOWSTONE_DUST) {
            return "glowstone_dust";
        } else if (ma == Material.RAW_FISH) {
            return "fish";
        } else if (ma == Material.COOKED_FISH) {
            return "cooked_fish";
        } else if (ma == Material.INK_SACK) {
            return "dye";
        } else if (ma == Material.BONE) {
            return "bone";
        } else if (ma == Material.SUGAR) {
            return "sugar";
        } else if (ma == Material.CAKE) {
            return "cake";
        } else if (ma == Material.BED) {
            return "bed";
        } else if (ma == Material.DIODE) {
            return "repeater";
        } else if (ma == Material.COOKIE) {
            return "cookie";
        } else if (ma == Material.MAP) {
            return "filled_map";
        } else if (ma == Material.SHEARS) {
            return "shears";
        } else if (ma == Material.MELON) {
            return "melon";
        } else if (ma == Material.PUMPKIN_SEEDS) {
            return "pumpkin_seeds";
        } else if (ma == Material.MELON_SEEDS) {
            return "melon_seeds";
        } else if (ma == Material.RAW_BEEF) {
            return "beef";
        } else if (ma == Material.COOKED_BEEF) {
            return "cooked_beef";
        } else if (ma == Material.RAW_CHICKEN) {
            return "chicken";
        } else if (ma == Material.COOKED_CHICKEN) {
            return "cooked_chicken";
        } else if (ma == Material.ROTTEN_FLESH) {
            return "rotten_flesh";
        } else if (ma == Material.ENDER_PEARL) {
            return "ender_pearl";
        } else if (ma == Material.BLAZE_ROD) {
            return "blaze_rod";
        } else if (ma == Material.GHAST_TEAR) {
            return "ghast_tear";
        } else if (ma == Material.GOLD_NUGGET) {
            return "gold_nugget";
        } else if (ma == Material.NETHER_STALK) {
            return "nether_wart";
        } else if (ma == Material.POTION) {
            return "potion";
        } else if (ma == Material.GLASS_BOTTLE) {
            return "glass_bottle";
        } else if (ma == Material.SPIDER_EYE) {
            return "spider_eye";
        } else if (ma == Material.FERMENTED_SPIDER_EYE) {
            return "fermented_spider_eye";
        } else if (ma == Material.BLAZE_POWDER) {
            return "blaze_powder";
        } else if (ma == Material.MAGMA_CREAM) {
            return "magma_cream";
        } else if (ma == Material.BREWING_STAND_ITEM) {
            return "brewing_stand";
        } else if (ma == Material.CAULDRON_ITEM) {
            return "cauldron";
        } else if (ma == Material.EYE_OF_ENDER) {
            return "ender_eye";
        } else if (ma == Material.SPECKLED_MELON) {
            return "speckled_melon";
        } else if (ma == Material.MONSTER_EGG) {
            return "spawn_egg";
        } else if (ma == Material.EXP_BOTTLE) {
            return "experience_bottle";
        } else if (ma == Material.FIREBALL) {
            return "fire_charge";
        } else if (ma == Material.BOOK_AND_QUILL) {
            return "writable_book";
        } else if (ma == Material.WRITTEN_BOOK) {
            return "written_book";
        } else if (ma == Material.EMERALD) {
            return "emerald";
        } else if (ma == Material.ITEM_FRAME) {
            return "item_frame";
        } else if (ma == Material.FLOWER_POT_ITEM) {
            return "flower_pot";
        } else if (ma == Material.CARROT_ITEM) {
            return "carrot";
        } else if (ma == Material.POTATO_ITEM) {
            return "potato";
        } else if (ma == Material.BAKED_POTATO) {
            return "baked_potato";
        } else if (ma == Material.POISONOUS_POTATO) {
            return "poisonous_potato";
        } else if (ma == Material.EMPTY_MAP) {
            return "map";
        } else if (ma == Material.GOLDEN_CARROT) {
            return "golden_carrot";
        } else if (ma == Material.SKULL_ITEM) {
            return "skull";
        } else if (ma == Material.CARROT_STICK) {
            return "carrot_on_a_stick";
        } else if (ma == Material.NETHER_STAR) {
            return "nether_star";
        } else if (ma == Material.PUMPKIN_PIE) {
            return "pumpkin_pie";
        } else if (ma == Material.FIREWORK) {
            return "fireworks";
        } else if (ma == Material.FIREWORK_CHARGE) {
            return "firework_charge";
        } else if (ma == Material.ENCHANTED_BOOK) {
            return "enchanted_book";
        } else if (ma == Material.REDSTONE_COMPARATOR) {
            return "comparator";
        } else if (ma == Material.NETHER_BRICK_ITEM) {
            return "netherbrick";
        } else if (ma == Material.QUARTZ) {
            return "quartz";
        } else if (ma == Material.EXPLOSIVE_MINECART) {
            return "tnt_minecart";
        } else if (ma == Material.HOPPER_MINECART) {
            return "hopper_minecart";
        } else if (ma == Material.PRISMARINE_SHARD) {
            return "prismarine_shard";
        } else if (ma == Material.PRISMARINE_CRYSTALS) {
            return "prismarine_crystals";
        } else if (ma == Material.RABBIT) {
            return "rabbit";
        } else if (ma == Material.COOKED_RABBIT) {
            return "cooked_rabbit";
        } else if (ma == Material.RABBIT_STEW) {
            return "rabbit_stew";
        } else if (ma == Material.RABBIT_FOOT) {
            return "rabbit_foot";
        } else if (ma == Material.RABBIT_HIDE) {
            return "rabbit_hide";
        } else if (ma == Material.ARMOR_STAND) {
            return "armor_stand";
        } else if (ma == Material.IRON_BARDING) {
            return "iron_horse_armor";
        } else if (ma == Material.GOLD_BARDING) {
            return "golden_horse_armor";
        } else if (ma == Material.DIAMOND_BARDING) {
            return "diamond_horse_armor";
        } else if (ma == Material.LEASH) {
            return "lead";
        } else if (ma == Material.NAME_TAG) {
            return "name_tag";
        } else if (ma == Material.COMMAND_MINECART) {
            return "command_block_minecart";
        } else if (ma == Material.MUTTON) {
            return "mutton";
        } else if (ma == Material.COOKED_MUTTON) {
            return "cooked_mutton";
        } else if (ma == Material.BANNER) {
            return "banner";
        } else if (ma == Material.END_CRYSTAL) {
            return "end_crystal";
        } else if (ma == Material.SPRUCE_DOOR_ITEM) {
            return "spruce_door";
        } else if (ma == Material.BIRCH_DOOR_ITEM) {
            return "birch_door";
        } else if (ma == Material.JUNGLE_DOOR_ITEM) {
            return "jungle_door";
        } else if (ma == Material.ACACIA_DOOR_ITEM) {
            return "acacia_door";
        } else if (ma == Material.DARK_OAK_DOOR_ITEM) {
            return "dark_oak_door";
        } else if (ma == Material.CHORUS_FRUIT) {
            return "chorus_fruit";
        } else if (ma == Material.CHORUS_FRUIT_POPPED) {
            return "chorus_fruit_popped";
        } else if (ma == Material.BEETROOT) {
            return "beetroot";
        } else if (ma == Material.BEETROOT_SEEDS) {
            return "beetroot_seeds";
        } else if (ma == Material.BEETROOT_SOUP) {
            return "beetroot_soup";
        } else if (ma == Material.DRAGONS_BREATH) {
            return "dragon_breath";
        } else if (ma == Material.SPLASH_POTION) {
            return "splash_potion";
        } else if (ma == Material.SPECTRAL_ARROW) {
            return "spectral_arrow";
        } else if (ma == Material.TIPPED_ARROW) {
            return "tipped_arrow";
        } else if (ma == Material.LINGERING_POTION) {
            return "lingering_potion";
        } else if (ma == Material.SHIELD) {
            return "shield";
        } else if (ma == Material.ELYTRA) {
            return "elytra";
        } else if (ma == Material.BOAT_SPRUCE) {
            return "spruce_boat";
        } else if (ma == Material.BOAT_BIRCH) {
            return "birch_boat";
        } else if (ma == Material.BOAT_JUNGLE) {
            return "jungle_boat";
        } else if (ma == Material.BOAT_ACACIA) {
            return "acacia_boat";
        } else if (ma == Material.BOAT_DARK_OAK) {
            return "dark_oak_boat";
        } else if (ma == Material.TOTEM) {
            return "totem_of_undying";
        } else if (ma == Material.SHULKER_SHELL) {
            return "shulker_shell";
        } else if (ma == Material.IRON_NUGGET) {
            return "iron_nugget";
        } else if (ma == Material.KNOWLEDGE_BOOK) {
            return "knowledge_book";
        } else if (ma == Material.GOLD_RECORD) {
            return "record_13";
        } else if (ma == Material.GREEN_RECORD) {
            return "record_cat";
        } else if (ma == Material.RECORD_3) {
            return "record_blocks";
        } else if (ma == Material.RECORD_4) {
            return "record_chirp";
        } else if (ma == Material.RECORD_5) {
            return "record_far";
        } else if (ma == Material.RECORD_6) {
            return "record_mall";
        } else if (ma == Material.RECORD_7) {
            return "record_mellohi";
        } else if (ma == Material.RECORD_8) {
            return "record_stal";
        } else if (ma == Material.RECORD_9) {
            return "record_strad";
        } else if (ma == Material.RECORD_10) {
            return "record_ward";
        } else if (ma == Material.RECORD_11) {
            return "record_11";
        } else {
            return ma == Material.RECORD_12 ? "record_wait" : ma.toString();
        }
    }
}
