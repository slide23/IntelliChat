package ws.slide.minecraft.mod_IntelliChat;

import java.util.List;

import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.mod_IntelliChat;

public class CommandHighlight extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "highlight";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2)
	{
		List<SettingsHighlight> highlights = mod_IntelliChat.getInstance().getSettings().getHighlights();

		if (var2.length == 1)
		{
			if (highlights.contains(var2[0]))
				var1.sendChatToPlayer("\"" + var2[0] + "\" already in highlight list.");
			else
			{
				highlights.add(new SettingsHighlight(var2[0], mod_IntelliChat.getInstance().getSettings().getHighlightColorDefault(), false));
				var1.sendChatToPlayer("Added \"" + var2[0] + "\" to highlight list.");
			}
		}
		else if (var2.length == 2)
		{
			if (var2[0].equals("-r"))
			{
				if (highlights.contains(var2[1]))
				{
					highlights.remove(var2[1]);
					var1.sendChatToPlayer("Removed \"" + var2[1] + "\" from highlight list.");
				}
				else
				{
					var1.sendChatToPlayer("\"" + var2[1] + "\" not in highlight list.");
				}
			}
			else
			{
				
			}
		}

	}
}