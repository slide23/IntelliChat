package ws.slide.minecraft.mod_IntelliChat;

public class SettingsHighlight
{
	private String text;
	private Byte color;
	private Boolean ding = false;

	public String getText() { return text; }
	public Byte getColor() { return color; }
	public Boolean doesDing() { return ding; }

	public SettingsHighlight(String text, Byte color, Boolean ding)
	{
		this.text = text;
		this.color = color;
		this.ding = ding;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof String)
			if (this.text.equals(obj))
				return true;

		return super.equals(obj);
	}
}