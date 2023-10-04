package com.brano.democp.controller;

public interface Responsible<T> {

    T respond() throws Exception;

}
