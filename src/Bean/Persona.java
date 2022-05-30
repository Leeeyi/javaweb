package Bean;

public class Persona {
    private static final long serialVersionUID = 1L;
    private double ele = 0;
    private double cloth = 0;
    private double food = 0;
    private double cosmetic = 0;
    private double stationery = 0;
    private double daily = 0;
    private double book = 0;
    private double office = 0;
    private double musical = 0;
    private double others = 0;

    public void setEle(double ele) {
        this.ele = ele;
    }

    public double getEle() {
        return ele;
    }

    public void setCloth(double cloth) {
        this.cloth = cloth;
    }

    public double getCloth() {
        return cloth;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getFood() {
        return food;
    }

    public void setCosmetic(double cosmetic) {
        this.cosmetic = cosmetic;
    }

    public double getCosmetic() {
        return cosmetic;
    }

    public void setStationery(double stationery) {
        this.stationery = stationery;
    }

    public double getStationery() {
        return stationery;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public double getDaily() {
        return daily;
    }

    public void setOffice(double office) {
        this.office = office;
    }

    public double getOffice() {
        return office;
    }

    public void setBook(double book) {
        this.book = book;
    }

    public double getBook() {
        return book;
    }

    public void setMusical(double musical) {
        this.musical = musical;
    }

    public double getMusical() {
        return musical;
    }

    public void setOthers(double others) {
        this.others = others;
    }

    public double getOthers() {
        return others;
    }

    public void addEle(){this.ele += 1;}
    public void addCloth(){this.cloth += 1;}
    public void addFood(){this.food += 1;}
    public void addCosmetic(){this.cosmetic += 1;}
    public void addStationery(){this.stationery += 1;}
    public void addDaily(){this.daily += 1;}
    public void addBook(){this.book += 1;}
    public void addOffice(){this.office += 1;}
    public void addMusical(){this.musical += 1;}
    public void addOthers(){this.others += 1;}

    public void addEle1(double i){this.ele += i;}
    public void addCloth1(double i){this.cloth += i;}
    public void addFood1(double i){this.food += i;}
    public void addCosmetic1(double i){this.cosmetic += i;}
    public void addStationery1(double i){this.stationery += i;}
    public void addDaily1(double i){this.daily += i;}
    public void addBook1(double i){this.book += i;}
    public void addOffice1(double i){this.office += i;}
    public void addMusical1(double i){this.musical += i;}
    public void addOthers1(double i){this.others += i;}
}
