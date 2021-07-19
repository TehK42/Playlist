package com.tehk42;

import java.util.*;

public class Main {
    private static List<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {
	// write your code here
        Album album = new Album("The Black Parade", "My Chemical Romance");
        album.addSong("The End", 1.52);
        album.addSong("Dead!", 3.15);
        album.addSong("This is How I Disappear", 3.59);
        album.addSong("The Sharpest Lives", 3.20);
        album.addSong("Welcome To The Black Parade", 5.11);
        album.addSong("I Don't Love You", 3.58);
        album.addSong("House Of Wolves", 3.04);
        album.addSong("Cancer", 2.22);
        album.addSong("Mama", 4.39);
        album.addSong("Sleep", 4.43);
        album.addSong("Teenagers", 2.41);
        album.addSong("Disenchanted", 4.55);
        album.addSong("Famous Last Words", 4.59);
        album.addSong("Blood [Hidden Track", 2.53);
        albums.add(album);

        album = new Album("You Won't Get What You Want", "Daughters");
        album.addSong("City Song", 1.52);
        album.addSong("Long Road, No Turns!", 3.15);
        album.addSong("Satan In The Wait", 3.59);
        album.addSong("The Flammable Man", 3.20);
        album.addSong("The Lords Song", 5.11);
        album.addSong("Less Sex", 3.58);
        album.addSong("Daughter", 3.04);
        album.addSong("The Reason They Hate Me", 2.22);
        album.addSong("Ocean Song", 4.39);
        album.addSong("Guest House", 4.43);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Welcome To The Black Parade", playList);
        albums.get(0).addToPlaylist("Mama", playList);
        albums.get(0).addToPlaylist("Sing", playList); //Does not exist
        albums.get(0).addToPlaylist(1, playList);
        albums.get(1).addToPlaylist(9, playList);
        albums.get(1).addToPlaylist(10, playList);
        albums.get(1).addToPlaylist(11, playList); //Track does not exist

        play(playList);


    }

    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0) {
            System.out.println("No songs in playlist.");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Quitting application");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached end of playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist.");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("Reached end of playlist.");
                        }
                    }
                    break;
                case 4:
                    printPlayList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printPlayList(List<Song> playList) {
        Iterator<Song> i = playList.iterator();
        System.out.println("============================");
        while(i.hasNext()) {
            System.out.println(i.next().getTitle());
        }
        System.out.println("============================");
        System.out.println("End of playlist.");
     }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");
    }

}
