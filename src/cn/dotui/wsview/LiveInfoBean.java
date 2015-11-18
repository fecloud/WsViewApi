/**
 * LiveInfoBean.java Created on 2015-11-18
 */
package cn.dotui.wsview;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The class <code>LiveInfoBean</code>
 * 
 * @author Feng OuYang
 * @version 1.0
 */
@XStreamAlias("contUL")
public class LiveInfoBean {

	@XStreamAlias("liveID")
	private String liveID;// string 直播ID

	@XStreamAlias("liveName")
	private String liveName;// string 直播名称

	@XStreamAlias("liveStatus")
	private int liveStatus; // Int 直播状态（0无效直播1 正在直播）

	@XStreamAlias("pushAddr")
	private String pushAddr;// string 推送地址
							// 多个地址用#分开如：rtmp://live.simope.com:1935/live/f6d8bd152a#rtmp://live.simope.com:1935/live/a3f43d36c5
	@XStreamAlias("releaseAddr")
	private String releaseAddr;// string 发布地址 //
								// 发布地址格式如下：http://www.wsview.com/yzplayerAction!play2.action?autoPlay=false&playType=uLive&userVideoID=100000538

	@XStreamAlias("liveType")
	private int liveType;// Int 直播类型(1：RTMP 2：云宙ES)

	@XStreamAlias("againstType")
	private String againstType;

	@XStreamAlias("accessCode")
	private String accessCode;

	@XStreamAlias("liveImage")
	private String liveImage;// String 直播图片地址

	@XStreamAlias("liveMakeTime")
	private String liveMakeTime;

	public String getLiveID() {
		return liveID;
	}

	public void setLiveID(String liveID) {
		this.liveID = liveID;
	}

	public String getLiveName() {
		return liveName;
	}

	public void setLiveName(String liveName) {
		this.liveName = liveName;
	}

	public int getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(int liveStatus) {
		this.liveStatus = liveStatus;
	}

	public String getPushAddr() {
		return pushAddr;
	}

	public void setPushAddr(String pushAddr) {
		this.pushAddr = pushAddr;
	}

	public String getReleaseAddr() {
		return releaseAddr;
	}

	public void setReleaseAddr(String releaseAddr) {
		this.releaseAddr = releaseAddr;
	}

	public int getLiveType() {
		return liveType;
	}

	public void setLiveType(int liveType) {
		this.liveType = liveType;
	}

	public String getLiveImage() {
		return liveImage;
	}

	public void setLiveImage(String liveImage) {
		this.liveImage = liveImage;
	}

	public String getAgainstType() {
		return againstType;
	}

	public void setAgainstType(String againstType) {
		this.againstType = againstType;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getLiveMakeTime() {
		return liveMakeTime;
	}

	public void setLiveMakeTime(String liveMakeTime) {
		this.liveMakeTime = liveMakeTime;
	}

	@Override
	public String toString() {
		return "LiveInfoBean [liveID=" + liveID + ", liveName=" + liveName
				+ ", liveStatus=" + liveStatus + ", pushAddr=" + pushAddr
				+ ", releaseAddr=" + releaseAddr + ", liveType=" + liveType
				+ ", againstType=" + againstType + ", accessCode=" + accessCode
				+ ", liveImage=" + liveImage + ", liveMakeTime=" + liveMakeTime
				+ "]";
	}

}
