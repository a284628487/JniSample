//package com.jni.bitmap;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.hardware.camera2.CameraAccessException;
//import android.hardware.camera2.CameraDevice;
//import android.hardware.camera2.CameraDevice.StateCallback;
//import android.hardware.camera2.CameraManager;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.os.Looper;
//
//@SuppressLint("NewApi")
//public class Camera2Activity extends Activity {
//	final String TAG = "CameraActivity";
//
//	private HandlerThread mDecodeThread;
//	private Handler mDecodeHandler;
//	private CameraManager mManager;
//	private StateCallback mCameraStateCallback;
//	private CameraDevice mCameraDevice;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		initDecodeHandler();
//		initCameraStateCallback();
//		openCamera();
//	}
//	
//	private void openCamera() {
//		mManager = (CameraManager) getSystemService(CAMERA_SERVICE);
//		String[] ids;
//		try {
//			ids = mManager.getCameraIdList();
//			if (null != ids && ids.length > 0) {
//				mManager.openCamera(ids[0], mCameraStateCallback, mDecodeHandler);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void initDecodeHandler() {
//		mDecodeThread = new HandlerThread("camera-decode");
//		mDecodeThread.start();
//		Looper looper = mDecodeThread.getLooper();
//		mDecodeHandler = new Handler(looper);
//	}
//	
//	private void initCameraStateCallback() {
//		mCameraStateCallback = new StateCallback() {
//			
//			@Override
//			public void onOpened(CameraDevice camera) {
//				mCameraDevice = camera;
//			}
//			
//			@Override
//			public void onError(CameraDevice camera, int error) {
//				
//			}
//			
//			@Override
//			public void onDisconnected(CameraDevice camera) {
//				
//			}
//		};
//	}
//	
//	private void startPreview() {
////		mCameraDevice.
//	}
//
//}
