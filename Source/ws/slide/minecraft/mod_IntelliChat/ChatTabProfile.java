package ws.slide.minecraft.mod_IntelliChat;

import java.util.ArrayList;
import java.util.List;

public class ChatTabProfile
{
	private String name;
	private String title;
	private String match;
	private String output;
	private ChatTabProfile parent = null;
	private String parent_name;
	private Boolean focus_on_activity;
	private Boolean focus_on_open;
	private Boolean closeable;
	private List<ChatFilter> filters;
	private Integer inputLimit;

	public void setName(String name) { this.name = name; }
	public void setTitle(String title) { this.title = title; }
	public void setMatch(String match) { this.match = match; }
	public void setOutput(String output) { this.output = output; }
	public void setParent(ChatTabProfile parent) { this.parent = parent; }
	public void setFocusOnActivity(Boolean focus_on_activity) { this.focus_on_activity = focus_on_activity; }
	public void setFocusOnOpen(Boolean focus_on_open) { this.focus_on_open = focus_on_open; }
	public void setCloseable(Boolean closeable) { this.closeable = closeable; }

	public void addFilter(ChatFilter filter)
	{
		if (this.filters == null)
			this.filters = new ArrayList<ChatFilter>();

		this.filters.add(filter);
	}

	public String getName() { return name; }

	public String getTitle()
	{
		if (this.title == null)
			if (this.parent != null)
				return this.parent.getTitle();
			else
				return "%TAB.PROFILE%";

		return title;
	}

	public String getMatch()
	{
		if (this.match == null)
			if (this.parent != null)
				return this.parent.getMatch();
			else
				return ".*";

		return match;
	}

	public String getOutput()
	{
		if (this.output == null)
			if (this.parent != null)
				return this.parent.getOutput();
			else
				return "%LINE%";

		return output;
	}

	public ChatTabProfile getParent()
	{
		return parent;
	}

	public String getParentName()
	{
		return parent_name;
	}

	public Boolean getFocusOnActivity()
	{
		if (this.focus_on_activity == null)
			if (this.parent != null)
				return this.parent.getFocusOnActivity();
			else
				return false;

		return focus_on_activity;
	}

	public Boolean getFocusOnOpen()
	{
		if (this.focus_on_open == null)
			if (this.parent != null)
				return this.parent.getFocusOnOpen();
			else
				return false;

		return focus_on_open;
	}

	public Boolean getCloseable()
	{
		if (this.closeable == null)
			if (this.parent != null)
				return this.parent.getCloseable();
			else
				return false;

		return closeable;
	}

	public List<ChatFilter> getFilters()
	{
		if (this.filters == null)
			if (this.parent != null)
				return this.parent.getFilters();
			else
				return new ArrayList<ChatFilter>();

		return filters;
	}

	public int getInputLimit()
	{
		if (this.inputLimit == null)
			if (this.parent != null)
				return this.parent.getInputLimit();
			else
				return 110;

		return inputLimit;
	}
}