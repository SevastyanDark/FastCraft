package net.benwoodworth.fastcraft.dependencies.gui.element

import net.benwoodworth.fastcraft.dependencies.event.FcListener
import net.benwoodworth.fastcraft.dependencies.gui.GuiLocation
import net.benwoodworth.fastcraft.dependencies.gui.GuiRegion
import net.benwoodworth.fastcraft.dependencies.gui.event.GuiEventClick
import net.benwoodworth.fastcraft.dependencies.gui.event.GuiEventLayoutChange
import net.benwoodworth.fastcraft.dependencies.item.FcItem

/**
 * An object that can be added to a GUI.
 */
interface GuiElement {

    /**
     * A listener for element changes.
     */
    val changeListener: FcListener<GuiEventLayoutChange>

    /**
     * The region this element occupies within the containing layout.
     */
    val region: GuiRegion.Positioned

    /**
     * Handles GUI clicks.
     *
     * @param event the click event.
     */
    fun click(event: GuiEventClick)

    /**
     * Get an item from within this element.
     *
     * @param location the location of the item, relative to this element.
     * @return the item at the specified position, or `null` if there is none.
     */
    fun getItem(location: GuiLocation): FcItem?

    /**
     * A [GuiElement] that can be moved and resized.
     */
    interface Mutable : GuiElement {
        override val region: GuiRegion.Positioned
    }
}