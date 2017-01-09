package celebrities;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CelebritiesBean {
	private String CeleName;
	private String gender;
	private String urlpath;
	private int num;
	public CelebritiesBean(String celeName, String gender, String urlpath, int num) {
		super();
		CeleName = celeName;
		this.gender = gender;
		this.urlpath = urlpath;
		this.num = num;
	}
	/**
	 * @return the celeName
	 */
	public String getCeleName() {
		return CeleName;
	}
	/**
	 * @param celeName the celeName to set
	 */
	public void setCeleName(String celeName) {
		CeleName = celeName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the urlpath
	 */
	public String getUrlpath() {
		return urlpath;
	}
	/**
	 * @param urlpath the urlpath to set
	 */
	public void setUrlpath(String urlpath) {
		this.urlpath = urlpath;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
