package net.benwoodworth.fastcraft.api.gui.layout

import net.benwoodworth.fastcraft.api.Listener
import net.benwoodworth.fastcraft.api.gui.GuiElement
import net.benwoodworth.fastcraft.api.gui.button.GuiButton
import net.benwoodworth.fastcraft.api.gui.event.EventGuiLayoutChange

/**
 * The button layout of a GUI.
 */
interface GuiLayout {

    /**
     * A listener for layout changes.
     */
    val changeListener: Listener<EventGuiLayoutChange>

    /**
     * The width of this [GuiLayout].
     */
    val width: Int

    /**
     * The height of this [GuiLayout].
     */
    val height: Int

    /**
     * Add a [GuiElement] to this layout.
     *
     * Elements added later will take precedence over layouts added earlier.
     *
     * @param element the [GuiElement] to add
     */
    fun addElement(element: GuiElement)

    /**
     * Get the child layout at a the specified position.
     *
     * If layouts are overlapping at the specified point,
     * the last layout added will be returned.
     *
     * @param element the [GuiElement] to remove
     */
    fun removeElement(element: GuiElement)

    /**
     * Get the layout element at the specified position in the layout.
     *
     * @return the element at the specified position, or 'null' if there is none
     */
    fun getElement(x: Int, y: Int): GuiElement?

    /**
     * Recursively get a button at the specified position in the layout.
     *
     * @param x the x-coordinate of the button
     * @param y the y-coordinate of the button
     * @return the button at the specified position, or 'null' if there is none
     */
    fun getButton(x: Int, y: Int): GuiButton?
}