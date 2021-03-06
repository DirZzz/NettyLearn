package zjc.learn.HelloNetty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.time.LocalDateTime;

/**
 * @author Sandu
 * @ClassName EchoServiceHandler
 * @date 2019/2/1
 */

@ChannelHandler.Sharable
public class EchoServiceHandler extends ChannelInboundHandlerAdapter {


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		UserBean bean = (UserBean) msg;
		String s = bean.toString();
		System.out.println(bean.toString());
		String reback = "reback msg " + LocalDateTime.now().toString() + ": res_ " + s;
		ctx.writeAndFlush(reback);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("Eexeption :"+cause.getLocalizedMessage()+" remote address:"+ctx.channel().remoteAddress().toString());
	}
}
