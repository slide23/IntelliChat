package ws.slide.minecraft.mod_IntelliChat;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;

public class GuiTabConfig extends GuiScreen
{
	private GuiTextField textField;
	
    public void initGui()
    {
        this.controlList.clear();

        
    }

    protected void keyTyped(char c, int i)
    {
    	
    }

    protected void mouseClicked(int i, int j, int k)
    {
    	super.mouseClicked(i, j, k);
    }

    protected void actionPerformed(GuiButton par1GuiButton)
    {
        switch (par1GuiButton.id)
        {
        }
    }

    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "IntelliChat Tab Configurations", this.width / 2, this.height / 6 - 20, 16777215);
        super.drawScreen(par1, par2, par3);
    }
}