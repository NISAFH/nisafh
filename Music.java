package com.nisafh;

public class Music {
    private String judulLagu;
    private String Penyanyi;

    public Music(String judulLagu, String Penyanyi) {
        this.judulLagu = judulLagu;
        this.Penyanyi = Penyanyi;
    }

    public String getJudulLagu(){
        return judulLagu;
    }

    @Override
    public String toString(){
        return Penyanyi + " - " + judulLagu;
    }
}
