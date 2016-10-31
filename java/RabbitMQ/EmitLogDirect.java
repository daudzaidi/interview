package RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

/**
 * Created by shalvi on 12/08/16.
 */
public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";
    public static void main(String... args)
            throws java.io.IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String[] argv = getMessage();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        for(int i = 0 ; i< argv.length ;i++) {
            String severity = getSeverity(argv[i]);
            String message = argv[i];
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
            System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
        }

        channel.close();
        connection.close();
    }

    private static String getSeverity(String argv) {
            return argv;
        }

    public static String[] getMessage() {
        String[] msg = {"error","info","warning","info","error","info","info"};
        return msg;
    }

}
