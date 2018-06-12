package com.example.andreacorronca.myapplicationtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/*
GENERI:

0 -> gdr
1 -> azione
2 -> survival
3 -> avventura
4 -> picchiaduro
5 -> racing
6 -> sparatutto
7 -> strategia
8 -> platform
9 -> stealth
10 -> carte
11 -> gestionale

AMBIENTAZIONE:

0 -> futuristica
1 -> attuale
2 -> fantasy
3 -> horror
4 -> guerra
5 -> passato

MODALITA'

0 -> giocatore singolo
1 -> multy locale
2 -> multy online
*/
public class GamesCathalogDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_GAMES_DB =
            "CREATE TABLE " + GameContract.GameEntry.TABLE_NAME + " (" +
                    GameContract.GameEntry._ID + " INTEGER PRIMARY KEY," +
                    GameContract.GameEntry.COLUMN_NAME_NAME + " TEXT," +
                    GameContract.GameEntry.COLUMN_NAME_IMG_ID + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_PRICE + " REAL," +
                    GameContract.GameEntry.COLUMN_NAME_DISCOUNT + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_METACRITIC + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_USERS_VOTE + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_SETTING + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_GAME_MODE + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS + " INTEGER," +
                    GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + GameContract.GameEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "GamesCathalog.db";

    public GamesCathalogDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_GAMES_DB);
        ContentValues initialValues = new ContentValues();
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Metal Gear Solid 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.mgs2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 96);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 87);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 9);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "God of War");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.god_of_war);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 69.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 94);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 92);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Persona 5");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.persona5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 20);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 93);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 91);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 11);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Silent Hill 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.sh2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 89);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 89);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Halo 3");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.halo3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 94);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Assassin's Creed: Origins");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.ac_origins);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 81);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 72);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Elex");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.elex);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 20);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 67);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 68);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Sea of Thieves");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.s_o_t);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 69.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 69);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Cuphead");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.cuphead);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 83);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 8);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Hearthstone");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.hearthstone);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 0.0F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 61);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 10);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 1);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Dark Souls");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.dark_souls);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 89);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 89);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Divinity: Original Sin 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.divinity2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 20);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 93);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 83);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Hitman");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.hitman);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 85);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 72);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 9);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Metal Gear Solid 3");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.mgs3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 91);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 90);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 9);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "The Last Of Us");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.the_last_of_us);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 95);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 92);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Batman: Arkham Knight");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.arkham_knight);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 20);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 87);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 78);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Zelda: Breath Of The Wild");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.zelda);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 59.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 97);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 85);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "ARK: SURVIVAL EVOLVED");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.ark);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 49.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 69);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 42);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Borderlands 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.borderlands2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 89);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 82);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Dawn of War 3");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.dawn_of_war3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 30);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 77);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 45);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Dragon Ball: FighterZ");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.db_fighterz);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 49.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 87);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 80);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Destiny 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.destiny2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 29.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 40);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 85);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 49);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Doom");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.doom);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 85);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 83);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "The Elder Scrolls: Legends");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.elder_scrolls_legends);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 0.0F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 80);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 57);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 10);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 1);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "For honor");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.for_honor);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 78);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 61);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Forza Horizon 3");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.forza_3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 30);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 91);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 80);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Gwent");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.gwent);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 0.0F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 91);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 80);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 10);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 1);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Player Unknown's BattleGrounds");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.player_unknown);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 29.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 86);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 45);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Fortnite");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.fortnite);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 29.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 78);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 34);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 1);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Starcraft 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.starcraft2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 93);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 82);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "TEKKEN 7");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.tekken7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 82);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 68);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Wolfenstein 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.wolfenstein2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 20);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 87);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 76);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Xcom 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.xcom2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 72);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 11);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Deus Ex: Mankind Divided");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.deus_ex);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 84);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 76);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 9);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Dishonored 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.dishonored2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 29.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 79);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 9);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Prey");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.prey);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 29.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 84);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 78);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 9);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Super Mario Odyssey");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.mario_odissey);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 59.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 97);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 8);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Forza Motorsport 7");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.forza7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 30);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 86);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 58);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Gears of War 4");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.gears4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 84);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 69);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Gran Turismo Sport");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.gt_sport);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 20);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 75);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 60);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Injustice 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.injustice);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 87);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 82);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Mario Kart 8");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.mario_kart);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 39.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 89);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 5);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Mortal Kombat X");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.mortal_kombat);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 30);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 83);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 78);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Rainbow Six: Siege");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.rainbow_six);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 79);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 71);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "TEKKEN TAG TOURNAMENT 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.tekken_tag_2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 82);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 83);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Halo Wars 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.halo_wars_2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 29.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 20);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 79);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 59);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Recore");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.recore);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 14.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 63);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 67);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Divinity: Original Sin");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.divinity);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 87);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 87);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Pillars of Eternity");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.pillars_of_eternity);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 5.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 70);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 89);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 83);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Call of Duty 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.cod2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 86);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 84);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Company of Heroes");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.company_of_heroes);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 93);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 4);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Super Mario Galaxy 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.galaxy_2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 97);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 91);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 8);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Gothic 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.gothic_2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 79);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 89);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "The Witcher 3");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.the_witcher_3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 50);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 93);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 93);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 1);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Ori and the Blind Forest");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.ori);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 5.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 60);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 88);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 86);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 8);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Ratchet and Clank");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.ratchet_clank);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 85);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 86);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 8);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Gravity Rush 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.gravity_rush_2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 80);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 83);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 8);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 12);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Dead Space 2");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.dead_space_2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 9.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 90);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 86);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 6);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);

        initialValues = new ContentValues();

        initialValues.put(GameContract.GameEntry.COLUMN_NAME_NAME, "Resident Evil 7");
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IMG_ID,R.drawable.re7);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_PRICE, 19.99F);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_DISCOUNT, 30);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_METACRITIC, 86);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_USERS_VOTE, 78);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_FIRST_GENRE, 2);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SECOND_GENRE, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_SETTING, 3);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_GAME_MODE, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_EARLY_ACCESS, 0);
        initialValues.put(GameContract.GameEntry.COLUMN_NAME_IS_FREE_TO_PLAY, 0);

        db.insert(GameContract.GameEntry.TABLE_NAME, null, initialValues);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public static ArrayList<Game> getAllGames(Context context){

        SQLiteDatabase db = new GamesCathalogDbHelper(context).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + GameContract.GameEntry.TABLE_NAME,null);

        return GamesCathalogDbHelper.getGamesByCursor(cursor);
    }

    public  static Game getGameById(int id,Context context){

        SQLiteDatabase db = new GamesCathalogDbHelper(context).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + GameContract.GameEntry.TABLE_NAME + " WHERE _id = " + id,null);

        ArrayList<Game> results = GamesCathalogDbHelper.getGamesByCursor(cursor);

        Game game = results.get(0);

        return game;

    }

    public static ArrayList<Game> getGamesByCursor(Cursor cursor){
            ArrayList<Game> gameList = new ArrayList<>();
            while (cursor.moveToNext()){
                gameList.add(new Game(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getFloat(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),cursor.getInt(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10),(cursor.getInt(11) != 0),(cursor.getInt(12) != 0)));
            }

            return  gameList;
    }
}
