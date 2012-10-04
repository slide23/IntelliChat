package ws.slide.minecraft.mod_IntelliChat;

import java.util.List;

import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.mod_IntelliChat;

public class CommandUnIgnore extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "unignore";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2)
	{
		List<String> ignores = mod_IntelliChat.getInstance().getSettings().getIgnores();

		if (ignores.contains(var2[0]))
		{
			ignores.remove(var2[0]);
			var1.sendChatToPlayer("Removed \"" + var2[0] + "\" from ignore list.");
		}
		else
		{
			var1.sendChatToPlayer("\"" + var2[0] + "\" not in ignore list.");
		}
	}

	@Override
	public String getCommandUsage(ICommandSender par1iCommandSender)
	{
		return "Usage: \"/unignore <player>\"";
	}
}