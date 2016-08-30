/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.servidorweb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kvin2
 */
public class Servidor {

    public void correrServidor() throws IOException {
        String cadena = "";
        String html = "";
        ServerSocket server = new ServerSocket(9090);
        while (true) {
            Socket con = server.accept();
            PrintStream salida = new PrintStream(con.getOutputStream());
            BufferedReader entrada = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linea = "";
            String[] arr = new String[10];
            int i = 0;
            while ((linea = entrada.readLine()) != null) {
                arr[i] = linea;
                i++;
                if (linea.isEmpty()) {
                    break;
                }
            }

            String[] ruta;
            ruta = arr[0].split(" ");
            System.out.println(ruta[1]);

            FileReader f = new FileReader("C:/Users/kvin2/Documents/NetBeansProjects" + ruta[1]);
            BufferedReader b = new BufferedReader(f);

            while ((cadena = b.readLine()) != null) {

                html += cadena;

            }

            salida.println("HTTP/1.1 200 OK");
            salida.println("Content-type:text/html");
            salida.println("Content-Length:" + html.length());
            salida.println();
            salida.println(html);
            salida.close();
            entrada.close();
            b.close();
            con.close();

        }
    }

}
