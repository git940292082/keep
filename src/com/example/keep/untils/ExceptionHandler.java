package com.example.keep.untils;

import java.io.PrintWriter;
import java.io.StringWriter;

import android.util.Log;


/**
 * ͳһ�����쳣
 * 
 * @author pjy
 * 
 */
public class ExceptionHandler {
	public static void handlerException(Throwable e) {
		// �ж��ǲ��ǿ����׶�
			// ���쳣��Ϣת���ַ���
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			// �쳣��Ϣ�ȴ�printWriter,�ٴ�stringWriter
			e.printStackTrace(printWriter);
			String str = stringWriter.toString();
			// ��volley����������
//			Log.i("�쳣��Ϣ", str);
			e.printStackTrace();
	}
}
