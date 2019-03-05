package zjc.learn.httpProtocol.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * @author Sandu
 * @ClassName RequestCodec
 * @date 2019/2/22-16:31$
 */
public class RequestCodec extends ByteToMessageCodec {
	/**
	 * @param ctx
	 * @param msg
	 * @param out
	 * @see MessageToByteEncoder#encode(ChannelHandlerContext, Object, ByteBuf)
	 */
	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {

	}

	/**
	 * @param ctx
	 * @param in
	 * @param out
	 * @see ByteToMessageDecoder#decode(ChannelHandlerContext, ByteBuf, List)
	 */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) throws Exception {

	}
}
