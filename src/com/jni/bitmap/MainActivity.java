package com.jni.bitmap;

import java.io.File;
import java.io.IOException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.jni.datatype.DataType;
import com.jni.io.IO;
import com.jni.jcf.JCF;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Toast.makeText(
		// this,
		// HW.getABI() + " -- > " + Lib.getPower() + " -- > "
		// + Lib.getPower2(), 1).show();

		TextView tv = (TextView) findViewById(R.id.tv);
		byte[] bts = new byte[] { 10, 20 };
		DataType.getValueFromJava(12, "javaString#Hello", bts);
		tv.setText(bts + " - " + JCF.getJCF());
		//
		tv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,
						CameraActivity.class));
			}
		});
	}

	protected void ioOperation(TextView tv) {
		File root = Environment.getExternalStorageDirectory();
		File ioTest = new File(root, "iotest.txt");
		try {
			ioTest.createNewFile();
		} catch (IOException e) {
			System.out.println("ex: " + e);
		}
		// IO.writeFile(ioTest.getAbsolutePath(), "FuckYYN");
		// IO.appendFile(ioTest.getAbsolutePath(), "FuckYYN2");
		String ct = IO.readFile(ioTest.getAbsolutePath());
		tv.setText(ct);
	}

	protected void huiduBitmap() {
		ImageView iv = (ImageView) findViewById(R.id.iv);
		Bitmap bmp = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		bmp = bmp.copy(bmp.getConfig(), true);
		Bmp.huidu(bmp);
		iv.setImageBitmap(bmp);
	}

}
