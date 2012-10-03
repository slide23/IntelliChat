package ws.slide.minecraft.mod_IntelliChat;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.client.Minecraft;
import net.minecraft.src.ChatLine;

public class ChatTab
{
	private String name;
	private String title;
	private List<String> variableNames = new ArrayList<String>();
	private Map<String, String> variables = new HashMap<String, String>();
	private List<String> variableValues = new ArrayList<String>();
	private List<ChatLine> history = new ArrayList<ChatLine>();
	private int historySize = 200;
	private ChatTabProfile profile;
	private String profileName;
	private Boolean activity = false;

	public void updateVariables(Map<String, String> variables)
	{
		this.variables.putAll(variables);
		this.title = this.parse(this.profile.getTitle());
	}

	public String parse(String source)
	{
		if (source == null)
			return null;

		String parsed = source;

		parsed = parsed.replaceAll("%TAB\\.PROFILE%", this.profile.getName());
		parsed = parsed.replaceAll("%TAB\\.TITLE%", this.title);
		Minecraft mc = Minecraft.getMinecraft();
		if (mc != null && mc.thePlayer != null)
			parsed = parsed.replaceAll("%NAME%", mc.thePlayer.username);

		for (Map.Entry<String, String> variable : variables.entrySet())
			parsed = parsed.replaceAll("%" + variable.getKey() + "%", Matcher.quoteReplacement(variable.getValue().toString()));

		return parsed;
	}

	public void addLine(String text)
	{
        synchronized (history)
        {
        	this.history.add(0, new ChatLine(Minecraft.getMinecraft().ingameGUI.getUpdateCounter(), this.parse(text), this.history.size()));
        }
        this.activity = true;
	}

	public void clear()
	{
		this.history = new ArrayList<ChatLine>();
	}

	@Override
	public boolean equals(Object obj)
	{
		return this.title.equals(((ChatTab)obj).getTitle());
	}

	public ChatTab(ChatTabProfile profile)
	{
		this.setProfile(profile);
	}

	public ChatTab()
	{
		this.variables = new HashMap<String, String>();
	}

	public String getName() { return this.name; }
	public String getTitle() { return this.title; }
	public List<ChatLine> getHistory() { return this.history; }
	public ChatTabProfile getProfile() { return this.profile; }
	public Boolean hasActivity() { return this.activity; }
	public String getProfileName() { return this.profileName; }

	public void setName(String name) { this.name = name; }
	public void setTitle(String title) { this.title = title; }
	public void setProfile(ChatTabProfile profile)
	{
		this.profile = profile;
		this.title = this.parse(this.profile.getTitle());
	}
	public void setHistorySize(int historySize) { this.historySize = historySize; }
	public void setProfileName(String profileName) { this.profileName = profileName; }

	public void clearActivity() { this.activity = false; }
}