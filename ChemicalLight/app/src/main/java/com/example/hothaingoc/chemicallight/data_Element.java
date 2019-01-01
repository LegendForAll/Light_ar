package com.example.hothaingoc.chemicallight;

public class data_Element {

    private  int id;
    private  int img;
    private  String name;
    private  String symbol;
    private  String atomic_mass;
    private  String group;
    private  String cycle;
    private  String oxi;

    public data_Element() {

    }

    public data_Element(int id, int img, String name, String symbol, String atomic_mass, String group, String cycle, String oxi) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.symbol = symbol;
        this.atomic_mass = atomic_mass;
        this.group = group;
        this.cycle = cycle;
        this.oxi = oxi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAtomic_mass() {
        return atomic_mass;
    }

    public void setAtomic_mass(String atomic_mass) {
        this.atomic_mass = atomic_mass;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getOxi() {
        return oxi;
    }

    public void setOxi(String oxi) {
        this.oxi = oxi;
    }
}
