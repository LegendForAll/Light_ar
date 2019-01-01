package com.example.hothaingoc.chemicallight;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter() {
    }

    public SlideAdapter(Context context) {
        this.context = context;
    }

    //Tile slide
    public String[] lsTile = {
            "",
            ""
    };

    //Image background slide
    public int[] lsImg = {
            R.drawable.intro_1,
            R.drawable.intro_2
    };

    @Override
    public int getCount() {
        return lsTile.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_intro,container,false);

        LinearLayout layoutSl = (LinearLayout) view.findViewById(R.id.slide_lay);
        TextView text_Tile = (TextView) view.findViewById(R.id.txt_tile);

        layoutSl.setBackgroundResource(lsImg[position]);
        text_Tile.setText(lsTile[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
