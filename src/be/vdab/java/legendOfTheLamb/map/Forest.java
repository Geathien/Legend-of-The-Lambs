package be.vdab.java.legendOfTheLamb.map;

import java.io.*;
import java.nio.file.Path;

public class Forest {
    Path path = Path.of(".\\src\\be\\vdab\\java\\legendOfTheLamb\\map\\Forest.txt");
    private char[][] map= new char[40][40];
    private int playerXPosition;
    private int playerYPosition;

    public Forest(){
        generateMap();
        write();
        read();
    }
    public void generateMap(){
        for(int i = 0; i< map.length;i++){
            for(int j = 0;j <map[0].length;j++){
                map[i][j]=' ';
            }
        }
        for (int i = 23; i<35;i++){
            map[i][1]='X';
        }
        for (int i= 1; i<12; i++){
            map[23][i]='X';
        }
        for(int i = 3; i<32;i++){
            map[i][34]='X';
        }
        for (int i = 19; i<27;i++){
            map[15][i]='X';
        }
        map[15][27]='D';
        for(int i = 3; i<13;i++){
            map[i][2]='V';
        }
        map[13][2]='K';
        map[14][2]='V';
        for(int i = 3; i<19;i++) {
            map[14][i]='V';
        }
        for(int i = 3; i<16;i++){
            map[i][18]='X';
        }
        map[15][2]='K';
        for(int i = 16;i<23;i++){
            map[i][2]='V';
        }
        for(int i = 2;i<18;i++){
            map[3][i]='V';
        }
        for(int i = 18;i<35;i++){
            map[3][i]='X';
        }
        for(int i = 37;i<40;i++){
            map[i][6]='X';
        }
        for(int i = 6;i<9;i++){
            map[37][i]='X';
        }
        for (int i = 34; i<38;i++){
            map[i][8]='X';
        }
        for(int i = 1; i<9;i++){
            map[34][i]='X';
        }
        for(int i=17; i<29;i++){
            map[37][i]='X';
        }
        for(int i= 35;i<38;i++){
            map[i][17]='X';
        }
        for(int i= 37; i>30;i--){
            map[i][28]='X';
        }
        for(int i = 28; i<35;i++){
            map[31][i]='X';
        }
        for(int i=32;i<37;i++){
            map[i][32]='V';
        }
        for(int i = 32; i<39;i++){
            map[33][i]='V';
        }
        for(int i = 38;i>32;i--){
            map[i][38]='V';
        }
        for(int i = 38; i>29;i--){
            map[38][i]='V';
        }
        for(int i=38; i>35;i--){
            map[i][30]='V';
        }
        map[36][31]='V';
        for(int i = 17;i<23;i++) {
            map[35][i] = 'X';
        }
        for(int i = 35; i>25;i--){
            map[i][22]='X';
        }
        for(int i = 22;i>17;i--){
            map[26][i]='X';
        }
        for(int i = 26;i<31;i++){
            map[i][18]='X';
        }
        for(int i=18;i>10;i--){
            map[30][i]='X';
        }
        for(int i=30;i>22;i--){
            map[i][11]='X';
        }
        for(int i =12;i<17;i++){
            map[25][i]='V';
        }
        for(int i = 25;i>19;i--){
            map[i][16]='V';
        }
        for(int i=16;i<29;i++){
            map[21][i]='V';
        }
        map[21][29]='W';
    }

    public void draw(){
        for(int i = 0; i< map.length; i++)
        {
            for(int j = 0; j<map[i].length; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void write(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < map.length; i++)//for each row
        {
            for(int j = 0; j < map[1].length; j++)//for each column
            {
                builder.append(map[i][j]+"");//append to the output string
                if(j < map.length - 1)//if this is not the last row element
                    builder.append(" ");//then add comma (if you don't like commas you can use spaces)
            }
            builder.append("\n");//append new line at the end of the row
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()));
            writer.write(builder.toString());//save the string representation of the board
            writer.close();
        } catch (IOException io){
            io.printStackTrace();
        }

    }

    public void read(){
        try (FileReader fileReader = new FileReader(path.toString());
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            int character;
            StringBuilder sb = new StringBuilder();
            while ((character = bufferedReader.read()) != -1){
                sb.append((char) character);
            }
            System.out.println(sb.toString());
        } catch (IOException io){
            System.out.println("Something went wrong");
            io.printStackTrace();
        }
    }
    public boolean wallCheck(int x, int y){
        boolean check = true;
        if(x>39|| y>39){
            check = false;
        }
        else if (map[x][y]==' '){
            check = false;
        }
        return check;
    }

    public void setPlayerPosition(int x, int y){
        map[x][y] = 'P';
        this.playerXPosition = x;
        this.playerYPosition = y;
    }

    public int getPlayerXPosition(){
        return this.playerXPosition;
    }

    public int getPlayerYPosition(){
        return this.playerYPosition;
    }
}