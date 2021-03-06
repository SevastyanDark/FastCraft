package net.benwoodworth.fastcraft.core.gui.crafting

import net.benwoodworth.fastcraft.core.gui.crafting.elements.*
import net.benwoodworth.fastcraft.core.lang.FastCraftLang
import net.benwoodworth.fastcraft.dependencies.gui.GuiFactory
import net.benwoodworth.fastcraft.dependencies.gui.GuiLocation
import net.benwoodworth.fastcraft.dependencies.gui.GuiRegion
import net.benwoodworth.fastcraft.dependencies.gui.mvp.MvpView
import javax.inject.Inject

class CraftingGuiView @Inject constructor(
        guiFactory: GuiFactory,
        fastCraftLang: FastCraftLang,

        buttonWorkbenchFactory: ButtonWorkbenchFactory,
        buttonMultiplierFactory: ButtonMultiplierFactory,
        buttonRefreshFactory: ButtonRefreshFactory,
        buttonPageFactory: ButtonPageFactory,

        elementRecipeListFactory: ElementRecipeListFactory
) : MvpView {

    val elementRecipeList = elementRecipeListFactory.create(GuiRegion.Rectangle(0, 0, 8, 6))

    val buttonWorkbench = buttonWorkbenchFactory.create(GuiLocation(8, 0))
    val buttonMultiplier = buttonMultiplierFactory.create(GuiLocation(8, 2))
    val buttonRefresh = buttonRefreshFactory.create(GuiLocation(8, 3))
    val buttonPage = buttonPageFactory.create(GuiLocation(8, 5))

    val gui = guiFactory.withSize(
            9,
            6,
            fastCraftLang.guiTitle()
    ).apply {
        layout.addElement(elementRecipeList)
        layout.addElement(buttonWorkbench)
        layout.addElement(buttonMultiplier)
        layout.addElement(buttonRefresh)
        layout.addElement(buttonPage)
    }
}