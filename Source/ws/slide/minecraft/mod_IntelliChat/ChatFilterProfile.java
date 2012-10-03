package ws.slide.minecraft.mod_IntelliChat;

public class ChatFilterProfile
{
	private ChatFilter filter;
	private ChatTabProfile profile;
	private String filterName;
	private String profileName;
	private Boolean showNewOnScreen;

	public ChatFilterProfile(ChatFilter filter, ChatTabProfile profile)
	{
		this.filter = filter;
		this.profile = profile;
	}

	public ChatFilter getFilter() { return filter; }
	public ChatTabProfile getProfile() { return profile; }
	public String getProfileName() { return this.profileName; }
	public String getFilterName() { return this.filterName; }

	public void setFilter(ChatFilter filter) { this.filter = filter; }
	public void setProfile(ChatTabProfile profile) { this.profile = profile; }
	public void setProfileName(String profileName) { this.profileName = profileName; }
	public void setFilterName(String filterName) { this.filterName = filterName; }
}