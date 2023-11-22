package com.example.aulasensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.auladois.R;

import sun.management.Sensor;

public class MainActivity extends AppCompatActivity {

    SensorManager mSensorManager;
    android.hardware.Sensor mSensorLight;
    TextView mtvLight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtvLight.findViewById(R.id.tvSensorLight);

        mSensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener((SensorEventListener) this, mSensorLight,SensorManager.SENSOR_DELAY_FASTEST);

    }

    @Override
    public void onSensorChange (SensorEvent event){

    }

    @Override
    public void onAcurrencyChange(Sensor sensor, int acurrency){

    }

}