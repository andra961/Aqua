package com.example.andreacorronca.myapplicationtest;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Game {

    private int id;
    private String name;
    private int imgId;
    private float price;
    private int discount;
    private int metacritic;
    private int usersVote;
    private int firstGenre;
    private int secondGenre;
    private int setting;
    private int gameMode;
    private boolean isEarlyAccess;
    private boolean isFreeToPlay;

    public Game(int id, String name, int imgId, float price,int discount, int metacritic, int usersVote, int firstGenre, int secondGenre, int setting, int gameMode, boolean isEarlyAccess, boolean isFreeToPlay) {
        this.setId(id);
        this.setName(name);
        this.setImgId(imgId);
        this.setPrice(price);
        this.setDiscount(discount);
        this.setMetacritic(metacritic);
        this.setUsersVote(usersVote);
        this.setFirstGenre(firstGenre);
        this.setSecondGenre(secondGenre);
        this.setSetting(setting);
        this.setGameMode(gameMode);
        this.setEarlyAccess(isEarlyAccess);
        this.setFreeToPlay(isFreeToPlay);
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Game other = (Game) obj;
        if (!(this.getId() == ((Game) obj).getId())){
            return false;
        }

        return true;
    }



    public static String getGenre(int id){

        String genre ="";

        switch (id){
            case 0:
                genre = "GDR";
                break;

            case 1:
                genre = "Azione";
                break;

            case 2:
                genre = "Survival";
                break;

            case 3:
                genre = "Avventura";
                break;

            case 4:
                genre = "Picchiaduro";
                break;

            case 5:
                genre = "Racing";
                break;

            case 6:
                genre = "Sparatutto";
                break;

            case 7:
                genre = "Strategia";
                break;

            case 8:
                genre = "Platform";
                break;
            case 9:
                genre = "Stealth";
                break;

            case 10:
                genre = "Carte";
                break;

            case 11:
                genre = "Gestionale";
                break;
        }

        return genre;
    }

    public static String getSetting(int id){

        String setting ="";

        switch (id){
            case 0:
                setting = "Futuristica";
                break;

            case 1:
                setting = "Moderna";
                break;

            case 2:
                setting = "Fantasy";
                break;

            case 3:
                setting = "Horror";
                break;

            case 4:
                setting = "Guerra";
                break;

            case 5:
                setting = "Storica";
                break;

        }

        return setting;
    }

    public static String getMode(int id){

        String mode ="";

        switch (id){
            case 0:
                mode = "Giocatore Singolo";
                break;

            case 1:
                mode = "Multiplayer Locale";
                break;

            case 2:
                mode = "Multiplayer Online";
                break;

        }

        return mode;
    }

    public static float getTotalPrice(ArrayList<Game> cart){

        float total = 0;


        for (Game game : cart) {
            total += game.getPrice();
            //decFormat.format(decFormat + game.getPrice());
        }

        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public int getUsersVote() {
        return usersVote;
    }

    public void setUsersVote(int usersVote) {
        this.usersVote = usersVote;
    }

    public int getFirstGenre() {
        return firstGenre;
    }

    public void setFirstGenre(int firstGenre) {
        this.firstGenre = firstGenre;
    }

    public int getSecondGenre() {
        return secondGenre;
    }

    public void setSecondGenre(int secondGenre) {
        this.secondGenre = secondGenre;
    }

    public int getSetting() {
        return setting;
    }

    public void setSetting(int setting) {
        this.setting = setting;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public boolean isEarlyAccess() {
        return isEarlyAccess;
    }

    public void setEarlyAccess(boolean earlyAccess) {
        isEarlyAccess = earlyAccess;
    }

    public boolean isFreeToPlay() {
        return isFreeToPlay;
    }

    public void setFreeToPlay(boolean freeToPlay) {
        isFreeToPlay = freeToPlay;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
