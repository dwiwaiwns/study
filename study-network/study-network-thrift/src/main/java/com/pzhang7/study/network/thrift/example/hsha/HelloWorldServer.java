package com.pzhang7.study.network.thrift.example.hsha;

import com.pzhang7.study.network.thrift.service.HelloWorldService;
import com.pzhang7.study.network.thrift.service.impl.HelloWorldServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * Author: Zhang Peng
 * Date: 2017/1/23 0023
 * Description:
 */
public class HelloWorldServer {
    public static final int SERVER_PORT = 8090;

    /**
     * @param args
     */
    public static void main(String[] args) {
        HelloWorldServer server = new HelloWorldServer();
        server.startServer();
    }

    public void startServer() {
        try {
            System.out.println("HelloWorld THsHaServer start ....");
            TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());
            TNonblockingServerSocket tNonblockingServerSocket = new TNonblockingServerSocket(SERVER_PORT);
            THsHaServer.Args tHsHaServer = new THsHaServer.Args(tNonblockingServerSocket);
            tHsHaServer.processor(tprocessor);
            tHsHaServer.transportFactory(new TFramedTransport.Factory());
            tHsHaServer.protocolFactory(new TBinaryProtocol.Factory());
            //半同步半异步的服务模型
            TServer server = new THsHaServer(tHsHaServer);
            server.serve();
        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }
}
