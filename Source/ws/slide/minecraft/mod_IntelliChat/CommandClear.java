package ws.slide.minecraft.mod_IntelliChat;

import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.mod_IntelliChat;

public class CommandClear extends CommandBase
{
	@Override
	public String getCommandName()
	{
		return "clear";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2)
	{
		mod_IntelliChat.getInstance().getActiveChatTab().clear();
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender par1iCommandSender)
	{
		return true;
	}
}