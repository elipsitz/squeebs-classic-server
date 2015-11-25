package com.aegamesi.squeebsserver;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static final int PROTOCOL_VERSION = 4;
    public static final int PORT = 12564;
    public static final int PLAYER_MAX = 20;
    public static final int TPS = 20;

    public static long bytes_sent = 0;
    public static long bytes_received = 0;

    public static boolean running = true;
    public static Database db = new Database();
    public static ClientHandler clientHandler;
    public static PhysicsLoop physicsLoop;

    public static void main(String[] args) throws IOException {
        // setup gui
        Logger.init();

        Logger.log("Starting up Squeebs Java Server...");

        // test accounts
        {
            Database.User user = new Database.User();
            user.username = "Eli";
            user.password = "test";
            user.lvl = 10;
            db.users.add(user);
        }

        clientHandler = new ClientHandler();
        Logger.log("There are " + db.users.size() + " users.");

        // physloop
        physicsLoop = new PhysicsLoop();
        physicsLoop.start();

        // input loop
        //inputLoop = new InputLoop();
        //inputLoop.start();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            Logger.log("Listening on port " + PORT);

            while (running) {
                Socket socket = serverSocket.accept();
                Logger.log("Accepted connection from " + socket.getInetAddress());
                clientHandler.handleNewClient(socket);
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        running = false;
    }
}