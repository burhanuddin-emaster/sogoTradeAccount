package com.provider.sogotrade;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import android.util.Log;
import android.os.Bundle;
import android.widget.Button;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;


import com.example.ui.open_account.Step1;
import com.example.ui.open_account.models.OpenAccountModel;

public class RNSogoTradeModule extends ReactContextBaseJavaModule {

  private static ReactApplicationContext reactContext;

  private static final String DURATION_SHORT_KEY = "SHORT";
  private static final String DURATION_LONG_KEY = "LONG";

  RNSogoTradeModule(ReactApplicationContext context) {
    super(context);
    reactContext = context;
  }

  @Override
  public String getName() {
    return "RNSogoTrade";
  }

  @ReactMethod
  public void startAction() {
    try {
      final Activity activity = getCurrentActivity();
      Intent intent = new Intent(activity, Step1.class);
      OpenAccountModel.getModel().setOpenAccountURL("https://applyqa.sogotrade.com/");
      OpenAccountModel.getModel().setAuthorities("com.example.provider");
      activity.startActivity(intent);
    }catch(Exception e){
      Log.e("Exce", String.valueOf(e));
    }
  }

}
