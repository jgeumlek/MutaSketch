package MutaSketchGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Player {
	//A name given by the player for identification.
	private String name;
	//The connection through which data is sent to this player.
	private Socket connection;
	//Access for sending/receiving data from this player.
	private ObjectOutputStream toPlayer;
	private ObjectInputStream fromPlayer;
	
	public Player(String name, Socket connectionSocket) throws IOException {
		this.name = name;
		connection = connectionSocket;
		toPlayer = new ObjectOutputStream(connectionSocket.getOutputStream());
		fromPlayer = new ObjectInputStream(connectionSocket.getInputStream());
	}
	
	public void sendEntry(Entry entry) throws IOException {
		toPlayer.writeObject(entry);
	}
	
	public Entry getEntry() throws IOException, ClassNotFoundException {
		return (Entry) fromPlayer.readObject();
	}
	
	public String getName() {
		return name;
	}
}
