package ws.slide.minecraft.mod_IntelliChat;

import java.util.List;

import ws.slide.minecraft.mod_ClientCommands.ChatCallback;
import net.minecraft.src.mod_IntelliChat;

public class ICChatCallback implements ChatCallback
{
	@Override
	public Boolean execute(StringBuilder line)
	{
        ChatTab tab = mod_IntelliChat.getInstance().getActiveChatTab();
        if (tab != null && tab.getProfile() != null && tab.getProfile().getFilters() != null)
        {
            List<ChatFilter> tabFilters = tab.getProfile().getFilters();
            for (ChatFilter tabFilter : tabFilters)
            {
            	if (tabFilter.matches(line.toString()))
            	{
            		tab.updateVariables(tabFilter.getVariables(line.toString()));
            		line.delete(0, line.length());
            		line.append(tab.parse(tabFilter.getOutput()));

                	return tabFilter.getConsume();
            	}
            }
        }
        return true;
	}
}