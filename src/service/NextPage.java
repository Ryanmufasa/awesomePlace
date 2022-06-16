package service;

public class NextPage{
	
	private String nextPath;
	private boolean isRedirect;
	
	
	public NextPage(String nextPath, boolean isRedirect) {
		this.nextPath = nextPath;
		this.isRedirect = isRedirect;
	}
	
	public String getNextPath() {
		return nextPath;
	}
	
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
	
