package com.example.keep.fragmet;

import java.util.ArrayList;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.keep.R;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RunFram  extends Fragment implements BDLocationListener{

	@ViewInject(R.id.main_mapView)
	MapView  mapView;
	View view;
	//定位
	private LocationClient locationClient;
	private BaiduMap baiduMap;
	private ArrayList<LatLng> latlngs;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.fram_run, null);
			x.view().inject(this,view);
			setListener();
			Log.i("测试", "RunFram");
			setData();
		}else{
			((ViewGroup) view.getParent()).removeView(view);
		}
		return view;
	}

	private void setListener() {
		// TODO Auto-generated method stub
		
	}
	private void setData() {
		// TODO Auto-generated method stub
		latlngs=new ArrayList<LatLng>();
		baiduMap=mapView.getMap();
		locationClient=new LocationClient(getActivity());
		locationClient.registerLocationListener(this);
		LocationClientOption option = new LocationClientOption();  
		option.setOpenGps(true); //打开GPRS  
		option.setAddrType("all");//返回的定位结果包含地址信息  
		option.setCoorType("bd09ll");//返回的定位结果是百度经纬度,默认值gcj02  
		option.setScanSpan(1);
		locationClient.start();

	}
	@Override
	public void onReceiveLocation(BDLocation arg0) {
		// 获得等位后的经纬度
		double latitude=arg0.getLatitude();
		double longitude=arg0.getLongitude();
		showToas("纬度="+latitude+",经度="+longitude);
		LatLng latLng=new LatLng(latitude, longitude);
		MapStatusUpdate mapStatusUpdate=MapStatusUpdateFactory.newLatLngZoom(latLng, 17);
		baiduMap.animateMapStatus(mapStatusUpdate);
		//添加图片			
		MarkerOptions markerOptions=new MarkerOptions();
		markerOptions.position(latLng);
		BitmapDescriptor bitmap=BitmapDescriptorFactory.fromResource(R.drawable.icon_marka);
		markerOptions.icon(bitmap);
		baiduMap.addOverlay(markerOptions);
		latlngs.add(latLng);
		if(latlngs.size()==2){
			PolylineOptions polylineOptions=new PolylineOptions();
			polylineOptions.points(latlngs);
			latlngs.clear();
		}
	}


	private void showToas(String msg) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(),msg, 0).show();
	}
}
