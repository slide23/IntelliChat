package ws.slide.minecraft.mod_IntelliChat;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import net.minecraft.src.StringUtils;

public class ChatFilter
{
	private String name;
	private String match;
	private List<String> variableNames;
	private Map<String, String> variables = new HashMap<String, String>();
	private String output;
	private String ignoreVariableName;
	private String highlightVariableName;
	private Boolean stripColorCodes = true;
	private Boolean consume = true;

	public Boolean matches(String line)
	{
		String message;

		if (this.stripColorCodes)
			message = StringUtils.stripControlCodes(line);
		else
			message = line;

		try
		{
			if (Pattern.compile(this.match).matcher(message).matches())
				return true;
		} catch (PatternSyntaxException e) { Logger.getLogger("Minecraft").info(e.getDescription()); }

		return false;
	}

	public Map<String, String> getVariables(String line)
	{
		String message;

		if (this.stripColorCodes)
			message = StringUtils.stripControlCodes(line);
		else
			message = line;

		try
		{
			Matcher m = Pattern.compile(this.match).matcher(message);

			if (m.matches())
			{
				variables.put("LINE", line);
				if (m.groupCount() == this.variableNames.size())
					for (int i = 0; i < m.groupCount(); i++)
						variables.put(this.variableNames.get(i), m.group(i+1));
			}
		} catch (PatternSyntaxException e) { Logger.getLogger("Minecraft").info(e.getDescription()); }

		return variables;
	}

	public ChatFilter(String match, List<String> variableNames, String output, Boolean stripColorCodes, Boolean consume)
	{
		this.match = match;
		if (this.match == null)
			this.match = ".*";
		this.variableNames = variableNames;
		if (this.variableNames == null)
			this.variableNames = new ArrayList<String>();
		this.output = output;
		if (this.output == null)
			this.output = "%LINE%";
		this.stripColorCodes = stripColorCodes;
		this.consume = consume;
	}

	public ChatFilter(String match, List<String> variableNames, String output)
	{
		this(match, variableNames, output, true, true);
	}

	public ChatFilter(String match, List<String> variableNames)
	{
		this(match, variableNames, null, true, true);
	}

	public ChatFilter(String match)
	{
		this(match, null, null, true, true);
	}

	public ChatFilter()
	{
		this.match = ".*";
		this.variableNames = new ArrayList<String>();
		this.output = "%LINE%";
		this.stripColorCodes = true;
		this.consume = true;
	}

	public void setName(String name) { this.name = name; }
	public void setMatch(String match) { this.match = match; }
	public void setVariableNames(List<String> variableNames) { this.variableNames = variableNames; }
	public void setOutput(String output) { this.output = output; }
	public void setStripColorCodes(Boolean stripColorCodes) { this.stripColorCodes = stripColorCodes; }
	public void setConsume(Boolean consume) { this.consume = consume; }

	public String getName() { return name; }
	public String getMatch() { return match; }
	public List<String> getvariableNames() { return variableNames; }
	public Map<String, String> getVariables() { return variables; }
	public String getOutput() { return output; }
	public String getIgnoreVariableName() { return ignoreVariableName; }
	public String getHighlightVariableName() { return highlightVariableName; }
	public Boolean getStripColorCodes() { return stripColorCodes; }
	public Boolean getConsume() { return consume; }
}