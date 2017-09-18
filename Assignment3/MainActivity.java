package com.a290.kevin.assignment3music;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Artist> myArtistList = new ArrayList<Artist>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateList();
        populateListView();
    }

    private void populateListView() {
        ArrayAdapter<Artist> myAdapter = new myListAdapter();
        ListView myListViewer = (ListView) findViewById(R.id.myArtistListView);
        myListViewer.setAdapter(myAdapter);
    }

    private void populateList() {
        myArtistList.add(new Artist("The Beatles", "John Lennon", "Rock and Roll", R.drawable.beatles));
        myArtistList.add(new Artist("Aerosmith", "Steven Tyler", "Rock and Roll", R.drawable.aerosmith));
        myArtistList.add(new Artist("The Rolling Stones", "Mick Jagger", "Rock and Roll", R.drawable.stones));
        myArtistList.add(new Artist("Rush", "Geddy Lee", "Rock and Roll", R.drawable.rush));
        myArtistList.add(new Artist("Led Zeppelin", "John Bonham", "Rock and Roll", R.drawable.zeppelin));
    }

    private class myListAdapter extends ArrayAdapter<Artist> {
        public myListAdapter() {
            super(MainActivity.this, R.layout.artist_layout, myArtistList);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            if (itemView ==null){
                itemView = getLayoutInflater().inflate(R.layout.artist_layout, parent, false);
            }

            Artist currentArtist = myArtistList.get(position);

            ImageView itemImage = (ImageView) itemView.findViewById(R.id.artist_ImageView);
            itemImage.setImageResource(currentArtist.getArtistId());

            TextView itemDescription = (TextView) itemView.findViewById(R.id.artistDescription);
            itemDescription.setText(currentArtist.getDescription());

            TextView itemGenre = (TextView) itemView.findViewById(R.id.artistGenre);
            itemGenre.setText(currentArtist.getGenre());

            TextView itemName = (TextView) itemView.findViewById(R.id.artistName);
            itemName.setText(currentArtist.getName());

            return itemView;
        }

    }

}
