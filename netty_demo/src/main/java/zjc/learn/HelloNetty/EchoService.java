package zjc.learn.HelloNetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Sandu
 * @ClassName EchoService
 * @date 2018/11/6
 */
public class EchoService {

	private Integer serverPort;

	public static void main(String[] args) {
		System.out.println("starting EchoServer ing...");
		new EchoService(10086).start();
		System.out.println("starting EchoServer done!!");

	}

	public  EchoService(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public void start()   {
		EchoServiceHandler echoServiceHandler = new EchoServiceHandler();
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();

		try {
			bootstrap
					.localAddress(this.serverPort)
					.group(eventLoopGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline()
									.addFirst(new EchoServiceHandler())
									.addFirst(new POJOEncoder())
									.addFirst(new POJODecoder());
						}
					});

			ChannelFuture future = bootstrap.bind().sync();

			future.channel().closeFuture().sync();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			eventLoopGroup.shutdownGracefully();
		}


	}
}
