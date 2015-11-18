/**
 * CreateLiveBean.java Created on 2015-11-18
 */
package cn.dotui.wsview;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The class <code>CreateLiveBean</code>
 * 
 * @author Feng OuYang
 * @version 1.0
 */
@XStreamAlias("PRespVULC")
public class CreateLiveBean {

	@XStreamAlias("resultCode")
	private int resultCode;

	@XStreamAlias("resultMsg")
	private String resultMsg;

	@XStreamAlias("liveID")
	private String liveID;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public String getLiveID() {
		return liveID;
	}

	public void setLiveID(String liveID) {
		this.liveID = liveID;
	}

	@Override
	public String toString() {
		return "CreateLiveBean [resultCode=" + resultCode + ", resultMsg="
				+ resultMsg + ", liveID=" + liveID + "]";
	}

}
