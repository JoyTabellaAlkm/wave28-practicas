package com.company;

public class Main {

    public static void main(String[] args) {
	    String[] cities = {"London", "Madrid", "New York", "Buenos Aires",
                "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
	    int[] temp_mn = {-2, -3, -8, 4, 6, 5, 0, -7, -1, -10};
        int[] temp_mx = {33, 32, 27, 37, 42, 43, 39, 26, 31, 35};
        int mn_temp = 100;
        int mx_temp = -100;
        String city_mn, city_mx;
        city_mn = city_mx = "";
        for(int i = 0; i < cities.length; ++i){
            if(mn_temp > temp_mn[i]){
                mn_temp = temp_mn[i];
                city_mn = cities[i];
            }
            if(mx_temp < temp_mx[i]) {
                mx_temp = temp_mx[i];
                city_mx = cities[i];
            }
        }
        System.out.println(city_mx + ", " + mx_temp + "°C");
        System.out.println(city_mn + ", " + mn_temp + "°C");
    }
}
