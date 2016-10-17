package com.example.pianotest;

import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button share;
	private static final String APP_ID = "wx59b5f3646e7f0fde";//申请的app_id
	public static IWXAPI api;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerToWx();
		share = (Button)findViewById(R.id.share);
		share.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				wechatShare(1);
			}

			
		});
	}
	private void registerToWx() {
	    api = WXAPIFactory.createWXAPI(this, APP_ID, false);
	    api.registerApp(APP_ID);
	  }	
	private void wechatShare(int i) {
		// TODO Auto-generated method stub
		if (!MainActivity.api.isWXAppInstalled()) {  
	        Toast.makeText(MainActivity.this, "您还未安装微信客户端",  
	                Toast.LENGTH_SHORT).show();  
	        return;  
	    } 
		final String text1 = "微信测试";
		final String content = "能不能成啊!";
		Toast.makeText(MainActivity.this, "就知道",  
                Toast.LENGTH_SHORT).show();  
		WXTextObject  text = new WXTextObject();  
		text.text = content; 
		WXMediaMessage msg = new WXMediaMessage(); 
		msg.mediaObject = text;
	    msg.title = text1;  
	    msg.description = text1;    
	    SendMessageToWX.Req req = new SendMessageToWX.Req();  
	    req.transaction = String.valueOf(System.currentTimeMillis());  
	    req.message = msg;  
	    req.scene = i;
	    MainActivity.api.sendReq(req);  
	}


}
