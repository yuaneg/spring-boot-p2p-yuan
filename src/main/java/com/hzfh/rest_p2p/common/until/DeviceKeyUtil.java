package com.hzfh.rest_p2p.common.until;

import com.hzfh.rest_p2p.common.config.common.WebInfo;
import com.hzfh.rest_p2p.common.parameter.DeviceOrigin;


/**
 * 根据设备类型获得相应的公钥
 * Created by 袁恩光 on 2017/3/18.
 */
public class DeviceKeyUtil {

    public static String getDeviceKey(DeviceOrigin deviceOrigin){
        switch (deviceOrigin){
            case PC:
                return WebInfo.getRsaPCPublicKey();
            case ANDROID:
                return WebInfo.getRsaAndroidPublicKey();
            case IPHONE:
                return WebInfo.getResaIphonePublicKey();
            case WAP:
                return "";
            case IPAD:
                return "";
            case TABLE:
                return "";
            default:
                return "";
        }
    }

}
