package ws.slide.minecraft.mod_IntelliChat;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSlider;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.StatCollector;
import net.minecraft.src.mod_IntelliChat;

public class GuiSettings extends GuiScreen
{
	private GuiSliderOptions sliderTimestampColors;
	private GuiTextField textFieldTimestampFormat;
	private GuiSliderScaled sliderBackgroundOpacity;
	private GuiTextField textFieldBackgroundColor;

    public void initGui()
    {
        this.controlList.clear();
        
        // Return on bottom middle
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 6 + 24 * (15 >> 1), StatCollector.translateToLocal("ic.menu.retunToChat")));


        // Left side controls from top to bottom
        int x = this.width / 2 - 155 + 0 % 2 * 160;
        this.controlList.add(new GuiSmallButton(10, x, this.height / 6 + 24 * ((0 * 2) >> 1), "Enabled: " + mod_IntelliChat.getInstance().getSettings().isEnabled().toString()));
        this.controlList.add(new GuiSmallButton(11, x, this.height / 6 + 24 * ((1 * 2) >> 1), "Fill Screen: " + mod_IntelliChat.getInstance().getSettings().getExpandToFillScreen().toString()));
        this.controlList.add(new GuiSmallButton(12, x, this.height / 6 + 24 * ((2 * 2) >> 1), "Timestamp: " + mod_IntelliChat.getInstance().getSettings().isTimestampEnabled().toString()));
        String[] colors = {"§0Black", "§1Dark Blue", "§2Dark Green", "§3Dark Aqua", "§4Dark Red", "§5Purple", "§6Gold", "§7Grey", "§8Dark Grey", "§9Indigo", "§aBright Green", "§bAqua", "§cRed", "§dPink", "§eYellow", "§fWhite"};
        sliderTimestampColors = new GuiSliderOptions(13, x, this.height / 6 + 24 * ((3 * 2) >> 1), "Timestamp Color", colors, mod_IntelliChat.getInstance().getSettings().getTimestampColor().intValue());
        this.controlList.add(sliderTimestampColors);
        textFieldTimestampFormat = new GuiTextField(fontRenderer, x + 100, this.height / 6 + 24 * ((4 * 2) >> 1), 50, 20);
        textFieldTimestampFormat.setFocused(false);
        textFieldTimestampFormat.setText(mod_IntelliChat.getInstance().getSettings().getTimestampFormat());

        // Right side control from top to bottom
        x = this.width / 2 - 155 + 1 % 2 * 160;
        this.controlList.add(new GuiSmallButton(20, x, this.height / 6 + 24 * ((0 * 2) >> 1), "Tab Configurations"));
        this.controlList.add(new GuiSmallButton(21, x, this.height / 6 + 24 * ((1 * 2) >> 1), "Tab Indicators: " + mod_IntelliChat.getInstance().getSettings().getShowTabIndicators().toString()));
        this.controlList.add(new GuiSmallButton(22, x, this.height / 6 + 24 * ((2 * 2) >> 1), "Show Background: " + mod_IntelliChat.getInstance().getSettings().getShowBackground().toString()));
        sliderBackgroundOpacity = new GuiSliderScaled(23, x, this.height / 6 + 24 * ((3 * 2) >> 1), "Background Opacity", mod_IntelliChat.getInstance().getSettings().getBackgroundOpacity(), 100.0);
        this.controlList.add(sliderBackgroundOpacity);
        textFieldBackgroundColor = new GuiTextField(fontRenderer, x + 100, this.height / 6 + 24 * ((4 * 2) >> 1), 50, 20);
        textFieldBackgroundColor.setFocused(false);
        textFieldBackgroundColor.setMaxStringLength(6);
        textFieldBackgroundColor.setText(mod_IntelliChat.getInstance().getSettings().getBackgroundColorAsString());
    }

    protected void keyTyped(char c, int i)
    {
    	if (textFieldTimestampFormat.isFocused())
    	{
	    	textFieldTimestampFormat.textboxKeyTyped(c, i);
	    	mod_IntelliChat.getInstance().getSettings().setTimestampFormat(textFieldTimestampFormat.getText());
    	}
    	else if (textFieldBackgroundColor.isFocused())
    	{
    		if ("0123456789abcdef".indexOf(c) != -1 || c == 8 || c == 0)
    		{
    			textFieldBackgroundColor.textboxKeyTyped(c, i);
            	mod_IntelliChat.getInstance().getSettings().setBackgroundColorFromString(textFieldBackgroundColor.getText());
    		}
    	}
    	if (c == 1)
    	{
        	mod_IntelliChat.getInstance().getSettings().setTimestampColor(sliderTimestampColors.sliderValue.byteValue());
        	mod_IntelliChat.getInstance().getSettings().setBackgroundOpacity(sliderBackgroundOpacity.sliderValue);
    	}
    	super.keyTyped(c, i);
    }

    protected void mouseClicked(int i, int j, int k)
    {
    	super.mouseClicked(i, j, k);
    	textFieldTimestampFormat.mouseClicked(i, j, k);
    	textFieldBackgroundColor.mouseClicked(i, j, k);
    }

    protected void actionPerformed(GuiButton par1GuiButton)
    {
        switch (par1GuiButton.id)
        {
            case 0:
            	mod_IntelliChat.getInstance().getSettings().setTimestampColor(sliderTimestampColors.sliderValue.byteValue());
            	mod_IntelliChat.getInstance().getSettings().setBackgroundOpacity(sliderBackgroundOpacity.sliderValue);
                this.mc.displayGuiScreen((GuiScreen)null);
            	break;
            case 10:
            	mod_IntelliChat.getInstance().getSettings().setEnabled(!mod_IntelliChat.getInstance().getSettings().isEnabled());
            	par1GuiButton.displayString = "Enabled: " + mod_IntelliChat.getInstance().getSettings().isEnabled().toString();
            	break;
            case 11:
            	mod_IntelliChat.getInstance().getSettings().setExpandToFillScreen(!mod_IntelliChat.getInstance().getSettings().getExpandToFillScreen());
            	par1GuiButton.displayString = "Fill Screen: " + mod_IntelliChat.getInstance().getSettings().getExpandToFillScreen().toString();
            	break;
            case 12:
            	mod_IntelliChat.getInstance().getSettings().setTimestampEnabled(!mod_IntelliChat.getInstance().getSettings().isTimestampEnabled());
            	par1GuiButton.displayString = "Timestamp: " + mod_IntelliChat.getInstance().getSettings().isTimestampEnabled().toString();
            	break;
            case 21:
            	mod_IntelliChat.getInstance().getSettings().setShowTabIndicators(!mod_IntelliChat.getInstance().getSettings().getShowTabIndicators());
            	par1GuiButton.displayString = "Tab Indicators: " + mod_IntelliChat.getInstance().getSettings().getShowTabIndicators().toString();
            	break;
        }
    }

    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "IntelliChat Settings", this.width / 2, this.height / 6 - 20, 16777215);
        textFieldTimestampFormat.drawTextBox();
        drawString(fontRenderer, "Timestamp Format :", this.width / 2 - 155 + 0 % 2 * 160, this.height / 6 + 24 * ((4 * 2) >> 1) + 10 - fontRenderer.FONT_HEIGHT / 2, 0xffffff);
        textFieldBackgroundColor.drawTextBox();
        drawString(fontRenderer, "Background Color :", this.width / 2 - 155 + 1 % 2 * 160, this.height / 6 + 24 * ((4 * 2) >> 1) + 10 - fontRenderer.FONT_HEIGHT / 2, 0xffffff);
        super.drawScreen(par1, par2, par3);
    }
}