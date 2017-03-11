package com.gmail.at.sichyuriyy.javatraining.homework4.task23;

/**
 * Created by Yuriy on 3/10/2017.
 */
public interface OrderState {

    void consider();
    void cancel();
    void deffer();
    void confirm();
    void deny();

}
