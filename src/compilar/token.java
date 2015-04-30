package compilar;

public class token {

	/**
	 * @return the tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}
	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	/**
	 * @return the tokenValue
	 */
	public String getTokenValue() {
		return tokenValue;
	}
	/**
	 * @param tokenValue the tokenValue to set
	 */
	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}
	String tokenType;
	String tokenValue;
	/**
	 * @return the isReserved
	 */
	public boolean getisReserved() {
		return isReserved;
	}
	/**
	 * @param isReserved the isReserved to set
	 */
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	boolean isReserved;
	public token(String tokenType, String tokenValue, boolean isReserved) {
		super();
		this.tokenType = tokenType;
		this.tokenValue = tokenValue;
		this.isReserved = isReserved;
	}
	public token(String tokenType, String tockenValue) {
		super();
		this.tokenType = tokenType;
		this.tokenValue = tockenValue;
		this.isReserved = false;

	}

}
