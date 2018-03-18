package net.benwoodworth.fastcraft.implementations.bukkit.api.text

import net.benwoodworth.fastcraft.dependencies.api.text.FcText
import org.apache.commons.lang.WordUtils
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import javax.inject.Inject

@Suppress("ClassName")
class BukkitFcText_Legacy_1_7_2_R0_3(
        override val text: String
) : BukkitFcText_Legacy {

    override var color: BukkitFcTextColor? = null
    override var bold: Boolean? = null
    override var italic: Boolean? = null
    override var underlined: Boolean? = null
    override var strikeThrough: Boolean? = null
    override var obfuscated: Boolean? = null
    override var shiftClickAction: BukkitFcTextAction.ShiftClick? = null
    override var clickAction: BukkitFcTextAction.Click? = null
    override var hoverAction: BukkitFcTextAction.Hover? = null
    override var extra: MutableList<BukkitFcText> = mutableListOf()

    class Factory @Inject constructor(
    ) : BukkitFcText_Legacy.Factory {

        override fun buildText(text: String): FcText.Builder {
            return BukkitFcText_Legacy.Builder(
                    BukkitFcText_Legacy_1_7_2_R0_3(text)
            )
        }

        override fun getItemName(item: ItemStack): BukkitFcText {
            return BukkitFcText_Legacy_1_7_2_R0_3(
                    WordUtils.capitalizeFully(item.data.toString())
            )
        }

        override fun getItemDisplayName(item: ItemStack): BukkitFcText? {
            return if (item.hasItemMeta()) {
                item.itemMeta.displayName?.let {
                    BukkitFcText_Legacy_1_7_2_R0_3(it)
                }
            } else {
                null
            }
        }

        override fun setItemDisplayName(item: ItemStack, displayName: FcText?) {
            item.itemMeta.displayName = (displayName as BukkitFcText_Legacy?)?.text
        }

        override fun getItemLore(item: ItemStack): List<BukkitFcText?>? {
            return if (item.hasItemMeta()) {
                item.itemMeta.lore?.map {
                    BukkitFcText_Legacy_1_7_2_R0_3(it)
                }
            } else {
                null
            }
        }

        override fun setItemLore(item: ItemStack, lore: List<BukkitFcText?>?) {
            item.itemMeta.lore = lore?.map {
                (it as BukkitFcText_Legacy?)?.text
            }
        }

        override fun sendPlayerMessage(player: Player, message: FcText) {
            player.sendMessage(
                    (message as BukkitFcText_Legacy).text
            )
        }
    }
}