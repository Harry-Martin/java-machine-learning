package com.harrymartin.ml;

public class Activation {
    public static double signum(double input){
        return input < 0 ? -1 : 1;
    }

    public static double heaviside_step(double input){
        return input < 0 ? 0 : 1;
    }

    public static double rectified_linear_unit(double input){
        return input < 0 ? 0 : input;
    }
}
