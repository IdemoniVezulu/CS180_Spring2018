import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

final class ChatClient
{
    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;

    private final String server;
    private final String username;
    private final int port;

    /* ChatClient constructor
     * @param server - the ip address of the server as a string
     * @param port - the port number the server is hosted on
     * @param username - the username of the user connecting
     */
    private ChatClient(String server, int port, String username)
    {
        this.server = server;
        this.port = port;
        this.username = username;
    }

    /**
     * Attempts to establish a connection with the server
     * @return boolean - false if any errors occur in startup, true if successful
     */
    private boolean start()
    {
        // Create a socket
        try
        {
            socket = new Socket(server, port);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        // Attempt to create output stream
        try
        {
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        // Attempt to create input stream
        try
        {
            sInput = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        // Create client thread to listen from the server for incoming messages
        Runnable r = new ListenFromServer();
        Thread t = new Thread(r);
        t.start();

        // After starting, send the clients username to the server.
        try
        {
            sOutput.writeObject(username);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return true;
    }


    /*
     * Sends a string to the server
     * @param msg - the message to be sent
     */
    private void sendMessage(ChatMessage msg)
    {
        try
        {
            sOutput.writeObject(msg);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    /*
     * To start the Client use one of the following command
     * > java ChatClient
     * > java ChatClient username
     * > java ChatClient username portNumber
     * > java ChatClient username portNumber serverAddress
     *
     * If the portNumber is not specified 1500 should be used
     * If the serverAddress is not specified "localHost" should be used
     * If the username is not specified "Anonymous" should be used
     */
    public static void main(String[] args)
    {
        // Get proper arguments and override defaults

        // Client's credentials
        String  username = "Anonymous";
        int     portNumber = 1500;
        String  serverAddress = "localHost";


                if(args.length >= 1)
                {
                    username = args[0];
                }
                if(args.length >= 2)
                {
                    portNumber = Integer.parseInt(args[1]);
                }
                if(args.length >= 3)
                {
                    serverAddress = args[2];
                }

        // Create your client and start it
        ChatClient  client = new ChatClient(serverAddress, portNumber, username);
                    client.start();

                    // Send an empty message to the server
                    client.sendMessage(new ChatMessage(0, args[0], username));

                    // Logout if the user wants to logout
                    if(args.equals("/logout"))
                    {
                        client.sendMessage(new ChatMessage(1, args[1], username));
                    }


    }


    /*
     * This is a private class inside of the ChatClient
     * It will be responsible for listening for messages from the ChatServer.
     * ie: When other clients send messages, the server will relay it to the client.
     */
    private final class ListenFromServer implements Runnable
    {
        public void run()
        {
            try
            {
                while(true)
                {
                    String msg = (String) sInput.readObject();
                    System.out.print(msg);
                }

            }
            catch (IOException | ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}