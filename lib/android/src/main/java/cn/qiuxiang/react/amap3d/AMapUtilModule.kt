package cn.qiuxiang.react.amap3d

import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.CoordinateConverter.CoordType;
import com.amap.api.maps.model.LatLng;
import cn.qiuxiang.react.amap3d.toLatLng;

import com.facebook.react.bridge.ReadableMap;

import com.facebook.react.bridge.*
import com.facebook.react.modules.core.DeviceEventManagerModule

@Suppress("unused")
class AMapUtilModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "AMapUtil"
    }

    @ReactMethod
    fun converter(coordinate: ReadableMap, promise: Promise) {
        
        val converter  = CoordinateConverter(reactContext); 
        // CoordType.GPS 待转换坐标类型
        converter.from(CoordType.valueOf("BAIDU")); 
        // sourceLatLng待转换坐标点 LatLng类型
        converter.coord(coordinate.toLatLng()); 
        // 执行转换操作
        val desLatLng = converter.convert();
        
        promise.resolve(desLatLng.toWritableMap());
        
    }
}