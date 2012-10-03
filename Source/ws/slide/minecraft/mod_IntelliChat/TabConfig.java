package ws.slide.minecraft.mod_IntelliChat;

import java.util.List;
import java.util.ArrayList;

public class TabConfig
{
	private List<ChatTabProfile> tabProfiles = new ArrayList<ChatTabProfile>();
	private List<ChatTab> tabs = new ArrayList<ChatTab>();
	private List<ChatFilter> filters = new ArrayList<ChatFilter>();
	private List<ChatFilterProfile> filterProfiles = new ArrayList<ChatFilterProfile>();

	public List<ChatTabProfile> getTabProfiles() { return tabProfiles; }
	public List<ChatTab> getTabs() { return tabs; }
	public List<ChatFilter> getFilters() { return filters; }
	public List<ChatFilterProfile> getFilterProfiles() { return filterProfiles; }

	public void setTabProfiles(List<ChatTabProfile> tabProfiles) { this.tabProfiles = tabProfiles; }
	public void setTabs(List<ChatTab> tabs) { this.tabs = tabs; }
	public void setFilters(List<ChatFilter> filters) { this.filters = filters; }
	public void setFilterProfiles(List<ChatFilterProfile> filterProfiles) { this.filterProfiles = filterProfiles; }
}