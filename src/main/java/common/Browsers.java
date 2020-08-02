package common;

public enum Browsers {

	CHROME("CH"), INTERNET_EXPLORER("IE"), FIREFOX("FF");
	
	private String text;
	
	Browsers(final String text){
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static Browsers fromString(final String text) throws Exception {
		for(final Browsers browsers : Browsers.values()) {
			if(text.equalsIgnoreCase(browsers.text))
				return browsers;
		}
	throw new Exception();
	}
}
