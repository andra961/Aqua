package com.example.andreacorronca.myapplicationtest;

public class Filter {

    private boolean descending;

    private int sortOrder;


    private boolean showGdr;

    private boolean showAction;

    private boolean showSurvival;

    private boolean showAdventure;

    private boolean showFighting;

    private boolean showRacing;

    private boolean showShooter;

    private boolean showStrategy;

    private boolean showPlatform;

    private boolean showStealth;

    private boolean showCards;

    private boolean showManagerial;


    private boolean showFuturistic;

    private boolean showActual;

    private boolean showFantasy;

    private boolean showHorror;

    private boolean showWar;

    private boolean showPast;


    private boolean showSingle;

    private boolean showLocal;

    private boolean showOnline;


    private boolean showFree;

    private boolean showEarly;

    private boolean showStandard;

    private boolean priceRange;

    private float minimumPrice;

    private float maximumPrice;

    public Filter(boolean descending, int sortOrder, boolean showGdr, boolean showAction, boolean showSurvival, boolean showAdventure, boolean showFighting, boolean showRacing, boolean showShooter, boolean showStrategy, boolean showPlatform, boolean showStealth, boolean showCards, boolean showManagerial, boolean showFuturistic, boolean showActual, boolean showFantasy, boolean showHorror, boolean showWar, boolean showPast, boolean showSingle, boolean showLocal, boolean showOnline, boolean showFree, boolean showEarly, boolean showStandard, boolean priceRange, float minimumPrice, float maximumPrice) {
        this.descending = descending;
        this.sortOrder = sortOrder;
        this.showGdr = showGdr;
        this.showAction = showAction;
        this.showSurvival = showSurvival;
        this.showAdventure = showAdventure;
        this.showFighting = showFighting;
        this.showRacing = showRacing;
        this.showShooter = showShooter;
        this.showStrategy = showStrategy;
        this.showPlatform = showPlatform;
        this.showStealth = showStealth;
        this.showCards = showCards;
        this.showManagerial = showManagerial;
        this.showFuturistic = showFuturistic;
        this.showActual = showActual;
        this.showFantasy = showFantasy;
        this.showHorror = showHorror;
        this.showWar = showWar;
        this.showPast = showPast;
        this.showSingle = showSingle;
        this.showLocal = showLocal;
        this.showOnline = showOnline;
        this.showFree = showFree;
        this.showEarly = showEarly;
        this.showStandard = showStandard;
        this.priceRange = priceRange;
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Filter other = (Filter) obj;
        if (!(this.isDescending() == ((Filter) obj).isDescending())){
            return false;
        }
        if (!(this.getSortOrder() == ((Filter) obj).getSortOrder())){
            return false;
        }
        if (!(this.isShowGdr()) == ((Filter) obj).isShowGdr()){
            return false;
        }
        if (!(this.isShowAction() == ((Filter) obj).isShowAction())){
            return false;
        }
        if (!(this.isShowSurvival() == ((Filter) obj).isShowSurvival())){
            return false;
        }
        if (!(this.isShowAdventure() == ((Filter) obj).isShowAdventure())){
            return false;
        }
        if (!(this.isShowFighting() == ((Filter) obj).isShowFighting())){
            return false;
        }
        if (!(this.isShowRacing() == ((Filter) obj).isShowRacing())){
            return false;
        }
        if (!(this.isShowShooter() == ((Filter) obj).isShowShooter())){
            return false;
        }
        if (!(this.isShowStrategy() == ((Filter) obj).isShowStrategy())){
            return false;
        }
        if (!(this.isShowPlatform() == ((Filter) obj).isShowPlatform())){
            return false;
        }
        if (!(this.isShowStealth() == ((Filter) obj).isShowStealth())){
            return false;
        }
        if (!(this.isShowCards() == ((Filter) obj).isShowCards())){
            return false;
        }
        if (!(this.isShowManagerial() == ((Filter) obj).isShowManagerial())){
            return false;
        }
        if (!(this.isShowFuturistic() == ((Filter) obj).isShowFuturistic())){
            return false;
        }
        if (!(this.isShowActual() == ((Filter) obj).isShowActual())){
            return false;
        }
        if (!(this.isShowFantasy() == ((Filter) obj).isShowFantasy())){
            return false;
        }
        if (!(this.isShowHorror()) == ((Filter) obj).isShowHorror()){
            return false;
        }
        if (!(this.isShowWar() == ((Filter) obj).isShowWar())){
            return false;
        }
        if (!(this.isShowPast() == ((Filter) obj).isShowPast())){
            return false;
        }
        if (!(this.isShowSingle()) == ((Filter) obj).isShowSingle()){
            return false;
        }
        if (!(this.isShowLocal() == ((Filter) obj).isShowLocal())){
            return false;
        }
        if (!(this.isShowOnline() == ((Filter) obj).isShowOnline())){
            return false;
        }
        if (!(this.isShowFree()) == ((Filter) obj).isShowFree()){
            return false;
        }
        if (!(this.isShowEarly() == ((Filter) obj).isShowEarly())){
            return false;
        }
        if (!(this.isShowStandard() == ((Filter) obj).isShowStandard())){
            return false;
        }
        if (!(this.isShowFree()) == ((Filter) obj).isShowFree()){
            return false;
        }
        if (!(this.isShowEarly() == ((Filter) obj).isShowEarly())){
            return false;
        }
        if (!(this.isPriceRange() == ((Filter) obj).isPriceRange())){
            return false;
        }
        if (!(this.getMinimumPrice() == ((Filter) obj).getMinimumPrice())){
            return false;
        }
        if (!(this.getMaximumPrice() == ((Filter) obj).getMaximumPrice())){
            return false;
        }

        return true;
    }

    public boolean isDescending() {
        return descending;
    }

    public void setDescending(boolean descending) {
        descending = descending;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
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
}
