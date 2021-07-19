package com.tehk42;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String name;
    private String artistName;
    private ArrayList<Song> songs;

    public Album(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
        this.songs = new ArrayList<Song>();
    }

    private Song findSong(String title) {
        for (Song checkSong : this.songs) {
            if (checkSong.getTitle().equals(title)) {
                return checkSong;
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            System.out.println("Song is already added");
            return false;
        } else {
        Song newSong = new Song(title, duration);
        songs.add(newSong);
        return true;
        }
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
        if(trackNumber <= 0 || trackNumber > songs.size()) {
            System.out.println("Track number is out of range");
            return false;
        }
        int index = trackNumber - 1;
        Song songToAdd = songs.get(index);
        String songTitleToAdd = songToAdd.getTitle();

        ListIterator<Song> playListIterator = playList.listIterator();
        while(playListIterator.hasNext()) {
            if(playListIterator.next().getTitle().compareTo(songTitleToAdd) == 0) {
                System.out.println("Song is already in playlist");
                return false;
            }
        }
        System.out.println(trackNumber + ". " + songTitleToAdd + " has successfully been added to the playlist");
        playList.add(songToAdd);
        return true;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList) {
        Song songToAdd = findSong(title);
        if(songToAdd == null) {
            System.out.println("Song does not exist");
            return false;
        }

        ListIterator<Song> playListIterator = playList.listIterator();
        while(playListIterator.hasNext()) {
            if(playListIterator.next().getTitle().compareTo(songToAdd.getTitle()) == 0) {
                System.out.println("Song is already in playlist");
                return false;
            }
        }
        System.out.println(songToAdd.getTitle() + " has successfully been added to the playlist");
        playList.add(songToAdd);
        return true;
    }
}
