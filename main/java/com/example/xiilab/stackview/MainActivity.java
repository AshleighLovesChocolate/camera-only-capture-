package com.example.xiilab.stackview;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.StackView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackView stackView = (StackView) findViewById(R.id.stackview);
        stackView.setAdapter(new ImageAdapater(this));

    }

    private class ImageAdapater implements Adapter {
        private Context context;
        Integer[] images = {
                R.drawable.survey_thumbnail_big,

                R.drawable.survey_thumbnail_big,

                R.drawable.survey_thumbnail_big,

                R.drawable.survey_thumbnail_big,

                R.drawable.survey_thumbnail_big
        };
        public ImageAdapater(Context c) {
            context = c;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater vi = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.item_stack_view, null, false);
            }
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageView.setImageResource(images[position]);
            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}
