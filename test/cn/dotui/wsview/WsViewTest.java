/**
 * WsViewTest.java Created on 2015-11-18
 */
package cn.dotui.wsview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class <code>WsViewTest</code>
 * 
 * @author Feng OuYang
 * @version 1.0
 */
public class WsViewTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		final WsViewApi api = new WsViewApi();
		final String token = api.getToken(username, password);
		System.out.println(String.format("token:%s", token));
		List<String> list = new ArrayList<String>();
		for(int i = 0;i < 1000;i++){
			String createLive =  api.createLive(username, token, "直播" + System.currentTimeMillis(), null);
			System.out.println(String.format("createLive url:%s", createLive));
			list.add(createLive);
		}
		
		System.out.println("按任意键继续...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		for(int i = 0;i <list.size();i++){
			LiveInfoBean liveInfo = api.getLiveInfo(username, token, list.get(i));
			System.out.println(liveInfo);
			
			boolean deleteLive = api.deleteLive(username, token,  list.get(i));
			System.out.println("deleteLive:" + deleteLive);
		}
		
		

	}

}
