package com.a290.kevin.assignment3_music;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Artist> myArtistList = new ArrayList<Artist>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateList("Choose Genre");
        populateListView();

        Spinner genres = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genres_array ,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genres.setAdapter(adapter);
    }

    private void populateListView() {
        ArrayAdapter<Artist> myAdapter = new myListAdapter();
        ListView myListViewer = (ListView) findViewById(R.id.myArtistListView);
        myListViewer.setAdapter(myAdapter);
    }

    private void populateList(String genre) {
        myArtistList.add(new Artist("Aerosmith", "Aerosmith is an American rock band, sometimes referred to as \"the Bad Boys from Boston\" and \"America's Greatest Rock and Roll Band\".", "Rock and Roll", R.drawable.aerosmith));
        myArtistList.add(new Artist("Led Zeppelin", "Led Zeppelin were an English rock band formed in London in 1968. The group consisted of guitarist Jimmy Page, singer Robert Plant, bassist and keyboardist John Paul Jones, and drummer John Bonham.", "Rock and Roll", R.drawable.zeppelin));
        myArtistList.add(new Artist("Katy Perry", "Katheryn Elizabeth Hudson (born October 25, 1984), known professionally as Katy Perry, is an American singer and songwriter.", "Pop", R.drawable.perry));
        myArtistList.add(new Artist("Rush", "Rush is a Canadian rock band composed of Geddy Lee (bass guitar, lead vocals, keyboards), Alex Lifeson (guitars, backing vocals) and Neil Peart (drums, percussion, lyrics).", "Rock and Roll", R.drawable.rush));
        myArtistList.add(new Artist("Tupac", "Tupac Amaru Shakur (born Lesane Parish Crooks; June 16, 1971 – September 13, 1996), also known by his stage names 2Pac and Makaveli, was an American rapper and actor.", "Rap", R.drawable.tupac));
        myArtistList.add(new Artist("The Beatles", "The Beatles were an English rock band formed in Liverpool in 1960. With members John Lennon, Paul McCartney, George Harrison and Ringo Starr, they became widely regarded as the foremost and most influential act of the rock era.", "Rock and Roll", R.drawable.beatles));
        myArtistList.add(new Artist("The Rolling Stones", "The Rolling Stones are an English rock band formed in London in 1962. The first stable line-up consisted of Brian Jones (guitar, harmonica), Mick Jagger (lead vocals), Keith Richards (guitar, backing vocals), Bill Wyman (bass), Charlie Watts (drums), and Ian Stewart (piano).", "Rock and Roll", R.drawable.stones));


        if(genre.equals("Pop")){
            myArtistList.clear();
            myArtistList.add(new Artist("Katy Perry", "Katheryn Elizabeth Hudson (born October 25, 1984), known professionally as Katy Perry, is an American singer and songwriter.", "Pop", R.drawable.perry));
        } else if(genre.equals("Rap")){
            myArtistList.clear();
            myArtistList.add(new Artist("Tupac", "Tupac Amaru Shakur (born Lesane Parish Crooks; June 16, 1971 – September 13, 1996), also known by his stage names 2Pac and Makaveli, was an American rapper and actor.", "Rap", R.drawable.tupac));
        } else if(genre.equals("Rock and Roll")) {
            myArtistList.clear();
            myArtistList.add(new Artist("Aerosmith", "Aerosmith is an American rock band, sometimes referred to as \"the Bad Boys from Boston\" and \"America's Greatest Rock and Roll Band\".", "Rock and Roll", R.drawable.aerosmith));
            myArtistList.add(new Artist("Led Zeppelin", "Led Zeppelin were an English rock band formed in London in 1968. The group consisted of guitarist Jimmy Page, singer Robert Plant, bassist and keyboardist John Paul Jones, and drummer John Bonham.", "Rock and Roll", R.drawable.zeppelin));
            myArtistList.add(new Artist("Rush", "Rush is a Canadian rock band composed of Geddy Lee (bass guitar, lead vocals, keyboards), Alex Lifeson (guitars, backing vocals) and Neil Peart (drums, percussion, lyrics).", "Rock and Roll", R.drawable.rush));
            myArtistList.add(new Artist("The Beatles", "The Beatles were an English rock band formed in Liverpool in 1960. With members John Lennon, Paul McCartney, George Harrison and Ringo Starr, they became widely regarded as the foremost and most influential act of the rock era.", "Rock and Roll", R.drawable.beatles));
            myArtistList.add(new Artist("The Rolling Stones", "The Rolling Stones are an English rock band formed in London in 1962. The first stable line-up consisted of Brian Jones (guitar, harmonica), Mick Jagger (lead vocals), Keith Richards (guitar, backing vocals), Bill Wyman (bass), Charlie Watts (drums), and Ian Stewart (piano).", "Rock and Roll", R.drawable.stones));
        } else {
            myArtistList.clear();
            myArtistList.add(new Artist("Aerosmith", "Aerosmith is an American rock band, sometimes referred to as \"the Bad Boys from Boston\" and \"America's Greatest Rock and Roll Band\".", "Rock and Roll", R.drawable.aerosmith));
            myArtistList.add(new Artist("Led Zeppelin", "Led Zeppelin were an English rock band formed in London in 1968. The group consisted of guitarist Jimmy Page, singer Robert Plant, bassist and keyboardist John Paul Jones, and drummer John Bonham.", "Rock and Roll", R.drawable.zeppelin));
            myArtistList.add(new Artist("Katy Perry", "Katheryn Elizabeth Hudson (born October 25, 1984), known professionally as Katy Perry, is an American singer and songwriter.", "Pop", R.drawable.perry));
            myArtistList.add(new Artist("Rush", "Rush is a Canadian rock band composed of Geddy Lee (bass guitar, lead vocals, keyboards), Alex Lifeson (guitars, backing vocals) and Neil Peart (drums, percussion, lyrics).", "Rock and Roll", R.drawable.rush));
            myArtistList.add(new Artist("Tupac", "Tupac Amaru Shakur (born Lesane Parish Crooks; June 16, 1971 – September 13, 1996), also known by his stage names 2Pac and Makaveli, was an American rapper and actor.", "Rap", R.drawable.tupac));
            myArtistList.add(new Artist("The Beatles", "The Beatles were an English rock band formed in Liverpool in 1960. With members John Lennon, Paul McCartney, George Harrison and Ringo Starr, they became widely regarded as the foremost and most influential act of the rock era.", "Rock and Roll", R.drawable.beatles));
            myArtistList.add(new Artist("The Rolling Stones", "The Rolling Stones are an English rock band formed in London in 1962. The first stable line-up consisted of Brian Jones (guitar, harmonica), Mick Jagger (lead vocals), Keith Richards (guitar, backing vocals), Bill Wyman (bass), Charlie Watts (drums), and Ian Stewart (piano).", "Rock and Roll", R.drawable.stones));
        }
    }

    public void chooseGenreEventHandler(View view) {Button logIn = (Button) findViewById(R.id.chooseGenre);
        Spinner genres = (Spinner) findViewById(R.id.spinner);
        String choice = genres.getSelectedItem().toString();

        populateList(choice);
        populateListView();
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
