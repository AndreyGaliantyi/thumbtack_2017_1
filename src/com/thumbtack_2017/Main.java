/*IntelliJ IDEA 2017.1.2
        Build #IC-171.4249.39, built on April 25, 2017
        JRE: 1.8.0_112-release-736-b16 amd64
        JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
        Windows 10 10.0*/
package com.thumbtack_2017;

import java.io.*;
import java.nio.file.*;
import static java.nio.file.Files.newBufferedReader;

public class Main {

    public static void main(String[] args) throws IOException {

        FileWriter output_file=new FileWriter("output.txt"); //объект для записи в файл

        if(!new File("input.txt").exists()){ //проверка на существование входного файла
            output_file.write("Нет входного файла \"input.txt\"");
            output_file.flush();
            output_file.close();
            return;
        }

        BufferedReader reader=newBufferedReader(Paths.get("input.txt"));// объект для чтения файла
        String string_n=reader.readLine(); //чтение данных из файла
        reader.close();
        int n=Integer.parseInt(string_n.toString()); //преобразование строки в число N
        char[] hex; //для записи числа в шестнадцатеричном виде

        for(int i=16;i<n;++i){
            hex=Integer.toHexString(i).toCharArray(); //преобразование числа в шестнадцатеричный вид
            int j=1;
            while(j<hex.length) { //проверка на срого возрастающую последовательность цифр
                if(Character.isDigit(hex[j-1])&&Character.isDigit(hex[j])&&(hex[j-1]<hex[j]))j++;
                else break;
            }
            int k=1;
            while(k<hex.length) { //проверка на срого убывающую последовательность цифр
                if(Character.isDigit(hex[k-1])&&Character.isDigit(hex[k])&&(hex[k-1]>hex[k]))k++;
                else break;
            }
            if(j==hex.length||k==hex.length){
                output_file.write(Integer.toString(i)); //запись числа в файл
                output_file.write(System.lineSeparator());
            }
        }
        output_file.flush(); //запись файла на диск
        output_file.close();
    }
}