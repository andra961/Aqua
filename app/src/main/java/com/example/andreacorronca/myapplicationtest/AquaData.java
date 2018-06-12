package com.example.andreacorronca.myapplicationtest;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AquaData extends Application{

    private Boolean mustRefreshSearch = false;

    private String userName = "";

    private Game currentGame;

    private String lastQuery = "";

    private int adviceTabSelected = 0;

    private ArrayList<String> filterSelection = new ArrayList<String>((Arrays.asList("default")));

    private ArrayList<Game> wishList = new ArrayList<>();

    private ArrayList<Game> library = new ArrayList<>();

    private ArrayList<Game> cart = new ArrayList<>();

    private HashMap<Integer,Integer> votes = new HashMap<>();

    private int gdrPreference = 2;
    private int actionPreference = 2;
    private int survivalPreference = 2;

    private int adventurePreference = 2;
    private int fightingPreference = 2;
    private int racingPreference = 2;

    private int shooterPreference = 2;
    private int strategyPreference = 2;
    private int platformPreference = 2;

    private int stealthPreference = 2;
    private int cartePreference = 2;
    private int gestionalePreference = 2;



    private int futuristicPreference = 2;
    private int actualPreference = 2;
    private int fantasyPreference = 2;

    private int horrorPreference = 2;
    private int warPreference = 2;
    private int pastPreference = 2;



    private int singlePreference = 2;
    private int localPreference = 2;
    private int onlinePreference = 2;



    private int earlyAccessPreference = 2;
    private int freeToPlayPreference = 2;
    private int standardPreference = 2;



    private Filter currentFilter = new Filter(true,6,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,false,0.0F,69.99F);

    private ArrayList<Filter> filters = new ArrayList<Filter>((Arrays.asList(getCurrentFilter())));

    private boolean Descending = true;

    private int sortOrder = 6;

    private boolean showGdr = true;

    private boolean showAction = true;

    private boolean showSurvival = true;

    private boolean showAdventure = true;

    private boolean showFighting = true;

    private boolean showRacing = true;

    private boolean showShooter = true;

    private boolean showStrategy = true;

    private boolean showPlatform = true;

    private boolean showStealth = true;

    private boolean showCards = true;

    private boolean showManagerial = true;


    private boolean showFuturistic = true;

    private boolean showActual = true;

    private boolean showFantasy = true;

    private boolean showHorror = true;

    private boolean showWar = true;

    private boolean showPast = true;


    private boolean showSingle = true;

    private boolean showLocal = true;

    private boolean showOnline = true;


    private boolean showFree = true;

    private boolean showEarly = true;

    private boolean showStandard = true;

    private boolean priceRange = false;

    private float minimumPrice = 0.0F;

    private float maximumPrice = 69.99F;

    public int getGenrePreferenceById(int id){
        int preference = 2;

        switch (id){
            case 0:
                preference = getGdrPreference();
                break;

            case 1:
                preference = getActionPreference();
                break;

            case 2:
                preference = getSurvivalPreference();
                break;

            case 3:
                preference = getAdventurePreference();
                break;

            case 4:
                preference = getFightingPreference();
                break;

            case 5:
                preference = getRacingPreference();
                break;

            case 6:
                preference = getShooterPreference();
                break;

            case 7:
                preference = getStrategyPreference();
                break;

            case 8:
                preference = getPlatformPreference();
                break;

            case 9:
                preference = getStealthPreference();
                break;

            case 10:
                preference = getCartePreference();
                break;

            case 11:
                preference = getGestionalePreference();
                break;
        }

        return preference;
    }
    public int getSettingPreferenceById(int id){

        int preference = 2;

        switch (id){
            case 0:
                preference = getFuturisticPreference();
                break;

            case 1:
                preference = getActualPreference();
                break;

            case 2:
                preference = getFantasyPreference();
                break;

            case 3:
                preference = getHorrorPreference();
                break;

            case 4:
                preference = getWarPreference();
                break;

            case 5:
                preference = getPastPreference();
                break;

        }

        return preference;
    }

    public int getGameModePreferenceById(int id){

        int preference = 2;

        switch (id){
            case 0:
                preference = getSinglePreference();
                break;

            case 1:
                preference = getOnlinePreference();
                break;

            case 2:
                preference = getLocalPreference();
                break;

        }

        return preference;
    }

    public int getInfoPreferenceById(boolean free,boolean earlyAccess){
        int preference = 0;
        if (free) preference+= getFreeToPlayPreference();
        if (earlyAccess) preference+= getEarlyAccessPreference();
        if (!free && !earlyAccess) preference+= getStandardPreference();

        return preference;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public int getGdrPreference() {
        return gdrPreference;
    }

    public void setGdrPreference(int gdrPreference) {
        this.gdrPreference = gdrPreference;
    }

    public int getActionPreference() {
        return actionPreference;
    }

    public void setActionPreference(int actionPreference) {
        this.actionPreference = actionPreference;
    }

    public int getSurvivalPreference() {
        return survivalPreference;
    }

    public void setSurvivalPreference(int survivalPreference) {
        this.survivalPreference = survivalPreference;
    }

    public int getAdventurePreference() {
        return adventurePreference;
    }

    public void setAdventurePreference(int adventurePreference) {
        this.adventurePreference = adventurePreference;
    }

    public int getFightingPreference() {
        return fightingPreference;
    }

    public void setFightingPreference(int fightingPreference) {
        this.fightingPreference = fightingPreference;
    }

    public int getRacingPreference() {
        return racingPreference;
    }

    public void setRacingPreference(int racingPreference) {
        this.racingPreference = racingPreference;
    }

    public int getShooterPreference() {
        return shooterPreference;
    }

    public void setShooterPreference(int shooterPreference) {
        this.shooterPreference = shooterPreference;
    }

    public int getStrategyPreference() {
        return strategyPreference;
    }

    public void setStrategyPreference(int strategyPreference) {
        this.strategyPreference = strategyPreference;
    }

    public int getPlatformPreference() {
        return platformPreference;
    }

    public void setPlatformPreference(int platformPreference) {
        this.platformPreference = platformPreference;
    }

    public int getFuturisticPreference() {
        return futuristicPreference;
    }

    public void setFuturisticPreference(int futuristicPreference) {
        this.futuristicPreference = futuristicPreference;
    }

    public int getActualPreference() {
        return actualPreference;
    }

    public void setActualPreference(int actualPreference) {
        this.actualPreference = actualPreference;
    }

    public int getFantasyPreference() {
        return fantasyPreference;
    }

    public void setFantasyPreference(int fantasyPreference) {
        this.fantasyPreference = fantasyPreference;
    }

    public int getHorrorPreference() {
        return horrorPreference;
    }

    public void setHorrorPreference(int horrorPreference) {
        this.horrorPreference = horrorPreference;
    }

    public int getWarPreference() {
        return warPreference;
    }

    public void setWarPreference(int warPreference) {
        this.warPreference = warPreference;
    }

    public int getPastPreference() {
        return pastPreference;
    }

    public void setPastPreference(int pastPreference) {
        this.pastPreference = pastPreference;
    }

    public int getSinglePreference() {
        return singlePreference;
    }

    public void setSinglePreference(int singlePreference) {
        this.singlePreference = singlePreference;
    }

    public int getLocalPreference() {
        return localPreference;
    }

    public void setLocalPreference(int localPreference) {
        this.localPreference = localPreference;
    }

    public int getOnlinePreference() {
        return onlinePreference;
    }

    public void setOnlinePreference(int onlinePreference) {
        this.onlinePreference = onlinePreference;
    }

    public int getEarlyAccessPreference() {
        return earlyAccessPreference;
    }

    public void setEarlyAccessPreference(int earlyAccessPreference) {
        this.earlyAccessPreference = earlyAccessPreference;
    }

    public int getFreeToPlayPreference() {
        return freeToPlayPreference;
    }

    public void setFreeToPlayPreference(int freeToPlayPreference) {
        this.freeToPlayPreference = freeToPlayPreference;
    }

    public String getLastQuery() {
        return lastQuery;
    }

    public void setLastQuery(String lastQuery) {
        this.lastQuery = lastQuery;
    }

    public ArrayList<Game> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<Game> wishList) {
        this.wishList = wishList;
    }

    public ArrayList<Game> getLibrary() {
        return library;
    }

    public void setLibrary(ArrayList<Game> library) {
        this.library = library;
    }

    public ArrayList<Game> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Game> cart) {
        this.cart = cart;
    }

    public int getStandardPreference() {
        return standardPreference;
    }

    public void setStandardPreference(int standardPreference) {
        this.standardPreference = standardPreference;
    }

    public int getStealthPreference() {
        return stealthPreference;
    }

    public void setStealthPreference(int stealthPreference) {
        this.stealthPreference = stealthPreference;
    }

    public int getCartePreference() {
        return cartePreference;
    }

    public void setCartePreference(int cartePreference) {
        this.cartePreference = cartePreference;
    }

    public int getGestionalePreference() {
        return gestionalePreference;
    }

    public void setGestionalePreference(int gestionalePreference) {
        this.gestionalePreference = gestionalePreference;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isDescending() {
        return Descending;
    }

    public void setDescending(boolean descending) {
        this.Descending = descending;
    }

    public float getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(float minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public float getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(float maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public boolean isShowGdr() {
        return showGdr;
    }

    public void setShowGdr(boolean showGdr) {
        this.showGdr = showGdr;
    }

    public boolean isShowAction() {
        return showAction;
    }

    public void setShowAction(boolean showAction) {
        this.showAction = showAction;
    }

    public boolean isShowSurvival() {
        return showSurvival;
    }

    public void setShowSurvival(boolean showSurvival) {
        this.showSurvival = showSurvival;
    }

    public boolean isShowAdventure() {
        return showAdventure;
    }

    public void setShowAdventure(boolean showAdventure) {
        this.showAdventure = showAdventure;
    }

    public boolean isShowFighting() {
        return showFighting;
    }

    public void setShowFighting(boolean showFighting) {
        this.showFighting = showFighting;
    }

    public boolean isShowRacing() {
        return showRacing;
    }

    public void setShowRacing(boolean showRacing) {
        this.showRacing = showRacing;
    }

    public boolean isShowShooter() {
        return showShooter;
    }

    public void setShowShooter(boolean showShooter) {
        this.showShooter = showShooter;
    }

    public boolean isShowStrategy() {
        return showStrategy;
    }

    public void setShowStrategy(boolean showStrategy) {
        this.showStrategy = showStrategy;
    }

    public boolean isShowPlatform() {
        return showPlatform;
    }

    public void setShowPlatform(boolean showPlatform) {
        this.showPlatform = showPlatform;
    }

    public boolean isShowStealth() {
        return showStealth;
    }

    public void setShowStealth(boolean showStealth) {
        this.showStealth = showStealth;
    }

    public boolean isShowCards() {
        return showCards;
    }

    public void setShowCards(boolean showCards) {
        this.showCards = showCards;
    }

    public boolean isShowManagerial() {
        return showManagerial;
    }

    public void setShowManagerial(boolean showManagerial) {
        this.showManagerial = showManagerial;
    }

    public boolean isShowFuturistic() {
        return showFuturistic;
    }

    public void setShowFuturistic(boolean showFuturistic) {
        this.showFuturistic = showFuturistic;
    }

    public boolean isShowActual() {
        return showActual;
    }

    public void setShowActual(boolean showActual) {
        this.showActual = showActual;
    }

    public boolean isShowFantasy() {
        return showFantasy;
    }

    public void setShowFantasy(boolean showFantasy) {
        this.showFantasy = showFantasy;
    }

    public boolean isShowHorror() {
        return showHorror;
    }

    public void setShowHorror(boolean showHorror) {
        this.showHorror = showHorror;
    }

    public boolean isShowWar() {
        return showWar;
    }

    public void setShowWar(boolean showWar) {
        this.showWar = showWar;
    }

    public boolean isShowPast() {
        return showPast;
    }

    public void setShowPast(boolean showPast) {
        this.showPast = showPast;
    }

    public boolean isShowSingle() {
        return showSingle;
    }

    public void setShowSingle(boolean showSingle) {
        this.showSingle = showSingle;
    }

    public boolean isShowLocal() {
        return showLocal;
    }

    public void setShowLocal(boolean showLocal) {
        this.showLocal = showLocal;
    }

    public boolean isShowOnline() {
        return showOnline;
    }

    public void setShowOnline(boolean showOnline) {
        this.showOnline = showOnline;
    }

    public boolean isShowFree() {
        return showFree;
    }

    public void setShowFree(boolean showFree) {
        this.showFree = showFree;
    }

    public boolean isShowEarly() {
        return showEarly;
    }

    public void setShowEarly(boolean showEarly) {
        this.showEarly = showEarly;
    }

    public boolean isShowStandard() {
        return showStandard;
    }

    public void setShowStandard(boolean showStandard) {
        this.showStandard = showStandard;
    }

    public boolean isPriceRange() {
        return priceRange;
    }

    public void setPriceRange(boolean priceRange) {
        this.priceRange = priceRange;
    }

    public int getAdviceTabSelected() {
        return adviceTabSelected;
    }

    public void setAdviceTabSelected(int adviceTabSelected) {
        this.adviceTabSelected = adviceTabSelected;
    }

    public ArrayList<String> getFilterSelection() {
        return filterSelection;
    }

    public void setFilterSelection(ArrayList<String> filterSelection) {
        this.filterSelection = filterSelection;
    }

    public HashMap<Integer, Integer> getVotes() {
        return votes;
    }

    public void setVotes(HashMap<Integer, Integer> votes) {
        this.votes = votes;
    }

    public Filter getCurrentFilter() {
        return currentFilter;
    }

    public void setCurrentFilter(Filter currentFilter) {
        this.currentFilter = currentFilter;
    }

    public ArrayList<Filter> getFilters() {
        return filters;
    }

    public void setFilters(ArrayList<Filter> filters) {
        this.filters = filters;
    }

    public Boolean getMustRefreshSearch() {
        return mustRefreshSearch;
    }

    public void setMustRefreshSearch(Boolean mustRefreshSearch) {
        this.mustRefreshSearch = mustRefreshSearch;
    }
}
