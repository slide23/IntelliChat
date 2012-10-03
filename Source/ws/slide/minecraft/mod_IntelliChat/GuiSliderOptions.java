package ws.slide.minecraft.mod_IntelliChat;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EnumOptions;
import net.minecraft.src.GuiButton;

import org.lwjgl.opengl.GL11;

public class GuiSliderOptions extends GuiButton
{
    /** The value of this slider control. */
    public Integer sliderValue = 0;

    /** Is this slider control being dragged. */
    public boolean dragging = false;

    public String label;

    public String[] options;

    public GuiSliderOptions(int id, int x, int y, String label, String[] options, int sliderValue)
    {
        super(id, x, y, 150, 20, label + ": " + options[sliderValue]);
        this.sliderValue = sliderValue;
        this.options = options;
        this.label = label;
    }

    /**
     * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over this button and 2 if it IS hovering over
     * this button.
     */
    protected int getHoverState(boolean par1)
    {
        return 0;
    }

    /**
     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
     */
    protected void mouseDragged(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            if (this.dragging)
            {
                this.sliderValue = Math.round((par2 - (this.xPosition + 4)) / (float)(this.width - 8) * (this.options.length - 1));

                if (this.sliderValue < 0)
                {
                    this.sliderValue = 0;
                }

                if (this.sliderValue >= this.options.length)
                {
                    this.sliderValue = this.options.length - 1;
                }

                this.displayString = label + ": " + this.options[this.sliderValue];
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8) / (this.options.length - 1)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8) / (this.options.length - 1)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }

    /**
     * Returns true if the mouse has been pressed on this control. Equivalent of MouseListener.mousePressed(MouseEvent
     * e).
     */
    public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3)
    {
        if (super.mousePressed(par1Minecraft, par2, par3))
        {
            this.sliderValue = Math.round((par2 - (this.xPosition + 4)) / (float)(this.width - 8) * (this.options.length - 1));

            if (this.sliderValue < 0)
            {
                this.sliderValue = 0;
            }

            if (this.sliderValue >= this.options.length)
            {
                this.sliderValue = this.options.length - 1;
            }

            this.displayString = label + ": " + this.options[this.sliderValue];
            this.dragging = true;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Fired when the mouse button is released. Equivalent of MouseListener.mouseReleased(MouseEvent e).
     */
    public void mouseReleased(int par1, int par2)
    {
        this.dragging = false;
    }
}
