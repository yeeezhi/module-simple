package taboolib.module.simple.util.hook;

import com.google.common.collect.Lists;
import com.mchim.ItemLoreOrigin.Config.Settings;
import com.mchim.ItemLoreOrigin.ItemLoreData.ItemLoreManager;
import com.mchim.ItemLoreOrigin.ItemLoreData.Origin.LoreOrigin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.List;

public class ItemLoreOriginUtil {
    /**
     * 处理ilo属性
     * 一般在ItemLoreStatusEvent,ItemLoreDamageEvent,ItemLoreTickEvent触发时使用
     *
     * @param player    玩家
     * @param managers  事件中获取
     * @param lore_list 生效的属性Lore
     */
    public static void handleAttribute(Player player, List<ItemLoreManager> managers, List<String> lore_list) {
        ItemLoreManager ilm = managers.get(0);
        ilm.getLoreData().addAll(getLoreOriginList(player, lore_list));
    }

    /**
     * 通过Lore获取属性
     *
     * @param player 玩家
     * @param lore   Lore
     * @return 玩家属性
     */
    public static List<LoreOrigin> getLoreOriginList(Player player, List<String> lore) {
        List<LoreOrigin> lists = Lists.newArrayList();
        if (lore.isEmpty()) {
            return lists;
        }
        for (String s : lore) {
            s = ChatColor.stripColor(s);
            String loreType = null;
            for (String type : Settings.I.loreType.keySet()) {
                List<String> list = Settings.I.loreType.get(type);
                for (String ss : list) {
                    if (s.contains(ss)) {
                        loreType = type;
                        break;
                    }
                }
            }

            if (loreType != null && LoreOrigin.originMap.containsKey(loreType)) {
                try {
                    LoreOrigin lo = LoreOrigin.originMap.get(loreType).getConstructor(new Class[]{LivingEntity.class}).newInstance(new Object[]{player});
                    lo.init(s);
                    if (lo.getName() != null) {
                        lists.add(lo);
                    }
                } catch (Exception var12) {
                    var12.printStackTrace();
                }
            }
        }

        return lists;
    }
}
