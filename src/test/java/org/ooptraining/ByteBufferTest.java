package org.ooptraining;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.ooptraining.util.test.IndicativeSentence;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DisplayNameGeneration(IndicativeSentence.class)
public class ByteBufferTest {

    @Test
    void byte_buffer_reverse_order() {
        final byte[] inByteArr = new byte[]{
                0, 1, 2, 3, 4, 5, 6, 7
        };
        final ByteBuffer buf = makeByteBuffer(inByteArr);

        reverseOrder(buf);

        final byte[] actualByteArr = getActualByteArr(buf);
        final byte[] expectedByteArr = new byte[]{
                7, 6, 5, 4, 3, 2, 1, 0
        };
        assertThat(actualByteArr).isEqualTo(expectedByteArr);
    }

    @Test
    void test2() throws IOException, URISyntaxException {
        final byte[] expected = new byte[]{
                '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        final ByteChannel in = FileChannel.open(Paths.get(getClass().getResource("/test1").toURI()));
        final ByteBuffer buf = ByteBuffer.allocate(expected.length);
        in.read(buf);

        buf.rewind();
        assertThat(buf.array()).isEqualTo(expected);
    }

    @Test
    void test3() throws IOException, URISyntaxException {
        final byte[] expected = new byte[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8
        };
        final ByteChannel in = FileChannel.open(Paths.get(getClass().getResource("/test2").toURI()));

        final ByteBuffer buf = ByteBuffer.allocate(expected.length);
        in.read(buf);

        buf.rewind();
        assertThat(buf.array()).isEqualTo(expected);
    }


    private void reverseOrder(final ByteBuffer buf) {
        buf.rewind();
        int length = buf.remaining();
        int halfLength = length / 2;
        for (int i = 0; i < halfLength; i++) {
            final byte front = buf.get(i);
            final byte back = buf.get(length - i - 1);

            buf.put(i, back);
            buf.put(length - i - 1, front);
        }
    }

    private ByteBuffer makeByteBuffer(final byte[] inByteArr) {
        final ByteBuffer buffer = ByteBuffer.allocate(inByteArr.length);
        buffer.put(inByteArr);

        return buffer;
    }

    private byte[] getActualByteArr(final ByteBuffer buffer) {
        buffer.rewind();

        final byte[] outByteArr = new byte[buffer.remaining()];
        buffer.get(outByteArr);
        return outByteArr;
    }
}
