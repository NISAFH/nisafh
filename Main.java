package com.nisafh;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LinkedList<Music> playlist = new LinkedList<>();

        boolean out = false;
        while (!out) {
            System.out.println("Pilih menu: ");
            System.out.println("1. Input lagu");
            System.out.println("2. Hapus lagu");
            System.out.println("3. Mainkan lagu");
            System.out.println("4. Keluar");
            System.out.print("Pilih salah satu (1/2/3/4): ");
            int pilih = input.nextInt();
            input.nextLine();

            switch(pilih) {
                //Input lagu
                case 1:
                    System.out.print("1. Masukkan judul lagu: ");
                    String judulLagu = input.next();
                    System.out.print("2. Masukkan nama penyanyi: ");
                    String Penyanyi = input.next();
                    playlist.addLast(new Music(judulLagu, Penyanyi));
                    break;
                case 2:
                    //Remove lagu
                    System.out.println("1. Hapus lagu paling terakhir");
                    System.out.println("2. Hapus lagu berdasarkan judul");
                    System.out.print("Pilih salah satu (1/2): ");
                    int delete = input.nextInt();
                    input.nextLine();
                    if (delete == 1) {
                        playlist.removeLast();
                        System.out.println("Anda berhasil menghapus lagu");
                    }
                    else if (delete == 2){
                        System.out.print("Masukkan judul lagu yang ingin dihapus: ");
                        String JudulLagu = input.next();
                        removeByTitle(playlist, JudulLagu);
                        System.out.println("Anda berhasil menghapus lagu");
                    }
                    else {
                        System.out.println("Pilihan anda tidak tersedia, silakan coba lagi");
                    }
                    break;
                case 3:
                    playMusic(playlist);
                    break;
                case 4:
                    out = true;
                    break;
                default:
                     System.out.println("Pilihan anda tidak tersedia, silakan coba lagi");
        }
    }
}
    public static void playMusic(LinkedList<Music> nf) {
        ListIterator<Music> iterator = nf.listIterator();

        while (iterator.hasNext()) {
            if (iterator.hasPrevious()) {
                System.out.print(", " + iterator.next());
            }
            else {
                System.out.print(iterator.next());
            }
        }
        iterator.previous();
        while (iterator.hasPrevious()) {
            System.out.print(", " + iterator.previous());
        }
        System.out.println();
    }
    public static void removeByTitle(LinkedList<Music> nf, String judulLagu) {
        ListIterator<Music> iterator = nf.listIterator();
        while (iterator.hasNext()) {
            Music current = iterator.next();
            if (current.getJudulLagu().equalsIgnoreCase(judulLagu)) {
                iterator.remove();
            }
        }
    }
}