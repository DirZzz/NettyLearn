package zjc.learn.HelloNetty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * @author Sandu
 * @ClassName TestCodec
 * @date 2019/2/19-16:53$
 */
public class TestCodec extends ByteToMessageCodec<UserBean> {


	private final Gson gson = new GsonBuilder().create();
	/**
	 * @param ctx
	 * @param msg
	 * @param out
	 * @see MessageToByteEncoder#encode(ChannelHandlerContext, Object, ByteBuf)
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, UserBean msg, ByteBuf out) throws Exception {
		System.out.println("it's test code c:"+msg.toString());
		out.writeBytes(gson.toJson(msg).getBytes());
	}

	/**
	 * @param ctx
	 * @param in
	 * @param out
	 * @see ByteToMessageDecoder#decode(ChannelHandlerContext, ByteBuf, List)
	 */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		byte[] bytes = new byte[1024];
		in.readBytes(bytes);
		String msg = new String(bytes);
		UserBean userBean = gson.fromJson(msg, UserBean.class);
		out.add(userBean);

	}
}
