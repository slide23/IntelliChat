package ws.slide.minecraft.mod_IntelliChat;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Settings
{
	private Boolean enabled = true;
	private List<SettingsServer> servers = new ArrayList<SettingsServer>();
	private List<SettingsHighlight> highlights = new ArrayList<SettingsHighlight>();
	private List<String> ignores = new ArrayList<String>();
	private Boolean configApplyToExistingChat = false;
	private Boolean expandToFillScreen = true;
	private Byte highlightColorDefault = 0xC;
	private Boolean timestampEnable = true;
	private String timestampFormat = "hh:mma";
	private Byte timestampColor = 0x8;
	private Byte chatWidth = 55;
	private Byte chatHeight = 20;
	private Byte chatOverylayHeight = 10;
	private Boolean tabIndicatorsShow = true;
	private String configDefault = "Default";
	private Boolean keepChatOpen = false;
	private Boolean backgroundShow = true;
	private Integer backgroundColor = 0x000000;
	private Double backgroundOpacity = 0.1;

	public Boolean isEnabled() { return enabled; }
	public List<SettingsServer> getServers() { return servers; }
	public List<SettingsHighlight> getHighlights() { return highlights; }
	public List<String> getIgnores() { return ignores; }
	public Boolean getConfigApplyToExistingChat() { return configApplyToExistingChat; }
	public Boolean getExpandToFillScreen() { return expandToFillScreen; }
	public Byte getHighlightColorDefault() { return highlightColorDefault; }
	public Boolean isTimestampEnabled() { return timestampEnable; }
	public String getTimestampFormat() { return timestampFormat; }
	public Byte getTimestampColor() { return timestampColor; }
	public String getTimestampColorAsString() { return Integer.toHexString(timestampColor.intValue()); }
	public Byte getChatWidth() { return chatWidth; }
	public Byte getChatHeight() { return chatHeight; }
	public Byte getChatOverlayHeight() { return chatOverylayHeight; }
	public Boolean getShowTabIndicators() { return tabIndicatorsShow; }
	public String getConfigDefault() { return configDefault; }
	public Boolean getKeepChatOpen() { return keepChatOpen; }
	public Boolean getShowBackground() { return backgroundShow; }
	public Integer getBackgroundColor() { return backgroundColor; }
	public String getBackgroundColorAsString() { return String.format("%06X", (0xFFFFFF & backgroundColor)); }
	public Double getBackgroundOpacity() { return this.backgroundOpacity; }

	public void setEnabled(Boolean enabled) { this.enabled = enabled; }
	public void setServers(List<SettingsServer> servers) { this.servers = servers; }
	public void setHighlights(List<SettingsHighlight> highlights) { this.highlights = highlights; }
	public void setIgnores(List<String> ignores) { this.ignores = ignores; }
	public void setConfigApplyToExistingChat(Boolean configApplyToExistingChat) { this.configApplyToExistingChat = configApplyToExistingChat; }
	public void setExpandToFillScreen(Boolean expandToFillScreen) { this.expandToFillScreen = expandToFillScreen; }
	public void setHighlightColorDefault(Byte highlightColorDefault) { this.highlightColorDefault = highlightColorDefault; }
	public void setTimestampEnabled(Boolean enable) { this.timestampEnable = enable; }
	public void setTimestampFormat(String format) { this.timestampFormat = format; }
	public void setTimestampColor(Byte color) { this.timestampColor = color; }
	public void setChatWidth(Byte width) { this.chatWidth = width; }
	public void setChatHeight(Byte height) { this.chatHeight = height; }
	public void setChatOverlayHeight(Byte height) { this.chatOverylayHeight = height; }
	public void setShowTabIndicators(Boolean tabIndicatorsShow) { this.tabIndicatorsShow = tabIndicatorsShow; }
	public void setConfigDefault(String configDefault) { this.configDefault = configDefault; }
	public void setKeepChatOpen(Boolean keepChatOpen) { this.keepChatOpen = keepChatOpen; }
	public void setShowBackground(Boolean show) { this.backgroundShow = show; }
	public void setBackgroundColor(Integer color) { this.backgroundColor = color; }
	public void setBackgroundColorFromString(String color) { this.backgroundColor = Integer.parseInt(color, 16); }
	public void setBackgroundOpacity(Double opacity){ this.backgroundOpacity = opacity; }
}