package com.example.dragonsage.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<AdapterItem> listnewsData = new ArrayList<>();
    myCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvList = (ListView)findViewById(R.id.lvList);

        listnewsData.add(new AdapterItem(1,"Developer","Develop apps"));
        listnewsData.add(new AdapterItem(2,"Game Developer", "Develop Games"));
        listnewsData.add(new AdapterItem(3,"No Developer", "Develops Nothing"));
        listnewsData.add(new AdapterItem(4,"Developer","Develop apps"));
        listnewsData.add(new AdapterItem(5,"Game Developer", "Develop Games"));
        listnewsData.add(new AdapterItem(6,"No Developer", "Develops Nothing"));
        customAdapter = new myCustomAdapter(listnewsData);

        lvList.setAdapter(customAdapter);
    }

    private class myCustomAdapter extends BaseAdapter{
        public ArrayList<AdapterItem> listnewsDataAdapter;

        public myCustomAdapter(ArrayList<AdapterItem> listnewsDataAdapter){
            this.listnewsDataAdapter = listnewsDataAdapter;

        }

        @Override
        public int getCount() {
            return listnewsDataAdapter.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater myInflater = getLayoutInflater();
            View myView = myInflater.inflate(R.layout.layoutticket, null);

            final AdapterItem adapterItem = listnewsDataAdapter.get(position);

            TextView tvID = (TextView)myView.findViewById(R.id.tvID);
            tvID.setText("Id: "+adapterItem.ID);


            TextView tvTitle = (TextView)myView.findViewById(R.id.tvTitle);
            tvTitle.setText(adapterItem.JobTitle);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), adapterItem.JobTitle, Toast.LENGTH_SHORT).show();
                }
            });

            TextView tvDesc = (TextView)myView.findViewById(R.id.tvDesc);
            tvDesc.setText(adapterItem.Description);

            return myView;
        }
    }
}
