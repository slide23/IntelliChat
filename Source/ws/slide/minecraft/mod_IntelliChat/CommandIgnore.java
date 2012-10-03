package ws.slide.minecraft.mod_IntelliChat;

import java.util.List;

import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.mod_IntelliChat;

public class CommandIgnore extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "ignore";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2)
	{
		List<String> ignores = mod_IntelliChat.getInstance().getSettings().getIgnores();
		if (var2.length == 1)
		{
			if (ignores.contains(var2[0]))
				var1.sendChatToPlayer("\"" + var2[0] + "\" already in ignore list.");
			else
			{
				ignores.add(var2[0]);
				var1.sendChatToPlayer("Added \"" + var2[0] + "\" to ignore list.");
			}
		}
		else if (var2.length == 2 && var2[0].equals("-r"))
		{
			if (ignores.contains(var2[1]))
			{
				ignores.remove(var2[1]);
				var1.sendChatToPlayer("Removed \"" + var2[1] + "\" from ignore list.");
			}
			else
			{
				var1.sendChatToPlayer("\"" + var2[1] + "\" not in ignore list.");
			}
		}
	}
}