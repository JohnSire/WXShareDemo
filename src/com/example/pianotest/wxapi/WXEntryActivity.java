package com.example.pianotest.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.example.pianotest.MainActivity;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/** ΢�ſͻ��˻ص�activityʾ�� */  
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {  
	//��������������΢�ŷ��ص���Ϣ���ͣ��ǶԵ�¼�Ĵ����ǶԷ���Ĵ�����¼���ں�����ܵ�
	  private static final int RETURN_MSG_TYPE_LOGIN = 1;
	  private static final int RETURN_MSG_TYPE_SHARE = 2;

	  private static final String TAG = "WXEntryActivity";
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, 
	    		WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

	   MainActivity.api.handleIntent(getIntent(), this);
	  }


	  //΢�ŷ�����Ϣ��app��app���ܲ�����Ļص�����
	  @Override
	  public void onReq(BaseReq baseReq) {

	  }

	  //app������Ϣ��΢�ţ�΢�ŷ��ص���Ϣ�ص�����,���ݲ�ͬ�ķ��������жϲ����Ƿ�ɹ�
	  @Override
	  public void onResp(BaseResp resp) {
	    switch (resp.errCode) {
	      case BaseResp.ErrCode.ERR_AUTH_DENIED:
	    	  Log.d("weixin", "�ܾ�");
	    	  finish();
	    	  break;
	      case BaseResp.ErrCode.ERR_USER_CANCEL:
	    	  Log.d("weixin", "ʧ��");
//	        showToast("΢��ʧ��");
	    	  finish();
	        break;
	      case BaseResp.ErrCode.ERR_COMM:
	    	  Log.d("weixin", "�ܾ�2");
	    	  finish();
	    	  break;
	      case BaseResp.ErrCode.ERR_SENT_FAILED:
	    	  Log.d("weixin", "�ܾ�3");
	    	  finish();
	    	  break;
	      case BaseResp.ErrCode.ERR_UNSUPPORT:
	    	  Log.d("weixin", "�ܾ�4");
	    	  finish();
	    	  break;
	      case BaseResp.ErrCode.ERR_OK:
	        switch (resp.getType()) {
	          case RETURN_MSG_TYPE_SHARE:
	        	  Log.d("weixin", "�ɹ�");
//	            showToast("΢�ŷ���ɹ�");
	            finish();
	            break;
	          case RETURN_MSG_TYPE_LOGIN:
	        	  finish();
	        	  break;
	        }
	        break;
	    }
	  }
}
