package com.example.andreacorronca.myapplicationtest;

import android.provider.BaseColumns;

public final class GameContract {

    private GameContract(){}

    public static class GameEntry implements BaseColumns {
        public static final String TABLE_NAME = "games";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_IMG_ID = "imgId";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_DISCOUNT = "discount";
        public static final String COLUMN_NAME_METACRITIC = "metacritic";
        public static final String COLUMN_NAME_USERS_VOTE = "usersVote";
        public static final String COLUMN_NAME_FIRST_GENRE = "firstGenre";
        public static final String COLUMN_NAME_SECOND_GENRE = "secondGenre";
        public static final String COLUMN_NAME_SETTING = "setting";
        public static final String COLUMN_NAME_GAME_MODE = "gameMode";
        public static final String COLUMN_NAME_IS_EARLY_ACCESS = "isEarlyAccess";
        public static final String COLUMN_NAME_IS_FREE_TO_PLAY = "isFreeToPlay";
    }
}
