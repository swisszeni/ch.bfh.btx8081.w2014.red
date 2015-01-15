package ch.bfh.btx8081.w2014.red.health;

import ch.bfh.btx8081.w2014.red.health.MenuWindow.Section;
import ch.bfh.btx8081.w2014.red.health.MenuWindow.State;

public interface IMenuListable {
	public String getMenuDisplayName();
	public String getURISubpath();
	public boolean shouldDisplayWithState(State state);
	public Section displayInSection();
}
