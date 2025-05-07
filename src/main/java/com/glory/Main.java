package com.glory;


import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Album1", "Nathaniel Bassey");

        album.addSong("Getting older",4.5);
        album.addSong("My future", 3.5);
        album.addSong("Your power", 5.0);
        album.addSong(album);

        album = new Album("Album2", "Worships");

        album.addSong("", 4.5);
        album.addSong("", 3.5);
        album.addSong("", 4.5);

      albums.add(album);

        LinkedList<Songs> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("", playList_1);
        albums.get(0).addToPlayList("", playList_1);
        albums.get(0).addToPlayList("", playList_1);
        albums.get(0).addToPlayList("", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Songs> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Songs> listIterator = playList.listIterator();

        if (playList.size() == 0){
            System.out.println("This playlist have no song");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("playList complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }

                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("No song available, reached to the end of the list");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;
            }
        }

    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<Songs> playList){
        Iterator<Songs> iterator = playList.iterator();
        System.out.println("************");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("****************");
    }
}
