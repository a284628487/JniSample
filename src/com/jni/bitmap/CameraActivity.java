package com.jni.bitmap;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;

@SuppressLint("NewApi")
public class CameraActivity extends Activity implements SurfaceTextureListener {
	final String TAG = "CameraActivity";
	private TextureView mTextureView;
	private Camera mCamera;
	private Bitmap mBmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.aty_camera);
		
		mTextureView = (TextureView) findViewById(R.id.textureView);
		mTextureView.setSurfaceTextureListener(this);
		mBmp = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
	}

	private void openCameraAndPreview(final SurfaceTexture surface, final int width,
			final int height) {
		mCamera = Camera.open();
		mCamera.setDisplayOrientation(90);
		try {
			mCamera.setPreviewTexture(surface);
			mCamera.startPreview();
			mCamera.addCallbackBuffer(new byte[46080]);
			mCamera.setPreviewCallback(new PreviewCallback() {
				@Override
				public void onPreviewFrame(byte[] data, Camera camera) {
					// 46080 720 640
//					Log.e(TAG, "onPreviewFrame: " + data.length + " width= "
//							+ width + " ;height= " + height);
					camera.addCallbackBuffer(data);
					
					mBmp = BitmapFactory.decodeByteArray(data, 0, data.length);
					Log.e(TAG, "onPreviewFrame: " + mBmp);
				}
			});
		} catch (IOException ioe) {
			// Something bad happened
		}
	}

	private void stopCamera() {
		if (null == mCamera) {
			return;
		}
		mCamera.stopPreview();
		mCamera.release();
	}

	@Override
	public void onSurfaceTextureAvailable(SurfaceTexture surface, int width,
			int height) {
		openCameraAndPreview(surface, width, height);
	}

	@Override
	public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width,
			int height) {
	}

	@Override
	public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
		stopCamera();
		return true;
	}

	@Override
	public void onSurfaceTextureUpdated(SurfaceTexture surface) {
	}

}

// https://blog.csdn.net/oShunz/article/details/49862273
// https://blog.csdn.net/ShareUs/article/details/52755809
// https://blog.csdn.net/oShunz/article/details/50537631
// https://blog.csdn.net/oShunz/article/details/50484997
