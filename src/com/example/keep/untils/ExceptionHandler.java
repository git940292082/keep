package com.example.keep.untils;

import java.io.PrintWriter;
import java.io.StringWriter;

import android.util.Log;


/**
 * 统一处理异常
 * 
 * @author pjy
 * 
 */
public class ExceptionHandler {
	public static void handlerException(Throwable e) {
		// 判断是不是开发阶段
			// 把异常信息转成字符串
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			// 异常信息先打到printWriter,再打到stringWriter
			e.printStackTrace(printWriter);
			String str = stringWriter.toString();
			// 用volley发给服务器
//			Log.i("异常信息", str);
			e.printStackTrace();
	}
}
