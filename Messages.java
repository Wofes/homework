package Homework;

public interface Messages<T> {
    String getFrom();
    String getTo();
    T getContent();

}
