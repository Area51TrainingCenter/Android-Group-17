package com.johannfjs.mod1class6_1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.johannfjs.adapters.ViewPagerAdapter;
import com.johannfjs.views.DepthPageTransformer;

public class MostrarActivity extends AppCompatActivity {//FragmentActivity
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        Bundle bundle = getIntent().getExtras();
        int posicion = bundle.getInt("posicion");
        viewPager.setCurrentItem(posicion);
    }
}
