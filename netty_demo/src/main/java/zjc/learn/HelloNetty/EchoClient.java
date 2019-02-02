package zjc.learn.HelloNetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Sandu
 * @ClassName EchoClient
 * @date 2019/2/1-17:27$
 */
public class EchoClient {


	public static void main(String[] args) throws InterruptedException {
		System.out.println("starting EchoClient ing...");
		EchoClient client = new EchoClient();
		client.start();
	}

	public void sendMsg(Object  msg){
		//todo sendMSG
	}

	public void start() throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap boot = new Bootstrap();

		try{
			ChannelFuture channelFuture = boot
					.remoteAddress("localhost",10086)
					.group(group)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.SO_KEEPALIVE, true)
					.handler(new ChannelInitializer<SocketChannel>() {

						/**
						 * This method will be called once the {@link Channel} was registered. After the method returns this instance
						 * will be removed from the {@link ChannelPipeline} of the {@link Channel}.
						 *
						 * @param ch the {@link Channel} which was registered.
						 * @throws Exception is thrown if an error occurs. In that case it will be handled by
						 *                   {@link #exceptionCaught(ChannelHandlerContext, Throwable)} which will by default close
						 *                   the {@link Channel}.
						 */
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addFirst(new EchoClientHandler()).addFirst(new POJOEncoder());
						}
					})
					.connect();
			//start client
			channelFuture.sync();

			//close channel
			channelFuture.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully();
		}

	}
}
