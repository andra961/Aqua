package com.example.andreacorronca.myapplicationtest;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HighestScores extends ArrayList<PreferenceScore> {

    public boolean add(PreferenceScore p){

        if (!(super.add(p)))
            return false;

        Collections.sort(this,new CustomComparator());
        Collections.reverse(this);
        if (this.size()> 5){
            this.remove(5);
        }

        return true;
    }

    public ArrayList<Game> toGames (Context context){

        ArrayList<Game> list = new ArrayList<>();
        for(PreferenceScore p : this){
            list.add(GamesCathalogDbHelper.getGameById(p.getId(),context));
        }
        return list;
    }

    public class CustomComparator implements Comparator<PreferenceScore> {
        @Override
        public int compare(PreferenceScore o1, PreferenceScore o2) {
            return new Integer(o1.getScore()).compareTo(new Integer(o2.getScore()));
        }
    }


}

